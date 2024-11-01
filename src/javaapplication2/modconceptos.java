package javaapplication2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;

public class modconceptos extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField txtIdConcepto, txtNombre;
    private JButton btnCargar, btnGuardar, btnVolver;
    private Connection conn;

    public modconceptos() {
        setTitle("Conceptos");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(700, 10, 80, 25);
        add(btnVolver);
        btnVolver.addActionListener(e -> {
            new MODIFICAR().setVisible(true); // Cambia a la ventana anterior que tengas
            dispose();
        });

        tableModel = new DefaultTableModel(new Object[]{"ID Concepto", "Nombre"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 50, 740, 100);
        add(scrollPane);

        btnCargar = new JButton("Modificar");
        btnCargar.setBounds(20, 270, 120, 30);
        add(btnCargar);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(150, 270, 120, 30);
        add(btnGuardar);

        JLabel lblIdConcepto = new JLabel("ID Concepto:");
        lblIdConcepto.setBounds(20, 320, 150, 25);
        add(lblIdConcepto);

        txtIdConcepto = new JTextField();
        txtIdConcepto.setBounds(170, 320, 250, 30);
        txtIdConcepto.setEditable(false);  // Hacer el ID no editable
        add(txtIdConcepto);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 360, 150, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(170, 360, 250, 30);
        add(txtNombre);

        conectarBaseDatos();
        cargarDatosTabla();

        btnCargar.addActionListener(e -> cargarDatosSeleccionados());
        btnGuardar.addActionListener(e -> guardarCambios());
        btnVolver.addActionListener(e -> dispose());

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
            String url = "jdbc:mysql://localhost:3306/Hospitales"; // Cambia el nombre de la base de datos si es necesario
            String user = "samuel";
            String password = "password"; // Cambia la contraseña según sea necesario
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.");
        }
    }

    private void cargarDatosTabla() {
        String query = "SELECT * FROM conceptos";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            tableModel.setRowCount(0);  // Limpiar la tabla

            while (rs.next()) {
                tableModel.addRow(new Object[]{
                        rs.getString("idConcepto"),
                        rs.getString("nombre")
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
            txtIdConcepto.setText(tableModel.getValueAt(filaSeleccionada, 0).toString());
            txtNombre.setText(tableModel.getValueAt(filaSeleccionada, 1).toString());
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila.");
        }
    }

    private void guardarCambios() {
        if (txtNombre.getText().isEmpty() || txtIdConcepto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
            return;
        }

        try {
            // Aquí no se cambia el ID, solo se actualiza el nombre
            String query = "UPDATE conceptos SET nombre=? WHERE idConcepto=?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, txtNombre.getText());
                pstmt.setString(2, txtIdConcepto.getText());  // Usar el ID existente

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
        SwingUtilities.invokeLater(() -> new modconceptos().setVisible(true));
    }
}
