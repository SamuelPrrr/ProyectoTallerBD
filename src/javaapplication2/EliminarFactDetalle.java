package javaapplication2;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;

public class EliminarFactDetalle extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnCargar, btnEliminar;

    private Connection conn;

    public EliminarFactDetalle() {
        // Configuración del JFrame
        setTitle("Detalle de Facturas");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Crear y configurar la tabla
        tableModel = new DefaultTableModel(new Object[]{"ID Factura", "ID Concepto", "Cantidad", "Precio Unitario", "Subtotal Concepto", "IVA", "Total Concepto", "ID Doctor"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 540, 200);
        add(scrollPane);

        // Agregar botones
        btnCargar = new JButton("Cargar");
        btnCargar.setBounds(20, 230, 100, 25);
        add(btnCargar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(130, 230, 100, 25);
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
            String query = "SELECT * FROM factdetalle";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Limpiar la tabla
            tableModel.setRowCount(0);

            // Llenar la tabla con los datos de la base
            while (rs.next()) {
                String idFactura = rs.getString("IdFactura");
                String idConcepto = rs.getString("idConcepto");
                int cant = rs.getInt("cant");
                int precioUnit = rs.getInt("precioUnit");
                int subtotalConcept = rs.getInt("subtotalConcept");
                double iva = rs.getDouble("iva");
                double totalConc = rs.getDouble("totalConc");
                String idDoctor = rs.getString("idDoctor");
                tableModel.addRow(new Object[]{idFactura, idConcepto, cant, precioUnit, subtotalConcept, iva, totalConc, idDoctor});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar el registro seleccionado
    private void eliminarRegistro() {
        int filaSeleccionada = table.getSelectedRow();
        if (filaSeleccionada != -1) {
            String idFactura = tableModel.getValueAt(filaSeleccionada, 0).toString();
            String idConcepto = tableModel.getValueAt(filaSeleccionada, 1).toString();
            try {
                String query = "DELETE FROM factdetalle WHERE IdFactura=? AND idConcepto=?";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, idFactura);
                pstmt.setString(2, idConcepto);

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
                new EliminarFactDetalle().setVisible(true);
            }
        });
    }
}
