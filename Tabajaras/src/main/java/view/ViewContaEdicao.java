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
        ExcluirCompra = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        limite1 = new javax.swing.JLabel();
        BTDetalharCompra = new javax.swing.JButton();
        combo = new javax.swing.JComboBox<>();
        cpf = new javax.swing.JTextField();
        AlterarCliente = new javax.swing.JButton();
        adata = new javax.swing.JTextField();
        nconta = new javax.swing.JLabel();
        ExcluirConta = new javax.swing.JButton();

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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 289, 531, 300));

        jLabel4.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel4.setText("Total Conta:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 35));

        valor.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        valor.setText("Valor");
        getContentPane().add(valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, 35));

        nome.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        nome.setText("cliente");
        getContentPane().add(nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

        limite.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        limite.setText("Valor");
        getContentPane().add(limite, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, -1, -1));

        jLabel6.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel6.setText("Vencimento:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, 35));

        venc.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        venc.setText("Valor");
        getContentPane().add(venc, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, -1, 35));

        jLabel7.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel7.setText("Nome Cliente:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 35));

        jLabel8.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel8.setText("Limite de Crédito:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 35));

        jLabel9.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel9.setText("COMPRAS");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, 35));

        jLabel10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel10.setText("RESUMO CONTA:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 12, -1, 35));

        AlterarVencimento.setText("Alterar Vencimento");
        AlterarVencimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarVencimentoActionPerformed(evt);
            }
        });
        getContentPane().add(AlterarVencimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 480, 155, -1));

        ExcluirCompra.setText("Excluir Compra");
        ExcluirCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirCompraActionPerformed(evt);
            }
        });
        getContentPane().add(ExcluirCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 560, 163, -1));

        jLabel11.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel11.setText("Crédito Disponível:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 35));

        limite1.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        limite1.setText("Valor");
        getContentPane().add(limite1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, -1, -1));

        BTDetalharCompra.setText("Detalhar Compra");
        BTDetalharCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTDetalharCompraActionPerformed(evt);
            }
        });
        getContentPane().add(BTDetalharCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 520, 163, -1));

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pessoa Física", "Pessoa Juridica" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });
        getContentPane().add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, -1, -1));

        cpf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cpf.setText("CPF");
        cpf.setPreferredSize(new java.awt.Dimension(140, 37));
        cpf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cpfMouseClicked(evt);
            }
        });
        getContentPane().add(cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 155, -1));

        AlterarCliente.setText("Alterar Cliente");
        AlterarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(AlterarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, 155, 45));

        adata.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        adata.setText("dd/MM/yyyy");
        adata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adataMouseClicked(evt);
            }
        });
        getContentPane().add(adata, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, 160, -1));

        nconta.setFont(new java.awt.Font("DejaVu Math TeX Gyre", 1, 24)); // NOI18N
        nconta.setText("nconta");
        getContentPane().add(nconta, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, -1));

        ExcluirConta.setText("Excluir Conta");
        ExcluirConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirContaActionPerformed(evt);
            }
        });
        getContentPane().add(ExcluirConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 150, 40));

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

    private void ExcluirContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirContaActionPerformed
       int x = JOptionPane.showConfirmDialog(null, "Confirma a Exclusão da Conta?");
       if(x==0){
           DAOConta.ExcluirConta(conta);
           this.dispose();
       }
           
    }//GEN-LAST:event_ExcluirContaActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AlterarCliente;
    private javax.swing.JButton AlterarVencimento;
    private javax.swing.JButton BTDetalharCompra;
    private javax.swing.JButton ExcluirCompra;
    private javax.swing.JButton ExcluirConta;
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
