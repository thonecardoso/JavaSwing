package dao;
import dao.DAOCliente;
import dao.DAOCliente;
import dao.SingletonCon;
import dao.SingletonCon;
import java.sql.*;
import java.time.LocalDate;
import java.time.Period;
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
                        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			while(rs.next()) {
				int idConta;
				int idCliente;
				LocalDate data;
				Double total;
				String dataVencimento;
				
				idConta=rs.getInt("id_conta");
				idCliente=rs.getInt("id_cli");
				total=rs.getDouble("total");
				//dataVencimento=rs.getString("data_vencimento");
                                dataVencimento = rs.getObject("data_vencimento").toString();
				
				compras=daocompra.relatorioCompra(idConta);
				clientes=daocli.ArrayClientes();
				for(int i=0;i<clientes.size();i++) {
					if(clientes.get(i).getId()==idCliente)
						cli=clientes.get(i);
				}
				
				data = LocalDate.parse(dataVencimento, formater);
				
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
        
        public ArrayList<Conta> ContaFisica(int chave) {
		
		ArrayList <Conta> contas = new ArrayList<>();
		ArrayList <Compra> compras = new ArrayList<>();
		ArrayList <Cliente> clientes = new ArrayList<>();
		Cliente cli=null;
		try {
			conexao=SingletonCon.getConexao();

			String SQL = "SELECT * FROM conta where id_cli = ?";
			stmt=conexao.prepareStatement(SQL);
                        stmt.setInt(1, chave);
			rs=stmt.executeQuery();
                        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			while(rs.next()) {
				int idConta;
				int idCliente;
				LocalDate data;
				Double total;
				String dataVencimento;
				
				idConta=rs.getInt("id_conta");
				idCliente=rs.getInt("id_cli");
				total=rs.getDouble("total");
				//dataVencimento=rs.getString("data_vencimento");
                                dataVencimento = rs.getObject("data_vencimento").toString();
				
				compras=daocompra.relatorioCompra(idConta);
				clientes=daocli.ArrayClientes();
				for(int i=0;i<clientes.size();i++) {
					if(clientes.get(i).getId()==idCliente)
						cli=clientes.get(i);
				}
				
				data = LocalDate.parse(dataVencimento, formater);
				
				Conta con = new Conta(compras, data,total,cli,idConta);
				contas.add(con);
                                System.out.println(contas.size());
				
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
            
		
                
                
		try {
                        conexao=SingletonCon.getConexao();	
			String SQL = "INSERT INTO conta (data_vencimento,total,id_cli) VALUES (TO_DATE(?, 'DD/MM/YYYY'),?,?)";
			stmt=conexao.prepareStatement(SQL);
			//stmt.setInt(1, con.getId());
			stmt.setString(1, con.getDataVencimento().format(format));
			stmt.setDouble(2, con.getTotal());
			stmt.setInt(3, con.getCli().getId());
			stmt.execute();
                        con.setId(buscarId());
			daocompra.cadastroCompra(con.getCompras(), con.getId());
			
			stmt.close();
			System.out.println("\nCadastro efetuado com sucesso.");
			System.out.println("===========================================");
		}
		catch(Exception e) {
			System.out.println("Erro ao tentar inserir a conta: "+e.getMessage());
		}
	
		
	}
        
        public int buscarId() {
		
		String SQL = "SELECT MAX(id_conta) AS id FROM conta;";
		int id = -1;
		try {
                        conexao=SingletonCon.getConexao();
			stmt=conexao.prepareStatement(SQL);
			
			rs=stmt.executeQuery();
			
			if(rs.next()){
                            id=rs.getInt(1);
                        }
			
			
		}
		catch(Exception ex) {
			System.out.println("Erro ao excluir a conta: "+ex.getMessage());
		}
                
                return id;
		
	}
        
         public void test() {
		//String dataVencimento = con.getDataVencimento().format(format);
		try {
                        LocalDate ld = LocalDate.now();
                        Timestamp tm = new Timestamp(System.currentTimeMillis());
                        System.out.println(tm);
                        conexao=SingletonCon.getConexao();	
			String SQL = "INSERT INTO public.teste(asdf, asd) VALUES (TO_DATE(?, 'DD/MM/YYYY'), ?);";
			stmt=conexao.prepareStatement(SQL);
                        stmt.setString(1,ld.format(format));
			stmt.setObject(2, tm); //JDBCType
			stmt.execute();
			//daocompra.cadastroCompra(con.getCompras(), con.getId());
			
			stmt.close();
			System.out.println("\nCadastro efetuado com sucesso.");
			System.out.println("===========================================");
		}
		catch(Exception e) {
			System.out.println("Erro ao tentar inserir a conta: "+e.getMessage());
		}
	
		
	}
         
        public void test2() {
		//String dataVencimento = con.getDataVencimento().format(format);
                
		try {
                        conexao=SingletonCon.getConexao();
                        /*String SQL = "SELECT * FROM teste;";
                        stmt=conexao.prepareStatement(SQL);
			rs=stmt.executeQuery();*/
                        Statement st = conexao.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM teste;");
			
			while(rs.next()) {
                            Object ld = rs.getObject(1);
                            Timestamp tm = rs.getTimestamp(2);
                            
                            System.out.println("localdate " + ld.toString());
                            //System.out.println("timestamp " + tm);
                            
                        }
                    
                        
			
			st.close();
			
		}
		catch(Exception e) {
			                 System.out.println(e.getMessage());
		}
	
		
	}
	
	public void alterarConta(int codConta, Conta con) {
		String dataVencimento = con.getDataVencimento().format(format);
		try {
                        conexao=SingletonCon.getConexao();
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
		daocompra.excluirCompra(con.getCompras());
		try {
                        conexao=SingletonCon.getConexao();
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