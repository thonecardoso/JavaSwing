package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import dao.DAOConta;
import dao.DAOFatura;
import dao.DAOPagamento;
import model.Conta;
import model.Fatura;
import model.Pagamento;
import model.PessoaFisica;
import model.PessoaJuridica;

public class GerenciadorFatura {

	private ArrayList<Conta> contas = new ArrayList<>();
	private ArrayList<Fatura> faturas = new ArrayList<>();
	private enum tipoParcela {DINHEIRO, DEBITO, CREDITO};
	private CalculaJuros cj = new CalculaJuros();
	private DAOFatura daoFat;
	private DAOConta daoConta;
	private DAOPagamento daoPaga;
	private LocalDate defaut;
	private Scanner sc = new Scanner (System.in);
	DateTimeFormatter form;
	
	public GerenciadorFatura() {
		daoFat= new DAOFatura();
		daoConta = new DAOConta();
		daoPaga= new DAOPagamento();
		form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		defaut = LocalDate.parse("01/01/2000", form);
		
		this.faturas=daoFat.relatorioFatura();
		this.contas=daoConta.relatorioConta();
	}
	
	
	private void cadastrarFatura() {
		
		System.out.println("---> Cadastro de Fatura <---");
		System.out.println("Gostaria de listar as contas cadastradas?(SIM-1//NÃO-2)");
		System.out.printf(">>>");
		int op;
		op=sc.nextInt();
		sc.nextLine();
		
		if(op==1) {
			for(int i=0;i<contas.size();i++) {
				mostrarConta(i);
			}
		}
		
		System.out.println("Digite a posição da conta que deseja inserir na fatura: ");
		System.out.printf(">>>");
		int pos;
		pos=sc.nextInt();
		sc.nextLine();
		if(pos>=0&&pos<contas.size()) {
			
		int qParcela;
		boolean loop=true;
		
		while(loop) {		
			System.out.println("Digite a quantidade de parcelas: (MÁXIMO 3 PARCELAS)");
			System.out.printf(">>>");
			qParcela=sc.nextInt();
			sc.nextLine();
			
			if(qParcela<=3&&qParcela>0) {
				boolean loop1=true;
				while(loop1) {
				System.out.println("#==== Digite o tipo de pagamento: ====#");
				System.out.println("#=====================================#");
				System.out.println("#== 1  - >  DINHEIRO                ==#");
				System.out.println("#== 2  - >  CARTÃO DE DÉBITO        ==#");
				System.out.println("#== 3  - >  CARTÃO DE CRÉDITO       ==#");
				System.out.println("#=====================================#");
				System.out.printf("OPÇÃO: ");
				Integer tipo;
				tipo=sc.nextInt();
				sc.nextLine();
				
				if(tipo>=1&&tipo<=3) {
					ArrayList<Pagamento> parcelas = new ArrayList<>();
					double juros=cj.calculoJurosParcelamento(contas.get(pos).getTotal(),qParcela, tipo);
					int data=0;
					int codPag= daoPaga.buscarIDMAX();
					for(int i=1; i<=qParcela;i++) {
						data+=30;
						codPag++;
						double valor, jurosParcela;
						valor=(contas.get(pos).getTotal()+juros)/qParcela;
						jurosParcela=juros/qParcela;
						Pagamento parcela = new Pagamento(contas.get(pos).getDataVencimento().plusDays(data),valor, tipo, jurosParcela,codPag);
						parcelas.add(parcela);
					}
					boolean codTrue=true;
					int cod=-1;
					while(codTrue) {
						System.out.println("Digite o código da fatura: ");
						cod=sc.nextInt();
						sc.nextLine();
						if(validaCodFatura(cod)) {
							codTrue=false;
						}
						else
							System.out.println("Código já existe.");
					}
						
					Fatura fat =new Fatura(contas.get(pos), defaut, juros, qParcela, parcelas,cod);
					daoFat.cadastroFatura(fat);
					loop=false;
					loop1=false;
				}
				else
					System.out.println("Tipo inválido. ");
				}
			}
			else {
				System.out.println("Quantidade de parcelas inválidas.");
			}
		}
			
		}
		else 
			System.out.println("Posição inválida");
				
	}
	
