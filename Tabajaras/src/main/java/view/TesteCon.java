/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.SingletonCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author chris
 */
public class TesteCon {
    public static void main(String[] args) {
        try{
            PreparedStatement stmt;
            ResultSet rs;
            Connection conexao = SingletonCon.getConexao();
            String sql = "SELECT * FROM login";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getString("usuario"));
                System.out.println(rs.getString("senha"));
                System.out.println("---------------------");
            }
            stmt.close();
            System.out.println("Conectado!");
        }catch(Exception e) {
            System.out.println("Falha: " + e.getMessage());
        }
    }
}
