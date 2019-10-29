/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author thone
 */
public class Pagamento {
    
    private LocalDate data;
	private double valor;
	private int tipo;
	private double juros;
	private int id;
	
	public Pagamento(LocalDate data, double valor, int tipo, double juros, int id) {
		super();
		this.data = data;
		this.valor = valor;
		this.tipo = tipo;
		this.juros = juros;
		this.id = id ;
	}

	public Pagamento() {
		
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public double getJuros() {
		return juros;
	}

	public void setJuros(double juros) {
		this.juros = juros;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    
}
