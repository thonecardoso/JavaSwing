package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Conta;
import model.Fatura;
import model.Pagamento;

public class DAOFatura {
    
    private ResultSet rs;
    private PreparedStatement stmt;
    private Connection conexao;
    private DAOCompra daocompra;
    private DateTimeFormatter format;
    private DAOPagamento daoPagamento;
    private DAOConta contaDAO;

    public DAOFatura() {
        daoPagamento = new DAOPagamento();
        contaDAO = new DAOConta();
        format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }
    
    
    
    public void cadastrarFatura(Fatura fatura) {
             
        try {
            conexao=SingletonCon.getConexao();	
            String SQL = "INSERT INTO public.fatura(\n" +
            "   id_conta_fatura, data_quitacao, quantidade_parcelas, juros)\n" +
            "	VALUES (?, TO_DATE(?, 'DD/MM/YYYY'), ?, ?);";
            stmt=conexao.prepareStatement(SQL);
            stmt.setInt(1, fatura.getConta().getId());
            stmt.setString(2, fatura.getDataQuitacao().format(format));
            stmt.setInt(3, fatura.getQuantParcela());
            stmt.setDouble(4, fatura.getJuros());
            stmt.execute();
            
            int id = buscarId();
            for(Pagamento p: fatura.getParcelas()){
                p.setId_fatura(id);
            }
            daoPagamento.cadastrarPagamento(fatura.getParcelas());


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
    
     public int buscarId() {

        String SQL = "SELECT MAX(id_fatura) AS id FROM fatura;";
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
            JOptionPane.showMessageDialog(null, "Erro ao pegar id fatura: "+ex.getMessage());
        }

        return id;

    }
    
    public ArrayList<Fatura> relatorioFatura(){
        
        ArrayList<Fatura> fat = new ArrayList<>();
        
        try {
            
            conexao = SingletonCon.getConexao();

            String SQL = "SELECT id_fatura, id_conta_fatura, data_quitacao, "
                    + "quantidade_parcelas, juros " +
                    "FROM public.fatura;";
            stmt = conexao.prepareStatement(SQL);
            rs = stmt.executeQuery();
            DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            
            
            while(rs.next()){
                int id = rs.getInt(1);
                int id_conta = rs.getInt(2);
                String data = rs.getObject(3).toString();
                int quantParcela = rs.getInt(4);
                double juros = rs.getDouble(5);
                
                LocalDate dataQuitacao = LocalDate.parse(data, formater);
                ArrayList <Pagamento> parcelas = new ArrayList<>();
                        parcelas.addAll(daoPagamento.relatorioPagamento(id));
                Conta conta = contaDAO.buscarConta(id_conta);
                
                
                fat.add(new Fatura(conta,dataQuitacao,juros,quantParcela,parcelas,id));
            }
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar relatório das Faturas!" + e.getMessage());
        }
        
        
        
        
        return fat;
    }
    
    public ArrayList<Fatura> relatorioFatura(int tipo, String str){
        
        ArrayList<Fatura> fat = new ArrayList<>();
        
        try {
            
            conexao = SingletonCon.getConexao();

            if(tipo == 1){
                
                String SQL =    "SELECT id_fatura, id_conta_fatura, data_quitacao, quantidade_parcelas, juros " +
                                "FROM fatura f " +
                                "JOIN conta c ON f.id_conta_fatura = c.id_conta " +
                                "JOIN cliente cl ON c.id_cli = cl.id_cliente " +
                                "WHERE cl.nome LIKE ? AND cl.tipo=1";
                
                stmt=conexao.prepareStatement(SQL);
                stmt.setString(1, str);
                rs=stmt.executeQuery();
            }else if(tipo ==2){
                String SQL =    "SELECT id_fatura, id_conta_fatura, data_quitacao, quantidade_parcelas, juros " +
                                "FROM fatura f " +
                                "JOIN conta c ON f.id_conta_fatura = c.id_conta " +
                                "JOIN cliente cl ON c.id_cli = cl.id_cliente " +
                                "WHERE cl.nome LIKE ? AND cl.tipo=2";
                stmt=conexao.prepareStatement(SQL);
                stmt.setString(1, str);
                rs=stmt.executeQuery();
            }else{
                String SQL =    "SELECT id_fatura, id_conta_fatura, data_quitacao, quantidade_parcelas, juros " +
                                "FROM fatura f " +
                                "JOIN conta c ON f.id_conta_fatura = c.id_conta " +
                                "JOIN cliente cl ON c.id_cli = cl.id_cliente " +
                                "WHERE cl.nome LIKE ?";
                stmt=conexao.prepareStatement(SQL);
                stmt.setString(1, str);                
                rs=stmt.executeQuery();
            }
            
            
            DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            
            
            while(rs.next()){
                int id = rs.getInt(1);
                int id_conta = rs.getInt(2);
                String data = rs.getObject(3).toString();
                int quantParcela = rs.getInt(4);
                double juros = rs.getDouble(5);
                
                LocalDate dataQuitacao = LocalDate.parse(data, formater);
                ArrayList <Pagamento> parcelas = new ArrayList<>();
                parcelas.addAll(daoPagamento.relatorioPagamento(id));
                Conta conta = contaDAO.buscarConta(id_conta);
                
                
                fat.add(new Fatura(conta,dataQuitacao,juros,quantParcela,parcelas,id));
            }
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar relatório das Faturas!" + e.getMessage());
        }
        
        
        return fat;
    }
    
}
