package dao;


    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.util.ArrayList;
    import javax.swing.JOptionPane;
    import model.Endereco;

    public class DAOEndereco {


            private PreparedStatement stmt;
            private Connection conexao;



            public void cadastrarEndereco(ArrayList<Endereco> end, int idcliente) {

                    String sql ="INSERT INTO public.endereco(" +
                                "logradouro, numero, complemento, bairro, municipio, estado, end_idcliente, tipo_endereco) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?);"; 



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
                                    stmt.setInt(7, idcliente);
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

                    String sql ="INSERT INTO public.endereco(" +
                    "logradouro, numero, complemento, bairro, municipio, estado, end_idcliente,  tipo_endereco) " +
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


}