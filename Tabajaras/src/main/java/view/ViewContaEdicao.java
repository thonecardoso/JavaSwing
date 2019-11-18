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

public class ViewContaEdicao extends javax.swing.JFrame {
    
     
    private DAOConta DAOConta = new DAOConta(); 
    private DAOCompra DAOCompra = new DAOCompra();
    private DAOCliente dc = new DAOCliente();
    private DAOProduto dp = new DAOProduto();
    
    private Locale locale = new Locale("pt", "BR");
    private NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
    
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private DefaultTableModel modelo = null;
    
    Cliente cli;
    Conta conta;
    ViewCompra vc;
    int posicao=0;
    int tipo = 1;
    double total = -1;
    private LocalDate data = null;
    private int idcompra;
    private ArrayList<Compra> compra;
        
    

    public ViewContaEdicao(ArrayList<Conta> arraycont) {
        initComponents();
        Conta c = arraycont.get(0);
        
        conta = c;
        compra = c.getCompras();
        
        setCompras();
        setCliente(c.getCli());
        setVencimento(conta.getDataVencimento());
        nconta.setText(String.valueOf(conta.getId()));
        
        
        
        
    }
    
    public void setCliente(Cliente cli){
        
        nome.setText(cli.getNome());        
        limite.setText(String.valueOf(cli.getLimiteDeCredito()));
        
    }
    
    public void setVencimento(LocalDate l){
        venc.setText(l.format(format));
    }
    
