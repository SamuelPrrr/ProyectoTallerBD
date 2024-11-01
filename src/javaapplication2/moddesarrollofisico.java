package javaapplication2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;

public class moddesarrollofisico extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField txtIdEtapa, txtNombre, txtEdadLimInf, txtEdadLimSup;
    private JButton btnCargar, btnGuardar, btnVolver;
    private Connection conn;

    public moddesarrollofisico() {
        setTitle("Desarrollo Físico");
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

        tableModel = new DefaultTableModel(new Object[]{"ID Etapa de Vida", "Nombre", "Edad Límite Inferior", "Edad Límite Superior"}, 0);
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

        JLabel lblIdEtapa = new JLabel("ID Etapa de Vida:");
        lblIdEtapa.setBounds(20, 320, 150, 25);
        add(lblIdEtapa);

        txtIdEtapa = new JTextField();
        txtIdEtapa.setBounds(170, 320, 250, 30);
        txtIdEtapa.setEditable(false);  // No permitir edición del ID
        add(txtIdEtapa);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 360, 150, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(170, 360, 250, 30);
        add(txtNombre);

        JLabel lblEdadLimInf = new JLabel("Edad Límite Inferior:");
        lblEdadLimInf.setBounds(20, 400, 150, 25);
        add(lblEdadLimInf);

        txtEdadLimInf = new JTextField();
        txtEdadLimInf.setBounds(170, 400, 250, 30);
        add(txtEdadLimInf);

        JLabel lblEdadLimSup = new JLabel("Edad Límite Superior:");
        lblEdadLimSup.setBounds(20, 440, 150, 25);
        add(lblEdadLimSup);

        txtEdadLimSup = new JTextField();
        txtEdadLimSup.setBounds(170, 440, 250, 30);
        add(txtEdadLimSup);

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
        String query = "SELECT * FROM desarrollofisico";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            tableModel.setRowCount(0);  // Limpiar la tabla

            while (rs.next()) {
                tableModel.addRow(new Object[]{
                        rs.getString("idEtapaVida"),
                        rs.getString("nombre"),
                        rs.getInt("edadLimInf"),
                        rs.getInt("edadLimSup")
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
            txtIdEtapa.setText(tableModel.getValueAt(filaSeleccionada, 0).toString());
            txtNombre.setText(tableModel.getValueAt(filaSeleccionada, 1).toString());
            txtEdadLimInf.setText(tableModel.getValueAt(filaSeleccionada, 2).toString());
            txtEdadLimSup.setText(tableModel.getValueAt(filaSeleccionada, 3).toString());
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila.");
        }
    }

    private void guardarCambios() {
        if (txtNombre.getText().isEmpty() || txtEdadLimInf.getText().isEmpty() || txtEdadLimSup.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
            return;
        }

        try {
            String query = "UPDATE desarrollofisico SET nombre=?, edadLimInf=?, edadLimSup=? WHERE idEtapaVida=?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, txtNombre.getText());
                pstmt.setInt(2, Integer.parseInt(txtEdadLimInf.getText()));
                pstmt.setInt(3, Integer.parseInt(txtEdadLimSup.getText()));
                pstmt.setString(4, txtIdEtapa.getText());

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
            JOptionPane.showMessageDialog(this, "La edad debe ser un número válido.");
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
        SwingUtilities.invokeLater(() -> new moddesarrollofisico().setVisible(true));
    }
}
