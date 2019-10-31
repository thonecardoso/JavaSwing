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
public class Conta {
    
        private ArrayList<Compra> compras;
	private LocalDate dataVencimento;
	private double total;
	private Cliente cliente;
        private int id;
	
	public Conta(ArrayList<Compra> compras, LocalDate dataVencimento, double total, Cliente cli, int id) {
		super();
		this.compras = compras;
		this.dataVencimento = dataVencimento;
		this.total = total;
		this.cliente = cli;
		this.id = id;
	}

	public Conta() {
	
	}
	
	public ArrayList<Compra> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList<Compra> compras) {
		this.compras = compras;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Cliente getCli() {
		return cliente;
	}

	public void setCli(Cliente cli) {
		this.cliente = cli;
	}

	public void setId(int id) {
		this.id = id;
		
	}
	
	public int getId () {
		return id;
		
	}
    
}
