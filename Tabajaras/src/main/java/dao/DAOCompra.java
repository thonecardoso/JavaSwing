package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import model.Compra;
import model.Produto;

public class DAOCompra {

    private ResultSet rs;
    private PreparedStatement stmt;
    private Connection conexao = null;

    private DAOItensCompra it;
    private DateTimeFormatter format;

    public DAOCompra(){
        it= new DAOItensCompra();
        format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public ArrayList<Compra> relatorioCompra(int codConta) {

        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        ArrayList <Compra> compras = new ArrayList<>();
        try {
            conexao=SingletonCon.getConexao();

            String SQL = "SELECT * FROM compra WHERE id_conta=?";
            stmt=conexao.prepareStatement(SQL);
            stmt.setInt(1, codConta);
            rs=stmt.executeQuery();

            while(rs.next()) {
                double total;
                String dataBanco;
                int codCompra;
                LocalDate dataReal;
                ArrayList <Produto> prod;

                total=rs.getDouble("total");
                //dataBanco=rs.getString("data_compra");
                dataBanco=rs.getObject("data_compra").toString();
                codCompra=rs.getInt("id_compra");

                prod=it.relatorioItensCompra(codCompra);

                dataReal=LocalDate.parse(dataBanco, formater);

                Compra comprar = new Compra(prod, total, dataReal, codCompra);
                compras.add(comprar);
            }
        }
        catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Erro no relatório compra: "+e.getMessage());
        }

        try {
            rs.close();
            stmt.close();
            return compras;

        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar o relatório compra: "+e.getMessage());
        }
        return compras;
    }

    public void cadastroCompra(ArrayList<Compra> compras, int codConta) {

        for(int i=0;i<compras.size();i++) {

            try {
                
                conexao=SingletonCon.getConexao();
                String SQL = "INSERT INTO compra (total, data_compra, id_conta) VALUES (?,TO_DATE(?, 'DD/MM/YYYY'),?)";
                stmt=conexao.prepareStatement(SQL);
                stmt.setDouble(1, compras.get(i).getTotal());
                stmt.setString(2, compras.get(i).getData().format(format));
                stmt.setInt(3, codConta);
                stmt.execute();	
                stmt.close();

                it.cadastroItensCompra(compras.get(i),this.getId());
            }
            catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao tentar inserir a compra: "+e.getMessage());
            }


        }


    }




    public Compra buscarCompra(int id_compra, int id_conta) {
        
        String SQL = "SELECT * FROM compra WHERE id_conta=?, id_compra=?";
        Compra comprar=null;
        try {
            conexao=SingletonCon.getConexao();

            stmt=conexao.prepareStatement(SQL);
            stmt.setInt(1, id_conta);
            stmt.setInt(2, id_compra);
            rs=stmt.executeQuery();

            if(rs.next()) {

                double total;
                String dataBanco;
                int codCompra;
                LocalDate dataReal;
                ArrayList <Produto> prod;

                total=rs.getDouble("total");
                dataBanco=rs.getString("data_compra");
                codCompra=rs.getInt("id_compra");

                prod=it.relatorioItensCompra(codCompra);

                dataReal=LocalDate.parse(dataBanco, format);

                comprar = new Compra(prod, total, dataReal, codCompra);
                rs.close();
                stmt.close();
            }
        }
        catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar a compra: "+e.getMessage());
        }
        return comprar;
    }

    public int getId() {

        String SQL = "SELECT MAX(id_compra) AS id FROM compra;";
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
                JOptionPane.showMessageDialog(null, "Erro ao pegar Id compra"+ex.getMessage());
        }

        return id;

    }
    public void excluirCompra(int cod) {



        try {
            
            conexao=SingletonCon.getConexao();
            String SQL = "DELETE FROM compra where id_compra = ?";
            stmt=conexao.prepareStatement(SQL);
            stmt.setInt(1, cod);
            stmt.execute();	


        }
        catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar inserir a compra: "+e.getMessage());
        }

        try {
                stmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao fechar conexão" + e.getMessage());
        }




    }
        
}