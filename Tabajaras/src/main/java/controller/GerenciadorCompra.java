/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import model.Cliente;
import model.Compra;
import model.Produto;

/**
 *
 * @author thone
 */
public class GerenciadorCompra {
    
    private ArrayList<Compra> compras = new ArrayList<>();
	private ArrayList<Produto> prod = new ArrayList<>();
	private Cliente cli = new Cliente();
	private Scanner sc = new Scanner(System.in);
	private double creditoCliente; 


	public GerenciadorCompra(ArrayList<Compra> compras, ArrayList<Produto> prod, Cliente cli) {
		this.prod = prod;
		this.compras = compras;
		this.cli =cli;
	}

	private void atualizaCredito() {
		double total=0;
		for(int i=0;i<compras.size();i++)
			total+=compras.get(i).getTotal();
		
		creditoCliente=cli.getLimiteDeCredito()-total;
	}
	
	private void comprarProduto() {

		if(!prod.isEmpty()) {

			System.out.println("Gostaria de listar os produtos existentes?(SIM-1\\NÃO-2)");
			System.out.printf(">>>");
			int op;
			op=sc.nextInt();
			sc.nextLine();

			if(op==1) {
				System.out.println("========> Lista de Produtos <========");
				System.out.println("=====================================");
				for(int i =0; i<prod.size();i++) {
					System.out.println("Nome: "+prod.get(i).getNome());
					System.out.println("Valor: "+prod.get(i).getPreco());
					System.out.println("Código de Barras: "+prod.get(i).getCodigoDeBarras());
					System.out.println("=====================================");
	
				}
				System.out.println("=====================================");
				System.out.println("Limite de crédito do cliente: "+creditoCliente);
				System.out.println("=====================================");
			}


			double total=0;
			boolean loop = true;
			LocalDate date;
			ArrayList<Produto> lista = new ArrayList<>();
			double result=creditoCliente;

			while(loop) {

				System.out.println("Digite o código de barras do produto a ser adicionado:");
				System.out.printf(">>>");
				String cod;
				cod=sc.nextLine();
				int pos;
				pos=validaCodigo(cod);

				if(pos>=0) {
					System.out.println("\n=====================================");
					System.out.println("Nome: "+prod.get(pos).getNome());
					System.out.println("Código de Barras: "+prod.get(pos).getCodigoDeBarras());
					System.out.println("Valor: "+prod.get(pos).getPreco());
					System.out.println("=====================================");
					System.out.println("Limite de crédito do cliente: "+(creditoCliente-total));
					System.out.println("=====================================");
					System.out.println("Deseja adicionar este produto?(SIM-1//NÃO-2)");
					System.out.printf(">>>");
					int op2;
					op2=sc.nextInt();
					sc.nextLine();

					
					
					if(op2==1) {
						
						if((result-prod.get(pos).getPreco())>=0) {
							
							lista.add(prod.get(pos));
							total+=prod.get(pos).getPreco();
							date=LocalDate.now();
							result-=prod.get(pos).getPreco();
						}
						else {
							System.out.println("\nLimite de crédito excedido. Produto não adicionado.");
							System.out.println("=====================================");
							System.out.println("Limite de crédito do cliente: "+creditoCliente);
							System.out.println("=====================================");
						}
							
							boolean loop2=true;

							while(loop2) {

								System.out.println("\nDeseja comprar mais algum produto?(SIM-1//NÃO-2)");
								System.out.printf(">>>");
								int opcao;
								opcao=sc.nextInt();
								sc.nextLine();

								if(opcao==1) {
									loop2=false;
								}

								else if(opcao==2) {
									boolean validaCod = true;
									int codCompra=0;
									while(validaCod) {
										System.out.println("Digite o codigo para esta compra: ");
										System.out.println(">>> ");
										codCompra = sc.nextInt();
										sc.nextLine();
										if(validaCodigo(codCompra)) {
											validaCod=false;
										}
										else
											System.out.println("Código repitido, digite um código diferente.");
									}
									
									date=LocalDate.now();
									Compra com = new Compra(lista,total,date, codCompra);
									compras.add(com);
									loop2=false;
									loop=false;
									System.out.println("Compra finalizada com sucesso.");

								}
								else
									System.out.println("Opção incorreta.");

							}

							
						}
						else
							System.out.println("\nProduto não adicionado.\n");
						
					}
					else
						System.out.println("Código de barras inválido.\n");
					}
					
				}
				else
					System.out.println("Não existe produtos cadastrados.");
						
			
	}
	
	private boolean validaCodigo(int cod) {
		boolean valido=true;
		
		for(int i=0;i<compras.size();i++) {
			if(compras.get(i).getCodCompra()==cod) {
				valido=false;
			}
		}
		
		return valido;
	}

