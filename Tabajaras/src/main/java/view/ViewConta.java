package view;

import dao.DAOCliente;
import dao.DAOCompra;
import dao.DAOConta;
import dao.DAOProduto;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Compra;
import model.Conta;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Produto;

public class ViewConta extends javax.swing.JFrame {
    
    private ArrayList<Produto> produtos;
    private ArrayList<Compra> compras;
    private ArrayList<Cliente> cliente;
    private DAOConta DAOConta = new DAOConta(); 
    private DAOCompra DAOCompra = new DAOCompra();
    
    
    
    DAOCliente dc = new DAOCliente();
    DAOProduto dp = new DAOProduto();
    Locale locale = new Locale("pt", "BR");
    NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
    Cliente cli;
    Conta conta;
    ViewCompra vc;
    int posicao=0;
    int tipo = 1;
    double total = -1;
    private DateTimeFormatter format;
    private LocalDate data = null;
    private int idcompra;
        
    

    public ViewConta(Conta c) {
        initComponents();
        this.cliente = dc.ArrayClientes();
        this.produtos = dp.relatorioProduto();
        format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        idcompra = DAOCompra.getId()+1;
        
        conta = c;
        
        data = LocalDate.now().plus(Period.ofDays(30));
        conta.setDataVencimento(data);
        venc.setText(data.format(format));
        
        
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnCompra = new javax.swing.JButton();
        busc = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        r1 = new javax.swing.JRadioButton();
        r2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        valor = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        limite = new javax.swing.JLabel();
        Atualizar = new javax.swing.JButton();
        finalizar = new javax.swing.JButton();
        vencimento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        venc = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        setdata = new javax.swing.JToggleButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        finalizar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCompra.setText("NOVA COMPRA");
        btnCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraActionPerformed(evt);
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

        jLabel1.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel1.setText("Consultar Cliente:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel4.setText("Total Conta:");

        valor.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        valor.setText("Valor");

        nome.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        nome.setText("cliente");

        limite.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        limite.setText("Valor");

        Atualizar.setText("Atualizar Tabela");
        Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarActionPerformed(evt);
            }
        });

        finalizar.setText("FINALIZAR");
        finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarActionPerformed(evt);
            }
        });

        vencimento.setText("dd/MM/yyyy");

        jLabel5.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jLabel5.setText("Para outro vencimento diferente do padrão de 30 dias");

        jLabel6.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel6.setText("Vencimento:");

        venc.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        venc.setText("Valor");

        jLabel7.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel7.setText("Nome Cliente:");

        jLabel8.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel8.setText("Crédito:");

        setdata.setText("SET");
        setdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setdataActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel9.setText("RESUMO COMPRAS");

        jLabel10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel10.setText("RESUMO CONTA");

        finalizar1.setText("CANCELAR");
        finalizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(31, 31, 31)
                                .addComponent(r1)
                                .addGap(18, 18, 18)
                                .addComponent(r2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(busc, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Atualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(setdata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(finalizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(56, 56, 56)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel8)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel7))
                                            .addGap(51, 51, 51)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(nome)
                                                .addComponent(limite)
                                                .addComponent(venc)
                                                .addComponent(valor)))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(finalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jLabel10)))
                .addGap(0, 358, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar)
                    .addComponent(busc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r2)
                    .addComponent(r1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setdata))
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nome))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limite))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(venc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(finalizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraActionPerformed
        if(cli==null){
            JOptionPane.showMessageDialog(null, "Busque um Cliente Cadastrado Antes de ir as Compras!");
        }else{
            
            vc = new ViewCompra(conta);
            vc.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            vc.setVisible(true);
            
        }
        

    }//GEN-LAST:event_btnCompraActionPerformed

    private void buscMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscMouseClicked
        busc.setText("");
        nome.setText("");
        limite.setText(nf.format(0));

    }//GEN-LAST:event_buscMouseClicked

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed

        buscar();
        if(cli!=null){
            
            nome.setText(cli.getNome());
            limite.setText(nf.format(cli.getLimiteDeCredito()));
            
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void buscar(){
         String chave = busc.getText().trim();
        
        boolean cond = true;
        
        if(tipo==1){
            PessoaFisica pf = dc.ClienteFisico(chave); 
            
            if(pf==null){
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            }else{
                cli=pf;
                conta.setCli(pf);
            }
        }else if(tipo==2){
            PessoaJuridica pj = dc.ClienteJuridico(chave); 
            
            if(pj==null){
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            }else{
                cli=pj;
                conta.setCli(pj);
            }
        }
    }
    private void r1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1ActionPerformed
        if(r1.isSelected()){
            busc.setText("CPF");
            
            tipo = 1;
        }else if(r2.isSelected()){

            busc.setText("CNPJ");
            
            tipo = 2;
        }

    }//GEN-LAST:event_r1ActionPerformed

    private void r2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2ActionPerformed
        if(r1.isSelected()){
            busc.setText("CPF");
            
            tipo = 1;
        }else if(r2.isSelected()){

            busc.setText("CNPJ");
            
            tipo = 2;
        }
    }//GEN-LAST:event_r2ActionPerformed

    private void AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarActionPerformed
       int numeroitem = 1;
       DefaultTableModel modelo = new DefaultTableModel();
       
               
       modelo.addColumn("Nº");
       modelo.addColumn("COD COMPRA");
       modelo.addColumn("QT ITÉNS");
       modelo.addColumn("DATA");
       modelo.addColumn("TOTAL");
       total = 0;
       int id = idcompra++;
       for(Compra comp: conta.getCompras()){
           
           total  = total + comp.getTotal();
            modelo.addRow(new Object[]{String.valueOf(numeroitem),
                    String.valueOf(id++),
                    String.valueOf(comp.getProd().size()),
                    comp.getData().format(format),
                    nf.format(comp.getTotal())});
           
       }
       jTable1.setModel(modelo);
       
       valor.setText(nf.format(total));
       
       
    }//GEN-LAST:event_AtualizarActionPerformed

    private void setdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setdataActionPerformed
        boolean aceito = false;
        try {
            data = LocalDate.parse(vencimento.getText(),format);
            conta.setDataVencimento(data);
            aceito = true;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        if(aceito){
            
            if(data.isBefore(LocalDate.now())){
                JOptionPane.showMessageDialog(null, "Deve informar uma Data Furuta!");
            }
            venc.setText(data.format(format));
        }
    }//GEN-LAST:event_setdataActionPerformed

    private void finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarActionPerformed
        if(total>=0 &&
           conta.getCompras().size()>0 &&
           conta.getCli().getLimiteDeCredito()>total &&
           data!=null
                ){
            
            
            conta.setTotal(total);
            DAOConta.cadastroConta(conta);
            
            JOptionPane.showMessageDialog(null, "Conta Cadastrada com Sucesso!");
            JOptionPane.showMessageDialog(null, "Id conta nº --> " + DAOConta.buscarId());
            this.dispose();
        }
    }//GEN-LAST:event_finalizarActionPerformed

    private void finalizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizar1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_finalizar1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atualizar;
    private javax.swing.JButton btnCompra;
    private javax.swing.JTextField busc;
    private javax.swing.JButton buscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton finalizar;
    private javax.swing.JButton finalizar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel limite;
    private javax.swing.JLabel nome;
    private javax.swing.JRadioButton r1;
    private javax.swing.JRadioButton r2;
    private javax.swing.JToggleButton setdata;
    private javax.swing.JLabel valor;
    private javax.swing.JLabel venc;
    private javax.swing.JTextField vencimento;
    // End of variables declaration//GEN-END:variables
}
