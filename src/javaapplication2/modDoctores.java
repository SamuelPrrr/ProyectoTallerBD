package javaapplication2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;

public class modDoctores extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField txtId, txtNombre, txtSueldo, txtEspecialidad, txtIdHosp;
    private JButton btnCargar, btnGuardar, btnVolver;
    private Connection conn;

    public modDoctores() {
        setTitle("Doctores");
        setSize(800, 600);  // Aumentar tamaño de ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);  // Centrar ventana

        // Botón "Volver" en la esquina superior derecha
       btnVolver = new JButton("Volver");
btnVolver.setBounds(700, 10, 80, 25);
add(btnVolver);

btnVolver.addActionListener(e -> {
    new MODIFICAR().setVisible(true);  // Abrir la ventana MODIFICAR
    dispose();  // Cerrar la ventana actual
});

        

        tableModel = new DefaultTableModel(new Object[]{"ID Doctor", "Nombre", "Sueldo", "Especialidad", "ID Hospital"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 50, 740, 200);  // Hacer más grande la tabla
        add(scrollPane);

        btnCargar = new JButton("Modificar");
        btnCargar.setBounds(20, 270, 120, 30);
        add(btnCargar);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(150, 270, 120, 30);
        add(btnGuardar);

        // Etiquetas para los JTextFields
        JLabel lblId = new JLabel("ID del Doctor:");
        lblId.setBounds(20, 320, 150, 25);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(170, 320, 250, 30);
        txtId.setEditable(false);  // No permitir edición del ID
        add(txtId);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 360, 150, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(170, 360, 250, 30);
        add(txtNombre);

        JLabel lblSueldo = new JLabel("Sueldo:");
        lblSueldo.setBounds(20, 400, 150, 25);
        add(lblSueldo);

        txtSueldo = new JTextField();
        txtSueldo.setBounds(170, 400, 250, 30);
        add(txtSueldo);

        JLabel lblEspecialidad = new JLabel("Especialidad:");
        lblEspecialidad.setBounds(20, 440, 150, 25);
        add(lblEspecialidad);

        txtEspecialidad = new JTextField();
        txtEspecialidad.setBounds(170, 440, 250, 30);
        add(txtEspecialidad);

        JLabel lblIdHosp = new JLabel("ID del Hospital:");
        lblIdHosp.setBounds(20, 480, 150, 25);
        add(lblIdHosp);

        txtIdHosp = new JTextField();
        txtIdHosp.setBounds(170, 480, 250, 30);
        add(txtIdHosp);

        conectarBaseDatos();
        cargarDatosTabla();

        btnCargar.addActionListener(e -> cargarDatosSeleccionados());
        btnGuardar.addActionListener(e -> guardarCambios());
        btnVolver.addActionListener(e -> dispose());  // Cerrar ventana actual

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cerrarConexion();
            }
        });
    }

    private void conectarBaseDatos() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Hospitales";
            String user = "samuel";
            String password = "password";
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.");
        }
    }

    private void cargarDatosTabla() {
        String query = "SELECT * FROM doctores";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            tableModel.setRowCount(0);  // Limpiar la tabla

            while (rs.next()) {
                tableModel.addRow(new Object[]{
                        rs.getString("idDoctor"),
                        rs.getString("nombre"),
                        rs.getDouble("sueldo"),
                        rs.getString("especialidad"),
                        rs.getString("idHosp")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos.");
        }
    }

    private void cargarDatosSeleccionados() {
        int filaSeleccionada = table.getSelectedRow();
        if (filaSeleccionada != -1) {
            txtId.setText(tableModel.getValueAt(filaSeleccionada, 0).toString());
            txtNombre.setText(tableModel.getValueAt(filaSeleccionada, 1).toString());
            txtSueldo.setText(tableModel.getValueAt(filaSeleccionada, 2).toString());
            txtEspecialidad.setText(tableModel.getValueAt(filaSeleccionada, 3).toString());
            txtIdHosp.setText(tableModel.getValueAt(filaSeleccionada, 4).toString());
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila.");
        }
    }

    private void guardarCambios() {
        if (txtNombre.getText().isEmpty() || txtSueldo.getText().isEmpty() ||
            txtEspecialidad.getText().isEmpty() || txtIdHosp.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
            return;
        }

        try {
            String query = "UPDATE doctores SET nombre=?, sueldo=?, especialidad=?, idHosp=? WHERE idDoctor=?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, txtNombre.getText());
                pstmt.setDouble(2, Double.parseDouble(txtSueldo.getText()));
                pstmt.setString(3, txtEspecialidad.getText());
                pstmt.setString(4, txtIdHosp.getText());
                pstmt.setString(5, txtId.getText());

                int filasAfectadas = pstmt.executeUpdate();
                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(this, "Datos actualizados correctamente.");
                    cargarDatosTabla();  // Refrescar la tabla
                } else {
                    JOptionPane.showMessageDialog(this, "Error al actualizar los datos.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar los cambios.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El sueldo debe ser un número válido.");
        }
    }

    private void cerrarConexion() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new modDoctores().setVisible(true));
    }
}