	private boolean validaCodFatura(int cod) {
		faturas=daoFat.relatorioFatura();
		for(int i=0; i<faturas.size();i++) {
			if(cod==faturas.get(i).getIdFatura()) {
				return false;
			}
		}
		return true;
	}
	
	private int validaCodFatura2(int cod) {
		faturas=daoFat.relatorioFatura();
		for(int i=0; i<faturas.size();i++) {
			if(cod==faturas.get(i).getIdFatura()) {
				return i;
			}
		}
		return -1;
	}
	
	private void mostrarConta(int pos) {
		DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			System.out.println("---> Cliente <---");
			if (contas.get(pos).getCli() instanceof PessoaFisica) {
				PessoaFisica pf = (PessoaFisica) contas.get(pos).getCli();

				System.out.println("Nome: " + pf.getNome());
				System.out.println("CPF: " + pf.getCpf());
				System.out.println("Limite de Credito: " + pf.getLimiteDeCredito());
				System.out.println("================================");
			} else {
				PessoaJuridica pj = (PessoaJuridica) contas.get(pos).getCli();

				System.out.println("Nome Fantasia: " + pj.getNomeFantasia());
				System.out.println("Nome: " + pj.getNome());
				System.out.println("CNPJ: " + pj.getCnpj());
				System.out.println("Limite de Crédito: " + pj.getLimiteDeCredito());
				System.out.println("================================");
			}

			for(int j=0; j<contas.get(pos).getCompras().size();j++) {
				for(int k=0;k<contas.get(pos).getCompras().get(j).getProd().size();k++) {
					System.out.println("Nome: "+contas.get(pos).getCompras().get(j).getProd().get(k).getNome());
					System.out.println("Preço: "+contas.get(pos).getCompras().get(j).getProd().get(k).getPreco());
					System.out.println("Código de barras: "+contas.get(pos).getCompras().get(j).getProd().get(k).getCodigoDeBarras());
					System.out.println("======================================");
				}
				System.out.println("======================================");
				System.out.println("Total compra: "+contas.get(pos).getCompras().get(j).getTotal());
				System.out.println("Data da compra: "+contas.get(pos).getCompras().get(j).getData().format(form));
			}
			System.out.println("======================================");
			System.out.println("Total conta: "+contas.get(pos).getTotal());
			System.out.println("Data de vencimento: "+contas.get(pos).getDataVencimento().format(form));
			System.out.println("======================================\n\n");
		}
	
