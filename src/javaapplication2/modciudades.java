package javaapplication2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;

public class modciudades extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField txtId, txtNombre, txtPoblacion, txtIdEstado;
    private JButton btnCargar, btnGuardar, btnVolver;
    private Connection conn;

    public modciudades() {
        setTitle("Ciudades");
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

        tableModel = new DefaultTableModel(new Object[]{"ID Ciudad", "Nombre", "Población", "ID Estado"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 50, 740, 200);
        add(scrollPane);

        btnCargar = new JButton("Modificar");
        btnCargar.setBounds(20, 270, 120, 30);
        add(btnCargar);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(150, 270, 120, 30);
        add(btnGuardar);

        JLabel lblId = new JLabel("ID de la Ciudad:");
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

        JLabel lblPoblacion = new JLabel("Población:");
        lblPoblacion.setBounds(20, 400, 150, 25);
        add(lblPoblacion);

        txtPoblacion = new JTextField();
        txtPoblacion.setBounds(170, 400, 250, 30);
        add(txtPoblacion);

        JLabel lblIdEstado = new JLabel("ID del Estado:");
        lblIdEstado.setBounds(20, 440, 150, 25);
        add(lblIdEstado);

        txtIdEstado = new JTextField();
        txtIdEstado.setBounds(170, 440, 250, 30);
        add(txtIdEstado);

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
        String query = "SELECT * FROM ciudades"; // Cambia el nombre de la tabla a ciudades
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            tableModel.setRowCount(0);

            while (rs.next()) {
                tableModel.addRow(new Object[]{
                        rs.getString("idCiudad"),
                        rs.getString("nombre"),
                        rs.getInt("poblacion"), // Asegúrate que sea int
                        rs.getString("idEstado")
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
            txtPoblacion.setText(tableModel.getValueAt(filaSeleccionada, 2).toString());
            txtIdEstado.setText(tableModel.getValueAt(filaSeleccionada, 3).toString());
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila.");
        }
    }

    private void guardarCambios() {
        if (txtNombre.getText().isEmpty() || txtPoblacion.getText().isEmpty() || txtIdEstado.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
            return;
        }

        try {
            int poblacion = Integer.parseInt(txtPoblacion.getText());
            String query = "UPDATE ciudades SET nombre=?, poblacion=?, idEstado=? WHERE idCiudad=?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, txtNombre.getText());
                pstmt.setInt(2, poblacion);
                pstmt.setString(3, txtIdEstado.getText());
                pstmt.setString(4, txtId.getText());

                int filasAfectadas = pstmt.executeUpdate();
                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(this, "Datos actualizados correctamente.");
                    cargarDatosTabla();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al actualizar los datos.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar los cambios.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La población debe ser un número válido.");
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
        SwingUtilities.invokeLater(() -> new modciudades().setVisible(true));
    }
}
