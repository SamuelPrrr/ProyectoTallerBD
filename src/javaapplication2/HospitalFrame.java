package javaapplication2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class HospitalFrame extends JFrame {

    private JTable table;
    private JTextField txtNombre;
    private JTextField txtTipo;
    private JTextField txtIdCiudad;
    private JButton btnCargar;
    private JButton btnGuardar;

    private DefaultTableModel model;
    private Connection conn;

    public HospitalFrame() {
        initComponents();
        connectDatabase();
        loadTableData();
    }

    private void initComponents() {
        // Configurando la ventana
        setTitle("Gestión de Hospitales");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Configurando la tabla
        table = new JTable();
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Tipo");
        model.addColumn("ID Ciudad");
        table.setModel(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 400, 150);
        add(scrollPane);

        // Campos de texto
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 200, 100, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(120, 200, 200, 25);
        add(txtNombre);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(20, 230, 100, 25);
        add(lblTipo);

        txtTipo = new JTextField();
        txtTipo.setBounds(120, 230, 200, 25);
        add(txtTipo);

        JLabel lblIdCiudad = new JLabel("ID Ciudad:");
        lblIdCiudad.setBounds(20, 260, 100, 25);
        add(lblIdCiudad);

        txtIdCiudad = new JTextField();
        txtIdCiudad.setBounds(120, 260, 200, 25);
        add(txtIdCiudad);

        // Botones
        btnCargar = new JButton("Cargar");
        btnCargar.setBounds(450, 50, 100, 30);
        add(btnCargar);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(450, 100, 100, 30);
        add(btnGuardar);

        // Listeners
        btnCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarDatosSeleccionados();
            }
        });

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarHospital();
            }
        });
    }

    // Conexión a la base de datos
    private void connectDatabase() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospitales", "samuel", "password");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Cargar datos de la tabla hospitales a la JTable
    private void loadTableData() {
        try {
            String query = "SELECT * FROM hospitales";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("idHosp"),
                        rs.getString("nombre"),
                        rs.getString("tipo"),
                        rs.getString("idCiudad")
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Cargar datos seleccionados a los JTextField
    private void cargarDatosSeleccionados() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            txtNombre.setText(model.getValueAt(selectedRow, 1).toString());
            txtTipo.setText(model.getValueAt(selectedRow, 2).toString());
            txtIdCiudad.setText(model.getValueAt(selectedRow, 3).toString());
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila");
        }
    }

    // Actualizar hospital en la base de datos
    private void actualizarHospital() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            try {
                String idHosp = model.getValueAt(selectedRow, 0).toString();
                String nombre = txtNombre.getText();
                String tipo = txtTipo.getText();
                String idCiudad = txtIdCiudad.getText();

                String query = "UPDATE hospitales SET nombre = ?, tipo = ?, idCiudad = ? WHERE idHosp = ?";
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setString(1, nombre);
                pst.setString(2, tipo);
                pst.setString(3, idCiudad);
                pst.setString(4, idHosp);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Datos actualizados correctamente");

                // Actualizar los datos de la tabla
                model.setValueAt(nombre, selectedRow, 1);
                model.setValueAt(tipo, selectedRow, 2);
                model.setValueAt(idCiudad, selectedRow, 3);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila para actualizar");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HospitalFrame().setVisible(true);
            }
        });
    }
}
