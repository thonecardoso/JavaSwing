package model;

public class Produto {

    private String nome;
    private double preco;
    private String codigoDeBarras;
    private String tipoDeUva;
    private String paisDeOrigem;
    private String tipoDeVinho;

    public Produto(String nome, double preco, String codigoDeBarras, String tipoDeUva, String paisDeOrigem, String tipoDeVinho) {
        this.nome = nome;
        this.preco = preco;
        this.codigoDeBarras = codigoDeBarras;
        this.tipoDeUva = tipoDeUva;
        this.paisDeOrigem = paisDeOrigem;
        this.tipoDeVinho = tipoDeVinho;
    }

    public Produto() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public String getTipoDeUva() {
        return tipoDeUva;
    }

    public void setTipoDeUva(String tipoDeUva) {
        this.tipoDeUva = tipoDeUva;
    }

    public String getPaisDeOrigem() {
        return paisDeOrigem;
    }

    public void setPaisDeOrigem(String paisDeOrigem) {
        this.paisDeOrigem = paisDeOrigem;
    }

    public String getTipoDeVinho() {
        return tipoDeVinho;
    }

    public void setTipoDeVinho(String tipoDeVinho) {
        this.tipoDeVinho = tipoDeVinho;
    }
}