	private void alterarFatura() {
		faturas=daoFat.relatorioFatura();
		
		if(!faturas.isEmpty()) {
			
			System.out.println("Digite o código da fatura que deseja alterar:");
			System.out.printf(">>>");
			int codFatura = sc.nextInt();
			int pos=validaCodFatura2(codFatura);
			sc.nextLine();
			
			if(pos>=0&&pos<faturas.size()) {
				System.out.println("Gostaria de listar as contas?(SIM-1//NÃO-2) ");
				int op;
				op=sc.nextInt();
				sc.nextLine();
				
				if(op==1) {
					for(int i =0; i<contas.size(); i++)
						mostrarConta(i);
				}
					System.out.println("Digite a posição da conta que deseja alterar: ");
					System.out.printf(">>>");
					int pos1;
					pos1=sc.nextInt();
					sc.nextLine();
					
					faturas.get(pos).setConta(contas.get(pos1));
					boolean loop=true;
					int qParcela;
					
					while(loop) {		
						System.out.println("Digite a quantidade de parcelas: (MÁXIMO 3 PARCELAS)");
						System.out.printf(">>>");
						qParcela=sc.nextInt();
						sc.nextLine();
						
						if(qParcela<=3&&qParcela>0) {
							boolean loop1=true;
							while(loop1) {
								
							System.out.println("#==== Digite o tipo de pagamento: ====#");
							System.out.println("#=====================================#");
							System.out.println("#== 1  - >  DINHEIRO                ==#");
							System.out.println("#== 2  - >  CARTÃO DE DÉBITO        ==#");
							System.out.println("#== 3  - >  CARTÃO DE CRÉDITO       ==#");
							System.out.println("#=====================================#");
							System.out.printf("OPÇÃO: ");
							Integer tipo;
							tipo=sc.nextInt();
							sc.nextLine();
					
							ArrayList<Pagamento> parcelas = new ArrayList<>();
							double juros=cj.calculoJurosParcelamento(contas.get(pos).getTotal(),qParcela, tipo);
							int data=0;
							int codPaga = daoPaga.buscarIDMAX();
							if(tipo>=1&&tipo<=3) {
								for(int i=1; i<=qParcela;i++) {
									data+=30;
									double valor, jurosParcela;
									codPaga++;
									valor=(contas.get(pos).getTotal()+juros)/qParcela;
									jurosParcela=juros/qParcela;
									Pagamento parcela = new Pagamento(contas.get(pos).getDataVencimento().plusDays(data),valor, tipo, jurosParcela,codPaga);
									parcelas.add(parcela);
								}
								
								faturas.get(pos).setJuros(juros);
								faturas.get(pos).setQuantParcela(qParcela);
								faturas.get(pos).setParcelas(parcelas);
								daoFat.alterarFatura(faturas.get(pos).getIdFatura(), faturas.get(pos));
								
								loop=false;
								loop1=false;
								System.out.println("Fatura alterada com sucesso. ");
								
							}
							else
								System.out.println("Tipo inválido.");
							}
						}
						else
							System.out.println("Quantidade de parcelas inválidas. ");
					}
				
			}
			else
				System.out.println("Não existe esta posição.");
			
		}
		else
			System.out.println("Não existe faturas cadastradas.");
		
	}
	
	private void pagarParcela() {
		faturas=daoFat.relatorioFatura();
		
		if(!faturas.isEmpty()) {
			
			System.out.println("Digite o código da fatura que deseja pagar: ");
			System.out.printf(">>>");
			int codFatura=sc.nextInt();
			int pos=validaCodFatura2(codFatura);
			sc.nextLine();
			
			if(pos>=0&&pos<faturas.size()) {
				
				if(!faturas.get(pos).parcelas.isEmpty()) {
				
				
				System.out.println("---> Parcelas da fatura selecionada <---\n");
				for(int i=0;i<faturas.get(pos).parcelas.size();i++) {
					System.out.printf("Valor: %.2f\n",faturas.get(pos).parcelas.get(i).getValor());
					System.out.printf("Juros: %.2f\n",faturas.get(pos).parcelas.get(i).getJuros());
					tipoParcela tipo=null;
					if(faturas.get(pos).getParcelas().get(i).getTipo()==1)
						tipo=tipo.DINHEIRO;
					else if(faturas.get(pos).getParcelas().get(i).getTipo()==2)
						tipo=tipo.DEBITO;
					else
						tipo=tipo.CREDITO;
					
					System.out.println("Tipo: "+tipo);
					System.out.println("Data de vencimento: "+faturas.get(pos).getParcelas().get(i).getData().format(form));
					System.out.println("======================================\n");	
				}
				
				System.out.println("Digite a posição da parcelas que deseja pagar: ");
				System.out.printf(">>>");
				int pos1;
				pos1=sc.nextInt();
				sc.nextLine();
				
				if(pos1>=0&&pos1<faturas.get(pos).parcelas.size()) {

					tipoParcela tipo=null;
	
					System.out.printf("Digite a data do pagamento no formato dd/MM/yyyy: ");
					String pagamento;
					pagamento=sc.nextLine();
					LocalDate dataPagamento=LocalDate.parse(pagamento, form);
					double juros;
					juros=cj.calculaJurosPorAtraso(faturas.get(pos).getParcelas().get(pos1).getValor(), faturas.get(pos).parcelas.get(pos1).getData(), dataPagamento);
					
					System.out.println("---> Parcela Selecionada <---");
					System.out.printf("Valor: %.2f\n",faturas.get(pos).parcelas.get(pos1).getValor());
					System.out.printf("Juros: %.2f\n",faturas.get(pos).parcelas.get(pos1).getJuros());
					
					if(faturas.get(pos).getParcelas().get(pos1).getTipo()==1)
						tipo=tipo.DINHEIRO;
					else if(faturas.get(pos).getParcelas().get(pos1).getTipo()==2)
						tipo=tipo.DEBITO;
					else
						tipo=tipo.CREDITO;
					
					System.out.println("Tipo: "+tipo);
					System.out.println("Data de vencimento: "+faturas.get(pos).getParcelas().get(pos1).getData().format(form));
					System.out.println("======================================");
					System.out.printf("Juros por atraso: %.2f\n",juros);
					System.out.printf("Valor total: %.2f\n", (juros+faturas.get(pos).parcelas.get(pos1).getValor()));
					System.out.println("======================================\n");
					System.out.println("Deseja pagar esta parcela?(SIM-1//NÃO-2)");
					System.out.printf(">>>");
					int op1;
					op1=sc.nextInt();
					sc.nextLine();
					if(op1==1) {
						
						daoPaga.pagarParcela(faturas.get(pos).parcelas.get(pos1).getData().format(form), faturas.get(pos).getIdFatura());
						faturas.get(pos).parcelas.remove(pos1);
					}
					else
						System.out.println("Parcela mantida.");
						
						if(faturas.get(pos).parcelas.isEmpty()) {
							faturas.get(pos).setDataQuitacao(LocalDate.now());
							daoFat.atualizarDataQuitacao(LocalDate.now().format(form), faturas.get(pos).getIdFatura());
						}
					}
				else
					System.out.println("Não existe parcelas nesta fatura.\n");
				}
				else
					System.out.println("Posição da parcela não existe.");
				
				
			}
			else
				System.out.println("Código inválido.");
			
		}
		else
			System.out.println("Não existe fatura cadastrada.");
		
	}
	
