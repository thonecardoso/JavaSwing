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
                private DAOEndereco enderecoDAO = new DAOEndereco();

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
                                        int id = buscarIDCliente();
					stmt = conexao.prepareStatement(sql);
					stmt.setString(1, pf.getCpf());
					stmt.setInt(2, id);
					stmt.execute();
					stmt.close();

					enderecoDAO.cadastrarEndereco(pf.getEndereco(),id);

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
				

				sql = "INSERT INTO pessoa_juridica (nome_fantasia,cnpj," + "juridica_cliente) VALUES (?,?,?)";

				try {
                                        int id = buscarIDCliente();
					stmt = conexao.prepareStatement(sql);
					stmt.setString(1, pj.getNomeFantasia());
					stmt.setString(2, pj.getCnpj());
					stmt.setInt(3, id);
					stmt.execute();
					
                                        

					enderecoDAO.cadastrarEndereco(pj.getEndereco(),id);

				} catch (Exception e) {

				}

			} catch (Exception e) {

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
                                        pf.setId(cod);
                                        pf.setTipo(tipo);
                                        pf.setNome(nome);
                                        pf.setLimiteDeCredito(credito);
                                        pf.setIdFisica(cod);
                                        pf.setEndereco(enderecoDAO.buscarEnd(cod));
                                        
                                        clientes.add(pf);
                                        
                                    }else if(tipo==2){
                                        PessoaJuridica pj = new PessoaJuridica();
                                        pj.setCnpj(cnpj);
                                        pj.setId(cod);                                        
                                        pj.setTipo(tipo);
                                        pj.setNome(nome);
                                        pj.setLimiteDeCredito(credito);
                                        pj.setIdJuridica(cod);
                                        pj.setNomeFantasia(nome_fantasia);
                                        pj.setEndereco(enderecoDAO.buscarEnd(cod));
                                        
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
                                    pf.setId(cod);
                                    pf.setTipo(tipo);
                                    pf.setNome(nome);
                                    pf.setLimiteDeCredito(credito);
                                    pf.setIdFisica(cod);
                                    pf.setEndereco(enderecoDAO.buscarEnd(cod));
                                    

                                   
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
                                    pj.setId(cod);                                        
                                    pj.setTipo(tipo);
                                    pj.setNome(nome);
                                    pj.setLimiteDeCredito(credito);
                                    pj.setIdJuridica(cod);
                                    pj.setNomeFantasia(nome_fantasia);
                                    pj.setEndereco(enderecoDAO.buscarEnd(cod));
                                        
                                       
                                }
                                    
                        } catch (Exception e) {

				JOptionPane.showMessageDialog(null, "Erro ao buscar clientes" + e.getMessage());

			}

			return pj;
                                
                }
                
                public Cliente ClienteById(int id) {
                    
                        int cod, tipo;
                        String nome, cpf, cnpj, nome_fantasia;
                        double credito;
                        
                        
			ResultSet rs;
                        PessoaJuridica pj = null;
                        PessoaFisica pf = null;

			String sql = "SELECT nome, credito, tipo, cnpj, nome_fantasia, cpf FROM  clientes WHERE cod=?";
                        try {

				conexao=SingletonCon.getConexao();
				stmt = conexao.prepareStatement(sql);
                                stmt.setInt(1, id);
				rs = stmt.executeQuery();
                                
                                if(rs.next()){
                                    cod=id;
                                    nome=rs.getString("nome");
                                    credito=rs.getDouble("credito");
                                    tipo=rs.getInt("tipo");                                    
                                    cpf=rs.getString("cpf");
                                    cnpj=rs.getString("cnpj");
                                    nome_fantasia=rs.getString("nome_fantasia");
                                    
                                    if(tipo == 1){
                                        
                                        pf = new PessoaFisica();
                                    
                                        pf.setCpf(cpf);
                                        pf.setId(cod);
                                        pf.setTipo(tipo);
                                        pf.setNome(nome);
                                        pf.setLimiteDeCredito(credito);
                                        pf.setIdFisica(cod);
                                        pf.setEndereco(enderecoDAO.buscarEnd(cod));
                                        
                                        return pf;

                                        
                                    }else{
                                        
                                        pj = new PessoaJuridica();

                                        pj.setCnpj(cnpj);
                                        pj.setId(cod);                                        
                                        pj.setTipo(tipo);
                                        pj.setNome(nome);
                                        pj.setLimiteDeCredito(credito);
                                        pj.setIdJuridica(cod);
                                        pj.setNomeFantasia(nome_fantasia);
                                        pj.setEndereco(enderecoDAO.buscarEnd(cod));
                                        
                                        
                                        return pj;
                                    }
                                    
                                        
                                       
                                }
                                    
                        } catch (Exception e) {

				JOptionPane.showMessageDialog(null, "Erro ao buscar cliente" + e.getMessage());

			}

			return null;
                                
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
                
                public ArrayList<Cliente> ClientesTabela(int tip, String str) {
                    
                        int cod, tipo;
                        String nome, cpf, cnpj, nome_fantasia;
                        double credito;
                        
                        ArrayList<Cliente> clientes = new ArrayList<>();
			ResultSet rs;
                        
                        String sql;
                        
                        if(tip == 1){
                            sql = "SELECT cod, nome, credito, tipo, cpf, cnpj, nome_fantasia " +
                                         "FROM public.clientes "
                                    + "where nome like ? and tipo = 1 ;";                            
                        }else if(tip == 2){
                            sql = "SELECT cod, nome, credito, tipo, cpf, cnpj, nome_fantasia " +
                                         "FROM public.clientes "
                                    + "where nome like ? and tipo = 2 ;";
                        }else{
                            sql = "SELECT cod, nome, credito, tipo, cpf, cnpj, nome_fantasia " +
                                         "FROM public.clientes "
                                    + "where nome like ? ;";
                        }
                        
                        
                        
                        try {

				conexao=SingletonCon.getConexao();
				stmt = conexao.prepareStatement(sql);
                                stmt.setString(1, str);
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
                                        pf.setId(cod);
                                        pf.setTipo(tipo);
                                        pf.setNome(nome);
                                        pf.setLimiteDeCredito(credito);
                                        pf.setIdFisica(cod);
                                        pf.setEndereco(enderecoDAO.buscarEnd(cod));
                                        
                                        clientes.add(pf);
                                        
                                    }else if(tipo==2){
                                        PessoaJuridica pj = new PessoaJuridica();
                                        pj.setCnpj(cnpj);
                                        pj.setId(cod);                                        
                                        pj.setTipo(tipo);
                                        pj.setNome(nome);
                                        pj.setLimiteDeCredito(credito);
                                        pj.setIdJuridica(cod);
                                        pj.setNomeFantasia(nome_fantasia);
                                        pj.setEndereco(enderecoDAO.buscarEnd(cod));
                                        
                                        clientes.add(pj);
                                    }
                                }
                        } catch (Exception e) {

				JOptionPane.showMessageDialog(null, "Erro ao buscar clientes" + e.getMessage());

			}

			return clientes;
                                
                }


}