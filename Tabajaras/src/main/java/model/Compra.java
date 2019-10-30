/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author thone
 */
public class Compra {
    
    private ArrayList<Produto> produtos;
private double total;
private LocalDate data;
private int codCompra;

public Compra(ArrayList<Produto> prod, double total, LocalDate data, int codCompra) {
	super();
	this.produtos = prod;
	this.total = total;
	this.data = data;
	this.codCompra = codCompra;
}

public Compra(){
    this.produtos = new ArrayList<>();
    this.data = LocalDate.now();
}

public int getCodCompra() {
	return codCompra;
}

public void setCodCompra(int codCompra) {
	this.codCompra = codCompra;
}

public ArrayList<Produto> getProd() {
	return produtos;
}

public void setProd(ArrayList<Produto> prod) {
	this.produtos = prod;
}

public double getTotal() {
	return total;
}

public void setTotal(double total) {
	this.total = total;
}

public LocalDate getData() {
	return data;
}

public void setData(LocalDate data) {
	this.data = data;
}
    
}
