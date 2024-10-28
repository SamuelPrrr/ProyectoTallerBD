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
public class POSTFACTDETALLE extends javax.swing.JFrame {
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
    public POSTFACTDETALLE() {
        initComponents();
        JPanelImage fondoImg = new JPanelImage(fondo, "img/hospitalback.jpg");
        fondo.add(fondoImg).repaint();
        fondo.setOpaque(false);
        fondo.setBorder(null);
        fondo.setBackground(new Color(0,0,0,0));
        //Llenar los combo box
        llenarComboBox("facturas", "idFactura", comboBoxFacturas);
        llenarComboBox("conceptos", "nombre", comboBoxConceptos);
        llenarComboBox("doctores", "nombre", comboBoxDoctores);
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cant = new javax.swing.JTextField();
        Volver = new javax.swing.JButton();
        comboBoxConceptos = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        preciounidad = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        comboBoxFacturas = new javax.swing.JComboBox<>();
        comboBoxDoctores = new javax.swing.JComboBox<>();
        iva = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Yrsa SemiBold", 1, 24)); // NOI18N
        jLabel1.setText("Registrar Pacientes");

        Registrar.setText("Registrar");
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });

        jLabel2.setText("Concepto:");

        jLabel4.setText("Cantidad:");

        jLabel5.setText("Precio unitario:");

        Volver.setText("Volver");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });

        jLabel6.setText("ID Factura:");

        jLabel7.setText("Doctor:");

        jLabel10.setText("IVA");

        comboBoxFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxFacturasActionPerformed(evt);
            }
        });

        comboBoxDoctores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxDoctoresActionPerformed(evt);
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
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addGap(51, 51, 51)
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(comboBoxConceptos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(preciounidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                .addComponent(comboBoxFacturas, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboBoxDoctores, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(iva, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                            .addComponent(cant, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(103, 103, 103))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                        .addComponent(Registrar)
                        .addGap(259, 259, 259))))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Volver)
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboBoxFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboBoxConceptos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(preciounidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(iva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(122, 122, 122)
                        .addComponent(Registrar))
                    .addComponent(comboBoxDoctores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(115, Short.MAX_VALUE))
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


    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        //Busqueda del IdCIudad
        String ConceptoID = "";
        String concepto = comboBoxConceptos.getSelectedItem().toString(); // Obtener el estado seleccionado
        String sqlBusqueda = "SELECT idConcepto FROM conceptos WHERE nombre = ?"; // Usar un placeholder en la consulta
        try (PreparedStatement ps = con.prepareStatement(sqlBusqueda)) {
        ps.setString(1, concepto); // Establecer el valor del estado en la consulta
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                ConceptoID = rs.getString("idConcepto"); // Obtener el idEstado si existe un resultado
            } else {
                System.out.println("No se encontró un concepto para la ciudad seleccionada."); // Mensaje si no hay coincidencia
            }
        }
        } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, "Error recuperando el concepto: " + e.getMessage());
        }
        
        String doctorID = "";
        String doctor = comboBoxDoctores.getSelectedItem().toString(); // Obtener el estado seleccionado
        String sqlBusqueda2 = "SELECT idDoctor FROM doctores WHERE nombre = ?"; // Usar un placeholder en la consulta
        try (PreparedStatement ps = con.prepareStatement(sqlBusqueda2)) {
        ps.setString(1, doctor); // Establecer el valor del estado en la consulta
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                doctorID = rs.getString("idDoctor"); // Obtener el idEstado si existe un resultado
            } else {
                System.out.println("No se encontró al doctor seleccionado."); // Mensaje si no hay coincidencia
            }
        }
        } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, "Error recuperando al doctor: " + e.getMessage());
        }

        String factID = comboBoxFacturas.getSelectedItem().toString();
        //Insercion
        conector();
        String sql = "INSERT INTO factdetalle (idFactura, idConcepto, cant, precioUnit, subtotalConcept,iva,totalConc, idDoctor) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            
            double cantt = Double.parseDouble(cant.getText());
            double precioU = Double.parseDouble(preciounidad.getText());
            double subtotal = cantt * precioU;
            double ivaa = Double.parseDouble(iva.getText()) / 100;
            ivaa = subtotal * ivaa;
            double total = subtotal + ivaa;
            
            // Establecer los valores de los parámetros de la consulta
            preparedStatement.setString(1, factID); 
            preparedStatement.setString(2, ConceptoID );
            preparedStatement.setDouble(3, cantt);
            preparedStatement.setDouble(4, precioU); 
            preparedStatement.setDouble(5, subtotal); 
            preparedStatement.setDouble(6, ivaa); 
            preparedStatement.setDouble(7, total); 
            preparedStatement.setString(8, doctorID); 

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
            Logger.getLogger(POSTFACTDETALLE.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_RegistrarActionPerformed

    private void comboBoxFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxFacturasActionPerformed
       
    }//GEN-LAST:event_comboBoxFacturasActionPerformed

    private void comboBoxDoctoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxDoctoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxDoctoresActionPerformed

 
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
            java.util.logging.Logger.getLogger(POSTFACTDETALLE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(POSTFACTDETALLE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(POSTFACTDETALLE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(POSTFACTDETALLE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new POSTFACTDETALLE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Registrar;
    private javax.swing.JButton Volver;
    private javax.swing.JTextField cant;
    private javax.swing.JComboBox<String> comboBoxConceptos;
    private javax.swing.JComboBox<String> comboBoxDoctores;
    private javax.swing.JComboBox<String> comboBoxFacturas;
    private javax.swing.JPanel fondo;
    private javax.swing.JTextField iva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField preciounidad;
    // End of variables declaration//GEN-END:variables
}