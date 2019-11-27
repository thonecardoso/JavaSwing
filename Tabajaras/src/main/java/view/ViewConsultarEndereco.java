package view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Endereco;
import dao.DAOCliente;
import dao.DAOEndereco;
import model.Cliente;

public class ViewConsultarEndereco extends javax.swing.JFrame {
    
    ArrayList<Endereco> endereco;
    int totalend;
    int posicao;
    Cliente cliente;
    DAOCliente dc;
    DAOEndereco endDAO = new DAOEndereco();

    public ViewConsultarEndereco(Cliente cli) {
        initComponents();
        cliente = cli;
        totalend = cli.getEndereco().size();
        posicao =0;
        dc = new DAOCliente();
        endDAO = new DAOEndereco();
        
        endereco = cli.getEndereco();
        carregacomp(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        logradouro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        num = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        complemento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        bairro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        municipio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tipo = new javax.swing.JTextField();
        estado = new javax.swing.JTextField();
        BotaoNext = new javax.swing.JButton();
        BotaoUndo = new javax.swing.JButton();
        tot = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        BotaoExcluir = new javax.swing.JButton();
        BotaoAdicionarEndereco = new javax.swing.JButton();
        BotaoFechar = new javax.swing.JButton();
        BotaoAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel1.setText("Consulta de Endereço");

        jLabel2.setText("LOGRADOURO");

        jLabel3.setText("Nº");

        jLabel4.setText("COMPLEMENTO");

        jLabel5.setText("BAIRRO");

        jLabel6.setText("MUNICÍPIO");

        jLabel7.setText("ESTADO");

        jLabel8.setText("TIPO DE ENDEREÇO");

        BotaoNext.setText(">>");
        BotaoNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoNextActionPerformed(evt);
            }
        });

        BotaoUndo.setText("<<");
        BotaoUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoUndoActionPerformed(evt);
            }
        });

        tot.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        tot.setText("1");

        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        BotaoExcluir.setText("Excluir");
        BotaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoExcluirActionPerformed(evt);
            }
        });

        BotaoAdicionarEndereco.setText("Novo Endereco");
        BotaoAdicionarEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAdicionarEnderecoActionPerformed(evt);
            }
        });

        BotaoFechar.setText("Fechar");
        BotaoFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoFecharActionPerformed(evt);
            }
        });

        BotaoAlterar.setText("Alterar");
        BotaoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BotaoAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotaoAdicionarEndereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoAlterar)
                    .addComponent(BotaoFechar)
                    .addComponent(BotaoAdicionarEndereco)
                    .addComponent(BotaoExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8))
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(estado)
                                .addComponent(tipo)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BotaoUndo)
                                    .addGap(4, 4, 4))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(40, 40, 40)
                                    .addComponent(logradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(BotaoNext)
                                    .addGap(25, 25, 25)
                                    .addComponent(tot)
                                    .addGap(25, 25, 25))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addGap(32, 32, 32)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(municipio, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bairro, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(complemento, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(BotaoUndo)
                    .addComponent(BotaoNext)
                    .addComponent(tot))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(logradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(complemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(municipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirActionPerformed
       if(totalend==1){
               JOptionPane.showMessageDialog(null, "Só há um endereço Cadastrado, só pode alterar!");
       }else{
           
            int j=JOptionPane.showConfirmDialog(null, "Corfirma a Exclusão desse Endereço?");
            if(j==0){
               totalend--;
               endDAO.deletarenderecobyid(endereco.get(posicao).getIdend());
               endereco.remove(posicao);
               JOptionPane.showMessageDialog(null, "Endereço Excluído com Sucesso!");
               carregacomp(0);
               
            }
       }
    }//GEN-LAST:event_BotaoExcluirActionPerformed

    private void BotaoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAlterarActionPerformed
        int j=JOptionPane.showConfirmDialog(null, "Corfirma a Ateração desse Endereço?");
            if(j==0){
                
                Endereco en = endereco.get(posicao);
                
                en.setLogradouro(logradouro.getText().trim());
                en.setNumero(Integer.parseInt(num.getText().trim()));
                en.setBairro(bairro.getText().trim());
                en.setComplemento(complemento.getText().trim());
                en.setMunicipio(municipio.getText().trim());
                en.setEstado(estado.getText().trim());
                en.setTipo(tipo.getText().trim());
               
               endDAO.alterarend(en);
               
               JOptionPane.showMessageDialog(null, "Endereço Alterado com Sucesso!");
               
               
            }
    }//GEN-LAST:event_BotaoAlterarActionPerformed

    private void BotaoNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoNextActionPerformed

        if(posicao < endereco.size()-1){
            posicao++;
            carregacomp(posicao);

        }
        tot.setText(String.valueOf(posicao + 1));
    }//GEN-LAST:event_BotaoNextActionPerformed

    private void BotaoUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoUndoActionPerformed

        if(posicao > 0){
            posicao--;
            carregacomp(posicao);

        }
        tot.setText(String.valueOf(posicao + 1));
    }//GEN-LAST:event_BotaoUndoActionPerformed

    private void BotaoFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_BotaoFecharActionPerformed

    private void BotaoAdicionarEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAdicionarEnderecoActionPerformed
        ViewCadastroEndereco vce = new ViewCadastroEndereco(cliente);
        vce.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        vce.setVisible(true);
    }//GEN-LAST:event_BotaoAdicionarEnderecoActionPerformed

    
    
    
    public void carregacomp(int i){
        
        Endereco e = endereco.get(i);
        bairro.setText(e.getBairro());
        complemento.setText(e.getComplemento());
        estado.setText(e.getEstado());
        num.setText(String.valueOf(e.getNumero()));
        logradouro.setText(e.getLogradouro());
        tipo.setText(e.getTipo());
        municipio.setText(e.getMunicipio());
    }

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoAdicionarEndereco;
    private javax.swing.JButton BotaoAlterar;
    private javax.swing.JButton BotaoExcluir;
    private javax.swing.JButton BotaoFechar;
    private javax.swing.JButton BotaoNext;
    private javax.swing.JButton BotaoUndo;
    private javax.swing.JTextField bairro;
    private javax.swing.JTextField complemento;
    private javax.swing.JTextField estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField logradouro;
    private javax.swing.JTextField municipio;
    private javax.swing.JTextField num;
    private javax.swing.JTextField tipo;
    private javax.swing.JLabel tot;
    // End of variables declaration//GEN-END:variables
}
