package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class SingletonCon {
	private static Connection conexao=null;
	public static Connection getConexao() throws Exception{
		try{
			if(conexao==null) {
				Class.forName("org.postgresql.Driver");

				Properties prop = new Properties();
				prop.put("user","postgres");
				prop.put("password", "123456");
				prop.put("charset", "UTF-8");
				prop.put("lc_ctype", "ISO8859_1");

				conexao=DriverManager.getConnection("jdbc:postgresql://localhost:5432/tabajara", prop);
			}
			return conexao;
                       
		}
		catch(Exception e){
			throw e;
		}
		//return conexao;
		
	}

}