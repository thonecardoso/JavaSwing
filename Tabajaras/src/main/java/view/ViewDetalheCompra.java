package view;

import dao.DAOItensCompra;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Compra;
import model.Produto;

public class ViewDetalheCompra extends javax.swing.JFrame {

    private DAOItensCompra it = new DAOItensCompra();
    private DefaultTableModel modelo = new DefaultTableModel();
    private double total = 0;
    private Locale locale = new Locale("pt", "BR");
    private NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
    private Compra compra;
    
    public ViewDetalheCompra(Compra comp) {
        initComponents();
        
       compra =comp;
               
       modelo.addColumn("Nº");
       modelo.addColumn("COD BARRAS");
       modelo.addColumn("ITÉM");
       modelo.addColumn("PREÇO");
       
       id.setText(String.valueOf(compra.getCodCompra()));
       setCompras(compra);
      
    }
    
    public void setCompras(Compra compra){
        int numeroitem = 1;
        total = 0;
       
       
        for(Produto prod: compra.getProd()){
           
            total= prod.getPreco() + total;
            modelo.addRow(new Object[]{
                String.valueOf(numeroitem++),
                prod.getCodigoDeBarras(),
                prod.getNome(),                
                nf.format(prod.getPreco())});
           
       }
       table.setModel(modelo);
       
       valor.setText(nf.format(total));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        excluir = new javax.swing.JButton();
        valor = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        valor2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel9.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel9.setText("COMPRAS ID:");

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

        excluir.setText("Excluir Itém");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        valor.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        valor.setText("valor");

        id.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        id.setText("valor");

        valor2.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        valor2.setText("Total Compra:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(id))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(valor2)
                        .addGap(86, 86, 86)
                        .addComponent(valor))
                    .addComponent(excluir))
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valor2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(excluir)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        int row = table.getSelectedRow();
        if(row != -1){
            String cod = modelo.getValueAt(row, 1).toString();
            int x = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do Itém: " + cod);
            if(x==0){
                //it.excluirItenCompra(compra.getCodCompra(), cod);
                
                total = total - compra.getProd().get(row).getPreco();
                
                valor.setText(nf.format(total));
                compra.getProd().remove(row);
                modelo.removeRow(row);
                
                JOptionPane.showMessageDialog(null, "Itém Excluído com Sucesso");
            }
        }
        
        
        
    }//GEN-LAST:event_excluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton excluir;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JLabel valor;
    private javax.swing.JLabel valor2;
    // End of variables declaration//GEN-END:variables
}
