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

public class ViewContaConsulta extends javax.swing.JFrame {
    
    private ViewConta vc;
    private DAOCliente clienteDAO = new DAOCliente ();
    
    private DAOConta contaDAO = new DAOConta();
    private RelatorioConta_1 rc1;
    
    private DefaultTableModel modelo = null;
    
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private Locale locale = new Locale("pt", "BR");
    private NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
    
    private ArrayList<Conta> contas = null;
    
    
    

    public ViewContaConsulta() {
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

        Busca_ID_CONTA = new javax.swing.JButton();
        id_conta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Refresh = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        comb = new javax.swing.JComboBox<>();
        filtro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jLabel5.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        jLabel5.setText("CONSULTA CONTAS");

        Refresh.setText("Refresh");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        comb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Física/Juridica", "Pessoa Física", "Pessoa Juridica", " " }));
        comb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(comb, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(id_conta, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Busca_ID_CONTA, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Refresh)
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Refresh)
                    .addComponent(jLabel1)
                    .addComponent(id_conta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Busca_ID_CONTA))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        contas = contaDAO.relatorioConta();
        preencherTabela(contas);
    }//GEN-LAST:event_RefreshActionPerformed

    
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
            java.util.logging.Logger.getLogger(ViewContaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewContaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewContaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewContaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewContaConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Busca_ID_CONTA;
    private javax.swing.JButton Refresh;
    private javax.swing.JComboBox<String> comb;
    private javax.swing.JTextField filtro;
    private javax.swing.JTextField id_conta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
