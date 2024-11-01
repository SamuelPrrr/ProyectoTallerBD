package javaapplication2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;

public class modestados extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField[] textFields; // Array de JTextField
    private JButton btnCargar, btnGuardar, btnVolver;
    private Connection conn;

    public modestados() {
        // Configurar el JFrame
        setTitle("Estados");
        setSize(800, 600);  // Tamaño más grande
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Crear y configurar la tabla
        tableModel = new DefaultTableModel(new Object[]{"ID Estado", "Nombre"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 50, 640, 130);  // Ajuste de tamaño
        add(scrollPane);

        // Botón Volver
        btnVolver = new JButton("Volver");
        btnVolver.setBounds(680, 10, 100, 30);  // Posición ajustada
        btnVolver.addActionListener(e -> {
            new MODIFICAR().setVisible(true); // Cambiar según la clase anterior
            dispose();
        });
        add(btnVolver);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(150, 200, 100, 30);
        btnGuardar.addActionListener(e -> guardarCambios()); // Guardar cambios
        add(btnGuardar);

        // Crear y configurar los JTextFields y sus Labels
        String[] labels = {"ID Estado", "Nombre"};
        textFields = new JTextField[2]; // Inicializar el array de JTextField

        int yPosition = 250; // Posición vertical inicial
        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            label.setBounds(20, yPosition, 100, 20); // Etiqueta en la columna izquierda
            add(label);

            textFields[i] = new JTextField();
            textFields[i].setBounds(100, yPosition, 200, 30); // Colocar el campo de texto a la derecha de la etiqueta
            
            // Hacer el campo ID Estado no editable
            if (i == 0) {
                textFields[i].setEditable(false); // No permitir edición del ID Estado
            } else {
                textFields[i].setEditable(true); // Permitir edición del Nombre
            }

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
            String url = "jdbc:mysql://localhost:3306/Hospitales"; // Cambia el nombre de la base de datos
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
            String query = "SELECT * FROM estados"; // Cambia el nombre de la tabla si es necesario
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            tableModel.setRowCount(0); // Limpiar la tabla

            while (rs.next()) {
                String idEstado = rs.getString("idEstado");
                String nombre = rs.getString("nombre");
                tableModel.addRow(new Object[]{idEstado, nombre});
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
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila.");
        }
    }

    private void guardarCambios() {
        try {
            String idEstado = textFields[0].getText(); // ID Estado no editable
            String nombre = textFields[1].getText();

            String query = "UPDATE estados SET nombre=? WHERE idEstado=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nombre);
            pstmt.setString(2, idEstado); // Usar el ID existente

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
        SwingUtilities.invokeLater(() -> new modestados().setVisible(true));
    }
}
