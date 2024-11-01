package javaapplication2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.*;

public class modfacturas extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField txtIdFactura, txtFecha, txtHora, txtIdHosp, txtIdPaciente, txtSubtotal, txtIva, txtTotal;
    private JButton btnCargar, btnGuardar, btnVolver;
    private Connection conn;

    public modfacturas() {
        setTitle("Facturas");
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

        tableModel = new DefaultTableModel(new Object[]{"ID Factura", "Fecha", "Hora", "ID Hosp", "ID Paciente", "Subtotal", "IVA", "Total"}, 0);
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

        JLabel lblIdFactura = new JLabel("ID Factura:");
        lblIdFactura.setBounds(20, 320, 150, 25);
        add(lblIdFactura);

        txtIdFactura = new JTextField();
        txtIdFactura.setBounds(170, 320, 250, 30);
        txtIdFactura.setEditable(false);  // No editable
        add(txtIdFactura);

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(20, 360, 150, 25);
        add(lblFecha);
        txtFecha = new JTextField();
        txtFecha.setBounds(170, 360, 250, 30);
        add(txtFecha);

        JLabel lblHora = new JLabel("Hora:");
        lblHora.setBounds(20, 400, 150, 25);
        add(lblHora);
        txtHora = new JTextField();
        txtHora.setBounds(170, 400, 250, 30);
        add(txtHora);

        JLabel lblIdHosp = new JLabel("ID Hosp:");
        lblIdHosp.setBounds(20, 440, 150, 25);
        add(lblIdHosp);
        txtIdHosp = new JTextField();
        txtIdHosp.setBounds(170, 440, 250, 30);
        add(txtIdHosp);

        JLabel lblIdPaciente = new JLabel("ID Paciente:");
        lblIdPaciente.setBounds(20, 480, 150, 25);
        add(lblIdPaciente);
        txtIdPaciente = new JTextField();
        txtIdPaciente.setBounds(170, 480, 250, 30);
        add(txtIdPaciente);

        JLabel lblSubtotal = new JLabel("Subtotal:");
        lblSubtotal.setBounds(450, 320, 150, 25);
        add(lblSubtotal);
        txtSubtotal = new JTextField();
        txtSubtotal.setBounds(570, 320, 150, 30);
        add(txtSubtotal);

        JLabel lblIva = new JLabel("IVA:");
        lblIva.setBounds(450, 360, 150, 25);
        add(lblIva);
        txtIva = new JTextField();
        txtIva.setBounds(570, 360, 150, 30);
        add(txtIva);

        JLabel lblTotal = new JLabel("Total:");
        lblTotal.setBounds(450, 400, 150, 25);
        add(lblTotal);
        txtTotal = new JTextField();
        txtTotal.setBounds(570, 400, 150, 30);
        add(txtTotal);

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
        String query = "SELECT * FROM facturas";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            tableModel.setRowCount(0);  // Limpiar la tabla

            while (rs.next()) {
                tableModel.addRow(new Object[]{
                        rs.getString("idFactura"),
                        rs.getDate("fecha"),
                        rs.getTime("hora"),
                        rs.getString("idHosp"),
                        rs.getString("idPaciente"),
                        rs.getBigDecimal("subtotal"),
                        rs.getBigDecimal("iva"),
                        rs.getBigDecimal("total")
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
            txtIdFactura.setText(tableModel.getValueAt(filaSeleccionada, 0).toString());
            txtFecha.setText(tableModel.getValueAt(filaSeleccionada, 1).toString());
            txtHora.setText(tableModel.getValueAt(filaSeleccionada, 2).toString());
            txtIdHosp.setText(tableModel.getValueAt(filaSeleccionada, 3).toString());
            txtIdPaciente.setText(tableModel.getValueAt(filaSeleccionada, 4).toString());
            txtSubtotal.setText(tableModel.getValueAt(filaSeleccionada, 5).toString());
            txtIva.setText(tableModel.getValueAt(filaSeleccionada, 6).toString());
            txtTotal.setText(tableModel.getValueAt(filaSeleccionada, 7).toString());
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila.");
        }
    }

    private void guardarCambios() {
        if (txtFecha.getText().isEmpty() || txtHora.getText().isEmpty() || txtIdHosp.getText().isEmpty() ||
            txtIdPaciente.getText().isEmpty() || txtSubtotal.getText().isEmpty() || txtIva.getText().isEmpty() || txtTotal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
            return;
        }

        try {
            String query = "UPDATE facturas SET fecha=?, hora=?, idHosp=?, idPaciente=?, subtotal=?, iva=?, total=? WHERE idFactura=?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setDate(1, Date.valueOf(txtFecha.getText()));  // Asumiendo que el formato es yyyy-mm-dd
                pstmt.setTime(2, Time.valueOf(txtHora.getText()));      // Asumiendo que el formato es hh:mm:ss
                pstmt.setString(3, txtIdHosp.getText());
                pstmt.setString(4, txtIdPaciente.getText());
                pstmt.setBigDecimal(5, new BigDecimal(txtSubtotal.getText()));
                pstmt.setBigDecimal(6, new BigDecimal(txtIva.getText()));
                 double subtotall = Double.parseDouble(txtSubtotal.getText());
            double ivaa = Double.parseDouble(txtIva.getText()) / 100;
            double ivaaa = subtotall * ivaa;
            double total  = subtotall + ivaaa;
                pstmt.setDouble(7, total);
                pstmt.setString(8, txtIdFactura.getText());  // ID que no se puede modificar

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
        SwingUtilities.invokeLater(() -> new modfacturas().setVisible(true));
    }
}
