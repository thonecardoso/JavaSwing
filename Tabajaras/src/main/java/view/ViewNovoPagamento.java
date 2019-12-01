package view;

import dao.DAOFatura;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import model.Conta;
import model.Fatura;

public class ViewNovoPagamento extends javax.swing.JFrame {
    
    DAOFatura faturaDAO = new DAOFatura();
    ArrayList<Fatura> faturas;
    Fatura fatura;
    DefaultTableModel modelo;
    private Locale locale = new Locale("pt", "BR");
    private NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    

    public ViewNovoPagamento() {
        initComponents();
        faturas  = faturaDAO.relatorioFatura();
        preencherTabela(faturas);
    }
    
    public void preencherTabela(ArrayList<Fatura> f){
        modelo = new DefaultTableModel();
        
        modelo.addColumn("Nº");
        modelo.addColumn("ID FATURA");
        modelo.addColumn("ID CONTA");
        modelo.addColumn("CLIENTE");
        modelo.addColumn("TIPO");
        modelo.addColumn("QT PARC");
        modelo.addColumn("VENCIMENTO");
        modelo.addColumn("TOTAL");
        
        int numeroitem = 1;
        
        for(Fatura fat: f){
            
            String tipo;
            if(fat.getConta().getCli().getTipo()==1){
                tipo = "Físico";
            }else{
                tipo = "Jurídico";
            }
           
           
            modelo.addRow(new Object[]{
                    String.valueOf(numeroitem++),
                    String.valueOf(fat.getId()),
                    String.valueOf(fat.getConta().getId()),
                    fat.getConta().getCli().getNome(),
                    tipo,
                    String.valueOf(fat.getQuantParcela()),
                    fat.getDataQuitacao().format(format),
                    nf.format(fat.getConta().getTotal())});
           
       }
       table.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        pagamento = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        combbuscatabela = new javax.swing.JComboBox<>();
        filtro = new javax.swing.JTextField();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pagamento.setText("Pagamento");
        pagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagamentoActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        label1.setText("Selecione uma Fatura para pagamento");

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
                "Nº", "ID FATURA", "ID CONTA", "CLIENTE", "QT. PARCELAS", "VENCIMENTO", "TOTAL"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table);

        combbuscatabela.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Física/Juridica", "Pessoa Física", "Pessoa Juridica", " " }));
        combbuscatabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combbuscatabelaActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1)
                .addGap(36, 36, 36)
                .addComponent(pagamento)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(combbuscatabela, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label1)
                    .addComponent(pagamento))
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combbuscatabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int x = table.getSelectedRow();
        fatura = faturas.get(x);
        
        ViewPagamento vp = new ViewPagamento(fatura);
        vp.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        vp.setVisible(true);
        

        

    }//GEN-LAST:event_tableMouseClicked

    private void combbuscatabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combbuscatabelaActionPerformed
        String str = "";
        str ="%"+str+"%";
        faturas = faturaDAO.relatorioFatura(combbuscatabela.getSelectedIndex(), str);
        preencherTabela(faturas);
    }//GEN-LAST:event_combbuscatabelaActionPerformed

    private void filtroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filtroMouseClicked
        filtro.setText("");
    }//GEN-LAST:event_filtroMouseClicked

    private void filtroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroKeyTyped
        String str = filtro.getText();
        str ="%"+str+"%"; 
        faturas = faturaDAO.relatorioFatura(combbuscatabela.getSelectedIndex(), str);
        preencherTabela(faturas);
    }//GEN-LAST:event_filtroKeyTyped

    private void pagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pagamentoActionPerformed

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
            java.util.logging.Logger.getLogger(ViewNovoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewNovoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewNovoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewNovoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewNovoPagamento().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combbuscatabela;
    private javax.swing.JTextField filtro;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label1;
    private javax.swing.JButton pagamento;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
