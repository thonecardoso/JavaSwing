package view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Endereco;
import dao.DAOCliente;
import dao.DAOEndereco;

public class ConsultarEndereco extends javax.swing.JFrame {
    
    ArrayList<Endereco> endereco;
    int totalend;
    int posicao;
    DAOCliente dc;
    DAOEndereco endDAO = new DAOEndereco();

    public ConsultarEndereco() {
        initComponents();
        posicao =0;
        dc = new DAOCliente();
        endDAO = new DAOEndereco();
        
        endereco = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
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
        next = new javax.swing.JButton();
        undo = new javax.swing.JButton();
        tot = new javax.swing.JLabel();
        alterar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton2.setText("Excluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel1.setText("Consulta de Endereço");

        jLabel2.setText("LOGRADOURO");

        jLabel3.setText("Nº");

        jLabel4.setText("COMPLEMENTO");

        jLabel5.setText("BAIRRO");

        jLabel6.setText("MUNICÍPIO");

        jLabel7.setText("ESTADO");

        jLabel8.setText("TIPO DE ENDEREÇO");

        next.setText(">>");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        undo.setText("<<");
        undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoActionPerformed(evt);
            }
        });

        tot.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        tot.setText("1");

        alterar.setText("Alterar");
        alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarActionPerformed(evt);
            }
        });

        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bairro, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(municipio)
                            .addComponent(complemento, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addComponent(alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(39, 39, 39)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8))
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tipo)
                                .addComponent(estado)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(40, 40, 40)
                                    .addComponent(logradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(22, 22, 22))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(undo)
                                    .addGap(4, 4, 4)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(14, 14, 14)
                                    .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(next)
                                    .addGap(25, 25, 25)
                                    .addComponent(tot)
                                    .addGap(25, 25, 25))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(undo)
                    .addComponent(next)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(municipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(alterar)
                    .addComponent(jButton1))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarActionPerformed
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
    }//GEN-LAST:event_alterarActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed

        if(posicao < endereco.size()-1){
            posicao++;
            carregacomp(posicao);

        }
        tot.setText(String.valueOf(posicao + 1));
    }//GEN-LAST:event_nextActionPerformed

    private void undoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoActionPerformed

        if(posicao > 0){
            posicao--;
            carregacomp(posicao);

        }
        tot.setText(String.valueOf(posicao + 1));
    }//GEN-LAST:event_undoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void setEndereco(ArrayList<Endereco> endereco) {
        this.endereco = endereco;
        totalend = endereco.size();
        carregacomp(posicao);
    }

    
    
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
    private javax.swing.JButton alterar;
    private javax.swing.JTextField bairro;
    private javax.swing.JTextField complemento;
    private javax.swing.JTextField estado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField logradouro;
    private javax.swing.JTextField municipio;
    private javax.swing.JButton next;
    private javax.swing.JTextField num;
    private javax.swing.JTextField tipo;
    private javax.swing.JLabel tot;
    private javax.swing.JButton undo;
    // End of variables declaration//GEN-END:variables
}
