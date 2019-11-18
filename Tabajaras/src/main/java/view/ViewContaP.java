package view;

import dao.DAOCliente;
import dao.DAOConta;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Compra;
import model.Conta;
import model.PessoaFisica;
import model.PessoaJuridica;

public class ViewContaP extends javax.swing.JFrame {
    
    private ViewConta vc;
    private DAOCliente clienteDAO = new DAOCliente ();
    
    private DAOConta contaDAO = new DAOConta();
    private RelatorioConta_1 rc1;
    
    private DefaultTableModel modelo = null;
    
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private Locale locale = new Locale("pt", "BR");
    private NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
    
    private ArrayList<Conta> contas = null;
    
    
    

    public ViewContaP() {
        initComponents();
        contas = contaDAO.relatorioConta();
        preencherTabela(contas);
        
    }
    
    public void preencherTabela(ArrayList<Conta> c){
        modelo = new DefaultTableModel();
        
        modelo.addColumn("Nº");
        modelo.addColumn("ID");
        modelo.addColumn("CLIENTE");
        modelo.addColumn("TIPO");
        modelo.addColumn("Qt. Comp");
        modelo.addColumn("Vencimento");
        modelo.addColumn("TOTAL");
        
        int numeroitem = 1;
        
        for(Conta conta: c){
            
            String tipo;
            if(conta.getCli().getTipo()==1){
                tipo = "Físico";
            }else{
                tipo = "Jurídico";
            }
           
           
            modelo.addRow(new Object[]{
                    String.valueOf(numeroitem++),
                    String.valueOf(conta.getId()),
                    conta.getCli().getNome(),
                    tipo,
                    String.valueOf(conta.getCompras().size()),
                    conta.getDataVencimento().format(format),
                    nf.format(conta.getTotal())});
           
       }
       table.setModel(modelo);
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        RelatorioConta = new javax.swing.JButton();
        Busca_ID_CONTA = new javax.swing.JButton();
        id_conta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        comb = new javax.swing.JComboBox<>();
        filtro = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Nova Conta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 168, 78));

        RelatorioConta.setText("Relatório Contas");
        RelatorioConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioContaActionPerformed(evt);
            }
        });
        getContentPane().add(RelatorioConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 168, 78));

        Busca_ID_CONTA.setText("Buscar");
        Busca_ID_CONTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Busca_ID_CONTAActionPerformed(evt);
            }
        });
        getContentPane().add(Busca_ID_CONTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 121, -1));

        id_conta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id_conta.setText("ID CONTA");
        id_conta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id_contaMouseClicked(evt);
            }
        });
        getContentPane().add(id_conta, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 121, -1));

        jLabel1.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jLabel1.setText("Busca por ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        jLabel5.setText("CONSULTA CONTAS");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 51, 392, -1));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nº", "ID", "CLIENTE", "TIPO", "QT. COMPRAS", "VENCIMENTO", "TOTAL"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 580, 230));

        comb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Física/Juridica", "Pessoa Física", "Pessoa Juridica", " " }));
        comb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combActionPerformed(evt);
            }
        });
        getContentPane().add(comb, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 280, -1));

        filtro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        filtro.setText("Buscar");
        filtro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filtroMouseClicked(evt);
            }
        });
        filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                filtroKeyTyped(evt);
            }
        });
        getContentPane().add(filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 300, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        vc = new ViewConta(new Conta());
        vc.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        vc.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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

    private void id_contaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id_contaMouseClicked
        id_conta.setText("");
    }//GEN-LAST:event_id_contaMouseClicked

    private void filtroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filtroMouseClicked
        filtro.setText("");
    }//GEN-LAST:event_filtroMouseClicked

    private void filtroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroKeyTyped
        String str = filtro.getText();
        str ="%"+str+"%";
        contas = contaDAO.relatorioConta(comb.getSelectedIndex(), str);
        preencherTabela(contas);
    }//GEN-LAST:event_filtroKeyTyped

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int x = table.getSelectedRow();
        ArrayList<Conta> c = new ArrayList<>();
        c.add(contas.get(x));
        ViewContaEdicao vce = new ViewContaEdicao(c); 


            vce.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            vce.setVisible(true);
    }//GEN-LAST:event_tableMouseClicked

    private void combActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combActionPerformed
        String str = "";
        str ="%"+str+"%";
        contas = contaDAO.relatorioConta(comb.getSelectedIndex(), str);
        preencherTabela(contas);
    }//GEN-LAST:event_combActionPerformed

    
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
    private javax.swing.JButton RelatorioConta;
    private javax.swing.JComboBox<String> comb;
    private javax.swing.JTextField filtro;
    private javax.swing.JTextField id_conta;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
