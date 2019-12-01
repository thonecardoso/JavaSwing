package view;

import Reports.CallReports;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import model.Conta;
import net.sf.jasperreports.view.JasperViewer;

public class Principal extends javax.swing.JFrame {
    
    LoginForm loginForm;

    public Principal() {
        initComponents();
        loginForm = new LoginForm(new javax.swing.JFrame(), true);
        loginForm.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        loginForm.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        produtoCadastrar = new javax.swing.JMenuItem();
        produtoConsultar = new javax.swing.JMenuItem();
        produtoAlterar = new javax.swing.JMenuItem();
        Jexcluirproduto = new javax.swing.JMenuItem();
        produtorelatorio = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        ClienteCadastrar = new javax.swing.JMenuItem();
        ClienteCRUD = new javax.swing.JMenuItem();
        ClienteRelatorio = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        ConsultarConta = new javax.swing.JMenuItem();
        AbrirConta = new javax.swing.JMenuItem();
        ContaRelatorio = new javax.swing.JMenuItem();
        menuFatura = new javax.swing.JMenu();
        TelaPrincipalFatura = new javax.swing.JMenuItem();
        GerarFatura = new javax.swing.JMenuItem();
        FaturaRelatório = new javax.swing.JMenuItem();
        Pagamento = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        RelatorioClientes = new javax.swing.JMenuItem();
        RelatorioClientesComEndereco = new javax.swing.JMenuItem();
        RelatorioContas = new javax.swing.JMenuItem();
        RelatorioContasComCompras = new javax.swing.JMenuItem();
        RelatorioProdutos = new javax.swing.JMenuItem();
        RelatorioFatura = new javax.swing.JMenuItem();

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

        jMenuItem1.setText("jMenuItem1");

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu6.setText("Edit");
        jMenuBar2.add(jMenu6);

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

        ClienteCadastrar.setText("Cadastrar");
        ClienteCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteCadastrarActionPerformed(evt);
            }
        });
        jMenu2.add(ClienteCadastrar);

        ClienteCRUD.setText("Consultar/Excluir/Alterar");
        ClienteCRUD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteCRUDActionPerformed(evt);
            }
        });
        jMenu2.add(ClienteCRUD);

        ClienteRelatorio.setText("Relatório");
        ClienteRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteRelatorioActionPerformed(evt);
            }
        });
        jMenu2.add(ClienteRelatorio);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Conta");

        ConsultarConta.setText("Consultar Conta");
        ConsultarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarContaActionPerformed(evt);
            }
        });
        jMenu3.add(ConsultarConta);

        AbrirConta.setText("Abrir Conta");
        AbrirConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirContaActionPerformed(evt);
            }
        });
        jMenu3.add(AbrirConta);

        ContaRelatorio.setText("Relatório");
        ContaRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContaRelatorioActionPerformed(evt);
            }
        });
        jMenu3.add(ContaRelatorio);

        jMenuBar1.add(jMenu3);

        menuFatura.setText("Fatura");

        TelaPrincipalFatura.setText("Menu Fatura");
        menuFatura.add(TelaPrincipalFatura);

        GerarFatura.setText("Gerar Fatura");
        GerarFatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GerarFaturaActionPerformed(evt);
            }
        });
        menuFatura.add(GerarFatura);

        FaturaRelatório.setText("Relatório");
        menuFatura.add(FaturaRelatório);

        jMenuBar1.add(menuFatura);

        Pagamento.setText("Pagamento");

        jMenuItem2.setText("Pagar Fatura");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        Pagamento.add(jMenuItem2);

        jMenuBar1.add(Pagamento);

        jMenu5.setText("Relatórios");

        RelatorioClientes.setText("Clientes");
        RelatorioClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioClientesActionPerformed(evt);
            }
        });
        jMenu5.add(RelatorioClientes);

        RelatorioClientesComEndereco.setText("Clientes Com Endereço");
        RelatorioClientesComEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioClientesComEnderecoActionPerformed(evt);
            }
        });
        jMenu5.add(RelatorioClientesComEndereco);

        RelatorioContas.setText("Contas");
        RelatorioContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioContasActionPerformed(evt);
            }
        });
        jMenu5.add(RelatorioContas);

        RelatorioContasComCompras.setText("Contas Com Compras");
        RelatorioContasComCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioContasComComprasActionPerformed(evt);
            }
        });
        jMenu5.add(RelatorioContasComCompras);

        RelatorioProdutos.setText("Produtos");
        RelatorioProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioProdutosActionPerformed(evt);
            }
        });
        jMenu5.add(RelatorioProdutos);

        RelatorioFatura.setText("Fatura");
        jMenu5.add(RelatorioFatura);

        jMenuBar1.add(jMenu5);

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
        this.RelatorioProdutosActionPerformed(evt);
    }//GEN-LAST:event_produtorelatorioActionPerformed

    private void ClienteCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteCadastrarActionPerformed
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
    }//GEN-LAST:event_ClienteCadastrarActionPerformed

    private void ClienteCRUDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteCRUDActionPerformed
        JInternalFrame[] frames = desktop.getAllFrames();
        for(JInternalFrame f : frames) {
            f.dispose();
        }
        ViewConsultaCliente janelaViewConsultaCliente = new ViewConsultaCliente();   
        JInternalFrame internoconsult = new JInternalFrame();
        internoconsult.setContentPane(janelaViewConsultaCliente.getContentPane());
        internoconsult.setMaximizable(true);
        internoconsult.setClosable(true);
        internoconsult.pack();
        internoconsult.setVisible(true);
        desktop.add(internoconsult);
    }//GEN-LAST:event_ClienteCRUDActionPerformed

    private void ClienteRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteRelatorioActionPerformed
        JInternalFrame[] frames = desktop.getAllFrames();
        for(JInternalFrame f : frames) {
            f.dispose();
        }
        this.RelatorioClientesActionPerformed(evt);
    }//GEN-LAST:event_ClienteRelatorioActionPerformed

    private void ContaRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContaRelatorioActionPerformed
        JInternalFrame[] frames = desktop.getAllFrames();
        for(JInternalFrame f : frames) {
            f.dispose();
        }
        this.RelatorioContasComComprasActionPerformed(evt);
    }//GEN-LAST:event_ContaRelatorioActionPerformed

    private void ConsultarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarContaActionPerformed
        JInternalFrame[] frames = desktop.getAllFrames();
        for(JInternalFrame f : frames) {
            f.dispose();
        }
        ViewContaConsulta janelaViewContaP = new ViewContaConsulta();   
        JInternalFrame internoconsult = new JInternalFrame();
        internoconsult.setContentPane(janelaViewContaP.getContentPane());
        internoconsult.setMaximizable(true);
        internoconsult.setClosable(true);
        internoconsult.pack();
        internoconsult.setVisible(true);
        desktop.add(internoconsult);
    }//GEN-LAST:event_ConsultarContaActionPerformed

    private void RelatorioClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioClientesActionPerformed
        JInternalFrame[] frames = desktop.getAllFrames();
        for(JInternalFrame f : frames) {
            f.dispose();
        }
        CallReports janelaCallReports = new CallReports();   
        janelaCallReports.Call(0);
        
    }//GEN-LAST:event_RelatorioClientesActionPerformed

    private void RelatorioClientesComEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioClientesComEnderecoActionPerformed
        JInternalFrame[] frames = desktop.getAllFrames();
        for(JInternalFrame f : frames) {
            f.dispose();
        }
        CallReports janelaCallReports = new CallReports();   
        janelaCallReports.Call(1);
    }//GEN-LAST:event_RelatorioClientesComEnderecoActionPerformed

    private void RelatorioContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioContasActionPerformed
        JInternalFrame[] frames = desktop.getAllFrames();
        for(JInternalFrame f : frames) {
            f.dispose();
        }
        CallReports janelaCallReports = new CallReports();   
        janelaCallReports.Call(2);
    }//GEN-LAST:event_RelatorioContasActionPerformed

    private void RelatorioContasComComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioContasComComprasActionPerformed
        JInternalFrame[] frames = desktop.getAllFrames();
        for(JInternalFrame f : frames) {
            f.dispose();
        }
        CallReports janelaCallReports = new CallReports();   
        janelaCallReports.Call(3);
    }//GEN-LAST:event_RelatorioContasComComprasActionPerformed

    private void RelatorioProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioProdutosActionPerformed
        JInternalFrame[] frames = desktop.getAllFrames();
        for(JInternalFrame f : frames) {
            f.dispose();
        }
        CallReports janelaCallReports = new CallReports();   
        janelaCallReports.Call(4);
    }//GEN-LAST:event_RelatorioProdutosActionPerformed

    private void AbrirContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirContaActionPerformed
        JInternalFrame[] frames = desktop.getAllFrames();
        for(JInternalFrame f : frames) {
            f.dispose();
        }
        ViewConta janelaViewConta = new ViewConta(new Conta());
        JInternalFrame internoconsult = new JInternalFrame();
        internoconsult.setContentPane(janelaViewConta.getContentPane());
        internoconsult.setMaximizable(true);
        internoconsult.setClosable(true);
        internoconsult.pack();
        internoconsult.setVisible(true);
        desktop.add(internoconsult);
    
    }//GEN-LAST:event_AbrirContaActionPerformed

    private void GerarFaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GerarFaturaActionPerformed
        JInternalFrame[] frames = desktop.getAllFrames();
        for(JInternalFrame f : frames) {
            f.dispose();
        }
        ViewNovaFatura janelaViewNovaFatura = new ViewNovaFatura();
        JInternalFrame internoconsult = new JInternalFrame();
        internoconsult.setContentPane(janelaViewNovaFatura.getContentPane());
        internoconsult.setMaximizable(true);
        internoconsult.setClosable(true);
        internoconsult.pack();
        internoconsult.setVisible(true);
        desktop.add(internoconsult);
        
    }//GEN-LAST:event_GerarFaturaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JInternalFrame[] frames = desktop.getAllFrames();
        for(JInternalFrame f : frames) {
            f.dispose();
        }
        ViewTelaPagamento janelaViewTelaPagamento = new ViewTelaPagamento();
        JInternalFrame internoconsult = new JInternalFrame();
        internoconsult.setContentPane(janelaViewTelaPagamento.getContentPane());
        internoconsult.setMaximizable(true);
        internoconsult.setClosable(true);
        internoconsult.pack();
        internoconsult.setVisible(true);
        desktop.add(internoconsult);
        
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
    private javax.swing.JMenuItem AbrirConta;
    private javax.swing.JMenuItem ClienteCRUD;
    private javax.swing.JMenuItem ClienteCadastrar;
    private javax.swing.JMenuItem ClienteRelatorio;
    private javax.swing.JMenuItem ConsultarConta;
    private javax.swing.JMenuItem ContaRelatorio;
    private javax.swing.JMenuItem FaturaRelatório;
    private javax.swing.JMenuItem GerarFatura;
    private javax.swing.JMenuItem Jexcluirproduto;
    private javax.swing.JMenu Pagamento;
    private javax.swing.JMenuItem RelatorioClientes;
    private javax.swing.JMenuItem RelatorioClientesComEndereco;
    private javax.swing.JMenuItem RelatorioContas;
    private javax.swing.JMenuItem RelatorioContasComCompras;
    private javax.swing.JMenuItem RelatorioFatura;
    private javax.swing.JMenuItem RelatorioProdutos;
    private javax.swing.JMenuItem TelaPrincipalFatura;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu menuFatura;
    private javax.swing.JMenuItem produtoAlterar;
    private javax.swing.JMenuItem produtoCadastrar;
    private javax.swing.JMenuItem produtoConsultar;
    private javax.swing.JMenuItem produtorelatorio;
    // End of variables declaration//GEN-END:variables
}
