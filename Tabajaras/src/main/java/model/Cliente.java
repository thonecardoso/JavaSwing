package model;

import java.util.ArrayList;

public class Cliente {

   private String nome;
   private ArrayList<Endereco> endereco;
   double limiteDeCredito;
   private int id_cliente;
   private int tipo;

    public Cliente() {
        this.endereco = new ArrayList<>();
    }

    public Cliente(String nome, ArrayList<Endereco> endereco, double limiteDeCredito, int id, int tipo) {
        this.nome = nome;
        this.endereco = endereco;
        this.limiteDeCredito = limiteDeCredito;
        this.id_cliente = id;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(ArrayList<Endereco> endereco) {
        this.endereco = endereco;
    }

    public double getLimiteDeCredito() {
        return limiteDeCredito;
    }

    public void setLimiteDeCredito(double limiteDeCredito) {
        this.limiteDeCredito = limiteDeCredito;
    }

    public int getId() {
        return id_cliente;
    }

    public void setId(int id) {
        this.id_cliente = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    
   
   
    
}

