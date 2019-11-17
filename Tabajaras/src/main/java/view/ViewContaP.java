package view;

import dao.DAOCliente;
import dao.DAOConta;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Conta;
import model.PessoaFisica;
import model.PessoaJuridica;

public class ViewContaP extends javax.swing.JFrame {
    
    private ViewConta vc;
    private DAOCliente clienteDAO = new DAOCliente ();
    
    private DAOConta contaDAO = new DAOConta();
    private RelatorioConta_1 rc1;
    
    
    

    public ViewContaP() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        RelatorioConta = new javax.swing.JButton();
        Busca_ID_CONTA = new javax.swing.JButton();
        id_conta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cpf = new javax.swing.JTextField();
        PessoaFisica = new javax.swing.JButton();
        cnpj = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        PessoaJuridica = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton2.setText("Nova Conta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        RelatorioConta.setText("Relatório Contas");
        RelatorioConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioContaActionPerformed(evt);
            }
        });

        Busca_ID_CONTA.setText("Buscar");
        Busca_ID_CONTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Busca_ID_CONTAActionPerformed(evt);
            }
        });

        id_conta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id_conta.setText("ID CONTA");
        id_conta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id_contaMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jLabel1.setText("Busca por ID");

        jLabel2.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jLabel2.setText("PessoaFisica");

        cpf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cpf.setText("CPF");
        cpf.setPreferredSize(new java.awt.Dimension(140, 37));
        cpf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cpfMouseClicked(evt);
            }
        });

        PessoaFisica.setText("Buscar");
        PessoaFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PessoaFisicaActionPerformed(evt);
            }
        });

        cnpj.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cnpj.setText("CNPJ");
        cnpj.setPreferredSize(new java.awt.Dimension(140, 37));
        cnpj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cnpjMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jLabel3.setText("PessoaJuridica");

        PessoaJuridica.setText("Buscar");
        PessoaJuridica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PessoaJuridicaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel4.setText("Buscar Conta Por Cliente");

        jLabel5.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        jLabel5.setText("CONSULTA CONTAS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(PessoaFisica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cnpj, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                            .addComponent(PessoaJuridica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(66, 66, 66)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(id_conta)
                                    .addComponent(Busca_ID_CONTA, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(8, 8, 8))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel4))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(RelatorioConta, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel5)
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RelatorioConta, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id_conta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Busca_ID_CONTA))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PessoaJuridica)
                            .addComponent(PessoaFisica))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        vc = new ViewConta(new Conta());
        vc.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        vc.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void PessoaFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PessoaFisicaActionPerformed
         String chave = cpf.getText().trim();
        
        boolean cond = true;
        
           
            PessoaFisica pf = clienteDAO.ClienteFisico(chave); 
            
            if(pf==null){
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            }else{
                ArrayList<Conta> contas = contaDAO.ContaFisica(pf.getId());
                rc1 = new RelatorioConta_1(contas); 
                rc1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                rc1.setVisible(true);
            }
            cpf.setText("CPF");
    }//GEN-LAST:event_PessoaFisicaActionPerformed

    private void PessoaJuridicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PessoaJuridicaActionPerformed
        String chave = cnpj.getText().trim();
        PessoaJuridica pj = clienteDAO.ClienteJuridico(chave); 
            
            if(pj==null){
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            }else{
                ArrayList<Conta> contas = contaDAO.ContaFisica(pj.getId());
                rc1 = new RelatorioConta_1(contas); 
                
               
                rc1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                rc1.setVisible(true);
                
            }
            cnpj.setText("CNPJ");
    }//GEN-LAST:event_PessoaJuridicaActionPerformed

    private void RelatorioContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioContaActionPerformed
        RelatorioConta rc1 = new RelatorioConta(); 
        rc1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        rc1.setVisible(true);
    }//GEN-LAST:event_RelatorioContaActionPerformed

    private void Busca_ID_CONTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Busca_ID_CONTAActionPerformed
        
        int x;
        try {
            x = Integer.parseInt(id_conta.getText().trim());
            ArrayList<Conta> contas1 = contaDAO.getConta(x);
            ViewContaEdicao vce = new ViewContaEdicao(contaDAO.getConta(x)); 


            vce.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            vce.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        /*int x;
        try {
            x = Integer.parseInt(id_conta.getText().trim());
            //ArrayList<Conta> contas1 = contaDAO.getConta(x);
            RelatorioConta_1 rc2 = new RelatorioConta_1(contaDAO.getConta(x)); 


            rc2.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            rc2.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }*/
        id_conta.setText("ID CONTA");
    }//GEN-LAST:event_Busca_ID_CONTAActionPerformed

    private void cpfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cpfMouseClicked
        cpf.setText("");
    }//GEN-LAST:event_cpfMouseClicked

    private void cnpjMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cnpjMouseClicked
        cnpj.setText("");
    }//GEN-LAST:event_cnpjMouseClicked

    private void id_contaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id_contaMouseClicked
        id_conta.setText("");
    }//GEN-LAST:event_id_contaMouseClicked

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewContaP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewContaP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewContaP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewContaP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewContaP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Busca_ID_CONTA;
    private javax.swing.JButton PessoaFisica;
    private javax.swing.JButton PessoaJuridica;
    private javax.swing.JButton RelatorioConta;
    private javax.swing.JTextField cnpj;
    private javax.swing.JTextField cpf;
    private javax.swing.JTextField id_conta;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