	private void alterarCompra() {
		if(!compras.isEmpty()) {
			System.out.println("---> Alteração da Lista de Compras <---\n");
			System.out.println("Digite a posição da compra que deseja alterar:");
			System.out.printf(">>>");
			int pos;
			pos=sc.nextInt();
			sc.nextLine();

			if(pos>=0&&pos<compras.size()) {

				System.out.println("Selecione a opção desejada: 1-Adicionar Produto// 2-Remover Produto");
				System.out.printf(">>>");
				int op;
				op=sc.nextInt();
				sc.nextLine();

				if(op==1) {
					System.out.println("Gostaria de listar os produtos?(SIM-1//NÃO-2)");
					System.out.printf(">>>");
					int opcao;
					opcao=sc.nextInt();
					sc.nextLine();

					if(opcao==1) {
						System.out.println("==> Lista de Produtos <==");
						System.out.println("=========================");
						for(int i =0; i<prod.size();i++) {
							System.out.println("Nome: "+prod.get(i).getNome());
							System.out.println("Valor: "+prod.get(i).getPreco());
							System.out.println("Código de Barras: "+prod.get(i).getCodigoDeBarras());
							System.out.println("=========================");
						}
						System.out.println("=====================================");
						System.out.println("Limite de crédito do cliente: "+creditoCliente);
						System.out.println("=====================================");

					}
					System.out.println("\nDigite o código de barras do produto a ser adicionado:");
					System.out.printf(">>>");
					String cod;
					cod=sc.nextLine();
					int posProduto;
					LocalDate data;
					posProduto=validaCodigo(cod);

					if(posProduto>=0) {
						double result = creditoCliente;
						
						if((result-prod.get(posProduto).getPreco())>=0) {
							compras.get(pos).getProd().add(prod.get(posProduto));
							compras.get(pos).setTotal(compras.get(pos).getTotal()+prod.get(posProduto).getPreco());
							data=LocalDate.now();
							compras.get(pos).setData(data);
							System.out.println("Produto adicionado com sucesso.\n");
							System.out.println("=====================================");
							System.out.println("Limite de crédito restante do cliente: "+(creditoCliente-compras.get(pos).getTotal()));
							System.out.println("=====================================");
							
						}
						else {
							System.out.println("Limíte de credito excedido, valor restante: "+creditoCliente);
						}
							
						
					}
					else
						System.out.println("Código de barras inválido.");


				}

				else if(op==2) {
					System.out.println("Gostaria de listar os produtos que estão dentro da compra?(SIM-1//NÃO-2)");
					System.out.printf(">>>");
					int opc;
					opc=sc.nextInt();
					sc.nextLine();

					if(opc==1) {
						System.out.println("---> Compra <---");
						System.out.println("Códico da compra: "+compras.get(pos).getCodCompra());
						System.out.println("================================");
						for(int i = 0; i<compras.get(pos).getProd().size();i++) {

							System.out.println("Nome: "+compras.get(pos).getProd().get(i).getNome());
							System.out.println("Preço: "+compras.get(pos).getProd().get(i).getPreco());
							System.out.println("Código de Barras: "+compras.get(pos).getProd().get(i).getCodigoDeBarras());
							System.out.println("================================");
							System.out.println("================================");
						}
						System.out.println("Total: "+compras.get(pos).getTotal());
						System.out.println("=====================================");
						System.out.println("Limite de crédito do cliente: "+creditoCliente);
						System.out.println("=====================================");
					}

					System.out.println("Digite o código de barras do produto que deseja excluir:");
					System.out.printf(">>>");
					String cod;
					cod=sc.nextLine();
					int posProduto;
					LocalDate data;
					posProduto=validaCodigo(cod);

					if(posProduto>=0) {
						compras.get(pos).setTotal(compras.get(pos).getTotal()-prod.get(posProduto).getPreco());
						data=LocalDate.now();
						compras.get(pos).setData(data);
						creditoCliente+=prod.get(posProduto).getPreco();
						compras.get(pos).getProd().remove(posProduto);
						System.out.println("\nProduto removido com sucesso.");
						atualizaCredito();
						System.out.println("Limite de crédito atualizado: "+creditoCliente);
						System.out.println("=====================================");

					}
					else
						System.out.println("Código inválido.");

				}
				else
					System.out.println("Opção inválida.");
			}
			else
				System.out.println("Posição inválida.");
		}
	}





	private int validaCodigo(String cod) {
		int pos;

		for(pos=0;pos<prod.size();pos++) {
			if(prod.get(pos).getCodigoDeBarras().equals(cod))
				return pos;
		}


		return -1;
	}

