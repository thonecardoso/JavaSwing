package dao;

import dao.DAOProduto;
import dao.DAOProduto;
import dao.SingletonCon;
import dao.SingletonCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Compra;
import model.Produto;

public class DAOItensCompra {
	private ResultSet rs;
	private PreparedStatement stmt;
	private Connection conexao;
	private DAOProduto daoProd;
	private ArrayList<Integer> idItens;
	private int codItens;

	public DAOItensCompra() {
		daoProd = new DAOProduto();
		idItens = new ArrayList<>();
	}


	public ArrayList<Produto> relatorioItensCompra(int codCompra) {
		conexao=SingletonCon.getConexao();
		ArrayList<Produto> prod = new ArrayList<>();
		Produto pro;
		try {

			String SQL = "SELECT * FROM itens_compra WHERE id_compra=?";
			stmt=conexao.prepareStatement(SQL);
			stmt.setInt(1, codCompra);
			rs=stmt.executeQuery();

			while(rs.next()) {
				double preco;
				String codBarras;
				preco=rs.getDouble("preco");
				codBarras=rs.getString("id_prod");
				pro=daoProd.buscarProduto(codBarras);
				pro.setPreco(preco);
				prod.add(pro);
				
			}

			
		}

		catch(Exception e) {
			System.out.println("Erro no relatório: "+e.getMessage());
		}
		try {
			
			rs.close();
			stmt.close();
			
			return prod;
		}
		catch(Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		return prod;
	}

	public void cadastroItensCompra(Compra compras) {
		conexao=SingletonCon.getConexao();
		buscarIDItens();
		
		if(idItens.isEmpty()) {
			codItens=0;
		}
		else {
			codItens=idItens.get(idItens.size()-1)+1;
		}

		for(int i=0;i<compras.getProd().size();i++) {

			try {
				String SQL = "INSERT INTO itens_compra (id_item, id_prod, id_compra, preco) VALUES (?,?,?,?)";
				stmt=conexao.prepareStatement(SQL);
				stmt.setInt(1, codItens);
				stmt.setString(2, compras.getProd().get(i).getCodigoDeBarras());
				stmt.setInt(3, compras.getCodCompra());
				stmt.setDouble(4, compras.getProd().get(i).getPreco());
				stmt.execute();
				codItens++;
				stmt.close();
				
			}
			catch(Exception e) {
				System.out.println("Erro ao tentar inserir a compra: "+e.getMessage());
			}
		}

	}
	
	public void buscarIDItens(){
		int id;
		try {
			conexao=SingletonCon.getConexao();
			String SQL = "SELECT * FROM itens_compra";
			stmt=conexao.prepareStatement(SQL);
			rs=stmt.executeQuery();

			while(rs.next()) {
				id=rs.getInt("id_item");
				idItens.add(id);
		}

		}

		catch(Exception e) {
			System.out.println("Erro no relatório: "+e.getMessage());
		}
		try {
			rs.close();
			stmt.close();
			

		}
		catch(Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
	
		
	}


	public void excluirItensCompra(Compra compras) {
		String SQL = "DELETE FROM itens_compra WHERE id_compra=?";

			try {
				conexao=SingletonCon.getConexao();
				stmt=conexao.prepareStatement(SQL);
				stmt.setInt(1, compras.getCodCompra());
				stmt.execute();
				stmt.close();
				
			}
			catch(Exception ex) {
				System.out.println("Erro ao excluir o produto: "+ex.getMessage());
			}
	}

}