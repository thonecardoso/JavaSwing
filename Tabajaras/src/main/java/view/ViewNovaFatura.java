package view;

import dao.DAOConta;
import dao.DAOFatura;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Conta;
import model.Fatura;
import model.Juros;
import model.Pagamento;

public class ViewNovaFatura extends javax.swing.JFrame {
    
    private DAOConta contaDAO = new DAOConta();
    private DAOFatura faturaDAO = new DAOFatura();
    private ArrayList<Conta> contas = new ArrayList<>();
    private Conta conta = null;
    
    private DefaultTableModel modelo = null;
    
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private Locale locale = new Locale("pt", "BR");
    private NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
    
    private Fatura fatura;
    
    private int qtparcelas;
    private double juros;
    private double totalvalorfatura;
    private Juros jr = new Juros();

    public ViewNovaFatura() {
        initComponents();
        
        this.qtparcelas = 1 + combp.getSelectedIndex();
        
        String str = "";
        str ="%"+str+"%";
        contas = contaDAO.relatorioContaParaGerarFatura(comb.getSelectedIndex(), str);
        
        //contas = contaDAO.relatorioConta();
        fatura = new Fatura();
        preencherTabela(contas);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GerarFatura = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        comb = new javax.swing.JComboBox<>();
        filtro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        id = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        vencimento = new javax.swing.JLabel();
        totalconta = new javax.swing.JLabel();
        parcela = new javax.swing.JLabel();
        totalfatura = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        combp = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GerarFatura.setText("Gerar Fatura");
        GerarFatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GerarFaturaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel1.setText("Selecionar Conta");

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(comb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        id.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        id.setText("id");

        nome.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        nome.setText("nome");

        vencimento.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        vencimento.setText("vencimento");

        totalconta.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        totalconta.setText("totalconta");

        parcela.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        parcela.setText("valorParcelas");

        totalfatura.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        totalfatura.setText("totalFatura");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id)
                    .addComponent(nome)
                    .addComponent(vencimento)
                    .addComponent(totalconta)
                    .addComponent(parcela)
                    .addComponent(totalfatura))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(id)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vencimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalconta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(parcela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalfatura)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel7.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel7.setText("ID CONTA:");

        jLabel4.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel4.setText("Cliente:");

        jLabel6.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel6.setText("Data Vencimento:");

        jLabel5.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel5.setText("Total Conta:");

        jLabel3.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel3.setText("Parcelas:");

        jLabel2.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel2.setText("Total Fatura:");

        combp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01x", "02x", "03x", "04x", "05x", "06x", "07x", "08x", "09x", "10x", "11x", "12x" }));
        combp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(combp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(GerarFatura)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(GerarFatura)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combActionPerformed
        String str = "";
        str ="%"+str+"%";
        contas = contaDAO.relatorioContaParaGerarFatura(comb.getSelectedIndex(), str);
        //contas = contaDAO.relatorioConta(comb.getSelectedIndex(), str);
        preencherTabela(contas);
    }//GEN-LAST:event_combActionPerformed

    private void filtroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filtroMouseClicked
        filtro.setText("");
    }//GEN-LAST:event_filtroMouseClicked

    private void filtroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroKeyTyped
        String str = filtro.getText();
        str ="%"+str+"%";
        contas = contaDAO.relatorioContaParaGerarFatura(comb.getSelectedIndex(), str);
        //contas = contaDAO.relatorioConta(comb.getSelectedIndex(), str);
        preencherTabela(contas);
    }//GEN-LAST:event_filtroKeyTyped

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int x = table.getSelectedRow();
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
            
        }
        
    }//GEN-LAST:event_tableMouseClicked

    private void combpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combpActionPerformed
        qtparcelas = 1 + combp.getSelectedIndex();
        if(conta!=null){
            juros = jr.calculaJurosPorParcelamento(conta.getTotal(), conta.getDataVencimento(), qtparcelas);
            totalvalorfatura = conta.getTotal() + juros;
            double parc = totalvalorfatura/qtparcelas;
            parcela.setText(nf.format(parc));
            totalfatura.setText(nf.format(totalvalorfatura));
            
        }
    }//GEN-LAST:event_combpActionPerformed

    private void GerarFaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GerarFaturaActionPerformed
        
        double parc = totalvalorfatura/qtparcelas;
        ArrayList<Pagamento> pag = new ArrayList<>();
        int id = faturaDAO.buscarId();
        for(int x = 0; x<qtparcelas; x++){
            Pagamento p = new Pagamento();
            LocalDate data = conta.getDataVencimento().plus(Period.ofMonths(x));
            p.setDataVencimento(data);
            p.setJuros(0);           
            p.setTipo(x+1);
            p.setValor(parc);
            pag.add(p);
            
        }
        fatura.setParcelas(pag);
        fatura.setQuantParcela(qtparcelas);
        fatura.setConta(conta);
        fatura.setDataQuitacao(conta.getDataVencimento().plus(Period.ofMonths(qtparcelas-1)));
        fatura.setJuros(juros);
        fatura.setId(id);
        
        faturaDAO.cadastrarFatura(fatura);
        JOptionPane.showMessageDialog(null, "Fatura Gerada com Sucesso!");
        this.dispose();

    }//GEN-LAST:event_GerarFaturaActionPerformed

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
            java.util.logging.Logger.getLogger(ViewNovaFatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewNovaFatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewNovaFatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewNovaFatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewNovaFatura().setVisible(true);
            }
        });
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GerarFatura;
    private javax.swing.JComboBox<String> comb;
    private javax.swing.JComboBox<String> combp;
    private javax.swing.JTextField filtro;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel parcela;
    private javax.swing.JTable table;
    private javax.swing.JLabel totalconta;
    private javax.swing.JLabel totalfatura;
    private javax.swing.JLabel vencimento;
    // End of variables declaration//GEN-END:variables
}
