package dao;

import dao.SingletonCon;
import dao.SingletonCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.Conta;
import model.Fatura;
import model.Pagamento;

public class DAOFatura {
	
	private ResultSet rs;
	private PreparedStatement stmt;
	private Connection conexao;
	private DateTimeFormatter format;
	private DAOConta daoConta;
	private DAOPagamento daoPag;
	private LocalDate defaut;
	
	public DAOFatura() {
		format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		daoConta = new DAOConta();
		daoPag = new DAOPagamento();
		defaut = LocalDate.parse("01/01/2000", format);
	}
	
	
	public ArrayList<Fatura> relatorioFatura() {
		
		ArrayList <Fatura> fats = new ArrayList<>();
		ArrayList <Pagamento> pag = new ArrayList<>();
		Fatura fatu;
		Conta con = new Conta();
		try {

			conexao=SingletonCon.getConexao();

			String SQL = "SELECT * FROM fatura";
			stmt=conexao.prepareStatement(SQL);
			rs=stmt.executeQuery();
			
			while(rs.next()) {
				int idFatura;
				int codConta;
				String dataQui;
				Double juros;
				int quantidade;
				LocalDate data;
				
				idFatura=rs.getInt("id_fatura");
				codConta=rs.getInt("id_conta_fatura");
				dataQui=rs.getString("data_quitacao");
				juros=rs.getDouble("juros");
				quantidade=rs.getInt("quantidade_parcelas");
				
					
				
				pag=daoPag.relatorioPagamento(idFatura);
				con=daoConta.buscarConta(codConta);
				if(dataQui==defaut.format(format))
				fatu = new Fatura(con,defaut,juros,quantidade,pag,idFatura);	
				
				else {
					data=LocalDate.parse(dataQui, format);
					fatu = new Fatura(con,data,juros,quantidade,pag,idFatura);
				}
	
				fats.add(fatu);
		
			}
	}
		catch(Exception e) {
			System.out.println("Erro no relatório fatura: "+e.getMessage());
		}
		
		try {
			rs.close();
			stmt.close();
			
			return fats;
			
		}
		catch(Exception e) {
			System.out.println("Erro ao fechar a conexao no relatório fatura: "+e.getMessage());
		}
		return fats;
	}
	
	public void cadastroFatura(Fatura fat) {
		
		
		try {
			conexao=SingletonCon.getConexao();
			String SQL = "INSERT INTO fatura (id_fatura,id_conta_fatura,data_quitacao,juros,quantidade_parcelas) VALUES (?,?,?,?,?)";
			stmt=conexao.prepareStatement(SQL);
			stmt.setInt(1, fat.getIdFatura());
			stmt.setInt(2, fat.getConta().getId());
			stmt.setString(3, fat.getDataQuitacao().format(format));
			stmt.setDouble(4, fat.getJuros());
			stmt.setInt(5, fat.getQuantParcela());
			stmt.execute();
			daoPag.cadastrarParcela(fat);
			stmt.close();
			
			System.out.println("\nCadastro efetuado com sucesso.");
			System.out.println("===========================================");
		}
		catch(Exception e) {
			System.out.println("Erro ao tentar inserir a fatura: "+e.getMessage());
		}
	
		
	}
	
	public void alterarFatura(int codFatura, Fatura fat) {
	
		
		try {
			conexao=SingletonCon.getConexao();
			String SQL = "UPDATE fatura SET id_conta_fatura=? ,data_quitacao=?, juros=?, quantidade_parcelas=? WHERE id_fatura=?";
			stmt=conexao.prepareStatement(SQL);	
			stmt.setInt(1, fat.getConta().getId());
			stmt.setString(2, fat.getDataQuitacao().format(format));
			stmt.setDouble(3, fat.getJuros());
			stmt.setInt(4, fat.getQuantParcela());
			stmt.setInt(5, codFatura);
			daoPag.excluirParcela(codFatura);
			daoPag.cadastrarParcela(fat);
			stmt.execute();
			stmt.close();
			
			System.out.println("Alteração concluída com sucesso.");
		}
		catch(Exception e) {
			System.out.println("Erro ao tentar alterar a fatura: "+e.getMessage());
		}
		
	}
	
	public void excluirFatura(int codFatura) {
		conexao=SingletonCon.getConexao();
		String SQL = "DELETE FROM fatura WHERE id_fatura= ? ";
		daoPag.excluirParcela(codFatura);
		try {

			stmt=conexao.prepareStatement(SQL);
			stmt.setInt(1, codFatura);
			stmt.execute();
			stmt.close();
			

			System.out.println("Exclusão concluída com sucesso!\n");
		}
		catch(Exception ex) {
			System.out.println("Erro ao excluir a fatura: "+ex.getMessage());
		}
		
	}
	
	public Fatura buscarFatura(int codFatura) {
		String SQL = "SELECT * FROM fatura WHERE id_fatura=?";
		Fatura fat = new Fatura();
		ArrayList<Pagamento> pagamen = new ArrayList<>();
		Conta con = new Conta();
		
		try {
			conexao=SingletonCon.getConexao();
			stmt=conexao.prepareStatement(SQL);
			stmt.setInt(1, codFatura);
			rs=stmt.executeQuery();
			
			if(rs.next()) {
				int idFatura;
				int codConta;
				String dataQui;
				Double juros;
				int quantidade;
				LocalDate data;
				
				idFatura=rs.getInt("id_fatura");
				codConta=rs.getInt("id_conta_fatura");
				dataQui=rs.getString("data_quitacao");
				juros=rs.getDouble("juros");
				quantidade=rs.getInt("quantidade_parcelas");
				
				rs.close();
				stmt.close();
				
				pagamen=daoPag.relatorioPagamento(idFatura);
				con=daoConta.buscarConta(codConta);
				
				if(dataQui==defaut.format(format))
				fat = new Fatura(con,defaut,juros,quantidade,pagamen,idFatura);
				else {
					data=LocalDate.parse(dataQui, format);
					fat=new Fatura(con,data,juros,quantidade,pagamen,idFatura);
				}
					
			}
		}
		catch(Exception e) {
			System.out.println("Erro ao buscar o produto: "+e.getMessage());
		}
		return fat;
	}
	
	public void atualizarDataQuitacao(String data, int codFatura) {
		String SQL = "UPDATE fatura SET data_quitacao=? WHERE id_fatura=?";
		try {
		conexao=SingletonCon.getConexao();
		stmt=conexao.prepareStatement(SQL);	
		stmt.setString(1, data);
		stmt.setInt(2, codFatura);
		stmt.execute();
		
		}
		catch(Exception e) {
			System.out.println("Erro ao alterar a data de quitação: "+e.getMessage());
		}
		try {
			stmt.close();
			System.out.println("Fatura quitada");	
		}
		catch(Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
	}
}