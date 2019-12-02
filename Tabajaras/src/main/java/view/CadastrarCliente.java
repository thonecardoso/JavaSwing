package view;



import controller.GerenciadorCliente;
import dao.DAOCliente;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.*;

public class CadastrarCliente extends javax.swing.JFrame {


    GerenciadorCliente gd;
    DAOCliente cd;
    PessoaFisica pf;
    PessoaJuridica pj;
    ArrayList<Endereco> ArrayEnd;
    boolean vcpf;
    boolean vendereco;
    int tipo;
    
    public CadastrarCliente() {
        initComponents();
        ArrayEnd = new ArrayList<>();
        pf = new PessoaFisica();
        pj = new PessoaJuridica();
//        end = new CadEndereco();
        cd = new DAOCliente ();
        gd = new GerenciadorCliente();
        vcpf = false;
        vendereco = false;
        
        
        if(radf.isSelected()){
            lcpf.setText("CPF");
            nomefantasia.setVisible(false);
            lfant.setVisible(false);
            tipo =1;
        }else if(radj.isSelected()){                
            lcpf.setText("CNPJ");
            tipo =2;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lcpf = new javax.swing.JLabel();
        lfant = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        limite = new javax.swing.JTextField();
        cpf = new javax.swing.JTextField();
        nomefantasia = new javax.swing.JTextField();
        radf = new javax.swing.JRadioButton();
        radj = new javax.swing.JRadioButton();
        btncadastrar = new javax.swing.JButton();
        validacpf = new javax.swing.JButton();
        valido = new javax.swing.JLabel();
        lfant1 = new javax.swing.JLabel();
        cend = new javax.swing.JButton();
        lend = new javax.swing.JLabel();
        btnend = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel1.setText("Cadastrar Cliente");

        jLabel2.setText("Nome:");

        jLabel3.setText("Limite de Crédito:");

        lcpf.setText("CPF/CNPJ");

        lfant.setText("Nome Fantasia:");

        buttonGroup1.add(radf);
        radf.setSelected(true);
        radf.setText("Pessoa Física");
        radf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radfActionPerformed(evt);
            }
        });

        buttonGroup1.add(radj);
        radj.setText("Pessoa Juridica");
        radj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radjActionPerformed(evt);
            }
        });

        btncadastrar.setText("Cadastrar");
        btncadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncadastrarActionPerformed(evt);
            }
        });

        validacpf.setText("Validar");
        validacpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validacpfActionPerformed(evt);
            }
        });

        valido.setText("Cpf: Inválido");

        lfant1.setText("Endereço:");

        cend.setText("Cadastrar Endereço");
        cend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cendActionPerformed(evt);
            }
        });

        lend.setText("null");

        btnend.setText("Verificar Endereço");
        btnend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radj))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cend))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(lcpf)
                            .addComponent(lfant))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(validacpf)
                                .addGap(18, 18, 18)
                                .addComponent(valido, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(nome, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                                .addComponent(limite))
                            .addComponent(nomefantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnend)
                                .addGap(46, 46, 46)
                                .addComponent(btncadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lfant1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lend)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radf)
                    .addComponent(radj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(limite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lcpf)
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(validacpf)
                    .addComponent(valido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lfant)
                    .addComponent(nomefantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lfant1)
                    .addComponent(lend))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cend)
                    .addComponent(btnend)
                    .addComponent(btncadastrar))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radfActionPerformed
        if(radf.isSelected()){
            nomefantasia.setVisible(false);
            lfant.setVisible(false);
            lcpf.setText("CPF");
            tipo =1;
        }else if(radj.isSelected()){
            nomefantasia.setVisible(true);
            lfant.setVisible(true);
            lcpf.setText("CNPJ");
            tipo =2;
        }
    }//GEN-LAST:event_radfActionPerformed

    
    private void radjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radjActionPerformed
        if(radf.isSelected()){
            nomefantasia.setVisible(false);
            lfant.setVisible(false);
            lcpf.setText("CPF");
            tipo =1;
        }else if(radj.isSelected()){
            nomefantasia.setVisible(true);
            lfant.setVisible(true);
            lcpf.setText("CNPJ");
            tipo =2;
        }
    }//GEN-LAST:event_radjActionPerformed

    private void btncadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadastrarActionPerformed
        validarcpf();
        verificarendereco();
        if(!vcpf){
            JOptionPane.showMessageDialog(null, "Verifique o cpf");
        }
        if(!vendereco){
            JOptionPane.showMessageDialog(null, "Verifique o Endereço");
        }
        
        if(vcpf && vendereco){
            
            if(tipo==1){
                pf.setEndereco(ArrayEnd);
                pf.setNome(nome.getText().trim());
                pf.setTipo(tipo);
                pf.setLimiteDeCredito(Double.parseDouble(limite.getText().trim()));
                pf.setCpf(cpf.getText().trim());
                
               cd.cadastroClienteFisica(pf);
               
               pf = null;

           }else if(tipo == 2){
                pj.setEndereco(ArrayEnd);
                pj.setNome(nome.getText().trim());
                pj.setTipo(tipo);
                pj.setLimiteDeCredito(Double.parseDouble(limite.getText().trim()));
                pj.setCnpj(cpf.getText().trim());
                pj.setNomeFantasia(nomefantasia.getText().trim());
                
                cd.cadastroClienteJuridica(pj);
                
                pj = null;
                
           }
            JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso!");
            limpacomponentes();
        }
    }//GEN-LAST:event_btncadastrarActionPerformed

    private void validacpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validacpfActionPerformed
        validarcpf();				
	
    }//GEN-LAST:event_validacpfActionPerformed

    private void validarcpf(){
        if(radf.isSelected()){
            int test = cd.validarCPF(cpf.getText().trim());
            if( test != -1) {

                    valido.setText("CPF: INVALIDO!");

            }else{
                vcpf = true;        
                valido.setText("CPF: VALIDO!");
            }            
        }else if(radj.isSelected()){
            int test = cd.validarCNPJ(cpf.getText().trim());
            if( test != -1) {

                    valido.setText("CNPJ: INVALIDO!");

            }else{
                vcpf = true;        
                valido.setText("CNPJ: VALIDO!");
            }
        }
    }
    
    
    private void cendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cendActionPerformed
