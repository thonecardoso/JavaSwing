package view;

import dao.DAOFatura;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Conta;
import model.Fatura;

public class ViewFatura extends javax.swing.JFrame {
    
    DAOFatura faturaDAO = new DAOFatura();
    ArrayList<Fatura> faturas;
    Fatura fatura;
    DefaultTableModel modelo;
    private Locale locale = new Locale("pt", "BR");
    private NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    

    public ViewFatura() {
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
    
    public double tratamentoTextFild(String str){
        char[] textoSeparado = str.toCharArray();
        System.out.println(textoSeparado);
        textoSeparado[0]=' ';
        textoSeparado[1]=' ';
        textoSeparado[5]='.';
        str = new String(textoSeparado).trim();
        
        double num = 0;
        System.out.println(str);
        
        try {
            num = Double.parseDouble(str);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Deve ter um número válido");
        }
                
        return num;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        novafatura = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        combbuscatabela = new javax.swing.JComboBox<>();
        filtro = new javax.swing.JTextField();
        AtualizarViewFatura = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tf = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        novafatura.setText("Nova Fatura");
        novafatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novafaturaActionPerformed(evt);
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

        AtualizarViewFatura.setText("Refresh");
        AtualizarViewFatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarViewFaturaActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        tf.setText("50.50");
        tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(combbuscatabela, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tf, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1)
                        .addGap(47, 47, 47)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(novafatura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(AtualizarViewFatura, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AtualizarViewFatura)
                        .addComponent(novafatura))
                    .addComponent(label1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combbuscatabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
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

    private void novafaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novafaturaActionPerformed
        ViewNovaFatura vnf = new ViewNovaFatura();
        vnf.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        vnf.setVisible(true);
    }//GEN-LAST:event_novafaturaActionPerformed

    private void AtualizarViewFaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarViewFaturaActionPerformed
        faturas  = faturaDAO.relatorioFatura();
        preencherTabela(faturas);
    }//GEN-LAST:event_AtualizarViewFaturaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String str = tf.getText();
        double num = Double.parseDouble(str);
        tf.setText(nf.format(num));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String str = tf.getText();
        Double num = tratamentoTextFild(str);
        tf.setText(String.valueOf(num));
        
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AtualizarViewFatura;
    private javax.swing.JComboBox<String> combbuscatabela;
    private javax.swing.JTextField filtro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label1;
    private javax.swing.JButton novafatura;
    private javax.swing.JTable table;
    private javax.swing.JTextField tf;
    // End of variables declaration//GEN-END:variables
}
