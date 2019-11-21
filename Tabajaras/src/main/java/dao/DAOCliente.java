package dao;

	
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
import javax.swing.JOptionPane;

	import model.Cliente;
	import model.Endereco;
	import model.PessoaFisica;
	import model.PessoaJuridica;

	public class DAOCliente {
            

		private PreparedStatement stmt;
		private Connection conexao;

		public void cadastroClienteFisica(PessoaFisica pf) {

			try {

				conexao=SingletonCon.getConexao();;

				String sql = "INSERT INTO cliente (nome,limite_de_credito,tipo) VALUES (?,?,?)";
				stmt = conexao.prepareStatement(sql);
				stmt.setString(1, pf.getNome());
				stmt.setDouble(2, pf.getLimiteDeCredito());
				stmt.setInt(3, 1);
				stmt.execute();
				stmt.close();

				sql = "INSERT INTO pessoa_fisica (cpf,id_fisica) VALUES (?,?)";

				try {

					stmt = conexao.prepareStatement(sql);
					stmt.setString(1, pf.getCpf());
					stmt.setInt(2, buscarIDCliente());
					stmt.execute();
					stmt.close();

					cadastrarEndereco(pf.getEndereco());

				} catch (Exception e) {

					JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
					JOptionPane.showMessageDialog(null, "Erro ao mandar cpf");

				}

			} catch (Exception e) {

			}

		}

		public void cadastroClienteJuridica(PessoaJuridica pj) {

			try {

				conexao=SingletonCon.getConexao();

				String sql = "INSERT INTO cliente (nome,limite_de_credito,tipo) VALUES (?,?,?)";
				stmt = conexao.prepareStatement(sql);
				stmt.setString(1, pj.getNome());
				stmt.setDouble(2, pj.getLimiteDeCredito());
				stmt.setInt(3, 2);
				stmt.execute();
				stmt.close();

				sql = "INSERT INTO pessoa_juridica (nome_fantasia,cnpj," + "juridica_cliente) VALUES (?,?,?)";

				try {

					stmt = conexao.prepareStatement(sql);
					stmt.setString(1, pj.getNomeFantasia());
					stmt.setString(2, pj.getCnpj());
					stmt.setInt(3, buscarIDCliente());
					stmt.execute();
					stmt.close();

					cadastrarEndereco(pj.getEndereco());

				} catch (Exception e) {

				}

			} catch (Exception e) {

			}

		}

		public void cadastrarEndereco(ArrayList<Endereco> end) {

			String sql ="INSERT INTO public.endereco(\n" +
"	logradouro, numero, complemento, bairro, municipio, estado, end_idcliente, tipo_endereco)\n" +
"	VALUES (?, ?, ?, ?, ?, ?, ?, ?);"; 
                                
                                /*"INSERT INTO endereco ("
                                + "logradouro,"
                                + "numero,"
                                + "complemento,"
                                + "bairro,"
				+ "municipio,"
                                + "estado,"
                                + "end_idcliente,) VALUES (?,?,?,?,?,?,?)";*/

			for (Endereco e : end) {

				try {

					conexao=SingletonCon.getConexao();
					stmt = conexao.prepareStatement(sql);
					stmt.setString(1, e.getLogradouro());
					stmt.setInt(2, e.getNumero());
					stmt.setString(3, e.getComplemento());
					stmt.setString(4, e.getBairro());
					stmt.setString(5, e.getMunicipio());
					stmt.setString(6, e.getEstado());
					stmt.setInt(7, buscarIDCliente());
                                        stmt.setString(8, e.getTipo());
					stmt.execute();
					stmt.close();

				} catch (Exception e2) {

					JOptionPane.showMessageDialog(null, "Erro: " + e2.getMessage());
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar endereço");

				}

			}

		}

		public void adicionarEndereco(Endereco e, int codigo) {

			//String sql = "INSERT INTO endereco (logradouro,numero,complemento,bairro,"
			//		+ "municipio,estado,end_idcliente) VALUES (?,?,?,?,?,?,?)";
                        
                        String sql ="INSERT INTO public.endereco(\n" +
                        "logradouro, numero, complemento, bairro, municipio, estado, end_idcliente,  tipo_endereco)\n" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?);"; 

			try {

				conexao=SingletonCon.getConexao();
				stmt = conexao.prepareStatement(sql);
				stmt.setString(1, e.getLogradouro());
				stmt.setInt(2, e.getNumero());
				stmt.setString(3, e.getComplemento());
				stmt.setString(4, e.getBairro());
				stmt.setString(5, e.getMunicipio());
				stmt.setString(6, e.getEstado());
				stmt.setInt(7, codigo);
                                stmt.setString(8, e.getTipo());
				stmt.execute();
				stmt.close();

			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "Erro: " + e2.getMessage());
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar endereço");

			}

		}
                
                public int validarCPF(String cpf) {

			String sql = "SELECT * FROM pessoa_fisica WHERE cpf = ? ";

			try {

				conexao=SingletonCon.getConexao();
				stmt = conexao.prepareStatement(sql);
				stmt.setString(1, cpf);

				ResultSet rs = null;

				rs = stmt.executeQuery();

				if (rs.next()) {

					return rs.getInt("id_fisica");

				}

			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, "ERRo: " + e.getMessage());

			}

			return -1;

		}

		
		public int validarCNPJ(String cnpj) {

			String sql = "SELECT * FROM pessoa_juridica WHERE cnpj = ? ";

			try {

				conexao=SingletonCon.getConexao();
				stmt = conexao.prepareStatement(sql);
				stmt.setString(1, cnpj);

				ResultSet rs = null;

				rs = stmt.executeQuery();

				if (rs.next()) {

					return rs.getInt("juridica_cliente");

				}

			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, "ERRo: " + e.getMessage());

			}

			return -1;

		}
                
                public int idjur(String cnpj){
                    
                    
                    
                    String sql = "SELECT * FROM pessoa_juridica WHERE cnpj = ?";

			try {

				conexao=SingletonCon.getConexao();
				stmt = conexao.prepareStatement(sql);
				stmt.setString(1, cnpj);

				ResultSet rs = null;

				rs = stmt.executeQuery();

				if (rs.next()) {

					return rs.getInt("juridica_cliente");

				}

			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, "ERRo: " + e.getMessage());

			}
                    
                    
                    
                    return -1;
                }
                
                public ArrayList<Cliente> ArrayClientes() {
                    
                        int cod, tipo;
                        String nome, cpf, cnpj, nome_fantasia;
                        double credito;
                        
                        ArrayList<Cliente> clientes = new ArrayList<>();
			ResultSet rs;

			String sql = "SELECT cod, nome, credito, tipo, cpf, cnpj, nome_fantasia\n" +
                                     "FROM public.clientes;";
                        try {

				conexao=SingletonCon.getConexao();
				stmt = conexao.prepareStatement(sql);
				rs = stmt.executeQuery();
                                int i=1;
				while (rs.next()) {
                                    
                                    cod=rs.getInt("cod");
                                    nome=rs.getString("nome");
                                    credito=rs.getDouble("credito");
                                    tipo=rs.getInt("tipo");                                    
                                    cpf=rs.getString("cpf");
                                    cnpj=rs.getString("cnpj");
                                    nome_fantasia=rs.getString("nome_fantasia");
                                    
                                    if(tipo==1){
                                        PessoaFisica pf = new PessoaFisica();
                                        pf.setCpf(cpf);
                                        pf.setEndereco(buscarEnd(cod));                                        
                                        pf.setId(cod);
                                        pf.setTipo(tipo);
                                        pf.setNome(nome);
                                        pf.setLimiteDeCredito(credito);
                                        pf.setIdFisica(cod);
                                        
                                        clientes.add(pf);
                                        
                                    }else if(tipo==2){
                                        PessoaJuridica pj = new PessoaJuridica();
                                        pj.setCnpj(cnpj);
                                        pj.setEndereco(buscarEnd(cod));
                                        pj.setId(cod);                                        
                                        pj.setTipo(tipo);
                                        pj.setNome(nome);
                                        pj.setLimiteDeCredito(credito);
                                        pj.setIdJuridica(cod);
                                        pj.setNomeFantasia(nome_fantasia);
                                        
                                        clientes.add(pj);
                                    }
                                }
                        } catch (Exception e) {

				JOptionPane.showMessageDialog(null, "Erro ao buscar clientes" + e.getMessage());

			}

			return clientes;
                                
                }

                public PessoaFisica ClienteFisico(String chave) {
                    
                        int cod, tipo;
                        String nome, cpf, cnpj, nome_fantasia;
                        double credito;
                        
                        
			ResultSet rs;
                        PessoaFisica pf = null;

			String sql = "SELECT cod, nome, credito, tipo, cpf, cnpj, nome_fantasia\n" +
                                     "FROM public.clientes where cpf=?;";
                        try {

				conexao=SingletonCon.getConexao();
				stmt = conexao.prepareStatement(sql);
                                stmt.setString(1, chave);
				rs = stmt.executeQuery();
                                
                                if(rs.next()){
                                    
                                    cod=rs.getInt("cod");
                                    nome=rs.getString("nome");
                                    credito=rs.getDouble("credito");
                                    tipo=rs.getInt("tipo");                                    
                                    cpf=rs.getString("cpf");
                                    cnpj=rs.getString("cnpj");
                                    nome_fantasia=rs.getString("nome_fantasia");
                                    
                                    pf = new PessoaFisica();
                                    
                                    pf.setCpf(cpf);
                                    pf.setEndereco(buscarEnd(cod));
                                    pf.setId(cod);
                                    pf.setTipo(tipo);
                                    pf.setNome(nome);
                                    pf.setLimiteDeCredito(credito);
                                    pf.setIdFisica(cod);

                                   
                                }
                        } catch (Exception e) {

				JOptionPane.showMessageDialog(null, "Erro ao buscar clientes" + e.getMessage());

			}

			return pf;
                                
                }
                
                public PessoaJuridica ClienteJuridico(String chave) {
                    
                        int cod, tipo;
                        String nome, cpf, cnpj, nome_fantasia;
                        double credito;
                        
                        
			ResultSet rs;
                        PessoaJuridica pj = null;

			String sql = "SELECT cod, nome, credito, tipo, cpf, cnpj, nome_fantasia\n" +
                                     "FROM public.clientes where cnpj=?;";
                        try {

				conexao=SingletonCon.getConexao();
				stmt = conexao.prepareStatement(sql);
                                stmt.setString(1, chave);
				rs = stmt.executeQuery();
                                
                                if(rs.next()){
                                    cod=rs.getInt("cod");
                                    nome=rs.getString("nome");
                                    credito=rs.getDouble("credito");
                                    tipo=rs.getInt("tipo");                                    
                                    cpf=rs.getString("cpf");
                                    cnpj=rs.getString("cnpj");
                                    nome_fantasia=rs.getString("nome_fantasia");
                                    
                                    pj = new PessoaJuridica();
                                    
                                    pj.setCnpj(cnpj);
                                    pj.setEndereco(buscarEnd(cod));
                                    pj.setId(cod);                                        
                                    pj.setTipo(tipo);
                                    pj.setNome(nome);
                                    pj.setLimiteDeCredito(credito);
                                    pj.setIdJuridica(cod);
                                    pj.setNomeFantasia(nome_fantasia);
                                        
                                       
                                }
                                    
                        } catch (Exception e) {

				JOptionPane.showMessageDialog(null, "Erro ao buscar clientes" + e.getMessage());

			}

			return pj;
                                
                }
                
		public ArrayList<Cliente> buscarClientes() {

			ArrayList<Cliente> clientes = new ArrayList<>();
			Cliente cli = new Cliente();
			ResultSet rs;

			String sql = "SELECT * FROM cliente";

			try {

				conexao=SingletonCon.getConexao();
				stmt = conexao.prepareStatement(sql);
				rs = stmt.executeQuery();

				while (rs.next()) {

					cli.setNome(rs.getString("nome"));
					cli.setLimiteDeCredito(rs.getDouble("limite_de_credito"));
					cli.setId(rs.getInt("id_cliente"));
                                       
					cli.setTipo(rs.getInt("tipo"));

					if (cli.getTipo() == 1) {

						PessoaFisica pf = new PessoaFisica();

						pf.setNome(cli.getNome());
						pf.setLimiteDeCredito(cli.getLimiteDeCredito());
						pf.setId(cli.getId());
                                                

						sql = "SELECT * FROM pessoa_fisica WHERE id_fisica = ? ";

						try {

							conexao=SingletonCon.getConexao();
							stmt = conexao.prepareStatement(sql);
							stmt.setInt(1, pf.getId());
							ResultSet resultSet = stmt.executeQuery();

							if (resultSet.next()) {

								pf.setCpf(resultSet.getString("cpf"));
								pf.setIdFisica(resultSet.getInt("id_fisica"));

							}

						} catch (Exception e) {

							JOptionPane.showMessageDialog(null, "Erro no segundo try " + e.getMessage());

						}

						pf.setEndereco(buscarEnd(pf.getId()));

						clientes.add(pf);

					} else if (cli.getTipo() == 2) {

						PessoaJuridica pj = new PessoaJuridica();

						pj.setNome(cli.getNome());
						pj.setLimiteDeCredito(cli.getLimiteDeCredito());
						pj.setIdJuridica(cli.getId());
                                                

						sql = "SELECT * FROM pessoa_juridica WHERE juridica_cliente = ? ";

						try {

							conexao=SingletonCon.getConexao();
							stmt = conexao.prepareStatement(sql);
							stmt.setInt(1, pj.getIdJuridica());
							ResultSet resultSet = stmt.executeQuery();

							if (resultSet.next()) {

								pj.setCnpj(resultSet.getString("cnpj"));
								pj.setNomeFantasia(resultSet.getString("nome_fantasia"));
								pj.setIdJuridica(resultSet.getInt("juridica_cliente"));

							}

						} catch (Exception e) {

							JOptionPane.showMessageDialog(null, "Erro no segundo try " + e.getMessage());

						}

						pj.setEndereco(buscarEnd(pj.getIdJuridica()));

						clientes.add(pj);

					}

				}


			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, "Erro no primeiro try " + e.getMessage());

			}

			return clientes;

		}

		

		public ArrayList<Endereco> buscarEnd(int codigo) {

			ArrayList<Endereco> end = new ArrayList<>();

			String sql = "SELECT * FROM endereco WHERE end_idcliente = ? ";

			try {

				conexao=SingletonCon.getConexao();
				stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, codigo);
				ResultSet rs = null;

				rs = stmt.executeQuery();

				while (rs.next()) {

					Endereco e = new Endereco();

					e.setLogradouro(rs.getString("logradouro"));
					e.setNumero(rs.getInt("numero"));
					e.setComplemento(rs.getString("complemento"));
					e.setBairro(rs.getString("bairro"));
					e.setMunicipio(rs.getString("municipio"));
					e.setEstado(rs.getString("estado"));
					e.setId(rs.getInt("end_idcliente"));
                                        e.setTipo(rs.getString("tipo_endereco"));
                                        e.setIdend(rs.getInt("id"));
					end.add(e);

				}

			} catch (Exception e) {

			}

			return end;

		}

                
                public void deletarenderecobyid(int codigo){
                    String sql = "DELETE FROM endereco WHERE id = ?";

			try {

				conexao=SingletonCon.getConexao();
				stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, codigo);
				stmt.execute();
				stmt.close();

			} catch (Exception e) {

			}
                }
                
                public void alterarend(Endereco e){
                    String sql = "UPDATE public.endereco\n" +
                    "SET logradouro=?, numero=?, complemento=?, bairro=?, municipio=?, estado=?, tipo_endereco=?\n" +
                    "WHERE id=?;";
                    
                        try {

				conexao=SingletonCon.getConexao();
				stmt = conexao.prepareStatement(sql);
                                stmt.setString(1, e.getLogradouro());
				stmt.setInt(2, e.getNumero());
				stmt.setString(3, e.getComplemento());
				stmt.setString(4, e.getBairro());
				stmt.setString(5, e.getMunicipio());
				stmt.setString(6, e.getEstado());
                                stmt.setString(7, e.getTipo());
				stmt.setInt(8, e.getIdend());
				stmt.execute();
				stmt.close();

			} catch (Exception en) {
                            JOptionPane.showMessageDialog(null, "Erro" + en.getMessage());

			}
                }

		public void excluirCli(int codigo) {

			String sql = "DELETE FROM cliente WHERE id_cliente =  ?";

			try {

				conexao=SingletonCon.getConexao();
				stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, codigo);
				stmt.execute();
				stmt.close();

			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, "Erro ao excluir cliente " + e.getMessage());

			}

		}

		public void alterarFis(PessoaFisica pf) {
                    

			String sql = "UPDATE pessoa_fisica SET cpf = ? WHERE id_fisica = ? ";

			try {

				conexao=SingletonCon.getConexao();
				stmt = conexao.prepareStatement(sql);
				stmt.setString(1, pf.getCpf());
				stmt.setInt(2, pf.getIdFisica());
				stmt.execute();

				sql = "UPDATE cliente SET nome = ? , limite_de_credito = ?" + " WHERE id_cliente = ? ";

				try {

					stmt = conexao.prepareStatement(sql);
					stmt.setString(1, pf.getNome());
					stmt.setDouble(2, pf.getLimiteDeCredito());
					stmt.setInt(3, pf.getId());
					stmt.execute();

				} catch (Exception e) {

                                        JOptionPane.showMessageDialog(null, "ERRO APAGAR CLI FIS " + e.getMessage());

				}


			} catch (Exception e) {

                                JOptionPane.showMessageDialog(null, "ERRO APAGAR FIS " + e.getMessage());

			}

		}

		public void alterarJur(PessoaJuridica pj) {
                    
			String sql = "UPDATE pessoa_juridica SET cnpj = ? , nome_fantasia = ? " + " WHERE juridica_cliente = ? ";

			try {

				conexao=SingletonCon.getConexao();
				stmt = conexao.prepareStatement(sql);
				stmt.setString(1, pj.getCnpj());
				stmt.setString(2, pj.getNomeFantasia());
				stmt.setInt(3, pj.getIdJuridica());
				stmt.execute();

				sql = "UPDATE cliente SET nome = ? , limite_de_credito = ?" + " WHERE id_cliente = ? ";

				try {

					stmt = conexao.prepareStatement(sql);
					stmt.setString(1, pj.getNome());
					stmt.setDouble(2, pj.getLimiteDeCredito());
					stmt.setInt(3, pj.getIdJuridica());
					stmt.execute();

				} catch (Exception e) {

                                        JOptionPane.showMessageDialog(null, "ERRO APAGAR CLI JUR " + e.getMessage());
				}


			} catch (Exception e) {

                                JOptionPane.showMessageDialog(null, "ERRO APAGAR JUR " + e.getMessage());

			}

		}

		
		public int buscarIDCliente() {

			String sql;
			PreparedStatement ps = null;
			int codigo = 0;

			sql = "SELECT MAX(id_cliente) FROM cliente";

			try {

				ps = conexao.prepareStatement(sql);
				ResultSet rs = null;

				rs = ps.executeQuery();

				if (rs.next()) {
					codigo = rs.getInt(1);
					codigo++;
				}

				ps.close();

			} catch (Exception e) {

                                JOptionPane.showMessageDialog(null, "Erro ao buscar id" + e.getMessage());
			}

			return codigo - 1;

		}


}