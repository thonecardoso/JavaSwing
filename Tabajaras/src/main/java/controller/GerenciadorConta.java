package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import dao.*;
import java.text.NumberFormat;
import java.util.Locale;
import model.*;


public class GerenciadorConta {

	private ArrayList<Compra> compras = new ArrayList<>();
	private ArrayList<Produto> prod = new ArrayList<>();
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private ArrayList<Conta> contas = new ArrayList<>();
	
        Locale locale = new Locale("pt", "BR");
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        
	private DAOCliente daocli;
	private DAOProduto daoprod;
	private DAOConta daoConta;

	

	public GerenciadorConta() {
		daocli = new DAOCliente();
		daoprod = new DAOProduto();
		daoConta = new DAOConta();
		
		this.clientes = daocli.ArrayClientes();
		this.prod = daoprod.relatorioProduto();
		this.contas=daoConta.relatorioConta();
	}
        
        public String RelatorioCont() {
		
		contas=daoConta.relatorioConta();
		String str="";
		if (!contas.isEmpty()) {
			str=str+"========== RELATÓRIO CONTAS ==========\n\n";
			
			for (int pos = 0; pos < contas.size(); pos++) {
				str=str+"Código da conta: "+contas.get(pos).getId();
                                str=str+"\n";
                                str=str+"Total conta: " + contas.get(pos).getTotal();
                                str=str+"\n";
				DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                str=str+"\n";
				str=str+"Data de vencimento: " + contas.get(pos).getDataVencimento().format(form);
                                str=str+"\n\n";
                                str=str+"CLIENTE\n";
                                
				if (contas.get(pos).getCli() instanceof PessoaFisica) {
					PessoaFisica pf = (PessoaFisica) contas.get(pos).getCli();
					str=str+"Nome: "+ pf.getNome();
                                        str=str+"\n";
					str=str+"CPF: "+ pf.getCpf();
                                        str=str+"\n";
					str=str+"Limite de Credito: "+ pf.getLimiteDeCredito();
                                        str=str+"\n";
				} else {
					PessoaJuridica pj = (PessoaJuridica) contas.get(pos).getCli();
					str=str+"Nome Fantasia: " + pj.getNomeFantasia();
                                        str=str+"\n";
					str=str+"Nome: " + pj.getNome();
                                        str=str+"\n";
					str=str+"CNPJ: " + pj.getCnpj();
                                        str=str+"\n";
					str=str+"Limite de Crédito: " + pj.getLimiteDeCredito();
                                        str=str+"\n\n\n";
				}

				for (int j = 0; j < contas.get(pos).getCompras().size(); j++) {
					str=str+"Compras\n\n";
                                        
                                        for(Compra c: contas.get(pos).getCompras()){
                                            str=str+"Compra->> "+c.getCodCompra();
                                            str=str+"\n";
                                            str=str+"Total->> "+c.getTotal();
                                            str=str+"\n";
                                            
                                            str=str+"Data da Compra->> "+c.getData().format(form);
                                            str=str+"\n\n";
                                            str=str+"Produtos";
                                            str=str+"\n\n";
                                                str=str+"Nº_";
                                            str=str+"__Produto__";
                                            str=str+"Pais de Origem__";
                                            str=str+"Preço__";
                                                for(int k=0;k<c.getProd().size();k++){
                                                    Produto pr = c.getProd().get(k);
                                                    str=str+(k+1);
                                                    str=str+pr.getNome();
                                                    str=str+pr.getPaisDeOrigem();
                                                    str=str+nf.format(pr.getPreco());
                                                    str=str+"\n";
                                                }
                                            str=str+"\n\n";    
                                        }
                                        
				}
				
				str=str+"======================================";
                                str=str+"\n";
			}

		} else
			str=str+"Não existe contas cadastradas.\n";
                        return str;   
	}
        
        public String RelatorioCont1(ArrayList<Conta> caracas) {
		
		contas=caracas;
		String str="";
		if (!contas.isEmpty()) {
			str=str+"========== RELATÓRIO CONTAS ==========\n\n";
			
			for (int pos = 0; pos < contas.size(); pos++) {
				str=str+"Código da conta: "+contas.get(pos).getId();
                                str=str+"\n";
                                str=str+"Total conta: " + contas.get(pos).getTotal();
                                str=str+"\n";
				DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                str=str+"\n";
				str=str+"Data de vencimento: " + contas.get(pos).getDataVencimento().format(form);
                                str=str+"\n\n";
                                str=str+"CLIENTE\n";
                                
				if (contas.get(pos).getCli() instanceof PessoaFisica) {
					PessoaFisica pf = (PessoaFisica) contas.get(pos).getCli();
					str=str+"Nome: "+ pf.getNome();
                                        str=str+"\n";
					str=str+"CPF: "+ pf.getCpf();
                                        str=str+"\n";
					str=str+"Limite de Credito: "+ pf.getLimiteDeCredito();
                                        str=str+"\n";
				} else {
					PessoaJuridica pj = (PessoaJuridica) contas.get(pos).getCli();
					str=str+"Nome Fantasia: " + pj.getNomeFantasia();
                                        str=str+"\n";
					str=str+"Nome: " + pj.getNome();
                                        str=str+"\n";
					str=str+"CNPJ: " + pj.getCnpj();
                                        str=str+"\n";
					str=str+"Limite de Crédito: " + pj.getLimiteDeCredito();
                                        str=str+"\n\n\n";
				}

				for (int j = 0; j < contas.get(pos).getCompras().size(); j++) {
					str=str+"Compras\n\n";
                                        
                                        for(Compra c: contas.get(pos).getCompras()){
                                            str=str+"Compra->> "+c.getCodCompra();
                                            str=str+"\n";
                                            str=str+"Total->> "+c.getTotal();
                                            str=str+"\n";
                                            
                                            str=str+"Data da Compra->> "+c.getData().format(form);
                                            str=str+"\n\n";
                                            str=str+"--==]Produtos[==--";
                                            str=str+"\n\n";
                                            
                                            str=str+"Nº_";
                                            str=str+"__Produto__";
                                            str=str+"Pais de Origem__";
                                            str=str+"Preço__";
                                                for(int k=0;k<c.getProd().size();k++){
                                                    Produto pr = c.getProd().get(k);
                                                    str=str+(k+1);
                                                    str=str+pr.getNome();
                                                    str=str+pr.getPaisDeOrigem();
                                                    str=str+nf.format(pr.getPreco());
                                                    str=str+"\n";
                                                }
                                            str=str+"\n\n";    
                                        }
                                        
				}
				
				str=str+"======================================";
                                str=str+"\n";
			}

		} else
			str=str+"Não existe contas cadastradas.\n";
                        return str;   
	}


	
			
}