/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JInternalFrame;

/**
 *
 * @author chris
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        produtoCadastrar = new javax.swing.JMenuItem();
        produtoConsultar = new javax.swing.JMenuItem();
        produtoAlterar = new javax.swing.JMenuItem();
        Jexcluirproduto = new javax.swing.JMenuItem();
        produtorelatorio = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 736, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
        );

        jMenu1.setText("Produto");

        produtoCadastrar.setText("Cadastrar");
        produtoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtoCadastrarActionPerformed(evt);
            }
        });
        jMenu1.add(produtoCadastrar);

        produtoConsultar.setText("Consultar");
        produtoConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtoConsultarActionPerformed(evt);
            }
        });
        jMenu1.add(produtoConsultar);

        produtoAlterar.setText("Alterar");
        produtoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtoAlterarActionPerformed(evt);
            }
        });
        jMenu1.add(produtoAlterar);

        Jexcluirproduto.setText("Excluir");
        Jexcluirproduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JexcluirprodutoActionPerformed(evt);
            }
        });
        jMenu1.add(Jexcluirproduto);

        produtorelatorio.setText("Relatório");
        produtorelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtorelatorioActionPerformed(evt);
            }
        });
        jMenu1.add(produtorelatorio);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Cliente");

        jMenuItem2.setText("Cadastrar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem1.setText("Consultar/Excluir/Alterar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem4.setText("Relatório");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktop)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktop)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void produtoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtoCadastrarActionPerformed
        JInternalFrame[] frames = desktop.getAllFrames();
        for(JInternalFrame f : frames) {
            f.dispose();
        }
        CadastrarProduto janelaCadastroProduto = new CadastrarProduto();       
        JInternalFrame interno = new JInternalFrame();
        interno.setContentPane(janelaCadastroProduto.getContentPane());
        interno.setMaximizable(true);
        interno.setClosable(true);
        interno.pack();
        interno.setVisible(true);        
        desktop.add(interno);
        
    }//GEN-LAST:event_produtoCadastrarActionPerformed

    private void produtoConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtoConsultarActionPerformed
       JInternalFrame[] frames = desktop.getAllFrames();
        for(JInternalFrame f : frames) {
            f.dispose();
        }
        ConsultarProduto janelaConsultarProduto = new ConsultarProduto();   
        JInternalFrame internoconsult = new JInternalFrame();
        internoconsult.setContentPane(janelaConsultarProduto.getContentPane());
        internoconsult.setMaximizable(true);
        internoconsult.setClosable(true);
        internoconsult.pack();
        internoconsult.setVisible(true);
        desktop.add(internoconsult); 
    }//GEN-LAST:event_produtoConsultarActionPerformed

    private void produtoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtoAlterarActionPerformed
        JInternalFrame[] frames = desktop.getAllFrames();
        for(JInternalFrame f : frames) {
            f.dispose();
        }
        AlterarProduto janelaAlterarProduto = new AlterarProduto();   
        JInternalFrame internoconsult = new JInternalFrame();
        internoconsult.setContentPane(janelaAlterarProduto.getContentPane());
        internoconsult.setMaximizable(true);
        internoconsult.setClosable(true);
        internoconsult.pack();
        internoconsult.setVisible(true);
        desktop.add(internoconsult);
    }//GEN-LAST:event_produtoAlterarActionPerformed

    private void JexcluirprodutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JexcluirprodutoActionPerformed
        JInternalFrame[] frames = desktop.getAllFrames();
        for(JInternalFrame f : frames) {
            f.dispose();
        }
        ExcluirProduto janelaExcluirProduto = new ExcluirProduto();   
        JInternalFrame internoconsult = new JInternalFrame();
        internoconsult.setContentPane(janelaExcluirProduto.getContentPane());
        internoconsult.setMaximizable(true);
        internoconsult.setClosable(true);
        internoconsult.pack();
        internoconsult.setVisible(true);
        desktop.add(internoconsult);
    }//GEN-LAST:event_JexcluirprodutoActionPerformed

    private void produtorelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtorelatorioActionPerformed
        JInternalFrame[] frames = desktop.getAllFrames();
        for(JInternalFrame f : frames) {
            f.dispose();
        }
        RelatorioProduto janelaRelatorioProduto = new RelatorioProduto();   
        JInternalFrame internoconsult = new JInternalFrame();
        internoconsult.setContentPane(janelaRelatorioProduto.getContentPane());
        internoconsult.setMaximizable(true);
        internoconsult.setClosable(true);
        internoconsult.pack();
        internoconsult.setVisible(true);
        desktop.add(internoconsult);
    }//GEN-LAST:event_produtorelatorioActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JInternalFrame[] frames = desktop.getAllFrames();
        for(JInternalFrame f : frames) {
            f.dispose();
        }
        CadastrarCliente janelaCadastrarCliente = new CadastrarCliente();   
        JInternalFrame internoconsult = new JInternalFrame();
        internoconsult.setContentPane(janelaCadastrarCliente.getContentPane());
        internoconsult.setMaximizable(true);
        internoconsult.setClosable(true);
        internoconsult.pack();
        internoconsult.setVisible(true);
        desktop.add(internoconsult);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JInternalFrame[] frames = desktop.getAllFrames();
        for(JInternalFrame f : frames) {
            f.dispose();
        }
        ConsultarCliente janelaConsultarCliente = new ConsultarCliente();   
        JInternalFrame internoconsult = new JInternalFrame();
        internoconsult.setContentPane(janelaConsultarCliente.getContentPane());
        internoconsult.setMaximizable(true);
        internoconsult.setClosable(true);
        internoconsult.pack();
        internoconsult.setVisible(true);
        desktop.add(internoconsult);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        JInternalFrame[] frames = desktop.getAllFrames();
        for(JInternalFrame f : frames) {
            f.dispose();
        }
        RelatorioCliente janelaRelatorioCliente = new RelatorioCliente();   
        JInternalFrame internoconsult = new JInternalFrame();
        internoconsult.setContentPane(janelaRelatorioCliente.getContentPane());
        internoconsult.setMaximizable(true);
        internoconsult.setClosable(true);
        internoconsult.pack();
        internoconsult.setVisible(true);
        desktop.add(internoconsult);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Jexcluirproduto;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem produtoAlterar;
    private javax.swing.JMenuItem produtoCadastrar;
    private javax.swing.JMenuItem produtoConsultar;
    private javax.swing.JMenuItem produtorelatorio;
    // End of variables declaration//GEN-END:variables
}