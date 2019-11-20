package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Conta;
import model.Pagamento;

public class DAOPagamento {

    private ResultSet rs;
    private PreparedStatement stmt;
    private Connection conexao;
    private DAOCompra daocompra;
    private DateTimeFormatter format;

    public DAOPagamento() {
        format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }
    
    
    
    public void cadastrarPagamento(ArrayList<Pagamento> pag) {
         
         
        for(Pagamento p: pag){
             
            try {
                conexao=SingletonCon.getConexao();	
                String SQL = "INSERT INTO public.pagamento(\n" +
                "	data, valor, tipo, juros, id_fatura)\n" +
                "	VALUES (TO_DATE(?, 'DD/MM/YYYY'), ?, ?, ?, ?);";
                stmt=conexao.prepareStatement(SQL);
                stmt.setString(1, p.getData().format(format));
                stmt.setDouble(2, p.getValor());
                stmt.setInt(3, p.getTipo());
                stmt.setDouble(4, p.getJuros());
                stmt.setInt(5, p.getId_fatura());
                stmt.execute();
                
                
            }
            catch(Exception e) {                
                JOptionPane.showMessageDialog(null, "Erro ao tentar inserir pagamento: "+e.getMessage());
            }
            
            try {
                stmt.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: \n"+e.getMessage());
            }
             
        }

    }
    
    public ArrayList<Pagamento> relatorioPagamento(int id_fat){
        
        ArrayList<Pagamento> pag = new ArrayList<>();
        
        try {
            
            conexao = SingletonCon.getConexao();

            String SQL = "SELECT id, data, valor, tipo, juros, paga FROM pagamento "
                         + "WHERE id_fatura = ? ";
                        
            //String SQL = "SELECT id, data, valor, tipo, juros, paga\n" +
            //"	FROM public.pagamento WHERE id_fatura = ?";            
                        
            stmt = conexao.prepareStatement(SQL);
            stmt.setInt(1, id_fat);
            rs = stmt.executeQuery();
            DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            while (rs.next()) {
                
                int id = rs.getInt(1);
                String dataVencimento = rs.getObject(2).toString();
                double valor = rs.getDouble(3);
                int tipo = rs.getInt(4);
                double juros = rs.getDouble(5);
                boolean paga = rs.getBoolean(6);
                //boolean paga = false;
                
                LocalDate data;
                data = LocalDate.parse(dataVencimento, formater);
                

                pag.add(new Pagamento(data,valor,tipo,juros,id,id_fat,paga));
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
        return pag;
    }
    
}
