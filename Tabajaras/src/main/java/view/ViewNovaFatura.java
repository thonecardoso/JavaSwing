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
        combp = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totalfatura = new javax.swing.JLabel();
        parcela = new javax.swing.JLabel();
        comb = new javax.swing.JComboBox<>();
        filtro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        vencimento = new javax.swing.JLabel();
        totalconta = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GerarFatura.setText("Gerar Fatura");
        GerarFatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GerarFaturaActionPerformed(evt);
            }
        });

        combp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01x", "02x", "03x", "04x", "05x", "06x", "07x", "08x", "09x", "10x", "11x", "12x" }));
        combp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combpActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel1.setText("Selecionar Conta");

        jLabel2.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel2.setText("Total Fatura:");

        totalfatura.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        totalfatura.setText("totalFatura");

        parcela.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        parcela.setText("valorParcelas");

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

        jLabel3.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel3.setText("Parcelas:");

        jLabel4.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel4.setText("Cliente:");

        jLabel5.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel5.setText("Total Conta:");

        jLabel6.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel6.setText("Data Vencimento:");

        nome.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        nome.setText("nome");

        vencimento.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        vencimento.setText("vencimento");

        totalconta.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        totalconta.setText("totalconta");

        jLabel7.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel7.setText("ID CONTA:");

        id.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        id.setText("id");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comb, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GerarFatura))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(combp, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id)
                            .addComponent(totalfatura)
                            .addComponent(parcela)
                            .addComponent(totalconta)
                            .addComponent(vencimento)
                            .addComponent(nome))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(nome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vencimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalconta)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalfatura, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(parcela)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(combp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)))
                .addGap(14, 14, 14)
                .addComponent(GerarFatura)
                .addContainerGap())
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel parcela;
    private javax.swing.JTable table;
    private javax.swing.JLabel totalconta;
    private javax.swing.JLabel totalfatura;
    private javax.swing.JLabel vencimento;
    // End of variables declaration//GEN-END:variables
}
