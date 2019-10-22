package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class DAOLogin {
    
    
    private ResultSet rs;
    private PreparedStatement stmt;
    private Connection conexao;


    public DAOLogin() {
        
    }
    
    
        public boolean autenticacao(String user, String senha){
        
		String SQL = "SELECT * FROM login WHERE usuario = ? AND senha = md5(?)";
		
		try {
                    conexao=SingletonCon.getConexao();
			stmt=conexao.prepareStatement(SQL);
			stmt.setString(1, user);
                        stmt.setString(2, senha);			
                        rs=stmt.executeQuery();
                        
                        if(rs.next()){
                            stmt.close();
                            return true;
                        }     
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro ao logar: "+ex.getMessage());
		}  
                
                return false;
        }
    
    
}