	private void relatorioFatura() {
		faturas=daoFat.relatorioFatura();
		
		if(!faturas.isEmpty()) {
			
			for(int pos=0;pos<faturas.size();pos++) {
				System.out.println("---> Fatura <---\n");
				System.out.println("Código fatura: "+faturas.get(pos).getIdFatura());
				System.out.println("---> Conta <---");
				System.out.println("---> Cliente <---");
				if (faturas.get(pos).getConta().getCli() instanceof PessoaFisica) {
					PessoaFisica pf = (PessoaFisica) faturas.get(pos).getConta().getCli();

					System.out.println("Nome: " + pf.getNome());
					System.out.println("CPF: " + pf.getCpf());
					System.out.println("Limite de Credito: " + pf.getLimiteDeCredito());
					System.out.println("================================");
				} else {
					PessoaJuridica pj = (PessoaJuridica) faturas.get(pos).getConta().getCli();

					System.out.println("Nome Fantasia: " + pj.getNomeFantasia());
					System.out.println("Nome: " + pj.getNome());
					System.out.println("CNPJ: " + pj.getCnpj());
					System.out.println("Limite de Crédito: " + pj.getLimiteDeCredito());
					System.out.println("================================");
				}

				for(int j=0; j<faturas.get(pos).getConta().getCompras().size();j++) {
					for(int k=0;k<faturas.get(pos).getConta().getCompras().get(j).getProd().size();k++) {
						System.out.println("Nome: "+faturas.get(pos).getConta().getCompras().get(j).getProd().get(k).getNome());
						System.out.println("Preço: "+faturas.get(pos).getConta().getCompras().get(j).getProd().get(k).getPreco());
						System.out.println("Código de barras: "+faturas.get(pos).getConta().getCompras().get(j).getProd().get(k).getCodigoDeBarras());
						System.out.println("======================================");
					}
					System.out.println("======================================");
					System.out.println("Total compra: "+faturas.get(pos).getConta().getCompras().get(j).getTotal());
					System.out.println("Data da compra: "+faturas.get(pos).getConta().getCompras().get(j).getData().format(form));
				}
				System.out.println("======================================");
				System.out.println("Total conta: "+faturas.get(pos).getConta().getTotal());
				System.out.println("Data de vencimento: "+faturas.get(pos).getConta().getDataVencimento().format(form));
				System.out.println("======================================\n");
				
				System.out.printf("Juros: %.2f\n",faturas.get(pos).getJuros());
				System.out.println("Quantidade de parcelas: "+faturas.get(pos).getQuantParcela());
				System.out.println("======================================\n");
				
				System.out.println("--> Parcelas <---\n");
				for(int i=0; i<faturas.get(pos).parcelas.size();i++) {
					System.out.printf("Valor: %.2f\n",faturas.get(pos).parcelas.get(i).getValor());
					System.out.printf("Juros: %.2f\n",faturas.get(pos).parcelas.get(i).getJuros());
					tipoParcela tipo=null;
					if(faturas.get(pos).getParcelas().get(i).getTipo()==1)
						tipo=tipo.DINHEIRO;
					else if(faturas.get(pos).getParcelas().get(i).getTipo()==2)
						tipo=tipo.DEBITO;
					else
						tipo=tipo.CREDITO;
					
					System.out.println("Tipo: "+tipo);
					System.out.println("Data de vencimento: "+faturas.get(pos).getParcelas().get(i).getData().format(form));
					System.out.println("Código da fatura: "+faturas.get(pos).getIdFatura());
					System.out.println("======================================\n\n");	
				}
				
				if(!faturas.get(pos).getDataQuitacao().format(form).equals(defaut.format(form))) {
					System.out.println("Data de quitação: "+faturas.get(pos).getDataQuitacao().format(form));
					System.out.println("Fatura quitada. ");
				}
				else
					System.out.println("Fatura não foi quitada.");
				
			}
			
		}
		else
			System.out.println("Não existe faturas cadastradas.");
		
	}
	
