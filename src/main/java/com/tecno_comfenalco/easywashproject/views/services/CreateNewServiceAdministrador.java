/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.views.services;

import java.time.Duration;

import javax.swing.JFrame;

import com.tecno_comfenalco.easywashproject.controllers.ServiceController;
import com.tecno_comfenalco.easywashproject.models.Service;

/**
 *
 * @author jacob
 */
public class CreateNewServiceAdministrador extends javax.swing.JFrame {

    /**
     * Creates new form CreateNewServiceAdministrador1
     */
    public CreateNewServiceAdministrador() {
        initComponents();
        setLocationRelativeTo(null); // Centra la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // No cerrar toda la app
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        labelCreateNewService = new javax.swing.JLabel();
        labelNameService = new javax.swing.JLabel();
        labelPriceService = new javax.swing.JLabel();
        labelDescriptionService = new javax.swing.JLabel();
        textFieldPriceService = new javax.swing.JTextField();
        textFieldNameService = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaDescriptionService = new javax.swing.JTextArea();
        btnCreateService = new javax.swing.JButton();
        textFieldDurationService = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelCreateNewService.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        labelCreateNewService.setText("Crear un Nuevo Servicio");
        bg.add(labelCreateNewService, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        labelNameService.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        labelNameService.setText("Nombre del Servicio");
        bg.add(labelNameService, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        labelPriceService.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        labelPriceService.setText("Precio");
        bg.add(labelPriceService, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, -1, -1));

        labelDescriptionService.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        labelDescriptionService.setText("Concepto");
        bg.add(labelDescriptionService, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, -1));

        textFieldPriceService.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        textFieldPriceService.setText("Ingresa el precio");
        bg.add(textFieldPriceService, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 280, 40));

        textFieldNameService.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        textFieldNameService.setText("Ingresa el nombre del servicio");
        bg.add(textFieldNameService, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 142, 280, 40));

        textFieldDurationService.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        textFieldDurationService.setText("Ingresa la duración del servicio");
        bg.add(textFieldDurationService, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 280, 40));

        textAreaDescriptionService.setColumns(20);
        textAreaDescriptionService.setRows(5);
        jScrollPane1.setViewportView(textAreaDescriptionService);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 640, -1));

        btnCreateService.setBackground(new java.awt.Color(153, 153, 153));
        btnCreateService.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        btnCreateService.setText("Crear");
        btnCreateService.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bg.add(btnCreateService, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 373, 220, 50));

        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        btnCreateService.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateServiceActionPerformed(evt);
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateNewServiceAdministrador.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateNewServiceAdministrador.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateNewServiceAdministrador.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateNewServiceAdministrador.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateNewServiceAdministrador().setVisible(true);
            }
        });
    }

    private void btnCreateServiceActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Duration duration = Duration.ofMinutes(Integer.parseInt(textFieldDurationService.getText()));
            String name = textFieldNameService.getText();
            double price = Double.parseDouble(textFieldPriceService.getText());
            String description = textAreaDescriptionService.getText();
            // Aquí puedes agregar la lógica para crear el servicio
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Por favor ingresa valores numéricos válidos para el precio y la duración.", "Error de entrada",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error: " + ex.getMessage(), "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }

        // Aquí puedes agregar la lógica para crear el servicio
        ServiceController serviceController = new ServiceController();
        serviceController.createService(new Service(
                textFieldNameService.getText(),
                Double.parseDouble(textFieldPriceService.getText()),
                textAreaDescriptionService.getText(),
                Duration.ofMinutes(Integer.parseInt(textFieldDurationService.getText()))));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnCreateService;
    private javax.swing.JLabel labelCreateNewService;
    private javax.swing.JLabel labelNameService;
    private javax.swing.JLabel labelPriceService;
    private javax.swing.JLabel labelDescriptionService;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textAreaDescriptionService;
    private javax.swing.JTextField textFieldPriceService;
    private javax.swing.JTextField textFieldNameService;
    private javax.swing.JTextField textFieldDurationService;
    // End of variables declaration//GEN-END:variables
}