//        end.setArrayEnd(ArrayEnd);
        CadEndereco ce = new CadEndereco(ArrayEnd);
        ce.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ce.setVisible(true);
        
    }//GEN-LAST:event_cendActionPerformed

    private void verificarendereco(){
        if(ArrayEnd.size()>0){
            vendereco = true;
            lend.setText("OK " + String.valueOf(ArrayEnd.size()) + " Endereços Cadastrados");
        }else{
            lend.setText("Cadastre pelo menos 1 Endereço");
        }
    }
    
    private void btnendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnendActionPerformed
        
        if(ArrayEnd.size()>0){
            vendereco = true;
            lend.setText("OK " + String.valueOf(ArrayEnd.size()) + " Endereços Cadastrados");
        }else{
            lend.setText("Cadastre pelo menos 1 Endereço");
        }
    }//GEN-LAST:event_btnendActionPerformed

    private void limpacomponentes(){
        limite.setText("");
        nome.setText("");
        nomefantasia.setText("");
        cpf.setText("");
    } 
    
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncadastrar;
    private javax.swing.JButton btnend;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cend;
    private javax.swing.JTextField cpf;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lcpf;
    private javax.swing.JLabel lend;
    private javax.swing.JLabel lfant;
    private javax.swing.JLabel lfant1;
    private javax.swing.JTextField limite;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField nomefantasia;
    private javax.swing.JRadioButton radf;
    private javax.swing.JRadioButton radj;
    private javax.swing.JButton validacpf;
    private javax.swing.JLabel valido;
    // End of variables declaration//GEN-END:variables
}
