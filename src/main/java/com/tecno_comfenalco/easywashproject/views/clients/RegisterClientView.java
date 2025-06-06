/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.views.clients;

import com.tecno_comfenalco.easywashproject.enums.EnumDocType;
import com.tecno_comfenalco.easywashproject.models.Client;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.ClientRepositoryImpl;
import com.tecno_comfenalco.easywashproject.views.auth.LoginClienteView;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author jacob
 */
public class RegisterClientView extends javax.swing.JFrame {

    /**
     * Creates new form RegisterClientView1
     */
    public RegisterClientView() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // No cierra toda la app
        loadDocumentTypes();
    }

    public String getNombre() {
        return NombreSave.getText().trim();
    }

    public String getTipoDocumento() {
        return comboDocumentType.getSelectedItem().toString();
    }

    public String getDocumento() {
        return DocumentoSave.getText().trim();
    }

    public String getTelefono() {
        return NumberPhoneSave.getText().trim();
    }

    public String getCorreo() {
        return DocumentoSave.getText().trim();
    }

    public void setRegisterListener(ActionListener listener) {
        btnRegistrar.addActionListener(listener);
    }

    public void setCancelListener(ActionListener listener) {
        btnCancelar.addActionListener(listener);
    }

    public void showError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void showSuccess(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Exito", JOptionPane.INFORMATION_MESSAGE);
    }

    private void loadDocumentTypes() {
        comboDocumentType.setModel(new DefaultComboBoxModel<>(EnumDocType.getDescripciones()));
    }

    private void limpiarCampos() {
        NombreSave.setText("");
        comboDocumentType.setSelectedIndex(0);
        DocumentoSave.setText("");
        NumberPhoneSave.setText("");
        DocumentoSave.setText("");
        correoSave.setText("");
    }

    public void close() {
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        BarraSuperior = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Titulo = new javax.swing.JLabel();
        PrimerParametro = new javax.swing.JLabel();
        TercerParametro = new javax.swing.JLabel();
        QuintoParametro = new javax.swing.JLabel();
        SegundoParametro = new javax.swing.JLabel();
        CuartoParametro = new javax.swing.JLabel();
        NumberPhoneSave = new javax.swing.JTextField();
        NombreSave = new javax.swing.JTextField();
        DocumentoSave = new javax.swing.JTextField();
        correoSave = new javax.swing.JTextField();
        comboDocumentType = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BarraSuperior.setBackground(new java.awt.Color(153, 153, 153));

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

        javax.swing.GroupLayout BarraSuperiorLayout = new javax.swing.GroupLayout(BarraSuperior);
        BarraSuperior.setLayout(BarraSuperiorLayout);
        BarraSuperiorLayout.setHorizontalGroup(
            BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraSuperiorLayout.createSequentialGroup()
                .addGap(0, 749, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        BarraSuperiorLayout.setVerticalGroup(
            BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bg.add(BarraSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 40));

        Titulo.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        Titulo.setText("Registro de Nuevo Cliente");
        bg.add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, -1));

        PrimerParametro.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        PrimerParametro.setText("Nombre Completo");
        bg.add(PrimerParametro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        TercerParametro.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        TercerParametro.setText("Numero de Documento");
        bg.add(TercerParametro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));

        QuintoParametro.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        QuintoParametro.setText("Correo");
        bg.add(QuintoParametro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, -1, -1));

        SegundoParametro.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        SegundoParametro.setText("Tipo de Documento");
        bg.add(SegundoParametro, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, -1, -1));

        CuartoParametro.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        CuartoParametro.setText("Numero de Telefono");
        bg.add(CuartoParametro, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, -1, -1));

        NumberPhoneSave.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        NumberPhoneSave.setText("Ingrese su numero de telefono");
        bg.add(NumberPhoneSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 220, 40));

        NombreSave.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        NombreSave.setText("Ingrese nombre completo");
        bg.add(NombreSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 220, 40));

        DocumentoSave.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        DocumentoSave.setText("Ingrese su numero de documento");
        bg.add(DocumentoSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 220, 40));

        correoSave.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        correoSave.setText("Ingrese su correo");
        bg.add(correoSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 220, 40));

        comboDocumentType.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        comboDocumentType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cedula de Ciudadanía", "Tarjeta de Identidad", "Cedula Extranjeria", "Pasaporte", "Permiso Provisional de permanencia" }));
        bg.add(comboDocumentType, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 220, 40));

        btnCancelar.setBackground(new java.awt.Color(153, 153, 153));
        btnCancelar.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        bg.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 140, 40));

        btnRegistrar.setBackground(new java.awt.Color(153, 153, 153));
        btnRegistrar.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        bg.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 140, 40));

        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        jLabel1.setBackground(Color.red);
        jLabel1.setForeground(Color.white);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        jLabel1.setBackground(Color.WHITE);
        jLabel1.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel1MouseExited

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRegistrarActionPerformed
        // Metodo para registrar nuevo cliente

        // 1. Obtengo la información de los campos ✅
        String nombreCompleto = NombreSave.getText();
        String tipoDocumento = (String) comboDocumentType.getSelectedItem();
        String numeroDocumento = DocumentoSave.getText();
        String numeroTelefono = NumberPhoneSave.getText();
        String correo = correoSave.getText();

        // 1.1 Valido que los campos no estén vacíos ✅
        if (nombreCompleto.isEmpty() || numeroDocumento.isEmpty() || numeroTelefono.isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 1.2 Valido que el correo electronico sea valido ("xyz@xyz.com") con el uso de
        // regex
        if (!correo.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            JOptionPane.showMessageDialog(this, "Correo electrónico no válido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 2. Guardar la información del usuario
        try {

            // 2.1 Transformar el valor seleccionado del combo box a un Enum
            EnumDocType docType = EnumDocType.fromDescripcion(tipoDocumento);

            // 2.2 Instanciar un nuevo usuario pasandole en
            // los parámetros del constructor los valores recuperados de los campos
            Client client = new Client(List.of(), nombreCompleto, docType, numeroDocumento, numeroTelefono, correo);

            // 2.3 Instanciar un nuevo objeto de tipo ClientRepository
            ClientRepositoryImpl clientRepositoryImpl = new ClientRepositoryImpl();

            // 2.4 Uso el metodo para guardar el cliente en JSON
            clientRepositoryImpl.create(client);

            // 2.5 Muestro un mensaje de exito
            JOptionPane.showMessageDialog(this, "Cliente registrado exitosamente", "Exito",
                    JOptionPane.INFORMATION_MESSAGE);

            // 2.6 Limpio los campos
            limpiarCampos();

            // 2.6.1 Ocultar la vista actual y mostrar la siguiente
            this.setVisible(false);
            new LoginClienteView().setVisible(true);
        } catch (IllegalArgumentException e) {
            // 2.7 Exepcion para cuando el tipo de documento no sea valido
            JOptionPane.showMessageDialog(this, "Tipo de documento no valido", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {

            // 2.8 Exepción para cuando haya un error al registrar un cliente
            JOptionPane.showMessageDialog(this, "Error al registrar el cliente" + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }// GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterClientView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterClientView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterClientView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterClientView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterClientView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraSuperior;
    private javax.swing.JLabel CuartoParametro;
    private javax.swing.JTextField DocumentoSave;
    private javax.swing.JTextField NombreSave;
    private javax.swing.JTextField NumberPhoneSave;
    private javax.swing.JLabel PrimerParametro;
    private javax.swing.JLabel QuintoParametro;
    private javax.swing.JLabel SegundoParametro;
    private javax.swing.JLabel TercerParametro;
    private javax.swing.JLabel Titulo;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> comboDocumentType;
    private javax.swing.JTextField correoSave;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
