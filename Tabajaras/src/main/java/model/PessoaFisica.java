package model;

import java.util.ArrayList;

public class PessoaFisica extends Cliente{
    
    private String cpf;
	private int idFisica;

	public PessoaFisica(String nome, ArrayList<Endereco> endereco, double limiteDeCredito, int id, int tipo, String cpf,
			int idFisica) {
		super(nome, endereco, limiteDeCredito, id, tipo);
		this.cpf = cpf;
		this.idFisica = idFisica;
	}

	public PessoaFisica() {

	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdFisica() {
		return idFisica;
	}

	public void setIdFisica(int idFisica) {
		this.idFisica = idFisica;
	}

    
}
