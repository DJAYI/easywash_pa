/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.views.clients;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author jacob
 */
public class MainClientView extends javax.swing.JFrame {

    /**
     * Creates new form MainClientView1
     */
    public MainClientView() {
        initComponents();
        setLocationRelativeTo(null);// Centrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Cerrar aplicacion al salir

        if (btnTengoCuenta == null || btnNoTengoCuenta == null) {
            JOptionPane.showMessageDialog(this, "Error: Botones no inicializados", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Metodos para controlar los listener
    public void setLoginListener(java.awt.event.ActionListener listener) {
        if (btnTengoCuenta == null) {
            throw new IllegalStateException("btnTengoCuenta no ha sido inicializado");
        }
        btnTengoCuenta.addActionListener(listener);
    }

    public void setRegisterListener(java.awt.event.ActionListener listener) {
        if (btnNoTengoCuenta == null) {
            throw new IllegalStateException("btnNoTengoCuenta no ha sido inicializado");
        }
        btnNoTengoCuenta.addActionListener(listener);
    }

    public void close() {
        this.dispose();
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TextTitulo = new javax.swing.JLabel();
        TextRegistrado = new javax.swing.JLabel();
        btnTengoCuenta = new javax.swing.JButton();
        btnNoTengoCuenta = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 750, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 40));

        TextTitulo.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        TextTitulo.setText("¡Hola! Bienvenido al Sistema ");
        jPanel1.add(TextTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        TextRegistrado.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        TextRegistrado.setText("¿Estas Registrado?");
        jPanel1.add(TextRegistrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        btnTengoCuenta.setBackground(new java.awt.Color(51, 255, 51));
        btnTengoCuenta.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        btnTengoCuenta.setText("Tengo Cuenta");
        btnTengoCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTengoCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTengoCuentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnTengoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, 140, 50));

        btnNoTengoCuenta.setBackground(new java.awt.Color(255, 204, 102));
        btnNoTengoCuenta.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        btnNoTengoCuenta.setText("No Tengo Cuenta");
        btnNoTengoCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btnNoTengoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 140, 50));

        jLabel2.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel2.setText("de Gestion de Citas EasyWash");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/IconAgregarUsuario (1).png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 200, 220));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/IconRegister (1).png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 206, 190, 200));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/EasyWash_transparente_v2.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 430, 280));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/EasyWash5 (1).jpg"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 36, 380, 470));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTengoCuentaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTengoCuentaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnTengoCuentaActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }// GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel1MouseEntered
        jLabel1.setBackground(Color.red);
        jLabel1.setForeground(Color.white);
    }// GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel1MouseExited
        jLabel1.setBackground(Color.WHITE);
        jLabel1.setForeground(Color.BLACK);
    }// GEN-LAST:event_jLabel1MouseExited

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
            java.util.logging.Logger.getLogger(MainClientView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainClientView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainClientView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainClientView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainClientView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TextRegistrado;
    private javax.swing.JLabel TextTitulo;
    private javax.swing.JButton btnNoTengoCuenta;
    private javax.swing.JButton btnTengoCuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
