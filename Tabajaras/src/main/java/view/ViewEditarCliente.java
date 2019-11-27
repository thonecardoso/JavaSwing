package view;

import controller.GerenciadorCliente;
import dao.DAOCliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.*;


public class ViewEditarCliente extends javax.swing.JFrame {

    Cliente cliente;
    DAOCliente clienteDAO;
    GerenciadorCliente gerenciadorCliente;
    
    ConsultarEndereco consultaEndereco;
    int tipo=0;
    int id = 0;
    public ViewEditarCliente(Cliente cli) {
        initComponents();
        gerenciadorCliente = new GerenciadorCliente();
        consultaEndereco = new ConsultarEndereco();
        clienteDAO = new DAOCliente();
        
        cliente = cli;
        CarregarComponentes();
        
        
        
        
       
        
        
        
       
        
        
        
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
                        .addGap(52, 52, 52)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(Excluir)
                        .addGap(28, 28, 28)
                        .addComponent(atualizar)))
                .addGap(0, 138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
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
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        ViewConsultarEndereco vce = new ViewConsultarEndereco(cliente);
        vce.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        vce.setVisible(true);
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    
    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
        
        int j = JOptionPane.showConfirmDialog(null, "Confirma Exclusão?");
                if(j==0){
                
                    if(tipo==2){
                        clienteDAO.excluirCli(id);
                        
                    }
                    else{
                        clienteDAO.excluirCli(id);
                        
                    }
                    JOptionPane.showMessageDialog(null, "Cliente Excluido!");
                    this.dispose();
                }
    }//GEN-LAST:event_ExcluirActionPerformed

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        
        
        int j = JOptionPane.showConfirmDialog(null, "Confirma Alterações?");
                if(j==0){
                
                    if(cliente.getTipo()==2){
                        
                        
                        PessoaJuridica pj = (PessoaJuridica) cliente;
                        
                        pj.setNome(nome.getText().trim());
                        pj.setTipo(tipo);
                        pj.setLimiteDeCredito(Double.parseDouble(limite.getText().trim()));
                        pj.setCnpj(cpf.getText().trim());
                        pj.setNomeFantasia(nomefantasia.getText().trim());
                        
                        
                        clienteDAO.alterarJur(pj);  
                        
                        
                    }
                    else{
                        PessoaFisica pf = (PessoaFisica) cliente;
                        pf.setNome(nome.getText().trim());
                        pf.setTipo(tipo);
                        pf.setLimiteDeCredito(Double.parseDouble(limite.getText().trim()));
                        pf.setCpf(cpf.getText().trim());
                        
                        clienteDAO.alterarFis(pf);
                        
                    }
                    JOptionPane.showMessageDialog(null, "Cliente Alterado!");
                    this.dispose();
                }
 
    }//GEN-LAST:event_atualizarActionPerformed

    private void CarregarComponentes(){
        Cliente c = cliente;
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
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Excluir;
    private javax.swing.JButton atualizar;
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
    // End of variables declaration//GEN-END:variables
}
