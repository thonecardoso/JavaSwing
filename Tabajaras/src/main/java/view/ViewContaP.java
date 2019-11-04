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

        id_conta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id_conta.setText("ID CONTA");

        jLabel1.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jLabel1.setText("Busca por ID");

        jLabel2.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jLabel2.setText("PessoaFisica");

        cpf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cpf.setText("CPF");
        cpf.setPreferredSize(new java.awt.Dimension(140, 37));

        PessoaFisica.setText("Buscar");
        PessoaFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PessoaFisicaActionPerformed(evt);
            }
        });

        cnpj.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cnpj.setText("CNPJ");
        cnpj.setPreferredSize(new java.awt.Dimension(140, 37));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PessoaFisica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(PessoaJuridica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(id_conta, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(Busca_ID_CONTA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(8, 8, 8)))
                .addGap(151, 151, 151))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RelatorioConta, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(RelatorioConta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(209, 209, 209)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
    }//GEN-LAST:event_PessoaFisicaActionPerformed

    private void PessoaJuridicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PessoaJuridicaActionPerformed
        String chave = cnpj.getText().trim();
        PessoaJuridica pj = clienteDAO.ClienteJuridico(chave); 
            
            if(pj==null){
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            }else{
                ArrayList<Conta> contas = contaDAO.ContaFisica(pj.getId());
                rc1 = new RelatorioConta_1(contas); 
                
                System.out.println(pj.getId());
                rc1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                rc1.setVisible(true);
                
            }
    }//GEN-LAST:event_PessoaJuridicaActionPerformed

    private void RelatorioContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioContaActionPerformed
        RelatorioConta rc1 = new RelatorioConta(); 
        rc1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        rc1.setVisible(true);
    }//GEN-LAST:event_RelatorioContaActionPerformed

    
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
    // End of variables declaration//GEN-END:variables
}