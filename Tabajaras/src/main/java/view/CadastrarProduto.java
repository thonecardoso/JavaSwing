package view;

import controller.GerenciadorProduto;
import javax.swing.JOptionPane;

public class CadastrarProduto extends javax.swing.JFrame {

    private GerenciadorProduto incluir;
            
    public CadastrarProduto() {
        incluir = new GerenciadorProduto();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        JNome = new javax.swing.JTextField();
        JPreco = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        JTipoUva = new javax.swing.JTextField();
        JCodigo = new javax.swing.JTextField();
        JPais = new javax.swing.JTextField();
        JCadastrar = new javax.swing.JButton();
        JTipo = new javax.swing.JTextField();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JNome.setText("Nome");
        JNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JNomeActionPerformed(evt);
            }
        });

        JPreco.setText("Preço");

        jLabel1.setText("Cadastrar Produto");

        JTipoUva.setText("Tipo de Uva");

        JCodigo.setText("Código de Barras");

        JPais.setText("País de Origem");

        JCadastrar.setText("Cadastrar");
        JCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCadastrarActionPerformed(evt);
            }
        });

        JTipo.setText("Tipo de Vinho");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JCadastrar)
                    .addComponent(JPreco)
                    .addComponent(JCodigo)
                    .addComponent(JTipoUva)
                    .addComponent(JPais)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(JNome)
                    .addComponent(JTipo))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(JNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JTipoUva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JCadastrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JNomeActionPerformed

    private void JCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCadastrarActionPerformed
        if(!JNome.getText().trim().isEmpty()){
            incluir.cadastrarProduto(JNome.getText(), Float.parseFloat(JPreco.getText()), JCodigo.getText(), JTipoUva.getText(), JPais.getText(), JTipo.getText());
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
        }
        else{
            JOptionPane.showMessageDialog(null, "Campo nome não pode ser nulo");
        }
    }//GEN-LAST:event_JCadastrarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JCadastrar;
    private javax.swing.JTextField JCodigo;
    private javax.swing.JTextField JNome;
    private javax.swing.JTextField JPais;
    private javax.swing.JTextField JPreco;
    private javax.swing.JTextField JTipo;
    private javax.swing.JTextField JTipoUva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