    public void setCompras(){
        
       int numeroitem = 1;
       
       modelo = new DefaultTableModel();
               
       modelo.addColumn("Nº");
       modelo.addColumn("COD COMPRA");
       modelo.addColumn("QT ITÉNS");
       modelo.addColumn("DATA");
       modelo.addColumn("TOTAL");
       total = 0;
       
       for(Compra comp: compra){
           
           total  = total + comp.getTotal();
            modelo.addRow(new Object[]{String.valueOf(numeroitem++),
                    String.valueOf(comp.getCodCompra()),
                    String.valueOf(comp.getProd().size()),
                    comp.getData().format(format),
                    nf.format(comp.getTotal())});
           
       }
       table.setModel(modelo);
       
       valor.setText(nf.format(total));
       limite1.setText(nf.format(conta.getCli().getLimiteDeCredito()-total));
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        valor = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        limite = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        venc = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        AlterarVencimento = new javax.swing.JButton();
        AlterarCompra = new javax.swing.JButton();
        ExcluirCompra = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        limite1 = new javax.swing.JLabel();
        BTDetalharCompra = new javax.swing.JButton();
        combo = new javax.swing.JComboBox<>();
        cpf = new javax.swing.JTextField();
        AlterarCliente = new javax.swing.JButton();
        adata = new javax.swing.JTextField();
        nconta = new javax.swing.JLabel();

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel.getContentPane());
        panel.getContentPane().setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table);

        jLabel4.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel4.setText("Total Conta:");

        valor.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        valor.setText("Valor");

        nome.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        nome.setText("cliente");

        limite.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        limite.setText("Valor");

        jLabel6.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel6.setText("Vencimento:");

        venc.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        venc.setText("Valor");

        jLabel7.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel7.setText("Nome Cliente:");

        jLabel8.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel8.setText("Limite de Crédito:");

        jLabel9.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel9.setText("COMPRAS");

        jLabel10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel10.setText("RESUMO CONTA:");

        AlterarVencimento.setText("Alterar Vencimento");
        AlterarVencimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarVencimentoActionPerformed(evt);
            }
        });

        AlterarCompra.setText("Alterar Compra");
        AlterarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarCompraActionPerformed(evt);
            }
        });

        ExcluirCompra.setText("Excluir Compra");
        ExcluirCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirCompraActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel11.setText("Crédito Disponível:");

        limite1.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        limite1.setText("Valor");

        BTDetalharCompra.setText("Detalhar Compra");
        BTDetalharCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTDetalharCompraActionPerformed(evt);
            }
        });

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pessoa Física", "Pessoa Juridica" }));
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

        AlterarCliente.setText("Alterar Cliente");
        AlterarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarClienteActionPerformed(evt);
            }
        });

        adata.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        adata.setText("dd/MM/yyyy");
        adata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adataMouseClicked(evt);
            }
        });

        nconta.setFont(new java.awt.Font("DejaVu Math TeX Gyre", 1, 24)); // NOI18N
        nconta.setText("nconta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel11)
                .addGap(10, 10, 10)
                .addComponent(limite1)
                .addGap(268, 268, 268)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AlterarVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(adata)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nconta))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(nome))
                            .addComponent(limite))
                        .addGap(324, 324, 324)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AlterarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel6)
                        .addGap(76, 76, 76)
                        .addComponent(venc))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4)
                        .addGap(76, 76, 76)
                        .addComponent(valor))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BTDetalharCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ExcluirCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AlterarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nconta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(nome)
                        .addGap(16, 16, 16)
                        .addComponent(limite))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(AlterarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(limite1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(adata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AlterarVencimento)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(venc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(BTDetalharCompra)
                        .addGap(6, 6, 6)
                        .addComponent(ExcluirCompra)
                        .addGap(6, 6, 6)
                        .addComponent(AlterarCompra))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTDetalharCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTDetalharCompraActionPerformed
        Compra c = compra.get(table.getSelectedRow());
        ViewDetalheCompra vdc = new ViewDetalheCompra(c);
        vdc.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        vdc.setVisible(true);
    }//GEN-LAST:event_BTDetalharCompraActionPerformed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        if(combo.getSelectedIndex()==0){

            cpf.setText("CPF");
           

        }else if(combo.getSelectedIndex()==1){
            
            cpf.setText("CNPJ");
        }
    }//GEN-LAST:event_comboActionPerformed

    private void cpfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cpfMouseClicked
        cpf.setText("");
    }//GEN-LAST:event_cpfMouseClicked

    private void AlterarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarClienteActionPerformed
        String chave = cpf.getText().trim();

        if(combo.getSelectedIndex()==0){

            boolean cond = true;

            PessoaFisica pf = dc.ClienteFisico(chave);

            if(pf==null){
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            }else{
                
                int x = JOptionPane.showConfirmDialog(null, 
                        "Confirma Alteração do Cliente Atual para\n" +
                        "Cliente: " + pf.getNome() + 
                        "\nLimite: " + nf.format(pf.getLimiteDeCredito()));
                if(x==0){
                    setCliente(pf);
                    conta.setCli(pf);
                    DAOConta.AlterarCliente(conta);
                    JOptionPane.showMessageDialog(null, "Cliente Alterado com Sucesso!");
                }

            }
            cpf.setText("CPF");

        }else if(combo.getSelectedIndex()==1){
            PessoaJuridica pj = dc.ClienteJuridico(chave);

            if(pj==null){
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            }else{

                 int x = JOptionPane.showConfirmDialog(null, 
                        "Confirma Alteração do Cliente Atual para\n" +
                        "Cliente: " + pj.getNome() + 
                        "\nLimite: " + nf.format(pj.getLimiteDeCredito()));
                if(x==0){
                    setCliente(pj);
                    conta.setCli(pj);
                    DAOConta.AlterarCliente(conta);
                    JOptionPane.showMessageDialog(null, "Cliente Alterado com Sucesso!");
                }                

            }
            cpf.setText("CNPJ");
        }
    }//GEN-LAST:event_AlterarClienteActionPerformed

    private void adataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adataMouseClicked
        adata.setText("");
    }//GEN-LAST:event_adataMouseClicked

    private void AlterarVencimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarVencimentoActionPerformed
        LocalDate ld = null;
        boolean verificacao = false;
        try {
            ld = LocalDate.parse(adata.getText().trim(), format);
            verificacao = true;
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato de data Inválido\n" + e.getMessage());
        }
        
        if(verificacao){
            if(ld.isBefore(LocalDate.now())){
                JOptionPane.showMessageDialog(null, "Deve informar uma Data Furuta!");
            }else{
                int x = JOptionPane.showConfirmDialog(null, "Confirma a Alteração do Vencimento\n"
                        + "de " + conta.getDataVencimento().format(format) + 
                        "\npara " + ld.format(format));
                if(x==0){
                    conta.setDataVencimento(ld);
                    DAOConta.AlterarVencimento(conta);
                    setVencimento(ld);
                }
            }
        }
                
        adata.setText("dd/MM/yyyy");
        
        
    }//GEN-LAST:event_AlterarVencimentoActionPerformed

    private void ExcluirCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirCompraActionPerformed
        
        int row = table.getSelectedRow();
        if(row != -1){
            String cod = modelo.getValueAt(row, 1).toString();
            int codigo = -1;
            try {
                codigo = Integer.parseInt(cod);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao converter srt to int\n" + e.getMessage());
            }
                
            int x = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do Itém: " + cod);
            if(x==0){
                
                DAOCompra.excluirCompra(codigo);
                
                compra = DAOCompra.relatorioCompra(conta.getId());
                setCompras();
                
                
                JOptionPane.showMessageDialog(null, "Compra " + cod +" Excluída com Sucesso");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma compra na tabela");
        }
    }//GEN-LAST:event_ExcluirCompraActionPerformed

    private void AlterarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AlterarCompraActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AlterarCliente;
    private javax.swing.JButton AlterarCompra;
    private javax.swing.JButton AlterarVencimento;
    private javax.swing.JButton BTDetalharCompra;
    private javax.swing.JButton ExcluirCompra;
    private javax.swing.JTextField adata;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JTextField cpf;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel limite;
    private javax.swing.JLabel limite1;
    private javax.swing.JLabel nconta;
    private javax.swing.JLabel nome;
    private javax.swing.JFrame panel;
    private javax.swing.JTable table;
    private javax.swing.JLabel valor;
    private javax.swing.JLabel venc;
    // End of variables declaration//GEN-END:variables
}
