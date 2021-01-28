package controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import dao.DAOProduto;
import javax.swing.JOptionPane;
import model.Produto;

public class GerenciadorProduto{

	private Scanner sc = new Scanner(System.in);
	private ArrayList <Produto> prod; 
	private DAOProduto daopro;
	private Connection con;

	public GerenciadorProduto() {
		super();
		prod = new ArrayList<>();
		daopro = new DAOProduto();
	}
	

	public void cadastrarProduto(String nome, double preco, String codigo, String tipouva, String pais, String tipovinho) {            
		Produto pro = new Produto(nome,preco,codigo,tipouva,pais,tipovinho);
		daopro.cadastroProduto(pro);
	}

	public Produto buscarProduto(String cod) {              
		prod=daopro.relatorioProduto();
		if(!prod.isEmpty()) {
			Produto pro = new Produto();
			pro = daopro.buscarProduto(cod);
			if(pro.getNome() != null) {
                            return pro;
			}
			else
                            JOptionPane.showMessageDialog(null,"Produto não encontrado");
		}
		else
                    JOptionPane.showMessageDialog(null,"Não existe produtos cadastrados");                    
                return null;                      
        }

	public void alterarProduto(Produto produto, String cod) {           
            daopro.alterarProduto(cod, produto);				
	}

	public void excluirProduto(String cod) {          
               daopro.excluirProduto(cod);
	}
			
	public String relatorioProduto() {
		prod=daopro.relatorioProduto();
		String str="";
		if(!prod.isEmpty()) {
			
			str = str +"--->Relatório de Produtos<---";
                        str = str +"\n";
			for(int i=0; i<prod.size();i++) {
				str = str +"=======================\n";
				str = str +"Nome: "+ prod.get(i).getNome();
                                str = str +"\n";
				str = str +"Preço: " + String.valueOf(prod.get(i).getPreco());
                                str = str + "\n";
				str = str +"Código de Barras: " + prod.get(i).getCodigoDeBarras();
                                str = str + "\n";
                                str = str +"Tipo de Uva: " + prod.get(i).getTipoDeUva();
                                str = str +"\n";
                                str = str +"Páis de Origem: " + prod.get(i).getPaisDeOrigem();
                                str = str + "\n";
                                str = str +"Tipo de Vinho: " + prod.get(i).getTipoDeVinho();
                                str = str +"\n=======================\n";
			}
		}
		else
		str = str + "Não existe produtos cadastrados.\n";
                return str;
	}
	        
}