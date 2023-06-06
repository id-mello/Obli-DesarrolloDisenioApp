/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package iuEscritorio;

/**
 *
 * @author Ignac
 */
public class EmularTransito extends javax.swing.JDialog {

    /**
     * Creates new form EmularTransito
     */
    public EmularTransito(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboPuestos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaTarifas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        btnRegistrarMatricula = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Emular Transito");

        comboPuestos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboPuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPuestosActionPerformed(evt);
            }
        });

        jLabel1.setText("Puestos:");

        jLabel2.setText("Tarifas:");

        tablaTarifas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Categoría", "Monto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaTarifas.setColumnSelectionAllowed(true);
        tablaTarifas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaTarifas);
        tablaTarifas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabel3.setText("Ingrese matricula:");

        txtMatricula.setText("Escriba aquí...");
        txtMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculaActionPerformed(evt);
            }
        });

        btnRegistrarMatricula.setText("Registrar");
        btnRegistrarMatricula.setMaximumSize(new java.awt.Dimension(75, 22));
        btnRegistrarMatricula.setMinimumSize(new java.awt.Dimension(75, 22));
        btnRegistrarMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarMatriculaActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(comboPuestos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnRegistrarMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btnCerrar)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatriculaActionPerformed

    private void btnRegistrarMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarMatriculaActionPerformed

    private void comboPuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPuestosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPuestosActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCerrarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnRegistrarMatricula;
    private javax.swing.JComboBox<String> comboPuestos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaTarifas;
    private javax.swing.JTextField txtMatricula;
    // End of variables declaration//GEN-END:variables
}
