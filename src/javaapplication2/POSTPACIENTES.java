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
public class POSTPACIENTES extends javax.swing.JFrame {
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
    public POSTPACIENTES() {
        initComponents();
        JPanelImage fondoImg = new JPanelImage(fondo, "img/hospitalback.jpg");
        fondo.add(fondoImg).repaint();
        fondo.setOpaque(false);
        fondo.setBorder(null);
        fondo.setBackground(new Color(0,0,0,0));
        //Llenar los combo box
        llenarComboBox("estados", "nombre", comboBoxEstados);
        llenarComboBox("desarrollofisico", "nombre", comboBoxEtapas);
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
        namePac = new javax.swing.JTextField();
        año = new javax.swing.JTextField();
        Volver = new javax.swing.JButton();
        comboBoxCiudades = new javax.swing.JComboBox<>();
        comboBoxEtapas = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        IdPaciente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        age = new javax.swing.JTextField();
        celular = new javax.swing.JTextField();
        sexo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        comboBoxEstados = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Yrsa SemiBold", 1, 24)); // NOI18N
        jLabel1.setText("Registrar Pacientes");

        Registrar.setText("Registrar");
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre:");

        jLabel3.setText("Sexo");

        jLabel4.setText("Año Ingreso");

        jLabel5.setText("Edad");

        Volver.setText("Volver");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });

        comboBoxEtapas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEtapasActionPerformed(evt);
            }
        });

        jLabel6.setText("ID:");

        jLabel7.setText("Ciudad");

        jLabel8.setText("Etapa de vida");

        jLabel9.setText("Celular");

        jLabel10.setText("Estado");

        comboBoxEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEstadosActionPerformed(evt);
            }
        });

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
                .addContainerGap(372, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(51, 51, 51)
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(namePac)
                                .addComponent(comboBoxCiudades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboBoxEtapas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(IdPaciente, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(celular, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                .addComponent(age, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                .addComponent(sexo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                .addComponent(comboBoxEstados, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(año, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(103, 103, 103))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                        .addComponent(Registrar)
                        .addGap(187, 187, 187))))
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
                    .addComponent(IdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namePac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(año, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(comboBoxEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboBoxCiudades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(comboBoxEtapas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Registrar)
                .addContainerGap(83, Short.MAX_VALUE))
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
        
        String etapaID = "";
        String etapa = comboBoxEtapas.getSelectedItem().toString(); // Obtener el estado seleccionado
        String sqlBusqueda2 = "SELECT idEtapaVida FROM desarrollofisico WHERE nombre = ?"; // Usar un placeholder en la consulta
        try (PreparedStatement ps = con.prepareStatement(sqlBusqueda2)) {
        ps.setString(1, etapa); // Establecer el valor del estado en la consulta
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                etapaID = rs.getString("idEtapaVida"); // Obtener el idEstado si existe un resultado
            } else {
                System.out.println("No se encontró la etapa de vida seleccionada."); // Mensaje si no hay coincidencia
            }
        }
        } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, "Error recuperando la ciudad: " + e.getMessage());
        }

        //Insercion
        conector();
        String sql = "INSERT INTO pacientes (idPaciente, nombre, año_ingreso, edad, sexo, idCiudad, idEtapaVida, celular) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            // Establecer los valores de los parámetros de la consulta
            preparedStatement.setString(1, IdPaciente.getText());
            preparedStatement.setString(2, namePac.getText());
            preparedStatement.setString(3, año.getText());
            preparedStatement.setString(4, age.getText()); 
            preparedStatement.setString(5, sexo.getText()); 
            preparedStatement.setString(6, CiudadID); 
            preparedStatement.setString(7, etapaID); 
            preparedStatement.setString(8, celular.getText()); 

            // Ejecutar la consulta de inserción
            int filasInsertadas = preparedStatement.executeUpdate();

            // Comprobar si la inserción fue exitosa
            if (filasInsertadas > 0) {
                System.out.println("Inserción exitosa");
                JOptionPane.showMessageDialog(rootPane, "Paciente agregado");
            } else {
                System.out.println("No se pudo insertar el registro");
            }
        } catch (SQLException ex) {
            Logger.getLogger(POSTPACIENTES.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_RegistrarActionPerformed

    private void comboBoxEtapasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEtapasActionPerformed
        
    }//GEN-LAST:event_comboBoxEtapasActionPerformed

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
            java.util.logging.Logger.getLogger(POSTPACIENTES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(POSTPACIENTES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(POSTPACIENTES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(POSTPACIENTES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new POSTPACIENTES().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IdPaciente;
    private javax.swing.JButton Registrar;
    private javax.swing.JButton Volver;
    private javax.swing.JTextField age;
    private javax.swing.JTextField año;
    private javax.swing.JTextField celular;
    private javax.swing.JComboBox<String> comboBoxCiudades;
    private javax.swing.JComboBox<String> comboBoxEstados;
    private javax.swing.JComboBox<String> comboBoxEtapas;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField namePac;
    private javax.swing.JTextField sexo;
    // End of variables declaration//GEN-END:variables
}
