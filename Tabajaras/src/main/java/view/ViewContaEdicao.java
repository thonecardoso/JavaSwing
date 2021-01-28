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
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nconta = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        nome = new javax.swing.JLabel();
        limite = new javax.swing.JLabel();
        limite1 = new javax.swing.JLabel();
        venc = new javax.swing.JLabel();
        valor = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        combo = new javax.swing.JComboBox<>();
        cpf = new javax.swing.JTextField();
        AlterarCliente = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        adata = new javax.swing.JTextField();
        AlterarVencimento = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        BTDetalharCompra = new javax.swing.JButton();
        ExcluirCompra = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        ExcluirConta = new javax.swing.JButton();
        Refresh = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();

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

        jLabel9.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel9.setText("COMPRAS");

        jLabel10.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel10.setText("RESUMO CONTA:");

        nconta.setFont(new java.awt.Font("DejaVu Math TeX Gyre", 1, 24)); // NOI18N
        nconta.setText("nconta");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        nome.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        nome.setText("cliente");

        limite.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        limite.setText("Valor");

        limite1.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        limite1.setText("Valor");

        venc.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        venc.setText("Valor");

        valor.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        valor.setText("Valor");

        jLabel7.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel7.setText("Nome Cliente:");

        jLabel8.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel8.setText("Limite de Crédito:");

        jLabel11.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel11.setText("Crédito Disponível:");

        jLabel6.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel6.setText("Vencimento:");

        jLabel4.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel4.setText("Total Conta:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valor)
                    .addComponent(venc)
                    .addComponent(limite1)
                    .addComponent(limite)
                    .addComponent(nome))
                .addContainerGap(252, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limite)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limite1)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(venc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AlterarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AlterarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        adata.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        adata.setText("dd/MM/yyyy");
        adata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adataMouseClicked(evt);
            }
        });

        AlterarVencimento.setText("Alterar Vencimento");
        AlterarVencimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarVencimentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AlterarVencimento, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(adata))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adata, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AlterarVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        BTDetalharCompra.setText("Detalhar Compra");
        BTDetalharCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTDetalharCompraActionPerformed(evt);
            }
        });

        ExcluirCompra.setText("Excluir Compra");
        ExcluirCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(BTDetalharCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addComponent(ExcluirCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTDetalharCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExcluirCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        ExcluirConta.setText("Excluir Conta");
        ExcluirConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirContaActionPerformed(evt);
            }
        });

        Refresh.setText("Refresh");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ExcluirConta, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(Refresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ExcluirConta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(340, 340, 340)
                                .addComponent(nconta)))
                        .addGap(10, 10, 10)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(240, 240, 240)
                                .addComponent(jLabel9))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(nconta))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

    private void ExcluirContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirContaActionPerformed
       int x = JOptionPane.showConfirmDialog(null, "Confirma a Exclusão da Conta?");
       if(x==0){
           DAOConta.ExcluirConta(conta);
           this.dispose();
       }
           
    }//GEN-LAST:event_ExcluirContaActionPerformed

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RefreshActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AlterarCliente;
    private javax.swing.JButton AlterarVencimento;
    private javax.swing.JButton BTDetalharCompra;
    private javax.swing.JButton ExcluirCompra;
    private javax.swing.JButton ExcluirConta;
    private javax.swing.JButton Refresh;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
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
