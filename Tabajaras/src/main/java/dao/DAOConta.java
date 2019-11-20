package dao;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import model.*;

public class DAOConta {
    
    private ResultSet rs;
    private PreparedStatement stmt;
    private Connection conexao;
    private DAOCompra daocompra;
    private DateTimeFormatter format;
    private DAOCliente daocli;


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
                JOptionPane.showMessageDialog(null, "Erro no relatório compra: "+e.getMessage());
        }

        try {
                rs.close();
                stmt.close();
                return contas;

        }
        catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o relatório compra: "+e.getMessage());
        }
        return contas;
    }
    
    public ArrayList<Conta> relatorioConta(int tipo, String str) {

        ArrayList <Conta> contas = new ArrayList<>();
        ArrayList <Compra> compras = new ArrayList<>();
        ArrayList <Cliente> clientes = new ArrayList<>();
        Cliente cli=null;
            
        try {
            
            conexao=SingletonCon.getConexao();
            
            if(tipo == 1){
                
                String SQL =    "SELECT id_conta, data_vencimento, total, id_cli \n" +
                                "FROM conta c\n" +
                                "join cliente cl on c.id_cli = cl.id_cliente\n" +
                                "where cl.nome like ?\n" +
                                "and tipo=1;";
                stmt=conexao.prepareStatement(SQL);
                stmt.setString(1, str);
                rs=stmt.executeQuery();
            }else if(tipo ==2){
                String SQL =    "SELECT id_conta, data_vencimento, total, id_cli \n" +
                                "FROM conta c\n" +
                                "join cliente cl on c.id_cli = cl.id_cliente\n" +
                                "where cl.nome like ?\n" +
                                "and tipo=2;";
                stmt=conexao.prepareStatement(SQL);
                stmt.setString(1, str);
                rs=stmt.executeQuery();
            }else{
                String SQL =    "SELECT id_conta, data_vencimento, total, id_cli \n" +
                                "FROM conta c\n" +
                                "join cliente cl on c.id_cli = cl.id_cliente\n" +
                                "where cl.nome like ?\n";
                stmt=conexao.prepareStatement(SQL);
                stmt.setString(1, str);                
                rs=stmt.executeQuery();
            }

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
                JOptionPane.showMessageDialog(null, "1Erro buscar contas: "+e.getMessage());
        }

        try {
                rs.close();
                stmt.close();
                return contas;

        }
        catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o conexão ao buscar contas: "+e.getMessage());
        }
        return contas;
    }
    
    
    
    public ArrayList<Conta> relatorioContaParaGerarFatura(int tipo, String str) {

        ArrayList <Conta> contas = new ArrayList<>();
        ArrayList <Compra> compras = new ArrayList<>();
        ArrayList <Cliente> clientes = new ArrayList<>();
        Cliente cli=null;
            
        try {
            
            conexao=SingletonCon.getConexao();
            
            if(tipo == 1){
                
                String SQL =    "SELECT id_conta, data_vencimento, total, id_cli \n" +
                                "FROM conta c\n" +
                                "join cliente cl on c.id_cli = cl.id_cliente\n" +
                                "where cl.nome like ? " +
                                "and tipo=1 " + 
                                "AND id_conta NOT IN (select id_conta_fatura from fatura)";
                
                
                stmt=conexao.prepareStatement(SQL);
                stmt.setString(1, str);
                rs=stmt.executeQuery();
            }else if(tipo ==2){
                String SQL =    "SELECT id_conta, data_vencimento, total, id_cli \n" +
                                "FROM conta c\n" +
                                "join cliente cl on c.id_cli = cl.id_cliente\n" +
                                "where cl.nome like ?\n" +
                                "and tipo=2 " + 
                                "AND id_conta NOT IN (select id_conta_fatura from fatura)";
                stmt=conexao.prepareStatement(SQL);
                stmt.setString(1, str);
                rs=stmt.executeQuery();
            }else{
                String SQL =    "SELECT id_conta, data_vencimento, total, id_cli \n" +
                                "FROM conta c\n" +
                                "join cliente cl on c.id_cli = cl.id_cliente\n" +
                                "where cl.nome like ? " + 
                                "AND id_conta NOT IN (select id_conta_fatura from fatura)";
                stmt=conexao.prepareStatement(SQL);
                stmt.setString(1, str);                
                rs=stmt.executeQuery();
            }

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
                JOptionPane.showMessageDialog(null, "1Erro buscar contas: "+e.getMessage());
        }

        try {
                rs.close();
                stmt.close();
                return contas;

        }
        catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o conexão ao buscar contas: "+e.getMessage());
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


            }

        }
        catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Erro no relatório compra: "+e.getMessage());
        }

        try {
            rs.close();
            stmt.close();
            return contas;

        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar o relatório compra: "+e.getMessage());
        }
        return contas;
    }

    public ArrayList<Conta> getConta(int chave) {

        ArrayList <Conta> contas = new ArrayList<>();
        ArrayList <Compra> compras = new ArrayList<>();
        ArrayList <Cliente> clientes = new ArrayList<>();
        Cliente cli=null;
        try {
            conexao=SingletonCon.getConexao();

            String SQL = "SELECT * FROM conta where id_conta = ?";
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
                JOptionPane.showMessageDialog(null, "Erro no relatório compra: "+e.getMessage());
        }

        try {
                rs.close();
                stmt.close();
                return contas;

        }
        catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o relatório compra: "+e.getMessage());
        }
        return contas;
    }
    
    public Conta buscarConta(int id_conta) {

        
        ArrayList <Compra> compras = new ArrayList<>();
        ArrayList <Cliente> clientes = new ArrayList<>();
        Conta conta = null;
        Cliente cli=null;
        try {
            conexao=SingletonCon.getConexao();

            String SQL = "SELECT * FROM conta where id_conta = ?";
            stmt=conexao.prepareStatement(SQL);
            stmt.setInt(1, id_conta);
            rs=stmt.executeQuery();
            
            DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            if(rs.next()) {
                int idConta;
                int idCliente;
                LocalDate data;
                Double total;
                String dataVencimento;

                idConta=rs.getInt("id_conta");
                idCliente=rs.getInt("id_cli");
                total=rs.getDouble("total");
                dataVencimento = rs.getObject("data_vencimento").toString();

                compras=daocompra.relatorioCompra(idConta);
                clientes=daocli.ArrayClientes();
                
                for(int i=0;i<clientes.size();i++) {
                    if(clientes.get(i).getId()==idCliente)
                        cli=clientes.get(i);
                }

                data = LocalDate.parse(dataVencimento, formater);

                conta = new Conta(compras, data,total,cli,idConta);
                

            }

        }
        catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao pegar conta: \n"+e.getMessage());
        }

        /*try {
                rs.close();
                stmt.close();
                conexao.close();
                return conta;

        }
        catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o conexão: \n"+e.getMessage());
        }*/
        return conta;
    }


    public void cadastroConta(Conta con) {

        try {
            conexao=SingletonCon.getConexao();	
            String SQL = "INSERT INTO conta (data_vencimento,total,id_cli) VALUES (TO_DATE(?, 'DD/MM/YYYY'),?,?)";
            stmt=conexao.prepareStatement(SQL);
            stmt.setString(1, con.getDataVencimento().format(format));
            stmt.setDouble(2, con.getTotal());
            stmt.setInt(3, con.getCli().getId());
            stmt.execute();
            con.setId(buscarId());
            daocompra.cadastroCompra(con.getCompras(), con.getId());

            stmt.close();
            JOptionPane.showMessageDialog(null, "\nCadastro efetuado com sucesso.");
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir a conta: "+e.getMessage());
        }


    }
    
    public void ExcluirConta (Conta con) {

        try {
            conexao=SingletonCon.getConexao();	
            String SQL = "DELETE FROM conta WHERE id_conta = ?";
            stmt=conexao.prepareStatement(SQL);
            stmt.setInt(1, con.getId());
            stmt.execute();
            

            JOptionPane.showMessageDialog(null, "Cliente Excluído com Sucesso!");
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Cliente: "+e.getMessage());
        }

        try {
            stmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão\n" + e.getMessage());
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
            JOptionPane.showMessageDialog(null, "Erro ao excluir a conta: "+ex.getMessage());
        }

        return id;

    }

    public void AlterarCliente(Conta con) {


        String SQL = "UPDATE public.conta SET id_cli=? WHERE id_conta=?;";


        try {
            conexao=SingletonCon.getConexao();	
            stmt=conexao.prepareStatement(SQL);
            stmt.setInt(1, con.getCli().getId());
            stmt.setInt(2, con.getId());
            stmt.execute();


            JOptionPane.showMessageDialog(null, "\nAlteração do Cliente efetuado com sucesso,\n"
                        + "na tabela Conta.");
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir a conta: "+e.getMessage());
        }

        try {    
            stmt.close();                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }



    }

    public void AlterarVencimento(Conta con) {


        String SQL = "UPDATE public.conta SET data_vencimento = TO_DATE(?, 'DD/MM/YYYY') WHERE id_conta=?;";


        try {
            conexao=SingletonCon.getConexao();	
            stmt=conexao.prepareStatement(SQL);
            stmt.setString(1, con.getDataVencimento().format(format));
            stmt.setInt(2, con.getId());
            stmt.execute();


            JOptionPane.showMessageDialog(null, "\nAlteração DataVencimento efetuado com sucesso,\n"
                        + "na tabela Conta.");
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar Alterar Data: "+e.getMessage());
        }

        try {    
            stmt.close();                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }



    }
}