	private void buscarFatura() {
		faturas=daoFat.relatorioFatura();
		
		if(!faturas.isEmpty()) {
			System.out.println("Digite o código que deseja buscar:");
			System.out.printf(">>>");
			int codFatura = sc.nextInt();
			int pos=validaCodFatura2(codFatura);
			sc.nextLine();
			
			if(pos>=0&&pos<faturas.size()) {
				
				System.out.println("---> Fatura <---\n");
				System.out.println("---> Conta <---");
				DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				System.out.println("---> Cliente <---");
				if (faturas.get(pos).getConta().getCli() instanceof PessoaFisica) {
					PessoaFisica pf = (PessoaFisica) faturas.get(pos).getConta().getCli();

					System.out.println("Nome: " + pf.getNome());
					System.out.println("CPF: " + pf.getCpf());
					System.out.println("Limite de Credito: " + pf.getLimiteDeCredito());
					System.out.println("================================");
				} else {
					PessoaJuridica pj = (PessoaJuridica)  faturas.get(pos).getConta().getCli();

					System.out.println("Nome Fantasia: " + pj.getNomeFantasia());
					System.out.println("Nome: " + pj.getNome());
					System.out.println("CNPJ: " + pj.getCnpj());
					System.out.println("Limite de Crédito: " + pj.getLimiteDeCredito());
					System.out.println("================================");
				}

				for(int j=0; j<faturas.get(pos).getConta().getCompras().size();j++) {
					for(int k=0;k<faturas.get(pos).getConta().getCompras().get(j).getProd().size();k++) {
						System.out.println("Nome: "+faturas.get(pos).getConta().getCompras().get(j).getProd().get(k).getNome());
						System.out.println("Preço: "+faturas.get(pos).getConta().getCompras().get(j).getProd().get(k).getPreco());
						System.out.println("Código de barras: "+faturas.get(pos).getConta().getCompras().get(j).getProd().get(k).getCodigoDeBarras());
						System.out.println("======================================");
					}
					System.out.println("======================================");
					System.out.println("Total compra: "+faturas.get(pos).getConta().getCompras().get(j).getTotal());
					System.out.println("Data da compra: "+faturas.get(pos).getConta().getCompras().get(j).getData().format(form));
				}
				System.out.println("======================================");
				System.out.println("Total conta: "+faturas.get(pos).getConta().getTotal());
				System.out.println("Data de vencimento: "+faturas.get(pos).getConta().getDataVencimento().format(form));
				System.out.println("======================================\n");
				
				System.out.printf("Juros: %.2f\n",faturas.get(pos).getJuros());
				System.out.println("Quantidade de parcelas: "+faturas.get(pos).getQuantParcela());
				System.out.println("======================================\n");
				
				System.out.println("--> Parcelas <---\n");
				for(int i=0; i<faturas.get(pos).parcelas.size();i++) {
					System.out.printf("Valor: %.2f\n",faturas.get(pos).parcelas.get(i).getValor());
					System.out.printf("Juros: %.2f\n",faturas.get(pos).parcelas.get(i).getJuros());
					tipoParcela tipo=null;
					if(faturas.get(pos).getParcelas().get(i).getTipo()==1)
						tipo=tipo.DINHEIRO;
					else if(faturas.get(pos).getParcelas().get(i).getTipo()==2)
						tipo=tipo.DEBITO;
					else
						tipo=tipo.CREDITO;
					
					System.out.println("Tipo: "+tipo);
					System.out.println("Data de vencimento: "+faturas.get(pos).getParcelas().get(i).getData().format(form));
					System.out.println("Código da fatura: "+faturas.get(pos).getIdFatura());
					System.out.println("======================================\n\n");	
				}
				
				if(!faturas.get(pos).getDataQuitacao().format(form).equals(defaut.format(form))) {
					System.out.println("Data de quitação: "+faturas.get(pos).getDataQuitacao().format(form));
				}
				else
					System.out.println("Fatura não foi quitada.");
				
			}
			else
				System.out.println("Código inválido.");
			
		}
		else
			System.out.println("Não existe faturas cadastradas.");
		
	}
	
