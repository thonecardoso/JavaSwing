package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Produto;

public class DAOProduto {

    private ResultSet rs;
    private PreparedStatement stmt;
    private Connection conexao;

    public ArrayList<Produto> relatorioProduto() {

        ArrayList<Produto> prod = new ArrayList<>();
        try {

            conexao = SingletonCon.getConexao();

            String SQL = "SELECT * FROM produto";
            stmt = conexao.prepareStatement(SQL);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String nome;
                String codBarra;
                Double preco;
                String tipouva;
                String pais;
                String tipovinho;

                nome = rs.getString("nome");
                preco = rs.getDouble("preco");
                codBarra = rs.getString("cod_barras");
                tipouva = rs.getString("tipo_de_uva");
                pais = rs.getString("pais_de_origem");
                tipovinho = rs.getString("tipo_de_vinho");
                Produto pro = new Produto(nome, preco, codBarra, tipouva, pais, tipovinho);
                prod.add(pro);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        }

        try {
            rs.close();
            stmt.close();
            return prod;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
        return prod;
    }

    public void cadastroProduto(Produto pro) {
        try {
            conexao = SingletonCon.getConexao();
            String SQL = "INSERT INTO produto (nome,preco,cod_barras,tipo_de_uva,pais_de_origem,tipo_de_vinho) VALUES (?,?,?,?,?,?)";
            stmt = conexao.prepareStatement(SQL);
            stmt.setString(1, pro.getNome());
            stmt.setDouble(2, pro.getPreco());
            stmt.setString(3, pro.getCodigoDeBarras());
            stmt.setString(4, pro.getTipoDeUva());
            stmt.setString(5, pro.getPaisDeOrigem());
            stmt.setString(6, pro.getTipoDeVinho());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir produto");
        }
    }

    public void alterarProduto(String cod, Produto pro) {

        try {
            String SQL = "UPDATE produto SET nome=?,preco=?,tipo_de_uva=?,pais_de_origem=?,tipo_de_vinho=? WHERE cod_barras=?";
            conexao = SingletonCon.getConexao();
            stmt = conexao.prepareStatement(SQL);
            stmt.setString(1, pro.getNome());
            stmt.setDouble(2, pro.getPreco());
            stmt.setString(3, pro.getTipoDeUva());
            stmt.setString(4, pro.getPaisDeOrigem());
            stmt.setString(5, pro.getTipoDeVinho());
            stmt.setString(6, cod);
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Alteração concluída com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar produto");
        }

    }

    public void excluirProduto(String cod) {

        String SQL = "DELETE FROM produto WHERE cod_barras= ? ";

        try {
            stmt = conexao.prepareStatement(SQL);
            stmt.setString(1, cod);
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Exclusão feita com sucesso");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao exluir produto");
        }

    }

    public Produto buscarProduto(String cod) {

        String SQL = "SELECT * FROM produto WHERE cod_barras=?";
        Produto pro = new Produto();
        try {

            conexao = SingletonCon.getConexao();
            stmt = conexao.prepareStatement(SQL);
            stmt.setString(1, cod);
            rs = stmt.executeQuery();

            if (rs.next()) {
                String nome;
                String codBarra;
                Double preco;
                String tipouva;
                String pais;
                String tipovinho;

                nome = rs.getString("nome");
                preco = rs.getDouble("preco");
                codBarra = rs.getString("cod_barras");
                tipouva = rs.getString("tipo_de_uva");
                pais = rs.getString("pais_de_origem");
                tipovinho = rs.getString("tipo_de_vinho");

                pro = new Produto(nome, preco, codBarra, tipouva, pais, tipovinho);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o produto: " + e.getMessage());
        }
        return pro;
    }
}
