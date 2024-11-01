/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication2;
import java.awt.Color;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author samuel
 */
public class INSERTAR extends javax.swing.JFrame {
    private static Connection con;
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String user = "samuel";
    private static final String password = "password";
    private static final String url = "jdbc:mysql://127.0.0.1/Hospitales";
    
    public void conector(){
    con = null;
    try{
        Class.forName(driver);
        con = (Connection) DriverManager.getConnection(url, user, password);
        if(con!=null){
            
        }
    }
    catch(ClassNotFoundException | SQLException e){
        JOptionPane.showMessageDialog(null, "Hubo un error en la Base de datos");
    }
    }
    /**
     * Creates new form INSERTAR
     */
    public INSERTAR() {
        initComponents();
        JPanelImage fondoImg = new JPanelImage(fondo, "img/background.jpg");
        fondo.add(fondoImg).repaint();
        fondo.setOpaque(false);
        fondo.setBorder(null);
        fondo.setBackground(new Color(0,0,0,0));
        JPanelImage imagen2 = new JPanelImage(jPanel2, "img/nurse.jpg");
        jPanel2.add(imagen2).repaint();
        jPanel2.setOpaque(false);
        jPanel2.setBorder(null);
        jPanel2.setBackground(new Color(0,0,0,0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Volver = new javax.swing.JButton();
        doctoresBttn = new javax.swing.JButton();
        hospitalesBttn = new javax.swing.JButton();
        pacientes = new javax.swing.JButton();
        ciudades = new javax.swing.JButton();
        estados = new javax.swing.JButton();
        etapa = new javax.swing.JButton();
        conceptos = new javax.swing.JButton();
        facturas = new javax.swing.JButton();
        facturasDeta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Yrsa SemiBold", 1, 24)); // NOI18N
        jLabel1.setText("REGISTRO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );

        Volver.setText("Volver");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });

        doctoresBttn.setText("DOCTORES");
        doctoresBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctoresBttnActionPerformed(evt);
            }
        });

        hospitalesBttn.setText("HOSPITALES");
        hospitalesBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hospitalesBttnActionPerformed(evt);
            }
        });

        pacientes.setText("PACIENTES");
        pacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pacientesActionPerformed(evt);
            }
        });

        ciudades.setText("CIUDADES");
        ciudades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ciudadesActionPerformed(evt);
            }
        });

        estados.setText("ESTADOS");
        estados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadosActionPerformed(evt);
            }
        });

        etapa.setText("ETAPA");
        etapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etapaActionPerformed(evt);
            }
        });

        conceptos.setText("CONCEPTO");
        conceptos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conceptosActionPerformed(evt);
            }
        });

        facturas.setText("FACTURAS");
        facturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturasActionPerformed(evt);
            }
        });

        facturasDeta.setText("FACTURAS DETALLADAS");
        facturasDeta.setActionCommand("FACTURAS DETALLADAS");
        facturasDeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturasDetaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(doctoresBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hospitalesBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(estados, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ciudades, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etapa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(conceptos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(facturas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(facturasDeta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Volver))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(355, 355, 355)
                        .addComponent(jLabel1)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Volver)
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(69, 69, 69)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(hospitalesBttn)
                        .addGap(26, 26, 26)
                        .addComponent(doctoresBttn)
                        .addGap(27, 27, 27)
                        .addComponent(pacientes)
                        .addGap(18, 18, 18)
                        .addComponent(estados)
                        .addGap(18, 18, 18)
                        .addComponent(ciudades)
                        .addGap(18, 18, 18)
                        .addComponent(etapa)
                        .addGap(18, 18, 18)
                        .addComponent(conceptos))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(facturas)
                .addGap(18, 18, 18)
                .addComponent(facturasDeta)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        main nuevoFrame = new main();
        nuevoFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed

    private void doctoresBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctoresBttnActionPerformed
        POSTDOCTORES nuevoFrame = new POSTDOCTORES();
        nuevoFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_doctoresBttnActionPerformed

    private void hospitalesBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hospitalesBttnActionPerformed
        POSTHOSPITAL nuevoFrame = new POSTHOSPITAL();
        nuevoFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_hospitalesBttnActionPerformed

    private void pacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pacientesActionPerformed
        POSTPACIENTES nuevoFrame = new POSTPACIENTES();
        nuevoFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_pacientesActionPerformed

    private void ciudadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ciudadesActionPerformed
       POSTCIUDADES nuevoFrame = new POSTCIUDADES();
        nuevoFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ciudadesActionPerformed

    private void estadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadosActionPerformed
        POSTESTADOS nuevoFrame = new POSTESTADOS();
        nuevoFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_estadosActionPerformed

    private void etapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etapaActionPerformed
        POSTETAPA nuevoFrame = new POSTETAPA();
        nuevoFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_etapaActionPerformed

    private void conceptosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conceptosActionPerformed
        POSTCONCEPTOS nuevoFrame = new POSTCONCEPTOS();
        nuevoFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_conceptosActionPerformed

    private void facturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturasActionPerformed
        POSTFACTURAS nuevoFrame = new POSTFACTURAS();
        nuevoFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_facturasActionPerformed

    private void facturasDetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturasDetaActionPerformed
        POSTFACTDETALLE nuevoFrame = new POSTFACTDETALLE();
        nuevoFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_facturasDetaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(INSERTAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(INSERTAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(INSERTAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(INSERTAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new INSERTAR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Volver;
    private javax.swing.JButton ciudades;
    private javax.swing.JButton conceptos;
    private javax.swing.JButton doctoresBttn;
    private javax.swing.JButton estados;
    private javax.swing.JButton etapa;
    private javax.swing.JButton facturas;
    private javax.swing.JButton facturasDeta;
    private javax.swing.JPanel fondo;
    private javax.swing.JButton hospitalesBttn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton pacientes;
    // End of variables declaration//GEN-END:variables
}
