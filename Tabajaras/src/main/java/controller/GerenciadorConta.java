package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import dao.DAOCliente;
import dao.DAOConta;
import dao.DAOProduto;
import model.Cliente;
import model.Compra;
import model.Conta;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Produto;

public class GerenciadorConta {

	private ArrayList<Compra> compras = new ArrayList<>();
	private ArrayList<Produto> prod = new ArrayList<>();
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private ArrayList<Conta> contas = new ArrayList<>();
	
	private DAOCliente daocli;
	private DAOProduto daoprod;
	private DAOConta daoConta;

	private Scanner sc = new Scanner(System.in);

	public GerenciadorConta() {
		daocli = new DAOCliente();
		daoprod = new DAOProduto();
		daoConta = new DAOConta();
		
		this.clientes = daocli.buscarClientes();
		this.prod = daoprod.relatorioProduto();
		this.contas=daoConta.relatorioConta();
	}

	private void cadastrarConta() {

		System.out.println("--> CADASTRANDO CONTA <--");

		System.out.println("--> Escolha um cliente cadastrado.<-- ");
		System.out.println("Gostaria de listar os clientes cadastrados?(SIM-1//NÃO-2)");
		System.out.printf(">>>");
		int op;
		op = sc.nextInt();
		sc.nextLine();

		if (op == 1) {

			for (int i = 0; i < clientes.size(); i++) {

				if (clientes.get(i) instanceof PessoaFisica) {
					PessoaFisica pf = (PessoaFisica) clientes.get(i);

					System.out.println("Nome: " + pf.getNome());
					System.out.println("CPF: " + pf.getCpf());
					System.out.println("Limite de Credito: " + pf.getLimiteDeCredito());
					System.out.println("================================");
				} else {
					PessoaJuridica pj = (PessoaJuridica) clientes.get(i);

					System.out.println("Nome Fantasia: " + pj.getNomeFantasia());
					System.out.println("Nome: " + pj.getNome());
					System.out.println("CNPJ: " + pj.getCnpj());
					System.out.println("Limite de Crédito: " + pj.getLimiteDeCredito());
					System.out.println("================================");
				}
			}

		}

		System.out.println("Digite o CPF ou CNPJ do cliente que deseja inserir: ");
		System.out.printf(">>>");
		String cod;
		cod = sc.nextLine();
		Cliente cli;
		cli = buscarCliente(cod);

		if (cli != null) {

			GerenciadorCompra genCompra = new GerenciadorCompra(compras, prod, cli);
			genCompra.menuCompra();
			double total = 0;
			LocalDate dataVencimento, hoje;
			boolean loop = true;
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String vencimento;

			while (loop) {

				System.out.printf("Digite a data de vencimento no formato dd/MM/yyyy: ");
				vencimento = sc.nextLine();

				dataVencimento = LocalDate.parse(vencimento, format);
				hoje = LocalDate.now();
				if (!dataVencimento.isBefore(hoje)) {

					for (int i = 0; i < compras.size(); i++) {
						total += compras.get(i).getTotal();
					}
					System.out.println("\n---> Conta <---");
					System.out.println("Total: "+total);
					System.out.println("Data vencimento: "+dataVencimento.format(format));
					System.out.println("======================================\n");
					
					
					System.out.println("Gostaria de fazer o pagamento à vista desta conta?(SIM-1//NÃO-2)");
					int op1;
					op1=sc.nextInt();
					sc.nextLine();
					if(op1==1) {
						System.out.println("Conta paga com sucesso.");
						compras.clear();
						loop = false;
					}
					else {
						System.out.println("Digite o código da conta: ");
						int codConta;
						codConta = sc.nextInt();
						
						Conta cont = new Conta(compras, dataVencimento, total, cli, codConta);
						daoConta.cadastroConta(cont);
						compras.clear();
						
						loop = false;
					}
							
				} else {
					System.out.println("Data incorreta.");
				}

			}

		} else
			System.out.println("CPF ou CNPJ não encontrado.");
	}

