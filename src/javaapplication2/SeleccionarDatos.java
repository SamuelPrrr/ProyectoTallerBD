package javaapplication2;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SeleccionarDatos extends javax.swing.JFrame {

    private Connection conn;

    // Método para conectar a la base de datos
    private void conectarDB() {
        try {
            String url = "jdbc:mysql://localhost:3306/hospitales"; // Cambia la URL y los parámetros según tu base de datos
            String user = "root";  // Usuario de la base de datos
            String pass = "odimaryserazo29"; // Contraseña de la base de datos
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos");
        }
    }

    // Método para mostrar los datos de la tabla MySQL
    private void mostrarDatos() {
        String query = "SELECT * FROM pacientes";  // Cambia la consulta según la tabla que quieras mostrar
        try {
            // Conectar a la base de datos
            conectarDB();
            
            // Preparar la consulta
            PreparedStatement pst = conn.prepareStatement(query);
            
            // Ejecutar la consulta y obtener los resultados
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData metadatos = rs.getMetaData();
            int columnCount = metadatos.getColumnCount();
            
            // Crear un modelo para la tabla
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0);  // Limpiar la tabla
            
            // Recorrer los resultados y agregarlos a la tabla
            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = rs.getObject(i);  // Obtener el valor de cada columna
                }
                modelo.addRow(rowData);  // Añadir la fila al modelo
            }
            
            // Cerrar conexiones
            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al mostrar los datos: " + ex.getMessage());
        }
    }

    // Acción del botón "Seleccionar"
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        mostrarDatos();  // Llamar al método que muestra los datos en la tabla
    }

    // Código generado automáticamente para la interfaz gráfica
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID Paciente", "Nombre", "Edad", "Sexo", "Dirección" // Añadir columnas según la tabla en MySQL
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("SELECCIONAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }

    // Método main
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeleccionarDatos().setVisible(true);
            }
        });
    }

    // Variables de la interfaz
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}
