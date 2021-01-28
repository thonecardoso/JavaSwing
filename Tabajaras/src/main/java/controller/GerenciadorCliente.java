package controller;

import dao.DAOCliente;
import java.util.ArrayList;
import model.Cliente;
import model.Endereco;
import model.PessoaFisica;
import model.PessoaJuridica;

public class GerenciadorCliente {
    
    DAOCliente cd = new DAOCliente();
	
	public GerenciadorCliente() {
		
	}
        
    

    public String relatorio1() {


		    ArrayList<Cliente> clientes = new ArrayList<>();
            
		    clientes.addAll(cd.ArrayClientes());
                    
                    String str= "";
		    
		    if(!clientes.isEmpty()) {
		    
			str = str + "RELATÓRIO\n\n";

			for (Cliente cl : clientes) {

				if (cl instanceof PessoaFisica) {

					PessoaFisica pf = (PessoaFisica) cl;
					str = str + "NOME: " + pf.getNome();
                                        str = str + "  ";
					str = str + "CPF: " + pf.getCpf();
                                        str = str + "  ";
                                        str = str + "ID: " + pf.getId();
                                        str = str + "\n";
					str = str + "LIMITE DE CRÉDITO: " + pf.getLimiteDeCredito();
                                        str = str + "\n";
                                        str = str + "\n" + "ENDEREÇOS";
                                        str = str + "\n";
                                        str = str + "\n";
					for (Endereco e : pf.getEndereco()) {

						str = str + "\nLOGRADOURO: " + e.getLogradouro();
                                                str = str + "\n";
						str = str + "NÚMERO: " + e.getNumero();
                                                str = str + "\n";
						str = str + "COMPLEMENTO: " + e.getComplemento();
                                                str = str + "\n";
						str = str + "BAIRRO: " + e.getBairro();
                                                str = str + "\n";
						str = str + "MUNICÍPIO: " + e.getMunicipio();
                                                str = str + "\n";
						str = str + "ESTADO: " + e.getEstado();
                                                str = str + "\n";
						str = str + "Tipo Endereço: " + e.getTipo();
                                                str = str + "\n";
                                                str = str + "\n";

					}

					str = str + "\n---------------------------------\n\n";

				} else if (cl instanceof PessoaJuridica) {

					PessoaJuridica pj = (PessoaJuridica) cl;
					str = str + "NOME: " + pj.getNome();
                                        str = str + "  ";
					str = str + "CNPJ: " + pj.getCnpj();
                                        str = str + "  ";
                                        str = str + "ID: " + pj.getId();
                                        str = str + "\n";
					str = str + "NOME FANTASIA: " + pj.getNomeFantasia();
                                        str = str + "\n";
					str = str + "LIMITE DE CRÉDITO: " + pj.getLimiteDeCredito();
                                        str = str + "\n";

					for (Endereco e : pj.getEndereco()) {

						str = str + "\nLOGRADOURO: " + e.getLogradouro();
                                                str = str + "\n";
						str = str + "NÚMERO: " + e.getNumero();
                                                str = str + "\n";
						str = str + "COMPLEMENTO: " + e.getComplemento();
                                                str = str + "\n";
						str = str + "BAIRRO: " + e.getBairro();
                                                str = str + "\n";
						str = str + "MUNICÍPIO: " + e.getMunicipio();
                                                str = str + "\n";
						str = str + "ESTADO: " + e.getEstado();
                                                str = str + "\n";
						str = str + "Tipo Endereço: " + e.getTipo();
                                                str = str + "\n";
                                                str = str + "\n";

					}

					str = str + "\n---------------------------------\n\n";
				}

			}

	}else {
		
		str = str + "NÃO EXISTEM CLIENTES CADASTRADOS";
		
	}
             
                    return str;

	}
    
        public double creditoDisponivel(int id){
            double x = 0;
            
            
            
            
            return x;
        }

}
