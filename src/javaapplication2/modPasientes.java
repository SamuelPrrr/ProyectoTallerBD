package javaapplication2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;

public class modPasientes extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField[] textFields; // Array de JTextField
    private JButton btnCargar, btnGuardar, btnVolver; // Agregado botón "Volver"
    private Connection conn;

    public modPasientes() {
        setTitle("Pacientes");
        setSize(950, 500); // Ajustamos el tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);  // Centrar ventana
        
        // Botón "Volver"
        btnVolver = new JButton("Volver");
        btnVolver.setBounds(800, 10, 100, 25); // Ubicar en la esquina superior derecha
        add(btnVolver);

        // Configurar la tabla
        tableModel = new DefaultTableModel(new Object[]{
            "ID Paciente", "Nombre", "Año Ingreso", "Edad", "Sexo", "ID Ciudad", "ID Etapa Vida", "Celular"
        }, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 750, 150);
        add(scrollPane);

        // Botones
        btnCargar = new JButton("Modificar");
        btnCargar.setBounds(20, 180, 100, 25);
        add(btnCargar);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(130, 180, 100, 25);
        add(btnGuardar);

        // Crear y configurar los JTextFields y sus Labels
        String[] labels = {"ID Paciente", "Nombre", "Año Ingreso", "Edad", "Sexo", "ID Ciudad", "ID Etapa Vida", "Celular"};
        textFields = new JTextField[8]; // Inicializar el array de JTextField

        int yPosition = 220; // Posición vertical inicial
        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            label.setBounds(20, yPosition, 120, 20); // Etiqueta en la columna izquierda
            add(label);

            textFields[i] = new JTextField();
            textFields[i].setBounds(150, yPosition, 200, 25); // Colocar el campo de texto a la derecha de la etiqueta
            if (i == 0) {
                textFields[i].setEditable(false); // Solo el campo ID no es editable
            } else {
                textFields[i].setEditable(true); // Habilitar edición para los demás campos
            }
            add(textFields[i]);

            yPosition += 30; // Incrementar la posición vertical para el siguiente par de etiqueta y campo
        }

        // Ajustar el tamaño de los campos de texto para que quepan mejor
        textFields[1].setPreferredSize(new java.awt.Dimension(200, 25)); // Nombre
        textFields[2].setPreferredSize(new java.awt.Dimension(100, 25)); // Año Ingreso
        textFields[3].setPreferredSize(new java.awt.Dimension(50, 25)); // Edad
        textFields[4].setPreferredSize(new java.awt.Dimension(100, 25)); // Sexo
        textFields[5].setPreferredSize(new java.awt.Dimension(100, 25)); // ID Ciudad
        textFields[6].setPreferredSize(new java.awt.Dimension(100, 25)); // ID Etapa Vida
        textFields[7].setPreferredSize(new java.awt.Dimension(100, 25)); // Celular

        conectarBaseDatos();
        cargarDatosTabla();

        btnCargar.addActionListener(e -> cargarDatosSeleccionados());
        btnGuardar.addActionListener(e -> guardarCambios());

        // Acción del botón "Volver"
        btnVolver.addActionListener(e -> {
            new MODIFICAR().setVisible(true); // Cambia a la ventana anterior que tengas
            dispose();
        });

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
        String query = "SELECT * FROM pacientes";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            tableModel.setRowCount(0);  // Limpiar la tabla

            while (rs.next()) {
                tableModel.addRow(new Object[]{
                    rs.getString("idPaciente"),
                    rs.getString("nombre"),
                    rs.getInt("año_ingreso"),
                    rs.getInt("edad"),
                    rs.getString("sexo"),
                    rs.getString("idCiudad"),
                    rs.getString("idEtapaVida"),
                    rs.getString("celular")
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
            for (int i = 0; i < textFields.length; i++) {
                textFields[i].setText(tableModel.getValueAt(filaSeleccionada, i).toString());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila.");
        }
    }

    private void guardarCambios() {
        // Comprobar si los campos obligatorios están llenos
        for (int i = 1; i < textFields.length; i++) { // Comienza desde 1 para omitir el ID
            if (textFields[i].getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
                return;
            }
        }

        try {
            String query = "UPDATE pacientes SET nombre=?, año_ingreso=?, edad=?, sexo=?, idCiudad=?, idEtapaVida=?, celular=? WHERE idPaciente=?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, textFields[1].getText());
                pstmt.setInt(2, Integer.parseInt(textFields[2].getText()));
                pstmt.setInt(3, Integer.parseInt(textFields[3].getText()));
                pstmt.setString(4, textFields[4].getText());
                pstmt.setString(5, textFields[5].getText());
                pstmt.setString(6, textFields[6].getText());
                pstmt.setString(7, textFields[7].getText());
                pstmt.setString(8, textFields[0].getText()); // ID Paciente

                int filasAfectadas = pstmt.executeUpdate();
                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(this, "Datos actualizados correctamente.");
                    cargarDatosTabla();  // Refrescar la tabla
                } else {
                    JOptionPane.showMessageDialog(this, "Error al actualizar los datos.");
                }
            }
        } catch (SQLException | NumberFormatException e) {
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
        SwingUtilities.invokeLater(() -> new modPasientes().setVisible(true));
    }
}