	private void excluirFatura() {
		faturas=daoFat.relatorioFatura();
		
		if(!faturas.isEmpty()) {
			
			System.out.println("Digite o código da fatura que deseja excluir: ");
			System.out.println(">>>");
			int codFatura = sc.nextInt();
			int pos=validaCodFatura2(codFatura);
			sc.nextLine();
			
			if(pos>=0&&pos<faturas.size()) {
				System.out.println("---> Fatura <---\n");
				System.out.println("---> Conta <---");
				DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				System.out.println("---> Cliente <---");
				if (faturas.get(pos).getConta().getCli() instanceof PessoaFisica) {
					PessoaFisica pf = (PessoaFisica) contas.get(pos).getCli();

					System.out.println("Nome: " + pf.getNome());
					System.out.println("CPF: " + pf.getCpf());
					System.out.println("Limite de Credito: " + pf.getLimiteDeCredito());
					System.out.println("================================");
				} else {
					PessoaJuridica pj = (PessoaJuridica) contas.get(pos).getCli();

					System.out.println("Nome Fantasia: " + pj.getNomeFantasia());
					System.out.println("Nome: " + pj.getNome());
					System.out.println("CNPJ: " + pj.getCnpj());
					System.out.println("Limite de Crédito: " + pj.getLimiteDeCredito());
					System.out.println("================================");
				}

				for(int j=0; j<faturas.get(pos).getConta().getCompras().size();j++) {
					for(int k=0;k<faturas.get(pos).getConta().getCompras().get(j).getProd().size();k++) {
						System.out.println("Nome: "+faturas.get(pos).getConta().getCompras().get(j).getProd().get(k).getNome());
						System.out.println("Preço: "+faturas.get(pos).getConta().getCompras().get(j).getProd().get(k).getPreco());
						System.out.println("Código de barras: "+faturas.get(pos).getConta().getCompras().get(j).getProd().get(k).getCodigoDeBarras());
						System.out.println("======================================");
					}
					System.out.println("======================================");
					System.out.println("Total compra: "+faturas.get(pos).getConta().getCompras().get(j).getTotal());
					System.out.println("Data da compra: "+faturas.get(pos).getConta().getCompras().get(j).getData().format(form));
				}
				System.out.println("======================================");
				System.out.println("Total conta: "+faturas.get(pos).getConta().getTotal());
				System.out.println("Data de vencimento: "+faturas.get(pos).getConta().getDataVencimento().format(form));
				System.out.println("======================================\n");
				
				System.out.printf("Juros: %.2f\n",faturas.get(pos).getJuros());
				System.out.println("Quantidade de parcelas:  "+faturas.get(pos).getQuantParcela());
				System.out.println("======================================\n");
				
				System.out.println("--> Parcelas <---\n");
				for(int i=0; i<faturas.get(pos).parcelas.size();i++) {
					System.out.printf("Valor: %.2f\n",faturas.get(pos).parcelas.get(i).getValor());
					System.out.printf("Juros: %.2f\n",faturas.get(pos).parcelas.get(i).getJuros());
					tipoParcela tipo=null;
					if(faturas.get(pos).getParcelas().get(i).getTipo()==1)
						tipo=tipo.DINHEIRO;
					else if(faturas.get(pos).getParcelas().get(i).getTipo()==2)
						tipo=tipo.DEBITO;
					else
						tipo=tipo.CREDITO;
					
					System.out.println("Tipo: "+tipo);
					System.out.println("Data de vencimento: "+faturas.get(pos).getParcelas().get(i).getData().format(form));
					System.out.println("Código da fatura: "+faturas.get(pos).getIdFatura());
					System.out.println("======================================\n\n");	
				}
				
				if(faturas.get(pos).getDataQuitacao()!=defaut) {
					System.out.println("Fatura quitada.");
					System.out.println("Data de quitação: "+faturas.get(pos).getDataQuitacao().format(form));
					
				}
				else
					System.out.println("Fatura não foi quitada.");
				
				System.out.println("==========================================\n");
				System.out.println("Essa é a fatura que deseja excluir?(SIM-1//NÃO-2)");
				System.out.printf(">>>");
				int op;
				op=sc.nextInt();
				sc.nextLine();
				
				if(op==1) {
					daoFat.excluirFatura(faturas.get(pos).getIdFatura());
				}
				else
					System.out.println("Fatura mantida.");
				
			}
			else
				System.out.println("Posição inválida. ");
			
		}
		else
			System.out.println("Não existe faturas cadastradas.");
	}
	
