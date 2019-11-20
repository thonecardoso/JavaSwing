/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.DAOFatura;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import model.Fatura;

public class ViewFaturaOne extends javax.swing.JFrame {
    
    DAOFatura faturaDAO = new DAOFatura();
    ArrayList<Fatura> faturas;
    DefaultTableModel modelo;
    private Locale locale = new Locale("pt", "BR");
    private NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ViewFaturaOne() {
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

        jScrollPane3 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        combbuscatabela = new javax.swing.JComboBox<>();
        filtro = new javax.swing.JTextField();
        novafatura = new javax.swing.JButton();
        pagamento = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        novafatura.setText("Nova Fatura");

        pagamento.setText("Pagamento");

        label1.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        label1.setText("Selecione uma Fatura para pagamento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(novafatura)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label1)
                        .addGap(36, 36, 36)
                        .addComponent(pagamento))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(combbuscatabela, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(novafatura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label1)
                    .addComponent(pagamento))
                .addGap(132, 132, 132)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combbuscatabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        /*int x = table.getSelectedRow();
        conta = contas.get(x);
        nome.setText(conta.getCli().getNome());
        vencimento.setText(conta.getDataVencimento().format(format));
        id.setText(String.valueOf(conta.getId()));
        totalconta.setText(nf.format(conta.getTotal()));

        qtparcelas = 1 + combp.getSelectedIndex();
        if(conta!=null){
            juros = jr.calculaJurosPorParcelamento(conta.getTotal(), conta.getDataVencimento(), qtparcelas);
            totalvalorfatura = conta.getTotal() + juros;
            double parc = totalvalorfatura/qtparcelas;
            parcela.setText(nf.format(parc));
            totalfatura.setText(nf.format(totalvalorfatura));

        }*/
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
            java.util.logging.Logger.getLogger(ViewFaturaOne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewFaturaOne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewFaturaOne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewFaturaOne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewFaturaOne().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combbuscatabela;
    private javax.swing.JTextField filtro;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label1;
    private javax.swing.JButton novafatura;
    private javax.swing.JButton pagamento;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
