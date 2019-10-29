package dao;
import dao.DAOCliente;
import dao.DAOCliente;
import dao.SingletonCon;
import dao.SingletonCon;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.*;

public class DAOConta {
	private ResultSet rs;
	private PreparedStatement stmt;
	private Connection conexao;
	private DAOCliente daocli;
	private DAOCompra daocompra;
	private DateTimeFormatter format;
	
	
	public DAOConta() {
		daocli = new DAOCliente();
		daocompra = new DAOCompra();
		format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	}
	
	
	public ArrayList<Conta> relatorioConta() {
		
		ArrayList <Conta> contas = new ArrayList<>();
		ArrayList <Compra> compras = new ArrayList<>();
		ArrayList <Cliente> clientes = new ArrayList<>();
		Cliente cli=null;
		try {
			conexao=SingletonCon.getConexao();

			String SQL = "SELECT * FROM conta";
			stmt=conexao.prepareStatement(SQL);
			rs=stmt.executeQuery();
			
			while(rs.next()) {
				int idConta;
				int idCliente;
				LocalDate data;
				Double total;
				String dataVencimento;
				
				idConta=rs.getInt("id_conta");
				idCliente=rs.getInt("id_cli");
				total=rs.getDouble("total");
				dataVencimento=rs.getString("data_vencimento");
				
				compras=daocompra.relatorioCompra(idConta);
				clientes=daocli.buscarClientes();
				for(int i=0;i<clientes.size();i++) {
					if(clientes.get(i).getId()==idCliente)
						cli=clientes.get(i);
				}
				
				data = LocalDate.parse(dataVencimento, format);
				
				Conta con = new Conta(compras, data,total,cli,idConta);
				contas.add(con);
				
			}
			
	}
		catch(Exception e) {
			System.out.println("Erro no relatório compra: "+e.getMessage());
		}
		
		try {
			rs.close();
			stmt.close();
			return contas;
			
		}
		catch(Exception e) {
			System.out.println("Erro ao fechar o relatório compra: "+e.getMessage());
		}
		return contas;
	}
	
	public void cadastroConta(Conta con) {
		String dataVencimento = con.getDataVencimento().format(format);
		conexao=SingletonCon.getConexao();	
		try {
			String SQL = "INSERT INTO conta (id_conta,data_vencimento,total,id_cli) VALUES (?,?,?,?)";
			stmt=conexao.prepareStatement(SQL);
			stmt.setInt(1, con.getId());;
			stmt.setString(2, dataVencimento);
			stmt.setDouble(3, con.getTotal());
			stmt.setInt(4, con.getCli().getId());
			stmt.execute();
			daocompra.cadastroCompra(con.getCompras(), con.getId());
			
			stmt.close();
			System.out.println("\nCadastro efetuado com sucesso.");
			System.out.println("===========================================");
		}
		catch(Exception e) {
			System.out.println("Erro ao tentar inserir a conta: "+e.getMessage());
		}
	
		
	}
	
	public void alterarConta(int codConta, Conta con) {
		String dataVencimento = con.getDataVencimento().format(format);
		conexao=SingletonCon.getConexao();
		try {
			String SQL = "UPDATE conta SET data_vencimento=?, total=?, id_cli=? WHERE id_conta=?";
			stmt=conexao.prepareStatement(SQL);	
			stmt.setString(1, dataVencimento);
			stmt.setDouble(2, con.getTotal());
			stmt.setInt(3, con.getCli().getId());
			stmt.setInt(4, codConta);
			stmt.execute();
			daocompra.alterarCompra(con.getCompras(), con.getId());
			stmt.close();
			
			System.out.println("Alteração concluída com sucesso.");
		}
		catch(Exception e) {
			System.out.println("Erro ao tentar alterar a conta: "+e.getMessage());
		}
		
	}
	
	public void excluirConta(Conta con) {
		
		String SQL = "DELETE FROM conta WHERE id_conta= ? ";
		conexao=SingletonCon.getConexao();
		daocompra.excluirCompra(con.getCompras());
		try {
			daocompra.excluirCompra(con.getCompras());
			stmt=conexao.prepareStatement(SQL);
			stmt.setInt(1, con.getId());
			stmt.execute();
			stmt.close();
			
			System.out.println("Exclusão concluída com sucesso!\n");
		}
		catch(Exception ex) {
			System.out.println("Erro ao excluir a conta: "+ex.getMessage());
		}
		
	}
	
	public Conta buscarConta(int codConta) {
		String SQL = "SELECT * FROM conta WHERE id_conta=?";
		ArrayList<Compra> compras = new ArrayList<>(); 
		ArrayList<Cliente> clientes = new ArrayList<>();
		Cliente cli=null;
		Conta con=null;
		
		try {
			conexao=SingletonCon.getConexao();
			stmt=conexao.prepareStatement(SQL);
			stmt.setInt(1, codConta);
			rs=stmt.executeQuery();
			
			if(rs.next()) {
				int idCliente;
				LocalDate data;
				Double total;
				String dataVencimento;
				idCliente=rs.getInt("id_cli");
				total=rs.getDouble("total");
				dataVencimento=rs.getString("data_vencimento");
				clientes = daocli.buscarClientes();
				compras=daocompra.relatorioCompra(codConta);
				for(int i=0;i<clientes.size();i++) {
					if(clientes.get(i).getId()==idCliente)
						cli=clientes.get(i);
				}
				data = LocalDate.parse(dataVencimento, format);
				
				con = new Conta(compras, data,total,cli,codConta);
				
				rs.close();
				stmt.close();
			}
		}
		catch(Exception e) {
			System.out.println("Erro ao buscar a conta: "+e.getMessage());
		}
		return con;
	}
}