	public void menuFatura() {
		
		boolean loop = true;
		contas=daoConta.relatorioConta();
		
		if(!contas.isEmpty()) {
			
		while(loop) {

			System.out.println("\n#===============================#");
			System.out.println("#     ==> MENU FATURA <==       #");
			System.out.println("#===============================#");
			System.out.println("#== 1  - >  CADASTRO          ==#");
			System.out.println("#== 2  - >  ALTERAÇÃO         ==#");
			System.out.println("#== 3  - >  EXCLUSÃO          ==#");
			System.out.println("#== 4  - >  CONSULTA          ==#");
			System.out.println("#== 5  - >  RELATÓRIO         ==#");
			System.out.println("#== 6  - >  PAGAMENTO PARCELA ==#");
			System.out.println("#== 7  - >  VOLTAR            ==#");
			System.out.println("#===============================#");
			System.out.printf("OPÇÃO: ");
			int op;
			op=sc.nextInt();
			sc.nextLine();

			switch(op) {
			case 1:
				cadastrarFatura();
				break;
			case 2:
				alterarFatura();
				break;
			case 3:
				excluirFatura();
				break;
			case 4:
				buscarFatura();
				break;
			case 5:
				relatorioFatura();
				break;
			case 6:
				pagarParcela();
				break;
			case 7:
				loop=false;
				break;
			default:
				System.out.println("Opção inválida.");
				
			}
			
		}
		
		
		
		}
		else
			System.out.println("Não existe contas cadastradas.");
	}
	
	
}