
package Formularios;

import conexion.conexionMysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;



public class clientes_mensuales extends javax.swing.JPanel {
    public static bdclientemensual bdclientes;

 
    public clientes_mensuales() {
        initComponents();
          
    }
    
    
                   
    public void listarDatos(){
    
        
         String consulta = "SELECT * FROM `clientes`";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/parking_control", "root", "");
            Statement stat = conexion.createStatement();
            ResultSet rs = stat.executeQuery(consulta);

            // Crear un modelo de tabla para almacenar los datos
            
            DefaultTableModel modelo = new DefaultTableModel();

            // Agregar columnas al modelo (ajusta según tus columnas en la base de datos)
            modelo.addColumn("id");
            modelo.addColumn("numDoc");
            modelo.addColumn("tipoDoc");
            modelo.addColumn("nombreApellido");
            modelo.addColumn("clasVehi");
            modelo.addColumn("placa");
            modelo.addColumn("marca");
            modelo.addColumn("telefono");
            modelo.addColumn("tipoplan");
            modelo.addColumn("fechaPago");
            modelo.addColumn("valorPago");
            modelo.addColumn("observaciones");
            
            

            // Agregar filas al modelo con los datos de la consulta
            
            while (rs.next()) {
                Object[] fila = new Object[12];  
                fila[0] = rs.getInt("id");  
                fila[1] = rs.getString("numDoc");
                fila[2] = rs.getString("tipoDoc");
                fila[3] = rs.getString("nombreApellido");
                fila[4] = rs.getString("clasVehi");
                fila[5] = rs.getString("placa");
                fila[6] = rs.getString("marca");
                fila[7] = rs.getString("telefono");
                fila[8] = rs.getString("tipoplan");
                fila[9] = rs.getString("fechaPago");
                fila[10] = rs.getString("valorPago");
                fila[11] = rs.getString("observaciones");
                
                // Añade más filas según la estructura de tu tabla

                modelo.addRow(fila);
            }

            // Cierra la conexión y la consulta
            
            rs.close();
            stat.close();
            conexion.close();

            // Crea una tabla y asigna el modelo a la tabla
            
            tabla.setModel(modelo);

            
            

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Manejo de errores (puedes mostrar un mensaje de error en la interfaz gráfica)
        }
    }
    
    
    public void actualizarDatos(){
    
          int fila = tabla.getSelectedRow();
              if (fila >= 0) {
                try {
                    int id = Integer.parseInt(tabla.getValueAt(fila, 0).toString());
                    String numDoc = tabla.getValueAt(fila, 1).toString();
                    String tipoDoc = tabla.getValueAt(fila, 2).toString();
                    String nombreApellido = tabla.getValueAt(fila, 3).toString();
                    String clasVehi = tabla.getValueAt(fila, 4).toString();
                    String placa = tabla.getValueAt(fila, 5).toString();
                    String marca = tabla.getValueAt(fila, 6).toString();
                    String telefono = tabla.getValueAt(fila, 7).toString();
                    String tipoplan = tabla.getValueAt(fila, 8).toString();
                    String fechaPago = tabla.getValueAt(fila, 9).toString();
                    String valorPago = tabla.getValueAt(fila, 10).toString();
                    String observaciones = tabla.getValueAt(fila, 11).toString();

                    conexion.conexionMysql con = new conexionMysql();
                    Connection cn = con.conectar();

                    String actualizar = "UPDATE clientes SET numDoc=?, tipoDoc=?, nombreApellido=?, clasVehi=?, placa=?, marca=?, telefono=?, tipoplan=?, fechaPago=?, valorPago=?, observaciones=? WHERE id=?";

                    PreparedStatement ps = cn.prepareStatement(actualizar);

                    ps.setString(1, numDoc);
                    ps.setString(2, tipoDoc);
                    ps.setString(3, nombreApellido);
                    ps.setString(4, clasVehi);
                    ps.setString(5, placa);
                    ps.setString(6, marca);
                    ps.setString(7, telefono);
                    ps.setString(8, tipoplan);
                    ps.setString(9, fechaPago);
                    ps.setString(10, valorPago);
                    ps.setString(11, observaciones);
                    ps.setInt(12, id);

                    ps.executeUpdate();
                    

                    JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
                } catch (SQLException | NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Datos no se actualizaron correctamente: " + e.getMessage());
                }
    } 
    }
    
    
    public void eliminar(){
    
             int fila = tabla.getSelectedRow();
             String valor = tabla.getValueAt(fila, 0).toString();
             
             try {
                
                  conexion.conexionMysql con = new conexionMysql();
                  Connection cn = con.conectar();
                  PreparedStatement ps = cn.prepareStatement("DELETE FROM clientes WHERE id='"+valor+"' ");   
                  
                  ps.executeUpdate();
        } catch (Exception e) {
            
            JOptionPane.showInternalMessageDialog(null, e + "No se eliminaron los datos");
        }
    
    }
        

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(182, 182, 182))
        );

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel1.setText("Clientes Fijos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(384, 384, 384)
                .addComponent(jLabel1)
                .addGap(0, 405, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
    bdclientes=new bdclientemensual(null, true);
    bdclientes.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
       
        actualizarDatos();
    
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
     
        eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
    
        listarDatos();
        
    }//GEN-LAST:event_btnListarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
         
                   
    }//GEN-LAST:event_tablaMouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
