package view;

import controller.GerenciadorCliente;
import dao.DAOCliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.*;


public class ConsultarCliente extends javax.swing.JFrame {

    ArrayList<Cliente> cliente;
    DAOCliente clienteDAO;
    GerenciadorCliente gerenciadorCliente;
    int posicao;
    ConsultarEndereco consultaEndereco;
    int tipo=0;
    int id = 0;
    public ConsultarCliente() {
        initComponents();
        gerenciadorCliente = new GerenciadorCliente();
        consultaEndereco = new ConsultarEndereco();
        clienteDAO = new DAOCliente();
        posicao = -1;
        cliente = clienteDAO.ArrayClientes();
        //cliente.addAll(clienteDAO.ArrayClientes());
        
        
        
        
        if(r1.isSelected()){
            tipo = 1;
        }else if(r2.isSelected()){
            tipo = 2;
        }
        
        
        
       
        
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        limite = new javax.swing.JTextField();
        cpf = new javax.swing.JTextField();
        nomefantasia = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campocpf = new javax.swing.JLabel();
        lfant = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        busc = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        r1 = new javax.swing.JRadioButton();
        r2 = new javax.swing.JRadioButton();
        Excluir = new javax.swing.JButton();
        atualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel1.setText("Consultar Cliente");

        jLabel2.setText("Nome:");

        jLabel3.setText("Limite de Crédito:");

        campocpf.setText("CPF/CNPJ");

        lfant.setText("Nome Fantasia:");

        jButton3.setText("Visualizar Endereços");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        busc.setText("CPF");
        busc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscMouseClicked(evt);
            }
        });

        buscar.setText("BUSCAR");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        buttonGroup1.add(r1);
        r1.setSelected(true);
        r1.setText("Pessoa Fisica");
        r1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(r2);
        r2.setText("Pessoa Juridica");
        r2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2ActionPerformed(evt);
            }
        });

        Excluir.setText("EXCLUIR CLIENTE");
        Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirActionPerformed(evt);
            }
        });

        atualizar.setText("ATUALIZAR CLIENTE");
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(campocpf)
                    .addComponent(lfant))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(limite)
                    .addComponent(cpf)
                    .addComponent(nomefantasia, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nome)))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(r1)
                        .addGap(18, 18, 18)
                        .addComponent(r2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(busc, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(Excluir)
                        .addGap(28, 28, 28)
                        .addComponent(atualizar)))
                .addGap(0, 115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscar)
                    .addComponent(busc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r2)
                    .addComponent(r1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(limite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campocpf)
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lfant)
                    .addComponent(nomefantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(Excluir)
                    .addComponent(atualizar))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(posicao>-1)
        consultaEndereco.carregacomp(0);
        consultaEndereco.setVisible(true);
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
       
       buscar();
            
        
        
    }//GEN-LAST:event_buscarActionPerformed

    private void buscar(){
        String chave = busc.getText().trim();
        
        boolean cond = true;
        
        if(tipo==1){
            PessoaFisica pf = clienteDAO.ClienteFisico(chave); 
            consultaEndereco.setEndereco(pf.getEndereco());
            if(pf==null){
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            }else{
                nome.setText(pf.getNome());
                limite.setText(String.valueOf(pf.getLimiteDeCredito()));
                cpf.setText(pf.getCpf());
                nomefantasia.setText("");
                id = pf.getId();
            }
        }else if(tipo==2){
            PessoaJuridica pj = clienteDAO.ClienteJuridico(chave); 
            consultaEndereco.setEndereco(pj.getEndereco());
            if(pj==null){
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            }else{
                nome.setText(pj.getNome());
                limite.setText(String.valueOf(pj.getLimiteDeCredito()));
                cpf.setText(pj.getCnpj());
                nomefantasia.setText(pj.getNomeFantasia());
                id = pj.getId();
            }
        }
    }
    private void r1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1ActionPerformed
        if(r1.isSelected()){
            busc.setText("CPF");
            campocpf.setText("CPF");
            tipo = 1;
        }else if(r2.isSelected()){
            
            busc.setText("CNPJ");
            campocpf.setText("CNPJ");
            tipo = 2;
        }
        
        
    }//GEN-LAST:event_r1ActionPerformed

    private void r2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2ActionPerformed
        if(r1.isSelected()){
            busc.setText("CPF");
            campocpf.setText("CPF");
            tipo = 1;
        }else if(r2.isSelected()){
            
            busc.setText("CNPJ");
            campocpf.setText("CNPJ");
            tipo = 2;
        }
    }//GEN-LAST:event_r2ActionPerformed

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
        //String cnpj = busc.getText().trim();
        int j = JOptionPane.showConfirmDialog(null, "1Confirma Exclusão?");
                if(j==0){
                int chave = 0;
                    if(tipo==2){
                        clienteDAO.excluirCli(id);
                        limpacomponentes();
                    }
                    else{
                        clienteDAO.excluirCli(id);
                        limpacomponentes();
                    }
                    JOptionPane.showMessageDialog(null, "Cliente Excluido!");
                }
    }//GEN-LAST:event_ExcluirActionPerformed

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        
        String chave = busc.getText().trim();
        int j = JOptionPane.showConfirmDialog(null, "2Confirma Alterações?");
                if(j==0){
                
                    if(r2.isSelected()){
                        
                        
                        PessoaJuridica pj = clienteDAO.ClienteJuridico(chave);
                        pj.setIdJuridica(id);
                        pj.setNome(nome.getText().trim());
                        pj.setTipo(tipo);
                        pj.setLimiteDeCredito(Double.parseDouble(limite.getText().trim()));
                        pj.setCnpj(cpf.getText().trim());
                        pj.setNomeFantasia(nomefantasia.getText().trim());
                        
                        
                        clienteDAO.alterarJur(pj);  
                        limpacomponentes();
                        
                    }
                    else{
                        PessoaFisica pf = clienteDAO.ClienteFisico(chave);
                        pf.setNome(nome.getText().trim());
                        pf.setTipo(tipo);
                        pf.setLimiteDeCredito(Double.parseDouble(limite.getText().trim()));
                        pf.setCpf(cpf.getText().trim());
                        
                        clienteDAO.alterarFis(pf);
                        limpacomponentes();
                    }
                    JOptionPane.showMessageDialog(null, "Cliente Alterado!");
                }
 
    }//GEN-LAST:event_atualizarActionPerformed

    private void buscMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscMouseClicked
        busc.setText("");
        limpacomponentes();
        
    }//GEN-LAST:event_buscMouseClicked

    private void CarregarComponentes(int i){
        Cliente c = cliente.get(i);
        consultaEndereco.setEndereco(c.getEndereco());
        
        if(c instanceof PessoaFisica){
            
            PessoaFisica pf = (PessoaFisica)c;
            nome.setText(pf.getNome());
            limite.setText(String.valueOf(pf.getLimiteDeCredito()));
            cpf.setText(pf.getCpf());
            nomefantasia.setText("");
        }else{
            PessoaJuridica pj = (PessoaJuridica)c;
            
            nome.setText(pj.getNome());
            limite.setText(String.valueOf(pj.getLimiteDeCredito()));
            cpf.setText(pj.getCnpj());
            nomefantasia.setText(pj.getNomeFantasia());
        }
        
    }
    
    private void limpacomponentes(){
            nome.setText("");
            limite.setText("");
            cpf.setText("");
            nomefantasia.setText("");
            //cliente=clienteDAO.buscarClientes();
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
            java.util.logging.Logger.getLogger(ConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Excluir;
    private javax.swing.JButton atualizar;
    private javax.swing.JTextField busc;
    private javax.swing.JButton buscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel campocpf;
    private javax.swing.JTextField cpf;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lfant;
    private javax.swing.JTextField limite;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField nomefantasia;
    private javax.swing.JRadioButton r1;
    private javax.swing.JRadioButton r2;
    // End of variables declaration//GEN-END:variables
}
