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
                "	data_vencimento, valor, tipo, juros, id_fatura)\n" +
                "	VALUES (TO_DATE(?, 'DD/MM/YYYY'), ?, ?, ?, ?);";
                stmt=conexao.prepareStatement(SQL);
                stmt.setString(1, p.getDataVencimento().format(format));
                stmt.setDouble(2, p.getValor());
                stmt.setInt(3, p.getTipo());
                stmt.setDouble(4, p.getJuros());
                stmt.setInt(5, p.getId_fatura());
                stmt.execute();
                
               
                
            }
            catch(Exception e) {                
                JOptionPane.showMessageDialog(null, "Erro ao tentar inserir pagamento: "+e.getMessage());
            }
            
             
        }

    }
    
    public ArrayList<Pagamento> relatorioPagamento(int id_fat){
        
        ArrayList<Pagamento> pag = new ArrayList<>();
        
        try {
            
            conexao = SingletonCon.getConexao();
                                
            String SQL = "SELECT id, data_vencimento, valor, tipo, juros, paga, data_pagamento FROM pagamento "
                         + "WHERE id_fatura = ? "
                         + "ORDER BY id ASC";
                        
            //String SQL = "SELECT id, data, valor, tipo, juros, paga\n" +
            //"	FROM public.pagamento WHERE id_fatura = ?";            
                        
            stmt = conexao.prepareStatement(SQL);
            stmt.setInt(1, id_fat);
            rs = stmt.executeQuery();
            DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            while (rs.next()) {
                
                int id = rs.getInt(1);
                String dataV = rs.getObject(2).toString();
                double valor = rs.getDouble(3);
                int tipo = rs.getInt(4);
                double juros = rs.getDouble(5);
                boolean paga = rs.getBoolean(6);
                
                LocalDate dataVencimento, dataPagamento=null;
                String dataP="";
                if(paga){
                  dataP = rs.getObject(7).toString();                    
                    
                    try {
                        dataPagamento = LocalDate.parse(dataP, formater);

                    } catch (Exception e) {
                        dataPagamento = null;
                        JOptionPane.showMessageDialog(null, "Erro parse localdate pagamento\n" + e);
                    }
                }
                
                
                try {
                    dataVencimento = LocalDate.parse(dataV, formater);
                    
                } catch (Exception e) {
                    dataVencimento = null;
                    JOptionPane.showMessageDialog(null, "Erro parse localdate vencimento\n" + e);
                    
                }

                pag.add(new Pagamento(dataVencimento,valor,tipo,juros,id,id_fat,paga,dataPagamento));
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
        }
        
        
        return pag;
    }
    
    public void inserirPagamento(int id){
        
        try {
            conexao = SingletonCon.getConexao();
                                
            String SQL =    "UPDATE pagamento SET data_pagamento = NOW(),paga = true " +
                            "WHERE id = ?;";
                        
            
            stmt = conexao.prepareStatement(SQL);
            stmt.setInt(1, id);
            stmt.execute();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir pagamento!" + e);
        }
    }
    
    public void AtualizarJuros(int id, double juros){
        
        try {
            conexao = SingletonCon.getConexao();
                                
            String SQL =    "UPDATE pagamento SET juros = ? " +
                            "WHERE id = ?;";
                        
            
            stmt = conexao.prepareStatement(SQL);
            stmt.setDouble(1, juros);
            stmt.setInt(2, id);
            stmt.execute();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir pagamento!" + e);
        }
    }
    
}
