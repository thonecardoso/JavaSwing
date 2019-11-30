package Reports;

import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class CallReports {

    
    String strCliente = "Cliente";
    String strClienteEndereco = "ClienteComEndereco";
    String strConta = "Contas";
    String strContaCompra = "ContaComCompras";
    String strProduto = "Produtos";
    
    public void Call(int x){
        switch (x){
            
            case 0:
                getReport(strCliente);
                break;
            case 1:
                getReport(strClienteEndereco);
                break;
            case 2:
                getReport(strConta);
                break;
            case 3:
                getReport(strContaCompra);
                break;
            case 4:
                getReport(strProduto);
                break;
                
            
            
            
            
        }
            
    }
    
    
    private void getReport(String str){
        
        Connection connection = null;
        
		try {
		
			
                        String caminho = new File("Reports/" + str + ".jasper").getAbsolutePath();
                        caminho = caminho.replace("Tabajaras/", "Tabajaras/src/main/java/");
                       
			Map<String, Object> parameters = new HashMap<String, Object>();
			connection = dao.SingletonCon.getConexao(); 
                        
			JasperPrint print = JasperFillManager.fillReport(caminho, parameters, connection);
                        
			
                        JasperViewer view = new JasperViewer(print, false);
                            view.setVisible(true);
                        
                        

		} catch (Exception e) {
			                 System.out.println(e.getMessage());
                }
        
    }

    
}
