package javaapplication2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;

public class modhospi extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField[] textFields; // Array de JTextField
    private JButton btnCargar, btnGuardar, btnVolver;
    private Connection conn;

    public modhospi() {
        // Configurar el JFrame
        setTitle("Hospitales");
        setSize(800, 600);  // Tamaño más grande
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Crear y configurar la tabla
        tableModel = new DefaultTableModel(new Object[]{"ID", "Nombre", "Tipo", "ID Ciudad"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 640, 200);  // Ajuste de tamaño
        add(scrollPane);

        // Botón Volver
        btnVolver = new JButton("Volver");
        btnVolver.setBounds(680, 10, 100, 30);  // Posición ajustada
        btnVolver.addActionListener(e -> {
            new MODIFICAR().setVisible(true);
            dispose();
        });
        add(btnVolver);

        btnCargar = new JButton("Modificar");
        btnCargar.setBounds(20, 240, 120, 30);
        btnCargar.addActionListener(e -> cargarDatosSeleccionados()); // Cargar datos seleccionados
        add(btnCargar);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(160, 240, 120, 30);
        btnGuardar.addActionListener(e -> guardarCambios()); // Guardar cambios
        add(btnGuardar);

        // Crear y configurar los JTextFields y sus Labels
        String[] labels = {"ID", "Nombre", "Tipo", "ID Ciudad"};
        textFields = new JTextField[4]; // Inicializar el array de JTextField

        int yPosition = 300; // Posición vertical inicial
        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            label.setBounds(20, yPosition, 100, 20); // Etiqueta en la columna izquierda
            add(label);

            textFields[i] = new JTextField();
            textFields[i].setBounds(140, yPosition, 200, 30); // Colocar el campo de texto a la derecha de la etiqueta
            textFields[i].setEditable(i != 0); // Solo el campo ID no es editable
            add(textFields[i]);

            yPosition += 40; // Incrementar la posición vertical para el siguiente par de etiqueta y campo
        }

        conectarBaseDatos();
        cargarDatosTabla();

        // Agregar evento de selección de fila
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cargarDatosSeleccionados(); // Cargar datos al hacer clic en una fila
            }
        });
    }

    private void conectarBaseDatos() {
        try {
            String url = "jdbc:mysql://localhost:3306/Hospitales";
            String user = "samuel";
            String password = "password";
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.");
        }
    }

    private void cargarDatosTabla() {
        try {
            String query = "SELECT * FROM hospitales";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            tableModel.setRowCount(0); // Limpiar la tabla

            while (rs.next()) {
                String id = rs.getString("idHosp");
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                String idCiudad = rs.getString("idCiudad");
                tableModel.addRow(new Object[]{id, nombre, tipo, idCiudad});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos.");
        }
    }

    private void cargarDatosSeleccionados() {
        int filaSeleccionada = table.getSelectedRow();
        if (filaSeleccionada != -1) {
            textFields[0].setText(tableModel.getValueAt(filaSeleccionada, 0).toString());
            textFields[1].setText(tableModel.getValueAt(filaSeleccionada, 1).toString());
            textFields[2].setText(tableModel.getValueAt(filaSeleccionada, 2).toString());
            textFields[3].setText(tableModel.getValueAt(filaSeleccionada, 3).toString());
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila.");
        }
    }

    private void guardarCambios() {
        try {
            String id = textFields[0].getText();
            String nombre = textFields[1].getText();
            String tipo = textFields[2].getText();
            String idCiudad = textFields[3].getText();

            String query = "UPDATE hospitales SET nombre=?, tipo=?, idCiudad=? WHERE idHosp=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nombre);
            pstmt.setString(2, tipo);
            pstmt.setString(3, idCiudad);
            pstmt.setString(4, id);

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(this, "Datos actualizados correctamente.");
                cargarDatosTabla(); // Recargar datos para mostrar cambios
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar los datos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar los cambios.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new modhospi().setVisible(true));
    }
}