	private void buscarCompra() {

		if(!compras.isEmpty()) {

			System.out.println("Digite a posição da compra que deseja buscar:");
			System.out.printf(">>>");
			int pos;
			pos=sc.nextInt();
			sc.nextLine();

			if(pos>=0&&pos<compras.size()) {
				System.out.println("Códico da compra: "+compras.get(pos).getCodCompra());
				System.out.println("=========================");
				System.out.println("\n=========================");
				System.out.println("     Lista de produtos");
				System.out.println("=========================");
				for(int i=0;i<compras.get(pos).getProd().size();i++) {
					System.out.println("Nome: "+compras.get(pos).getProd().get(i).getNome());
					System.out.println("Preço: "+compras.get(pos).getProd().get(i).getPreco());
					System.out.println("Código de Barras: "+compras.get(pos).getProd().get(i).getCodigoDeBarras());
					System.out.println("=========================");
					System.out.println("=========================");
				}
				DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				System.out.println("Total: "+compras.get(pos).getTotal());
				System.out.println("Data da Compra: "+compras.get(pos).getData().format(format));
				System.out.println("=========================");
			}
			else
				System.out.println("Posição inválida.");

		}
		else
			System.out.println("Não existe compras cadastradas.");

	}


	private void relatorioCompra() {
		if(!compras.isEmpty()) {

			for(int j=0;j<compras.size();j++) {
				System.out.println("Códico da compra: "+compras.get(j).getCodCompra());
				System.out.println("=========================");
				System.out.println("\n=========================");
				System.out.println("     Lista de produtos");
				System.out.println("=========================");
				for(int i=0;i<compras.get(j).getProd().size();i++) {
					System.out.println("Nome: "+compras.get(j).getProd().get(i).getNome());
					System.out.println("Preço: "+compras.get(j).getProd().get(i).getPreco());
					System.out.println("Código de Barras: "+compras.get(j).getProd().get(i).getCodigoDeBarras());
					System.out.println("=========================");
				}
				DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				System.out.println("Total: "+compras.get(j).getTotal());
				System.out.println("Data da Compra: "+compras.get(j).getData().format(format));
				System.out.println("=========================");
			}
		}
		else
			System.out.println("Não existe compra cadastrada.");
	}


	private void excluirCompra() {
		if(!compras.isEmpty()) {
			System.out.println("Digite a posição da compra que deseja excluir:");
			System.out.printf(">>>");
			int pos;
			pos=sc.nextInt();
			sc.nextLine();

			if(pos>=0&&pos<compras.size()) {
				System.out.println("Códico da compra: "+compras.get(pos).getCodCompra());
				System.out.println("=========================");
				System.out.println("\n=========================");
				System.out.println("     Lista de produtos");
				System.out.println("=========================");
				for(int i=0;i<compras.get(pos).getProd().size();i++) {

					System.out.println("Nome: "+compras.get(pos).getProd().get(i).getNome());
					System.out.println("Preço: "+compras.get(pos).getProd().get(i).getPreco());
					System.out.println("Código de Barras: "+compras.get(pos).getProd().get(i).getCodigoDeBarras());
					System.out.println("=========================");
					System.out.println("=========================");
				}
				DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				System.out.println("Total: "+compras.get(pos).getTotal());
				System.out.println("Data da Compra: "+compras.get(pos).getData().format(format));
				System.out.println("=========================");

				System.out.println("Este é a compra que deseja excluir?(SIM-1//NÃO-2)");
				System.out.printf(">>>");
				int op;
				op=sc.nextInt();
				sc.nextLine();

				if(op==1) {
					compras.remove(pos);
					System.out.println("Removido com sucesso.");
				}
				else if(op==2) {
					System.out.println("Compra mantida.");
				}
				else
					System.out.println("Opção errada.");
			}
			else
				System.out.println("Posição inválida.");
		}
		else
			System.out.println("Não existe compra cadastrada.");
	}

	public void menuCompra() {
		
		boolean loop = true;

		while(loop) {
			atualizaCredito();

			System.out.println("\n#============================#");
			System.out.println("#     ==> MENU COMPRA <==     #");
			System.out.println("#=============================#");
			System.out.println("#== 1  - >  CADASTRO        ==#");
			System.out.println("#== 2  - >  ALTERAÇÃO       ==#");
			System.out.println("#== 3  - >  EXCLUSÃO        ==#");
			System.out.println("#== 4  - >  CONSULTA        ==#");
			System.out.println("#== 5  - >  RELATÓRIO       ==#");
			System.out.println("#== 6  - >  CREDITO CLIENTE ==#");
			System.out.println("#== 7  - >  VOLTAR          ==#");
			System.out.println("#=============================#");
			System.out.printf("OPÇÃO: ");
			int op;
			op=sc.nextInt();
			sc.nextLine();

			switch(op) {
			case 1:
				comprarProduto();;
				break;
			case 2:
				alterarCompra();
				break;
			case 3:
				excluirCompra();
				break;
			case 4:
				buscarCompra();
				break;
			case 5:
				relatorioCompra();
				break;
			case 6:
				System.out.println("\nLimite de Crédito do Cliente: "+creditoCliente);
				break;
			case 7:
				if(creditoCliente>=0) {
					if(!compras.isEmpty()) {
						loop=false;
					}
					else
						System.out.println("\nNão existe compras cadastradas. Cadastre uma compra.");
						
				}
				else
					System.out.println("\nLimite de crédito do cliente esta com valor negativo, retire alguns produtos.\n");
				break;
			default:
				System.out.println("Opção incorreta.\n");

			}
		}


	}

    
}
