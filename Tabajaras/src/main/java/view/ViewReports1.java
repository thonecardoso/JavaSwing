package view;

import Reports.CallReports;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.view.JasperViewer;

public class ViewReports1 extends javax.swing.JFrame {
    
    String strCliente = "Cliente";
    String strClienteEndereco = "ClienteComEndereco";
    String strConta = "Contas";
    String strContaCompra = "ContaComCompras";
    String strProduto = "Produtos";
    
    CallReports report = new CallReports();

    public ViewReports1() {
        initComponents();
    }
    
    public void CallReport(String str){
        
        Connection connection = null;
        
		try {
		
			
                        str = new File("Reports/" + str + ".jasper").getAbsolutePath();
                        str = str.replace("Tabajaras/", "Tabajaras/src/main/java/");
                        
			Map<String, Object> parameters = new HashMap<String, Object>();
			connection = dao.SingletonCon.getConexao(); 

			JasperPrint print = JasperFillManager.fillReport(str, parameters, connection);
			
                        JasperViewer view = new JasperViewer(print, false);
                            view.setVisible(true);
                        
                        

		} catch (Exception e) {
			throw new RuntimeException("Erro ao chamar relatório.", e);
                }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ClienteReport = new javax.swing.JButton();
        selectReport = new javax.swing.JComboBox<>();
        CallReport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ClienteReport.setText("Relatório Cliente");
        ClienteReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteReportActionPerformed(evt);
            }
        });

        selectReport.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente sem endereço", "Cliente com endereço", "Conta sem endereço", "Conta com compras", "Produtos", " " }));

        CallReport.setText("Chamar Relatório");
        CallReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CallReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(ClienteReport))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(selectReport, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CallReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(selectReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CallReport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(ClienteReport)
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ClienteReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteReportActionPerformed
        
        Connection connection = null;
        
		try {
		
			/*String reportName = "Reports/Cliente";
                        String str = new File(reportName + ".jasper").getAbsolutePath();
                        
                        
                        str = str.replace("Tabajaras/", "Tabajaras/src/main/java/");*/
                        
			Map<String, Object> parameters = new HashMap<String, Object>();
			connection = dao.SingletonCon.getConexao(); 

			/*JasperCompileManager.compileReportToFile(
                                "/home/thone/Documentos/PV-TAVV/Tabajaras/src/main/java/Reports/Cliente.jrxml");*/
                        
			JasperPrint print = JasperFillManager.fillReport(
                                "/home/thone/Documentos/PV-TAVV/Tabajaras/src/main/java/Reports/Produtos.jasper"
                                , parameters, connection);
			
			
                        JasperViewer view = new JasperViewer(print, false);
                            view.setVisible(true);
                        
                        

		} catch (Exception e) {
                    System.out.println(e.getMessage());
                    
			//throw new RuntimeException("It's not possible to generate the pdf report.", e);
                }
        
        
        
        
    }//GEN-LAST:event_ClienteReportActionPerformed

    private void CallReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CallReportActionPerformed
        int x = selectReport.getSelectedIndex();
        report.Call(x);
    }//GEN-LAST:event_CallReportActionPerformed

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
            java.util.logging.Logger.getLogger(ViewReports1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewReports1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewReports1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewReports1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewReports1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CallReport;
    private javax.swing.JButton ClienteReport;
    private javax.swing.JComboBox<String> selectReport;
    // End of variables declaration//GEN-END:variables
}
