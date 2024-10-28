/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication2;
import java.awt.Color;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;


/**
 *
 * @author samuel
 */
public class POSTHOSPITAL extends javax.swing.JFrame {
    private static Connection con;
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String user = "samuel";
    private static final String password = "password";
    private static final String url = "jdbc:mysql://127.0.0.1/Hospitales";
    
    
    public void conector(){
    con = null;
    try{
        Class.forName(driver);
        con = (Connection) DriverManager.getConnection(url, user, password);
        if(con!=null){
            
        }
    }
    catch(ClassNotFoundException | SQLException e){
        JOptionPane.showMessageDialog(null, "Hubo un error en la Base de datos");
    }
    }
    /**
     * Creates new form INSERTAR
     */
    public POSTHOSPITAL() {
        initComponents();
        JPanelImage fondoImg = new JPanelImage(fondo, "img/hospitalback.jpg");
        fondo.add(fondoImg).repaint();
        fondo.setOpaque(false);
        fondo.setBorder(null);
        fondo.setBackground(new Color(0,0,0,0));
        //Llenar los combo box
        llenarComboBox("estados", "nombre", comboBoxEstados);
      }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Registrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nameHosp = new javax.swing.JTextField();
        tipoHosp = new javax.swing.JTextField();
        Volver = new javax.swing.JButton();
        comboBoxCiudades = new javax.swing.JComboBox<>();
        comboBoxEstados = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        IdHosp = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Yrsa SemiBold", 1, 24)); // NOI18N
        jLabel1.setText("Registrar Hospital");

        Registrar.setText("Registrar");
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre:");

        jLabel3.setText("Ciudad:");

        jLabel4.setText("Tipo:");

        jLabel5.setText("Estado:");

        Volver.setText("Volver");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });

        comboBoxEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEstadosActionPerformed(evt);
            }
        });

        jLabel6.setText("ID:");

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Volver))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(jLabel1)))
                .addContainerGap(383, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addGap(51, 51, 51)
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tipoHosp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(nameHosp)
                            .addComponent(comboBoxCiudades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxEstados, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(IdHosp, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(103, 103, 103))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                        .addComponent(Registrar)
                        .addGap(237, 237, 237))))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Volver)
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(IdHosp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameHosp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tipoHosp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(36, 36, 36)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(comboBoxEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(81, 81, 81)
                        .addComponent(Registrar))
                    .addComponent(comboBoxCiudades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(196, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        INSERTAR nuevoFrame = new INSERTAR();
        nuevoFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed

    public class ComboItem {
    private String key;
    private String value;

    public ComboItem(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getKey() {
        return key;
    }
}

private void llenarComboBox(String tabla, String valor, JComboBox combo) {
    conector(); // Llamar al método de conexión
    String sql = "SELECT * FROM " + tabla; // Nota el espacio después de FROM
    try (Statement st = con.createStatement(); 
         ResultSet rs = st.executeQuery(sql)) { // Crear Statement y ejecutar la consulta
        while(rs.next()) {
            combo.addItem(rs.getString(valor)); // Usar el ResultSet para obtener el valor
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.toString());
    }
}

    private void llenarComboBoxCiudades(String idEstado) {
         comboBoxCiudades.removeAllItems(); // Limpiar el comboBox de ciudades antes de llenarlo
    String sql = "SELECT nombre FROM ciudades WHERE idEstado = ?"; // Utilizar PreparedStatement

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, idEstado); // Establecer el valor de idEstado en la consulta
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                comboBoxCiudades.addItem(rs.getString("nombre")); // Llenar el comboBox de ciudades con los nombres
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error llenando ciudades: " + e.toString());
    }
    }
    



    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        //Busqueda del IdCIudad
        String CiudadID = "";
        String ciudad = comboBoxCiudades.getSelectedItem().toString(); // Obtener el estado seleccionado
        String sqlBusqueda = "SELECT idCiudad FROM ciudades WHERE nombre = ?"; // Usar un placeholder en la consulta
        try (PreparedStatement ps = con.prepareStatement(sqlBusqueda)) {
        ps.setString(1, ciudad); // Establecer el valor del estado en la consulta
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                CiudadID = rs.getString("idCiudad"); // Obtener el idEstado si existe un resultado
            } else {
                System.out.println("No se encontró un idCiudad para la ciudad seleccionada."); // Mensaje si no hay coincidencia
            }
        }
        } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, "Error recuperando la ciudad: " + e.getMessage());
        }

        //Insercion
        conector();
        String sql = "INSERT INTO hospitales (idHosp, nombre, tipo, idCiudad) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            // Establecer los valores de los parámetros de la consulta
            preparedStatement.setString(1, IdHosp.getText());
            preparedStatement.setString(2, nameHosp.getText());
            preparedStatement.setString(3, tipoHosp.getText());
            preparedStatement.setString(4, CiudadID); 

            // Ejecutar la consulta de inserción
            int filasInsertadas = preparedStatement.executeUpdate();

            // Comprobar si la inserción fue exitosa
            if (filasInsertadas > 0) {
                System.out.println("Inserción exitosa");
                JOptionPane.showMessageDialog(rootPane, "Hospital agregado");
            } else {
                System.out.println("No se pudo insertar el registro");
            }
        } catch (SQLException ex) {
            Logger.getLogger(POSTHOSPITAL.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_RegistrarActionPerformed

 
    private void comboBoxEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEstadosActionPerformed
    String idEstado = "";
    String estado = comboBoxEstados.getSelectedItem().toString(); // Obtener el estado seleccionado
    String sql = "SELECT idEstado FROM estados WHERE nombre = ?"; // Usar un placeholder en la consulta

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, estado); // Establecer el valor del estado en la consulta
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                idEstado = rs.getString("idEstado"); // Obtener el idEstado si existe un resultado
            } else {
                System.out.println("No se encontró un idEstado para el estado seleccionado."); // Mensaje si no hay coincidencia
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error recuperando idEstado: " + e.getMessage());
    }
    llenarComboBoxCiudades(idEstado); // Llenar el ComboBox de ciudades con el idEstado obtenido
    }//GEN-LAST:event_comboBoxEstadosActionPerformed

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(POSTHOSPITAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(POSTHOSPITAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(POSTHOSPITAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(POSTHOSPITAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new POSTHOSPITAL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IdHosp;
    private javax.swing.JButton Registrar;
    private javax.swing.JButton Volver;
    private javax.swing.JComboBox<String> comboBoxCiudades;
    private javax.swing.JComboBox<String> comboBoxEstados;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField nameHosp;
    private javax.swing.JTextField tipoHosp;
    // End of variables declaration//GEN-END:variables
}