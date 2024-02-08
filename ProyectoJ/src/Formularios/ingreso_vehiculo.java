/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Formularios;

/*import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.mysql.jdbc.Connection;*/
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ingreso_vehiculo extends javax.swing.JPanel {

    public ingreso_vehiculo() {
        initComponents();
   
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ingreso_vehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    
     }
    
    @SuppressWarnings("unchecked")
    
        String fechaHora = "";
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtpropietario = new javax.swing.JTextField();
        rbmotocicleta = new javax.swing.JRadioButton();
        rbautomovil = new javax.swing.JRadioButton();
        rbotros = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtplaca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel1.setText("Modulo ingreso de vehiculos");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel2.setText("Placa");

        txtpropietario.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        btgroup.add(rbmotocicleta);
        rbmotocicleta.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        rbmotocicleta.setText("Motocicleta");

        btgroup.add(rbautomovil);
        rbautomovil.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        rbautomovil.setText("Automovil");
        rbautomovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbautomovilActionPerformed(evt);
            }
        });

        btgroup.add(rbotros);
        rbotros.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        rbotros.setText("Otros");

        jButton1.setBackground(new java.awt.Color(0, 51, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel3.setText("Propietario");

        txtplaca.setFont(new java.awt.Font("Arial", 0, 76)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel4.setText("Tipo vehículo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtplaca, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(213, 213, 213)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtpropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(239, 239, 239)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(249, 249, 249)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(154, 154, 154)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbmotocicleta)
                                .addGap(18, 18, 18)
                                .addComponent(rbautomovil)))
                        .addGap(27, 27, 27)
                        .addComponent(rbotros, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(txtplaca, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txtpropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbmotocicleta)
                    .addComponent(rbautomovil)
                    .addComponent(rbotros))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String placa =txtplaca.getText().trim();
        if (placa.isEmpty()){
            JOptionPane.showMessageDialog(this, "Debe ingresar Placa", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
       
        String clase_vehiculo = "";
        if (rbmotocicleta.isSelected()){
            clase_vehiculo = "Motocicleta";
        }
        if (rbautomovil.isSelected()){
            clase_vehiculo = "Automovil";
        }
        if (rbotros.isSelected()){
            clase_vehiculo = "Otros";
        }

        
        try {
            Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/parking_control","root","");
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            fechaHora = dateFormat.format(date);
            System.out.print(dateFormat.format(date));
            Statement stat = conexion.createStatement();
            String sql = "INSERT INTO `vehiculos diarios` (`placa`, `propietario`,`tipo_vehiculo`,`hora_entrada`,estado) "
                    + "VALUES ('" + txtplaca.getText() + "','" + txtpropietario.getText() + "','" + clase_vehiculo + "','" + fechaHora + "','Disponible')";
            stat.executeUpdate(sql);
            limpiar ();
            JOptionPane.showMessageDialog(null, "El vehiculo se registro exitosamente");
            
            }catch (SQLException ex) {
            Logger.getLogger(ingreso_vehiculo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rbautomovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbautomovilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbautomovilActionPerformed

    
        void limpiar (){
            txtplaca.setText("");
            txtpropietario.setText("");
            rbautomovil.setSelected(false);
            rbmotocicleta.setSelected(false);
            rbotros.setSelected(false);
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgroup;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton rbautomovil;
    private javax.swing.JRadioButton rbmotocicleta;
    private javax.swing.JRadioButton rbotros;
    private javax.swing.JTextField txtplaca;
    private javax.swing.JTextField txtpropietario;
    // End of variables declaration//GEN-END:variables
}
