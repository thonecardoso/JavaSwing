package dao;

import dao.SingletonCon;
import dao.SingletonCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.Fatura;
import model.Pagamento;

public class DAOPagamento {

	private ResultSet rs;
	private PreparedStatement stmt;
	private Connection conexao;
	private DateTimeFormatter format;
	
	public DAOPagamento() {
		format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	}
	
	public ArrayList<Pagamento> relatorioPagamento(int codFatura){
		conexao=SingletonCon.getConexao();
		ArrayList<Pagamento> pags = new ArrayList<>();
		Pagamento pag=null;
		try {

			String SQL = "SELECT * FROM pagamento WHERE id_fatura_pagamento=?";
			stmt=conexao.prepareStatement(SQL);
			stmt.setInt(1, codFatura);
			rs=stmt.executeQuery();

			while(rs.next()) {
				 int codPag;
				 String data;
				 LocalDate dataPagamento;
				 int tipo;
				 double juros,valor;
		
				codPag=rs.getInt("id_pagamento");
				data=rs.getString("data");
				tipo=rs.getInt("tipo");
				juros=rs.getDouble("juros");
				valor=rs.getDouble("valor");
				dataPagamento = LocalDate.parse(data, format);
				pag = new Pagamento(dataPagamento,valor,tipo,juros,codPag);
				pags.add(pag);
			}

		}

		catch(Exception e) {
			System.out.println("Erro no relatório: "+e.getMessage());
		}
		try {
			rs.close();
			stmt.close();
			
			return pags;

		}
		catch(Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		return pags;
	}
	
	public void cadastrarParcela(Fatura fat) {
		
		for(int i=0;i<fat.getParcelas().size();i++) {
			String data = fat.getParcelas().get(i).getData().format(format);

			try {
				conexao=SingletonCon.getConexao();
				String SQL = "INSERT INTO pagamento (id_pagamento, data, tipo, juros, valor, id_fatura_pagamento) VALUES (?,?,?,?,?,?)";
				stmt=conexao.prepareStatement(SQL);
				stmt.setInt(1, fat.parcelas.get(i).getId());
				stmt.setString(2, data);
				stmt.setInt(3, fat.getParcelas().get(i).getTipo());
				stmt.setDouble(4, fat.getParcelas().get(i).getJuros());
				stmt.setDouble(5, fat.getParcelas().get(i).getValor());
				stmt.setInt(6, fat.getIdFatura());
				stmt.execute();
			}
			catch(Exception e) {
				System.out.println("Erro ao tentar inserir a parcela: "+e.getMessage());
			}
		}

		try {
			stmt.close();
			
		}
		catch(Exception e) {
			System.out.println("Erro ao tentar inserir a parcela: "+e.getMessage());
		}


		
	}
	
	public void excluirParcela(int codFatura) {
		String SQL = "DELETE FROM pagamento WHERE id_fatura_pagamento=?";

		try {
			conexao=SingletonCon.getConexao();
			stmt=conexao.prepareStatement(SQL);
			stmt.setInt(1, codFatura);
			stmt.execute();
		}
		catch(Exception ex) {
			System.out.println("Erro ao excluir as parcelas: "+ex.getMessage());
		}
	
	try {
		stmt.close();
		
		
	}
	catch(Exception e) {
		System.out.println("Erro: "+e.getMessage());
	}
		
	}
	
	public int buscarIDMAX() {
		ArrayList<Integer> idMax = new ArrayList<>();
		
		try {
			conexao=SingletonCon.getConexao();

			String SQL = "SELECT * FROM pagamento";
			stmt=conexao.prepareStatement(SQL);
			rs=stmt.executeQuery();

			while(rs.next()) {
				int id=rs.getInt("id_pagamento");
				idMax.add(id);
		}

		}

		catch(Exception e) {
			System.out.println("Erro no relatório: "+e.getMessage());
		}
		try {
			rs.close();
			stmt.close();
			
			return idMax.size();
			
		}
		catch(Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		return -1;
	}
	
	public void pagarParcela(String data, int codFatura) {
		
		String sql = "DELETE FROM pagamento WHERE (id_fatura_pagamento=?) AND (data=?)";
		try {
			conexao=SingletonCon.getConexao();
			stmt=conexao.prepareStatement(sql);
			stmt.setInt(1, codFatura);
			stmt.setString(2, data);
			stmt.execute();
			System.out.println("Parcela paga com sucesso.\n");
		}
		catch(Exception ex) {
			System.out.println("Erro ao excluir as parcelas: "+ex.getMessage());
		}
	
	try {
		stmt.close();
		
	}
	catch(Exception e) {
		System.out.println("Erro: "+e.getMessage());
	}
		
		
	}
	
}