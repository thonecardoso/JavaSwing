package view;

import dao.DAOFatura;
import dao.DAOPagamento;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Fatura;
import model.Juros;
import model.Pagamento;

public class ViewTelaPagamento extends javax.swing.JFrame {
    
    Fatura fatura;
    
    
    private DefaultTableModel modelo;
    private Locale locale = new Locale("pt", "BR");
    private NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private DAOPagamento pagDAO = new DAOPagamento();
    private DAOFatura faturaDAO = new DAOFatura();
    
    private Juros juros = new Juros();
    
    public ViewTelaPagamento() {
        initComponents();
        
        
        
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
        double valorfatura = 0;
        Iterator it = fatura.getParcelas().iterator();
        while(it.hasNext()){
            Pagamento p = (Pagamento) it.next();
            valorfatura = valorfatura + p.getValor() + p.getJuros();
        }
        
        idconta.setText(String.valueOf(fatura.getConta().getId()));
        nome.setText(fatura.getConta().getCli().getNome());
        vencimento.setText(dat);
        Recebido.setText(nf.format(recebido) + "  de  " + nf.format(fatura.getConta().getTotal()));
        Emdebito.setText(nf.format(emdebito));
        totalfatura.setText(nf.format(valorfatura));
        parcela.setText(nf.format(fatura.getParcelas().get(0).getValor()));
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        PagarParcela = new javax.swing.JButton();
        AtualizarPainelPagamento = new javax.swing.JButton();
        idFatura = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        nome = new javax.swing.JLabel();
        vencimento = new javax.swing.JLabel();
        Recebido = new javax.swing.JLabel();
        Emdebito = new javax.swing.JLabel();
        parcela = new javax.swing.JLabel();
        totalfatura = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        idconta = new javax.swing.JLabel();
        BuscarFatura = new javax.swing.JButton();

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

        jLabel7.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel7.setText("ID FATURA:");

        PagarParcela.setText("PAGAR");
        PagarParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PagarParcelaActionPerformed(evt);
            }
        });

        AtualizarPainelPagamento.setText("Refresh");
        AtualizarPainelPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarPainelPagamentoActionPerformed(evt);
            }
        });

        idFatura.setText("Busca por id Fatura");
        idFatura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                idFaturaMouseClicked(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        nome.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N

        vencimento.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N

        Recebido.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N

        Emdebito.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N

        parcela.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N

        totalfatura.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nome)
                    .addComponent(vencimento)
                    .addComponent(Recebido)
                    .addComponent(Emdebito)
                    .addComponent(parcela)
                    .addComponent(totalfatura))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vencimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Recebido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Emdebito)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(parcela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalfatura)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel2.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel2.setText("Total Fatura:");

        jLabel3.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel3.setText("Parcelas:");

        jLabel8.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel8.setText("Total a receber:");

        jLabel5.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel5.setText("Total Pago:");

        jLabel6.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel6.setText("Data Proximo Vencimento:");

        jLabel4.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel4.setText("Cliente:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jLabel9.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel9.setText("ID CONTA:");

        idconta.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        idconta.setText("id");

        BuscarFatura.setText("Buscar");
        BuscarFatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarFaturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idFatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idconta))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PagarParcela)
                            .addComponent(BuscarFatura))
                        .addGap(5, 5, 5)
                        .addComponent(AtualizarPainelPagamento))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(idFatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BuscarFatura)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(idconta)
                    .addComponent(PagarParcela)
                    .addComponent(AtualizarPainelPagamento))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        

    }//GEN-LAST:event_tableMouseClicked

    private void PagarParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagarParcelaActionPerformed
        int index = table.getSelectedRow();
        if(fatura.getParcelas().get(index).isPaga()){
            JOptionPane.showMessageDialog(null, "Essa Parcela já está pagar\nObrigado tente pagar outra!!!");
        }else{
            int id = Integer.parseInt(modelo.getValueAt(index, 1).toString());
            int x = JOptionPane.showConfirmDialog(null, "Confirma o Pagamento de ID: " + id);
            if(x==0){
                pagDAO.inserirPagamento(id);
                JOptionPane.showMessageDialog(null, "Pagamento efetivado com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Pagamento não efetivado!");
            } 
        }
        
        
    }//GEN-LAST:event_PagarParcelaActionPerformed

    private void AtualizarPainelPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarPainelPagamentoActionPerformed
        fatura = faturaDAO.buscarFatura(fatura.getId());
        preencherTabela();
        preencherComponentes();
    }//GEN-LAST:event_AtualizarPainelPagamentoActionPerformed

    private void idFaturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idFaturaMouseClicked
        idFatura.setText("");
    }//GEN-LAST:event_idFaturaMouseClicked

    private void BuscarFaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarFaturaActionPerformed
        int x = -1;
        try {
            x = Integer.parseInt(idFatura.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Digite um número Inteiro");
        }
        if(x!=-1){
            fatura = faturaDAO.buscarFatura(x);
            if(fatura!=null){
            juros.jurosFatura(fatura.getParcelas());
            preencherTabela();
            preencherComponentes();
            }else{
                JOptionPane.showMessageDialog(null, "Fatura Inexistente");
            }
        }
    }//GEN-LAST:event_BuscarFaturaActionPerformed

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
    private javax.swing.JButton AtualizarPainelPagamento;
    private javax.swing.JButton BuscarFatura;
    private javax.swing.JLabel Emdebito;
    private javax.swing.JButton PagarParcela;
    private javax.swing.JLabel Recebido;
    private javax.swing.JTextField idFatura;
    private javax.swing.JLabel idconta;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel parcela;
    private javax.swing.JTable table;
    private javax.swing.JLabel totalfatura;
    private javax.swing.JLabel vencimento;
    // End of variables declaration//GEN-END:variables
}
