package dao;


import dao.SingletonCon;
import dao.SingletonCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.Compra;
import model.Produto;

public class DAOCompra {

	private ResultSet rs;
	private PreparedStatement stmt;
	private Connection conexao;

	private DAOItensCompra it;
	private DateTimeFormatter format;

	public DAOCompra() {
		it= new DAOItensCompra();
		format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		conexao=SingletonCon.getConexao();
	}

	public ArrayList<Compra> relatorioCompra(int codConta) {

		ArrayList <Compra> compras = new ArrayList<>();
		try {
			String SQL = "SELECT * FROM compra WHERE id_conta=?";
			stmt=conexao.prepareStatement(SQL);
			stmt.setInt(1, codConta);
			rs=stmt.executeQuery();

			while(rs.next()) {
				double total;
				String dataBanco;
				int codCompra;
				LocalDate dataReal;
				ArrayList <Produto> prod;

				total=rs.getDouble("total");
				dataBanco=rs.getString("data_compra");
				codCompra=rs.getInt("id_compra");

				prod=it.relatorioItensCompra(codCompra);

				dataReal=LocalDate.parse(dataBanco, format);

				Compra comprar = new Compra(prod, total, dataReal, codCompra);
				compras.add(comprar);
			}
		}
		catch(Exception e) {
			System.out.println("Erro no relatório compra: "+e.getMessage());
		}

		try {
			rs.close();
			stmt.close();
			return compras;

		}
		catch(Exception e) {
			System.out.println("Erro ao fechar o relatório compra: "+e.getMessage());
		}
		return compras;
	}

	public void cadastroCompra(ArrayList<Compra> compras, int codConta) {

		for(int i=0;i<compras.size();i++) {

			try {
				String SQL = "INSERT INTO compra (id_compra, total, data_compra, id_conta) VALUES (?,?,?,?)";
				stmt=conexao.prepareStatement(SQL);
				stmt.setInt(1, compras.get(i).getCodCompra());
				stmt.setDouble(2, compras.get(i).getTotal());
				stmt.setString(3, compras.get(i).getData().format(format));
				stmt.setInt(4, codConta);
				stmt.execute();	
				stmt.close();
				it.cadastroItensCompra(compras.get(i));
			}
			catch(Exception e) {
				System.out.println("Erro ao tentar inserir a compra: "+e.getMessage());
			}

		}

	}

	public void alterarCompra(ArrayList<Compra> compras, int codConta) {

		for(int i=0; i<compras.size();i++) {
			it.excluirItensCompra(compras.get(i));
		}

		for(int i=0; i<compras.size();i++) {

			try {
				String SQL = "UPDATE compra SET total=? ,data_compra=? WHERE id_conta=?, id_compra=?";
				stmt=conexao.prepareStatement(SQL);	
				stmt.setDouble(1, compras.get(i).getTotal());
				stmt.setString(2, compras.get(i).getData().format(format));
				stmt.setInt(3, codConta);
				stmt.setInt(4, compras.get(i).getCodCompra());
				stmt.execute();
				it.cadastroItensCompra(compras.get(i));
				stmt.close();

			}
			catch(Exception e) {
				System.out.println("Erro ao tentar alterar a compra: "+e.getMessage());
			}

		}

	}

	public void excluirCompra(ArrayList<Compra> compras) {

		String SQL = "DELETE FROM compra WHERE id_compra=?";
		for(int i=0; i<compras.size(); i++) 
			it.excluirItensCompra(compras.get(i));
		
		for(int i=0; i<compras.size(); i++) {

			try {
				stmt=conexao.prepareStatement(SQL);
				stmt.setInt(1, compras.get(i).getCodCompra());
				stmt.execute();
			}
			catch(Exception ex) {
				System.out.println("Erro ao excluir o produto: "+ex.getMessage());
			}
		}
		
	}

	public Compra buscarCompra(int id_compra, int id_conta) {
		String SQL = "SELECT * FROM compra WHERE id_conta=?, id_compra=?";
		Compra comprar=null;
		try {

			stmt=conexao.prepareStatement(SQL);
			stmt.setInt(1, id_conta);
			stmt.setInt(2, id_compra);
			rs=stmt.executeQuery();

			if(rs.next()) {

				double total;
				String dataBanco;
				int codCompra;
				LocalDate dataReal;
				ArrayList <Produto> prod;

				total=rs.getDouble("total");
				dataBanco=rs.getString("data_compra");
				codCompra=rs.getInt("id_compra");

				prod=it.relatorioItensCompra(codCompra);

				dataReal=LocalDate.parse(dataBanco, format);

				comprar = new Compra(prod, total, dataReal, codCompra);
				rs.close();
				stmt.close();
			}
		}
		catch(Exception e) {
			System.out.println("Erro ao buscar a compra: "+e.getMessage());
		}
		return comprar;
	}
}