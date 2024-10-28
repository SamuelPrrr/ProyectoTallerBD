package javaapplication2;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;

public class EliminarPaciente extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnCargar, btnEliminar;

    private Connection conn;

    public EliminarPaciente() {
        // Configuración del JFrame
        setTitle("Pacientes");
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Crear y configurar la tabla
        tableModel = new DefaultTableModel(new Object[]{"ID Paciente", "Nombre", "Año Ingreso", "Edad", "Sexo", "ID Ciudad", "ID Etapa Vida", "Teléfono"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 540, 150);
        add(scrollPane);

        // Agregar botones
        btnCargar = new JButton("Cargar");
        btnCargar.setBounds(20, 180, 100, 25);
        add(btnCargar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(130, 180, 100, 25);
        add(btnEliminar);

        // Conectar a la base de datos y cargar la tabla
        conectarBaseDatos();
        cargarDatosTabla();

        // Añadir eventos a los botones
        btnCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarDatosTabla();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarRegistro();
            }
        });
    }

    // Método para conectar a la base de datos
    private void conectarBaseDatos() {
        try {
            String url = "jdbc:mysql://localhost:3306/hospitales?useSSL=false&serverTimezone=America/Mexico_City";
            String user = "samuel";
            String password = "password";
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.");
        }
    }

    // Método para cargar datos en la tabla
    private void cargarDatosTabla() {
        try {
            String query = "SELECT idPaciente, nombre, año_ingreso, edad, sexo, idCiudad, idEtapaVida, celular FROM pacientes";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Limpiar la tabla
            tableModel.setRowCount(0);

            // Llenar la tabla con los datos de la base
            while (rs.next()) {
                String idPaciente = rs.getString("idPaciente");
                String nombre = rs.getString("nombre");
                String anioIngreso = rs.getString("año_ingreso");
                int edad = rs.getInt("edad");
                String sexo = rs.getString("sexo");
                String idCiudad = rs.getString("idCiudad");
                String idEtapaVida = rs.getString("idEtapaVida");
                String telefono = rs.getString("celular");
                tableModel.addRow(new Object[]{idPaciente, nombre, anioIngreso, edad, sexo,idCiudad, idEtapaVida, telefono});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar el registro seleccionado
    private void eliminarRegistro() {
        int filaSeleccionada = table.getSelectedRow();
        if (filaSeleccionada != -1) {
            String idPaciente = tableModel.getValueAt(filaSeleccionada, 0).toString();
            try {
                String query = "DELETE FROM pacientes WHERE idPaciente=?";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, idPaciente);

                int filasAfectadas = pstmt.executeUpdate();
                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(this, "Registro eliminado correctamente.");
                    cargarDatosTabla();  // Refrescar los datos de la tabla
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el registro.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al eliminar el registro.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EliminarPaciente().setVisible(true);
            }
        });
    }
}