	private Cliente buscarCliente(String cod) {

		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i) instanceof PessoaFisica) {
				PessoaFisica pf = (PessoaFisica) clientes.get(i);
				if (pf.getCpf().equals(cod)) {
					return clientes.get(i);
				}
			} else {
				PessoaJuridica pj = (PessoaJuridica) clientes.get(i);
				if (pj.getCnpj().equals(cod)) {
					return clientes.get(i);
				}
			}
		}

		return null;
	}

	private void alterarConta() {
		contas=daoConta.relatorioConta();

		if (!contas.isEmpty()) {

			System.out.println("---> Alterando a conta <---\n");

			System.out.println("Digite o código da conta que deseja altera:");
			System.out.printf(">>>");
			int pos, codConta;
			codConta = sc.nextInt();
			pos=validarConta(codConta);
			sc.nextLine();

			if (pos >= 0 && pos < contas.size()) {

				System.out.println("Gostaria de listar os clientes?(SIM-1//NÃO-2)");
				System.out.printf(">>>");
				int op;
				op = sc.nextInt();
				sc.nextLine();

				if (op == 1) {
					mostrarClientes();
				}

				System.out.printf("\nDigite o CPF ou CNPJ do cliente:");
				String cod;
				cod = sc.nextLine();
				Cliente cli = buscarCliente(cod);

				if (cli != null) {

					if (cli instanceof PessoaFisica) {
						PessoaFisica pf = (PessoaFisica) cli;

						System.out.println("Nome: " + pf.getNome());
						System.out.println("CPF: " + pf.getCpf());
						System.out.println("Limite de Crédito: " + pf.getLimiteDeCredito());
						System.out.println("================================");
					} else {
						PessoaJuridica pj = (PessoaJuridica) cli;

						System.out.println("Nome Fantasia: " + pj.getNomeFantasia());
						System.out.println("Nome: " + pj.getNome());
						System.out.println("CNPJ: " + pj.getCnpj());
						System.out.println("Limite de Crédito: " + pj.getLimiteDeCredito());
						System.out.println("================================");
					}

					System.out.println("Esse é o cliente que deseja sobrepor: (SIM-1//NÃO-2)");
					int opc;
					opc = sc.nextInt();
					sc.nextLine();

					if (opc == 1) {
						contas.get(pos).setCli(cli);
						System.out.println("Cliente alterado com sucesso!\n");
					} else
						System.out.println("Cliente não alterado");

					GerenciadorCompra genCompra = new GerenciadorCompra(contas.get(pos).getCompras(), prod,
							contas.get(pos).getCli());
					System.out.println("Alteração de conta.");
					genCompra.menuCompra();

					double total = 0;
					LocalDate dataVencimento, hoje;
					boolean loop = true;
					DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					String vencimento;

					while (loop) {

						System.out.printf("Digite a data de vencimento no formato dd/MM/yyyy: ");
						vencimento = sc.nextLine();

						dataVencimento = LocalDate.parse(vencimento, format);
						hoje = LocalDate.now();
						if (!dataVencimento.isBefore(hoje)) {

							for (int i = 0; i < compras.size(); i++) {
								total += compras.get(i).getTotal();
							}
							contas.get(pos).setTotal(total);
							contas.get(pos).setDataVencimento(dataVencimento);
							daoConta.alterarConta(contas.get(pos).getId(), contas.get(pos));
							loop = false;
							
						} else
							System.out.println("Data incorreta.");
					}

				} else
					System.out.println("CPF ou CNPJ não existe.");
			} else
				System.out.println("Posição não existe.");
		}
		else
			System.out.println("Não existe contas cadastradas.");
	}

	private void mostrarClientes() {
		for (int i = 0; i < clientes.size(); i++) {

			if (clientes.get(i) instanceof PessoaFisica) {
				PessoaFisica pf = (PessoaFisica) clientes.get(i);

				System.out.println("Nome: " + pf.getNome());
				System.out.println("CPF: " + pf.getCpf());
				System.out.println("Limite de Credito: " + pf.getLimiteDeCredito());
				System.out.println("================================");
			} else {
				PessoaJuridica pj = (PessoaJuridica) clientes.get(i);

				System.out.println("Nome Fantasia: " + pj.getNomeFantasia());
				System.out.println("Nome: " + pj.getNome());
				System.out.println("CNPJ: " + pj.getCnpj());
				System.out.println("Limite de Crédito: " + pj.getLimiteDeCredito());
				System.out.println("================================");
			}
		}

	}

	private void buscarConta() {
		
		contas=daoConta.relatorioConta();
		
		if (!contas.isEmpty()) {

			System.out.println("Digite o código da conta que deseja buscar:");
			System.out.printf(">>>");
			int pos,codConta;
			codConta = sc.nextInt();
			pos=validarConta(codConta);
			sc.nextLine();

			if (pos >= 0 && pos <= contas.size()) {

				System.out.println("Código da conta: "+contas.get(pos).getId());
				System.out.println("================================");
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

				for (int j = 0; j < contas.get(pos).getCompras().size(); j++) {
					System.out.println("\n===========Produtos===========");
					
					for (int x = 0; x < contas.get(pos).getCompras().get(j).getProd().size(); x++) {
						System.out.println("Nome: " + contas.get(pos).getCompras().get(j).getProd().get(x).getNome());
						System.out.println("Preço: " + contas.get(pos).getCompras().get(j).getProd().get(x).getPreco());
						System.out.println("Código de barras: "
								+ contas.get(pos).getCompras().get(j).getProd().get(x).getCodigoDeBarras());
						System.out.println("======================================\n");
					}
					System.out.println("Valor: " + contas.get(pos).getCompras().get(j).getTotal());
					DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					System.out.println("Data da Compra: " + contas.get(pos).getCompras().get(j).getData().format(format));
					System.out.println("======================================\n");
				}
				System.out.println("Total conta: " + contas.get(pos).getTotal());
				DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				System.out.println("Data de vencimento: " + contas.get(pos).getDataVencimento().format(form));
				System.out.println("======================================\n");

			} else
				System.out.println("Não existe este código.");

		} else
			System.out.println("Não existe contas cadastradas.");

	}

	public void relatorioConta() {
		
		contas=daoConta.relatorioConta();
		
		if (!contas.isEmpty()) {
			System.out.println("========== RELATÓRIO CONTAS ==========\n");
			
			for (int pos = 0; pos < contas.size(); pos++) {
				System.out.println("Código da conta: "+contas.get(pos).getId());
				System.out.println("================================");
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

				for (int j = 0; j < contas.get(pos).getCompras().size(); j++) {
					System.out.println("\n===========Produtos===========");
					for (int x = 0; x < contas.get(pos).getCompras().get(j).getProd().size(); x++) {
						System.out.println("Nome: " + contas.get(pos).getCompras().get(j).getProd().get(x).getNome());
						System.out.println("Preço: " + contas.get(pos).getCompras().get(j).getProd().get(x).getPreco());
						System.out.println("Código de barras: "
								+ contas.get(pos).getCompras().get(j).getProd().get(x).getCodigoDeBarras());
						System.out.println("======================================\n");
					}
					System.out.println("Valor: " + contas.get(pos).getCompras().get(j).getTotal());
					DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					System.out.println("Data da Compra: " + contas.get(pos).getCompras().get(j).getData().format(format));
					System.out.println("======================================\n");
				}
				System.out.println("Total conta: " + contas.get(pos).getTotal());
				DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				System.out.println("Data de vencimento: " + contas.get(pos).getDataVencimento().format(form));
				System.out.println("======================================\n");
			}

		} else
			System.out.println("Não existe contas cadastradas.");
	}

	private void excluirConta() {
		contas=daoConta.relatorioConta();
		
		if (!contas.isEmpty()) {
			System.out.println("========= EXCLUIR CONTA =========");
			System.out.println("Digite o código da conta que deseja excluir: ");
			System.out.printf(">>>");
			int pos;
			int codConta;
			codConta = sc.nextInt();
			pos=validarConta(codConta);
			sc.nextLine();

			if (pos >= 0 && pos < contas.size()) {

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

				for (int j = 0; j < contas.get(pos).getCompras().size(); j++) {
					System.out.println("\n===========Produtos===========");
					for (int x = 0; x < contas.get(pos).getCompras().get(j).getProd().size(); x++) {
						System.out.println("Nome: " + contas.get(pos).getCompras().get(j).getProd().get(x).getNome());
						System.out.println("Preço: " + contas.get(pos).getCompras().get(j).getProd().get(x).getPreco());
						System.out.println("Código de barras: "+ contas.get(pos).getCompras().get(j).getProd().get(x).getCodigoDeBarras());
						System.out.println("======================================\n");
					}
					System.out.println("Valor: " + contas.get(pos).getCompras().get(j).getTotal());
					DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					System.out.println("Data da Compra: " + contas.get(pos).getCompras().get(j).getData().format(format));
					System.out.println("======================================\n");
				}
				System.out.println("Total conta: " + contas.get(pos).getTotal());
				DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				System.out.println("Data de vencimento: " + contas.get(pos).getDataVencimento().format(form));
				System.out.println("======================================\n");
				System.out.println("Essa é a conta que deseja excluir?(SIM-1//NÃO-2)");
				System.out.printf(">>>");
				int op;
				op = sc.nextInt();
				sc.nextLine();
				if (op == 1) {
					daoConta.excluirConta(contas.get(pos));
				}
			} else
				System.out.println("Posição não existe.");

		} else
			System.out.println("Não existe contas cadastradas.");
	}
	
	public int validarConta(int codConta) {
		contas=daoConta.relatorioConta();
		
		for(int i=0; i<contas.size(); i++) {
			if(contas.get(i).getId()==codConta) {
				return i;
			}
		}
		return -1;
	}
	
	public void menuConta() {
		prod=daoprod.relatorioProduto();
		clientes=daocli.buscarClientes();
		
			if(!prod.isEmpty()) {
				
				if(!clientes.isEmpty()) {
					
						boolean loop = true;
						
						while(loop) {
							
						System.out.println("\n#======================#");
						System.out.println("# ==>  MENU CONTA  <== #");
						System.out.println("#======================#");
						System.out.println("#== 1 - >  CADASTRO  ==#");
						System.out.println("#== 2 - >  ALTERAÇÃO ==#");
						System.out.println("#== 3 - >  EXCLUSÃO  ==#");
						System.out.println("#== 4 - >  CONSULTA  ==#");
						System.out.println("#== 5 - >  RELATÓRIO ==#");
						System.out.println("#== 6 - >  VOLTAR    ==#");
						System.out.println("#======================#");
						System.out.printf("OPÇÃO: ");
						int op;
						op=sc.nextInt();
						sc.nextLine();
						
						switch(op) {
						case 1:
							cadastrarConta();
							break;
						case 2:
							alterarConta();
							break;
						case 3:
							excluirConta();
							break;
						case 4:
							buscarConta();
							break;
						case 5:
							relatorioConta();
							break;
						case 6:
							loop=false;
							break;
						default:
							System.out.println("Opção incorreta.");
					
						}
					}
				}
				else
					System.out.println("Não existe clientes cadastrados.");
				
			}
			else
				System.out.println("Não existe produtos cadastrados.");
			}

			
}