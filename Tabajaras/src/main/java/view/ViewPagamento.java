package view;

import dao.DAOPagamento;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Fatura;
import model.Pagamento;

public class ViewPagamento extends javax.swing.JFrame {
    
    Fatura fatura;
    
    
    private DefaultTableModel modelo;
    private Locale locale = new Locale("pt", "BR");
    private NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private DAOPagamento pagDAO = new DAOPagamento();
    
    
    public ViewPagamento(Fatura fat) {
        initComponents();
        
        fatura = fat;
        preencherTabela();
        preencherComponentes();
    }
    
    public void preencherTabela(){
        modelo = new DefaultTableModel();
        
        modelo.addColumn("Nº");
        modelo.addColumn("ID Pag");
        modelo.addColumn("VENCIMENTO");
        modelo.addColumn("Data Paga");
        modelo.addColumn("$ Parcela");
        modelo.addColumn("JUROS");
        modelo.addColumn("TOTAL");
        
        int numeroitem = 1;
        
        for(Pagamento pg: fatura.getParcelas()){
            String dataPag = "EM DEBITO"; 
            if(pg.isPaga()){
                dataPag = pg.getDataPagamento().format(format);
            }
            
                    modelo.addRow(new Object[]{
                    String.valueOf(numeroitem++),
                    String.valueOf(pg.getId()),
                    pg.getDataVencimento().format(format),
                    dataPag,
                    nf.format(pg.getValor()),
                    nf.format(pg.getJuros()),
                    nf.format(pg.getJuros() + pg.getValor())});
           
       }
        
       table.setModel(modelo);
    }
    
    public void preencherComponentes(){
        String dat = "";
        double recebido=0,emdebito=0;
        for(int i = fatura.getParcelas().size()-1; i>=0 ; i--){
            if(!fatura.getParcelas().get(i).isPaga()){
                dat = fatura.getParcelas().get(i).getDataVencimento().format(format);
                emdebito+=fatura.getParcelas().get(i).getValor() + fatura.getParcelas().get(i).getJuros();
            }else{
                recebido+=fatura.getParcelas().get(i).getValor() + fatura.getParcelas().get(i).getJuros();
            }
        }
        
        idfatura.setText(String.valueOf(fatura.getId()));
        idconta.setText(String.valueOf(fatura.getConta().getId()));
        nome.setText(fatura.getConta().getCli().getNome());
        vencimento.setText(dat);
        Recebido.setText(nf.format(recebido) + "  de  " + nf.format(fatura.getConta().getTotal()));
        Emdebito.setText(nf.format(emdebito));
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        totalfatura = new javax.swing.JLabel();
        vencimento = new javax.swing.JLabel();
        parcela = new javax.swing.JLabel();
        Recebido = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        idfatura = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        Emdebito = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        idconta = new javax.swing.JLabel();

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

        jLabel6.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel6.setText("Data Proximo Vencimento:");

        jLabel2.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel2.setText("Total Fatura:");

        nome.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        nome.setText("nome");

        totalfatura.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        totalfatura.setText("totalFatura");

        vencimento.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        vencimento.setText("vencimento");

        parcela.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        parcela.setText("valorParcelas");

        Recebido.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        Recebido.setText("totalconta");

        jLabel7.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel7.setText("ID FATURA:");

        idfatura.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        idfatura.setText("id");

        jLabel3.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel3.setText("Parcelas:");

        jLabel4.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel4.setText("Cliente:");

        jLabel5.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel5.setText("Total Pago:");

        jButton1.setText("PAGAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel8.setText("Total a receber:");

        Emdebito.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        Emdebito.setText("totalconta");

        jLabel9.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel9.setText("ID CONTA:");

        idconta.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        idconta.setText("id");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(idfatura))
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(idconta))
                            .addComponent(Recebido)
                            .addComponent(vencimento)
                            .addComponent(nome)
                            .addComponent(Emdebito))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalfatura)
                            .addComponent(parcela))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(30, 30, 30))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(idfatura))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(idconta)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(nome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vencimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Recebido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Emdebito)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalfatura, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(parcela)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        

    }//GEN-LAST:event_tableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int id = Integer.parseInt(modelo.getValueAt(table.getSelectedRow(), 1).toString());
        int x = JOptionPane.showConfirmDialog(null, "Confirma o Pagamento de ID: " + id);
        if(x==0){
            pagDAO.inserirPagamento(id);
            JOptionPane.showMessageDialog(null, "Pagamento efetivado com Sucesso!");
        }else{
            JOptionPane.showMessageDialog(null, "Pagamento não efetivado!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /*public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPagamento().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Emdebito;
    private javax.swing.JLabel Recebido;
    private javax.swing.JLabel idconta;
    private javax.swing.JLabel idfatura;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel parcela;
    private javax.swing.JTable table;
    private javax.swing.JLabel totalfatura;
    private javax.swing.JLabel vencimento;
    // End of variables declaration//GEN-END:variables
}
