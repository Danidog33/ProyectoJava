
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
import static principal.frmlogin.fr;
import principal.frmregistro;



public class empleados extends javax.swing.JPanel {
    public static bdclientemensual bdclientes;

 
    public empleados() {
        initComponents();
          
    }
    
    
                   
    public void listarDatos(){
    
        
         String consulta = "SELECT * FROM `usuario`";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/parking_control", "root", "");
            Statement stat = conexion.createStatement();
            ResultSet rs = stat.executeQuery(consulta);

            // Crear un modelo de tabla para almacenar los datos
            
            DefaultTableModel modelo = new DefaultTableModel();

            // Agregar columnas al modelo (ajusta según tus columnas en la base de datos)
            
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("CC");
            modelo.addColumn("Tipousuario");
            modelo.addColumn("Password");
            
            
            

            // Agregar filas al modelo con los datos de la consulta
            
            while (rs.next()) {
                Object[] fila = new Object[5];  
                 
                fila[0] = rs.getString("Nombre");
                fila[1] = rs.getString("Apellido");
                fila[2] = rs.getString("CC");
                fila[3] = rs.getString("Tipousuario");
                fila[4] = rs.getString("Password");
                
                
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
                    
                    String Nombre = tabla.getValueAt(fila, 0).toString();
                    String Apellido = tabla.getValueAt(fila, 1).toString();
                    String CC = tabla.getValueAt(fila, 2).toString();
                    String Tipousuario = tabla.getValueAt(fila, 3).toString();
                    String Password = tabla.getValueAt(fila, 4).toString();
                    

                    conexion.conexionMysql con = new conexionMysql();
                    Connection cn = con.conectar();

                    String actualizar = "UPDATE usuario SET Nombre=?, Apellido=?, Tipousuario=?, Password=? WHERE CC=?";

                    PreparedStatement ps = cn.prepareStatement(actualizar);

                    ps.setString(1, Nombre);
                    ps.setString(2, Apellido);
                    ps.setString(3, Tipousuario);
                    ps.setString(4, Password);
                    ps.setString(5, CC);
                    

                    ps.executeUpdate();
                    

                    JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
                } catch (SQLException | NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Datos no se actualizaron correctamente: " + e.getMessage());
                }
    } 
    }
    
    
    public void eliminar(){
    
             int fila = tabla.getSelectedRow();
             String valor = tabla.getValueAt(fila, 2).toString();
             
             try {
                
                  conexion.conexionMysql con = new conexionMysql();
                  Connection cn = con.conectar();
                  PreparedStatement ps = cn.prepareStatement("DELETE FROM usuario WHERE CC='"+valor+"' ");   
                  
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
        jButton2 = new javax.swing.JButton();
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

        jButton2.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jButton2.setText("Registrarse");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
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
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(179, 179, 179))
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
        jLabel1.setText("Cuenta empleados");

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
                .addGap(0, 347, Short.MAX_VALUE))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        fr=new frmregistro(null, true);
        fr.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
