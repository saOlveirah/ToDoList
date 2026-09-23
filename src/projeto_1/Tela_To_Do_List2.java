/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projeto_1;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Tela_To_Do_List2 extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Tela_To_Do_List2.class.getName());

    DefaultTableModel model;
    
    private static final String CONCLUIDA = "Concluida";
    private static final String NAO_CONCLUIDA = "Não concluida";
    
    private final ArrayList<String> tarefas = new ArrayList<>();
    private final ArrayList<String> tarefasFiltradas = new ArrayList<>();
   

    public Tela_To_Do_List2() {
        initComponents();
        
        setLocationRelativeTo(null); 
        
        model = (DefaultTableModel) jTableTarefas.getModel();
        
    }

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldDescricaoTarefa = new javax.swing.JTextField();
        jButtonAdicionarTarefa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTarefas = new javax.swing.JTable();
        jComboBoxFiltroStatus = new javax.swing.JComboBox<>();
        jButtonConcluirTarefa = new javax.swing.JButton();
        jButtonRemoverTarefa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextFieldDescricaoTarefa.addActionListener(this::jTextFieldDescricaoTarefaActionPerformed);

        jButtonAdicionarTarefa.setText("Adicionar");
        jButtonAdicionarTarefa.addActionListener(this::jButtonAdicionarTarefaActionPerformed);

        jTableTarefas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tarefa", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableTarefas);

        jComboBoxFiltroStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Concluído", "Não concluído" }));
        jComboBoxFiltroStatus.addActionListener(this::jComboBoxFiltroStatusActionPerformed);

        jButtonConcluirTarefa.setText("Concluir");

        jButtonRemoverTarefa.setText("Remover");
        jButtonRemoverTarefa.addActionListener(this::jButtonRemoverTarefaActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldDescricaoTarefa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAdicionarTarefa))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxFiltroStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonConcluirTarefa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRemoverTarefa)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDescricaoTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdicionarTarefa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxFiltroStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonRemoverTarefa)
                    .addComponent(jButtonConcluirTarefa))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAdicionarTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarTarefaActionPerformed
        if (jTextFieldDescricaoTarefa.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "A descrição não pode ser vazia");
            return;
        }
        
        if(hasTarefaRepetida(jTextFieldDescricaoTarefa.getText())){
            JOptionPane.showMessageDialog(null, "A tarefa " + jTextFieldDescricaoTarefa.getText() + "já existe!");
            return;
        }
        
        tarefas.add(jTextFieldDescricaoTarefa.getText() + ";" + NAO_CONCLUIDA);
        
        preencherTabela();
        
        jTextFieldDescricaoTarefa.setText("");
    }//GEN-LAST:event_jButtonAdicionarTarefaActionPerformed

        public boolean hasTarefaRepetida(String novaTarefa){
            for (String tarefa : tarefas){
                String dados[] = tarefa.split(";");
                
                if(novaTarefa.toLowerCase().equals(dados[0].toLowerCase())){
                return true;
            }
            }
            return false;
        }
        
        private void preencherTabela(){
            ArrayList<String> listaTarefas;
            
            if(jComboBoxFiltroStatus.getSelectedIndex() > 0){
                listaTarefas = tarefasFiltradas;    
            }else{
                listaTarefas = tarefas;
            }
            
            model.setRowCount(0);
            
            for(String tarefa : listaTarefas){
                String[] dados = tarefa.split(";");
                
                model.addRow(new Object[]{
                    dados[0],
                    dados[1]
                });
            }
        }
    private void jComboBoxFiltroStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFiltroStatusActionPerformed
        
    }//GEN-LAST:event_jComboBoxFiltroStatusActionPerformed

    private void jButtonRemoverTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverTarefaActionPerformed

    }//GEN-LAST:event_jButtonRemoverTarefaActionPerformed

    private void jTextFieldDescricaoTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDescricaoTarefaActionPerformed
        
    }//GEN-LAST:event_jTextFieldDescricaoTarefaActionPerformed


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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Tela_To_Do_List2().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarTarefa;
    private javax.swing.JButton jButtonConcluirTarefa;
    private javax.swing.JButton jButtonRemoverTarefa;
    private javax.swing.JComboBox<String> jComboBoxFiltroStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTarefas;
    private javax.swing.JTextField jTextFieldDescricaoTarefa;
    // End of variables declaration//GEN-END:variables
}
