package view;

import controller.GerenciadorProduto;
import dao.DAOCompra;
import java.text.*;
import java.time.LocalDate;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Compra;
import model.Conta;
import model.Produto;

public class ViewCompra extends javax.swing.JFrame {

    
    private ArrayList<Produto> produtos = new ArrayList<>();
    private ArrayList<Compra>  compra;
    private GerenciadorProduto genproduto = new GerenciadorProduto();
    DefaultTableModel modelo = new DefaultTableModel();
    private double total = 0;
    private double limitedisponivel = 0;
    int quantidade = 0;
    Compra con;
    Locale locale = new Locale("pt", "BR");
    NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
    private Conta cont;
    DAOCompra daocompra = new DAOCompra();
     
    public ViewCompra(Conta conta) {
        initComponents();
        cont = conta;
        this.compra = cont.getCompras();
        con = new Compra();
        if(compra.size()==0){
            con.setCodCompra(1);
        }else{
            con.setCodCompra(compra.get(compra.size()-1).getCodCompra()+1);
        }
        limitedisponivel = cont.getCli().getLimiteDeCredito();
        
        limitecli.setText(nf.format(cont.getCli().getLimiteDeCredito()));
        nomecli.setText(cont.getCli().getNome());
        
        totalcompra.setText(nf.format(total));
        saldodisp.setText(nf.format(limitedisponivel));
        
        
        
        modelo.addColumn("Nº");
        modelo.addColumn("COD");
        modelo.addColumn("ITEM");
        modelo.addColumn("PRECO");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        totalcompra = new javax.swing.JLabel();
        add = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        JCodigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        CancelarItem = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        limitecli = new javax.swing.JLabel();
        nomecli = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        saldodisp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel4.setText("Cliente:");

        totalcompra.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        totalcompra.setText("Valor");

        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jLabel1.setText("Código Produto:");

        JCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JCodigoMouseClicked(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nº", "Itém", "Preço"
            }
        ));
        jScrollPane1.setViewportView(table);

        jButton1.setText("Finalizar Compra");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        CancelarItem.setText("Cancelar Itém");
        CancelarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarItemActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel5.setText("Total:");

        jLabel6.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel6.setText("Limite de Credito:");

        limitecli.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        limitecli.setText("Cliente:");

        nomecli.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        nomecli.setText("Cliente:");

        jLabel7.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel7.setText("Saldo Disponível:");

        saldodisp.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        saldodisp.setText("Valor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(add))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(43, 43, 43)
                                        .addComponent(CancelarItem)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel5)))
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalcompra)
                                    .addComponent(saldodisp)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel4))
                                    .addGap(39, 39, 39)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nomecli)
                                        .addComponent(limitecli)))))))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(nomecli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(limitecli)))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(totalcompra))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jButton1)
                    .addComponent(CancelarItem)
                    .addComponent(saldodisp))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        Produto p = genproduto.buscarProduto(JCodigo.getText());
        if(p==null){
            JOptionPane.showMessageDialog(null, "Código não cadastrado!");
        }else{
            
            if(limitedisponivel>p.getPreco()){
                
                quantidade++;

                modelo.addRow(new Object[]{String.valueOf(quantidade),
                    p.getCodigoDeBarras(),
                    p.getNome(),
                    nf.format(p.getPreco())});

                table.setModel(modelo);

                total = total + p.getPreco();
                limitedisponivel -= p.getPreco();
                totalcompra.setText(nf.format(total));
                saldodisp.setText(nf.format(limitedisponivel));

                con.getProd().add(p);

            }else{
                JOptionPane.showMessageDialog(null, "Sem limite para add Itém!");
            }
            JCodigo.setText("");
                
            }
            
    }//GEN-LAST:event_addActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        con.setTotal(total);
        con.setData(LocalDate.now());        
        compra.add(con);
        cont.getCli().setLimiteDeCredito(limitedisponivel);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CancelarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarItemActionPerformed
        
        boolean pro = true;
        Iterator<Produto> it = con.getProd().iterator();
        while(it.hasNext() && pro){
            Produto i = it.next();
            if(JCodigo.getText().equals(i.getCodigoDeBarras())){
                pro=false;
                
                int x=JOptionPane.showConfirmDialog(null, "3confirma cancelamento itém?");
                if(x==0){
                    quantidade++;
                    i.setPreco(i.getPreco()*-1);

                    modelo.addRow(new Object[]{String.valueOf(quantidade),
                        i.getCodigoDeBarras(),
                        i.getNome(),
                        nf.format(i.getPreco())});

                    table.setModel(modelo);

                    total = total + i.getPreco();
                    limitedisponivel -= i.getPreco();
                    totalcompra.setText(nf.format(total));
                    saldodisp.setText(nf.format(limitedisponivel));

                    it.remove();
                    JOptionPane.showMessageDialog(null, "Produto Excluido com Sucesso!");
                }
            }
            
        }
        if(!pro){
            JOptionPane.showMessageDialog(null, "Código não encontrado!");
        }
    }//GEN-LAST:event_CancelarItemActionPerformed

    private void JCodigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JCodigoMouseClicked
        //JCodigo.setText("");
        
    }//GEN-LAST:event_JCodigoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelarItem;
    private javax.swing.JTextField JCodigo;
    private javax.swing.JToggleButton add;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel limitecli;
    private javax.swing.JLabel nomecli;
    private javax.swing.JLabel saldodisp;
    private javax.swing.JTable table;
    private javax.swing.JLabel totalcompra;
    // End of variables declaration//GEN-END:variables
}
