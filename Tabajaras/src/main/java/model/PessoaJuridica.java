package model;

import java.util.ArrayList;

public class PessoaJuridica extends Cliente {
    private String nomeFantasia;
	private String cnpj;
	private int idJuridica;

	public PessoaJuridica(String nome, ArrayList<Endereco> endereco, double limiteDeCredito, int id, int tipo,
			String nomeFantasia, String cnpj, int idJuridica) {
		super(nome, endereco, limiteDeCredito, id, tipo);
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.idJuridica = idJuridica;
	}

	public PessoaJuridica() {

	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public int getIdJuridica() {
		return idJuridica;
	}

	public void setIdJuridica(int idJuridica) {
		this.idJuridica = idJuridica;
	}

    
}
