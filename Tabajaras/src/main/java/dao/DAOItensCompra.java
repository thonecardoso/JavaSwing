package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
		ArrayList<Produto> prod = new ArrayList<>();
		Produto pro;
		try {

                        conexao=SingletonCon.getConexao();
			String SQL = "SELECT cod_barras FROM itens_compra WHERE id_compra=?";
			stmt=conexao.prepareStatement(SQL);
			stmt.setInt(1, codCompra);
			rs=stmt.executeQuery();

			while(rs.next()) {
				String cod_barras = rs.getString(1);
                                Produto p = daoProd.buscarProduto(cod_barras);
				prod.add(p);
				
			}

			
		}

		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro no relatório: "+e.getMessage());
		}
		try {
			
			rs.close();
			stmt.close();
			
			return prod;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
		}
		return prod;
	}

	public void cadastroItensCompra(Compra compras,int id) {
		
		
		
			codItens=1;
		

		for(int i=0;i<compras.getProd().size();i++) {
                    
                    String cod = compras.getProd().get(i).getCodigoDeBarras();
                    

			try {
                            
                                
                                conexao=SingletonCon.getConexao();
				String SQL = "INSERT INTO itens_compra (id_item, cod_barras, id_prod, id_compra, preco) VALUES (?,?,?,?,?)";
				stmt=conexao.prepareStatement(SQL);
				stmt.setInt(1, codItens++);
				stmt.setString(2, cod);
                                stmt.setInt(3,daoProd.getId(cod));
                                stmt.setInt(4,id);
				//stmt.setInt(4, compras.getCodCompra());
				stmt.setDouble(5, compras.getProd().get(i).getPreco());
				stmt.execute();
				//codItens++;
				stmt.close();
				
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao tentar inserir Itém : "+e.getMessage());
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
			JOptionPane.showMessageDialog(null, "Erro no relatório: "+e.getMessage());
		}
		try {
			rs.close();
			stmt.close();
			

		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
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
				JOptionPane.showMessageDialog(null, "Erro ao excluir o produto: "+ex.getMessage());
			}
	}
        
        public void excluirItenCompra(int id, String chave) {
		String SQL = "delete from itens_compra where id = (select min(id) from itens_compra "
                            + "where id_compra = ? and cod_barras = ?);";

			try {
				conexao=SingletonCon.getConexao();
				stmt=conexao.prepareStatement(SQL);
				stmt.setInt(1, id);
                                stmt.setString(2, chave);
				stmt.execute();
				stmt.close();
				
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Erro ao excluir o Itém: "+ex.getMessage());
			}
	}

}