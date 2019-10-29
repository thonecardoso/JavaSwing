/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author thone
 */
public class Fatura {
    
    private Conta conta;
	private LocalDate dataQuitacao;
	private double juros;
	private Integer quantParcela;
	public ArrayList <Pagamento> parcelas;
	private int idFatura;
	
	public Fatura(Conta conta, LocalDate dataQuitacao, double juros, Integer quantParcela,
			ArrayList<Pagamento> parcelas, int idFatura) {
		super();
		this.conta = conta;
		this.dataQuitacao = dataQuitacao;
		this.juros = juros;
		this.quantParcela = quantParcela;
		this.parcelas = parcelas;
		this.idFatura=idFatura;
	}
public Fatura() {
	// TODO Auto-generated constructor stub
}

	
	public int getIdFatura() {
	return idFatura;
}
public void setIdFatura(int idFatura) {
	this.idFatura = idFatura;
}
	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public LocalDate getDataQuitacao() {
		return dataQuitacao;
	}

	public void setDataQuitacao(LocalDate dataQuitacao) {
		this.dataQuitacao = dataQuitacao;
	}

	public double getJuros() {
		return juros;
	}

	public void setJuros(double juros) {
		this.juros = juros;
	}

	public Integer getQuantParcela() {
		return quantParcela;
	}

	public void setQuantParcela(Integer quantParcela) {
		this.quantParcela = quantParcela;
	}

	public ArrayList<Pagamento> getParcelas() {
		return parcelas;
	}

	public void setParcelas(ArrayList<Pagamento> parcelas) {
		this.parcelas = parcelas;
	}

    
}
