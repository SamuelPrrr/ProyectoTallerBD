/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EliminarCentral extends JFrame {

    public EliminarCentral() {
        // Configuración del JFrame
        setTitle("Eliminar Central");
        setSize(800, 600);  // Tamaño grande
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Botón de "Regresar" en la parte superior
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setFont(new Font("Arial", Font.BOLD, 24));  // Hacerlo grande
        btnRegresar.setPreferredSize(new Dimension(200, 50));   // Tamaño del botón
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Eliminar eliminarFrame = new Eliminar();  // Volver a la clase Eliminar
                eliminarFrame.setVisible(true);
                dispose();  // Cerrar la ventana actual
            }
        });
        add(btnRegresar, BorderLayout.NORTH);  // Ubicar en la parte superior

        // Panel con botones en la parte inferior
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(2, 4, 10, 10));  // 2 filas, 4 columnas con espacio entre botones

        // Crear los botones
        JButton btnPacientes = new JButton("Pacientes");
        JButton btnDoctores = new JButton("Doctores");
        JButton btnHospitales = new JButton("Hospitales");
        JButton btnCiudades = new JButton("Ciudades");
        JButton btnDesarrolloFisico = new JButton("Desarrollo Físico");
        JButton btnConceptos = new JButton("Conceptos");
        JButton btnFacturas = new JButton("Facturas");
        JButton btnFactDetalle = new JButton("FactDetalle");
        JButton btnEstados = new JButton("Estados");

        // Asignar acción a los botones existentes
        btnPacientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarPaciente eliminarPacienteFrame = new EliminarPaciente();
                eliminarPacienteFrame.setVisible(true);
                dispose();
            }
        });

        btnDoctores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarDoctores eliminarDoctoresFrame = new EliminarDoctores();
                eliminarDoctoresFrame.setVisible(true);
                dispose();
            }
        });

        btnHospitales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarHospitales eliminarHospitalesFrame = new EliminarHospitales();
                eliminarHospitalesFrame.setVisible(true);
                dispose();
            }
        });
        btnCiudades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarCiudades eliminarCiudadesFrame = new EliminarCiudades();
                eliminarCiudadesFrame.setVisible(true);
                dispose();
            }
        });
        
            btnConceptos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarConceptos eliminarConceptosFrame = new EliminarConceptos();
                eliminarConceptosFrame.setVisible(true);
                dispose();
            }
        });
            
                 btnDesarrolloFisico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarDesarrolloFisico eliminarDesarrolloFisicoFrame = new EliminarDesarrolloFisico();
                eliminarDesarrolloFisicoFrame.setVisible(true);
                dispose();
            }
        });
                 
                btnFacturas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarFacturas eliminarFacturasFrame = new EliminarFacturas();
                eliminarFacturasFrame.setVisible(true);
                dispose();
            }
        });
                
             btnFactDetalle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarFactDetalle eliminarFactDetalleFrame = new EliminarFactDetalle();
                eliminarFactDetalleFrame.setVisible(true);
                dispose();
            }
        });
             
                 btnEstados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarEstados1 eliminarEstadosFrame = new EliminarEstados1();
                eliminarEstadosFrame.setVisible(true);
                dispose();
            }
        });


        // Añadir los botones al panel
        panelBotones.add(btnPacientes);
        panelBotones.add(btnDoctores);
        panelBotones.add(btnHospitales);
        panelBotones.add(btnCiudades);           // Botón pendiente de asignar a una clase
        panelBotones.add(btnDesarrolloFisico);   // Botón pendiente de asignar a una clase
        panelBotones.add(btnConceptos);          // Botón pendiente de asignar a una clase
        panelBotones.add(btnFacturas);           // Botón pendiente de asignar a una clase
        panelBotones.add(btnFactDetalle);        // Botón pendiente de asignar a una clase
        panelBotones.add(btnEstados);

        // Añadir el panel de botones a la parte inferior
        add(panelBotones, BorderLayout.SOUTH);

        // Hacer visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        new EliminarCentral();  // Crear y mostrar la ventana
    }
}
