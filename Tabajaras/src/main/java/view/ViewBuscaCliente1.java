package view;

import dao.DAOCliente;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import model.Cliente;
import model.PessoaFisica;
import model.PessoaJuridica;

public class ViewBuscaCliente1 extends javax.swing.JFrame {
    
    DAOCliente clienteDAO = new DAOCliente();
    Locale locale = new Locale("pt", "BR");
    NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
    Cliente cl;
    boolean condicao = false;

    public ViewBuscaCliente1(Cliente c) {
        initComponents();
        cl = c;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        combo = new javax.swing.JComboBox<>();
        cpf = new javax.swing.JTextField();
        PessoaFisica = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cnpj = new javax.swing.JLabel();
        fant = new javax.swing.JLabel();
        fantasia = new javax.swing.JLabel();
        cpf1 = new javax.swing.JLabel();
        limite = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pessoa Física", "Pessoa Juridica" }));
        combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboItemStateChanged(evt);
            }
        });
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        cpf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cpf.setText("CPF");
        cpf.setPreferredSize(new java.awt.Dimension(140, 37));
        cpf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cpfMouseClicked(evt);
            }
        });

        PessoaFisica.setText("Buscar");
        PessoaFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PessoaFisicaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel3.setText("Limite de Crédito:");

        cnpj.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N

        fant.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N

        fantasia.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N

        cpf1.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N

        limite.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N

        nome.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(cnpj)
                    .addComponent(fant))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PessoaFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nome)
                    .addComponent(limite)
                    .addComponent(cpf1)
                    .addComponent(fantasia))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PessoaFisica))
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cnpj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fant))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(nome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(limite)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cpf1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fantasia)))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cpfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cpfMouseClicked
        cpf.setText("");
    }//GEN-LAST:event_cpfMouseClicked

    private void PessoaFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PessoaFisicaActionPerformed
        String chave = cpf.getText().trim();

        
        
        if(combo.getSelectedIndex()==0){
            
            boolean cond = true;

            PessoaFisica pf = clienteDAO.ClienteFisico(chave);
            

            if(pf==null){
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            }else{
                
                nome.setText(pf.getNome());
                limite.setText(nf.format(pf.getLimiteDeCredito()));
                cpf1.setText(pf.getCpf());
                fantasia.setText("");
                cnpj.setText("CPF:");
                fant.setText("");
                
                cl = pf;
                condicao = true;
                
            }
            cpf.setText("CPF");
            
        }else if(combo.getSelectedIndex()==1){
            PessoaJuridica pj = clienteDAO.ClienteJuridico(chave);
            
            

            if(pj==null){
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            }else{
                
                nome.setText(pj.getNome());
                limite.setText(nf.format(pj.getLimiteDeCredito()));
                cpf1.setText(pj.getCnpj());
                fant.setText("Nome Fantasia:");
                cnpj.setText("CNPJ:");
                fantasia.setText(pj.getNomeFantasia());
                
                cl = pj;
                
                condicao = true;

            }
            cpf.setText("CNPJ");
        }
    }//GEN-LAST:event_PessoaFisicaActionPerformed

    private void comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboItemStateChanged
        if(combo.getSelectedIndex()==0){
            
            cpf.setText("CPF");
            
        }else if(combo.getSelectedIndex()==0){
            
            cpf.setText("CNPJ");
        }
    }//GEN-LAST:event_comboItemStateChanged

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
         if(combo.getSelectedIndex()==0){
            
            cpf.setText("CPF");
             System.out.println("cpf");
            
        }else if(combo.getSelectedIndex()==1){
            System.out.println("cnpj");
            cpf.setText("CNPJ");
        }
    }//GEN-LAST:event_comboActionPerformed

    public boolean isCondicao() {
        return condicao;
    }

    
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
            java.util.logging.Logger.getLogger(ViewBuscaCliente1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBuscaCliente1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBuscaCliente1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBuscaCliente1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewBuscaCliente1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PessoaFisica;
    private javax.swing.JLabel cnpj;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JTextField cpf;
    private javax.swing.JLabel cpf1;
    private javax.swing.JLabel fant;
    private javax.swing.JLabel fantasia;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel limite;
    private javax.swing.JLabel nome;
    // End of variables declaration//GEN-END:variables
}
