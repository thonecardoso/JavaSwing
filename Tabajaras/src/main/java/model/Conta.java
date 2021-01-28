package model;

import java.time.LocalDate;
import java.util.ArrayList;

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
            this.compras = new ArrayList<>();
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
