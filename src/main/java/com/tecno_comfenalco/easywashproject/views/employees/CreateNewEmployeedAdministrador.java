/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.views.employees;

import java.util.List;

import javax.swing.JFrame;

import com.tecno_comfenalco.easywashproject.controllers.EmployeeController;
import com.tecno_comfenalco.easywashproject.enums.EnumDocType;
import com.tecno_comfenalco.easywashproject.models.Employee;
import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;

import java.time.LocalTime;

import javax.swing.JOptionPane;

/**
 *
 * @author jacob
 */
public class CreateNewEmployeedAdministrador extends javax.swing.JFrame {

    private TimePicker timePickerScheduleStart;
    private TimePicker timePickerScheduleEnd;

    /**
     * Creates new form CreateNewEmployeedAdministrador1
     */
    public CreateNewEmployeedAdministrador() {
        initComponents();
        setLocationRelativeTo(null); // Centra la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // No cerrar toda la app
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        labelCreateNewEmployee = new javax.swing.JLabel();
        labelFullnameEmployee = new javax.swing.JLabel();
        labelDocumentType = new javax.swing.JLabel();
        labelDocumentNumber = new javax.swing.JLabel();
        labelPhoneNumber = new javax.swing.JLabel();
        labelEmailAddress = new javax.swing.JLabel();
        labelSalaryEmployee = new javax.swing.JLabel();
        textFieldSalary = new javax.swing.JTextField();
        textFieldFullname = new javax.swing.JTextField();
        textFieldDocumentNumber = new javax.swing.JTextField();
        textFieldEmailAddress = new javax.swing.JTextField();
        textFieldPhoneNumber = new javax.swing.JTextField();
        comboBoxDocumentType = new javax.swing.JComboBox<>();
        btnRegisterEmployee = new javax.swing.JButton();
        javax.swing.JLabel labelScheduleStart = new javax.swing.JLabel();
        javax.swing.JLabel labelScheduleEnd = new javax.swing.JLabel();

        // LGoodDatePicker TimePickers
        TimePickerSettings startSettings = new TimePickerSettings();
        startSettings.use24HourClockFormat();
        timePickerScheduleStart = new TimePicker(startSettings);

        TimePickerSettings endSettings = new TimePickerSettings();
        endSettings.use24HourClockFormat();
        timePickerScheduleEnd = new TimePicker(endSettings);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelCreateNewEmployee.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        labelCreateNewEmployee.setText("Crear un Nuevo Trabajador");
        bg.add(labelCreateNewEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        labelFullnameEmployee.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        labelFullnameEmployee.setText("Nombre Completo");
        bg.add(labelFullnameEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));

        labelDocumentType.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        labelDocumentType.setText("Tipo de Documento");
        bg.add(labelDocumentType, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, -1, -1));

        labelDocumentNumber.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        labelDocumentNumber.setText("Numero de Documento");
        bg.add(labelDocumentNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        labelPhoneNumber.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        labelPhoneNumber.setText("Numero de Telefono");
        bg.add(labelPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, -1, -1));

        labelEmailAddress.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        labelEmailAddress.setText("Correo");
        bg.add(labelEmailAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, -1, -1));

        labelSalaryEmployee.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        labelSalaryEmployee.setText("Salario");
        bg.add(labelSalaryEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, -1, -1));

        textFieldSalary.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        textFieldSalary.setText("Ingrese su salario");
        bg.add(textFieldSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, 220, 40));

        textFieldFullname.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        textFieldFullname.setText("Ingrese su nombre completo");
        bg.add(textFieldFullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 220, 40));

        textFieldDocumentNumber.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        textFieldDocumentNumber.setText("Ingrese su numero de documento");
        bg.add(textFieldDocumentNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 220, 40));

        textFieldEmailAddress.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        textFieldEmailAddress.setText("Ingrese su correo");
        bg.add(textFieldEmailAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 220, 40));

        textFieldPhoneNumber.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        textFieldPhoneNumber.setText("Ingrese su numero de telefono");
        bg.add(textFieldPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 220, 40));

        comboBoxDocumentType.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        comboBoxDocumentType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cedula de Ciudadania",
                "Tarjeta de Identidad", "Cedula Extranjeria", "Pasaporte", "Permiso Provisional de permanencia" }));
        bg.add(comboBoxDocumentType, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 132, 220, 40));

        // Schedule Start Label and Picker
        labelScheduleStart.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        labelScheduleStart.setText("Hora Inicio Jornada");
        bg.add(labelScheduleStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, -1, -1));
        bg.add(timePickerScheduleStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 220, 40));

        // Schedule End Label and Picker
        labelScheduleEnd.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        labelScheduleEnd.setText("Hora Fin Jornada");
        bg.add(labelScheduleEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, -1, -1));
        bg.add(timePickerScheduleEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, 220, 40));

        btnRegisterEmployee.setBackground(new java.awt.Color(153, 153, 153));
        btnRegisterEmployee.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        btnRegisterEmployee.setText("Registrar");
        btnRegisterEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegisterEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterEmployeeActionPerformed(evt);
            }
        });
        bg.add(btnRegisterEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 470, 160, 40));

        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterEmployeeActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String fullname = textFieldFullname.getText();
            String documentType = comboBoxDocumentType.getSelectedItem().toString();
            String documentNumber = textFieldDocumentNumber.getText();
            String phoneNumber = textFieldPhoneNumber.getText();
            String emailAddress = textFieldEmailAddress.getText();
            double salary = Double.parseDouble(textFieldSalary.getText());

            LocalTime scheduleStartTime = timePickerScheduleStart.getTime();
            LocalTime scheduleEndTime = timePickerScheduleEnd.getTime();

            // Parse LocalTime to Duration (duration between start and end)
            java.time.Duration scheduleStart = java.time.Duration.between(LocalTime.MIN, scheduleStartTime);
            java.time.Duration scheduleEnd = java.time.Duration.between(LocalTime.MIN, scheduleEndTime);

            EnumDocType docType = EnumDocType.fromDescripcion(documentType);
            if (docType == null) {
                throw new IllegalArgumentException("Tipo de documento no válido");
            }

            // Aquí puedes agregar la lógica para registrar el empleado
            EmployeeController employeeController = new EmployeeController();
            // Suponiendo que el modelo Employee tiene campos para horario de inicio y fin
            employeeController.createEmployee(
                    new Employee(
                            salary,
                            scheduleStart,
                            scheduleEnd,
                            List.of(),
                            fullname,
                            docType,
                            documentNumber,
                            phoneNumber,
                            emailAddress));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al registrar el empleado: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateNewEmployeedAdministrador.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateNewEmployeedAdministrador.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateNewEmployeedAdministrador.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateNewEmployeedAdministrador.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateNewEmployeedAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnRegisterEmployee;
    private javax.swing.JComboBox<String> comboBoxDocumentType;
    private javax.swing.JLabel labelCreateNewEmployee;
    private javax.swing.JLabel labelFullnameEmployee;
    private javax.swing.JLabel labelDocumentType;
    private javax.swing.JLabel labelDocumentNumber;
    private javax.swing.JLabel labelPhoneNumber;
    private javax.swing.JLabel labelEmailAddress;
    private javax.swing.JLabel labelSalaryEmployee;
    private javax.swing.JTextField textFieldSalary;
    private javax.swing.JTextField textFieldFullname;
    private javax.swing.JTextField textFieldDocumentNumber;
    private javax.swing.JTextField textFieldEmailAddress;
    private javax.swing.JTextField textFieldPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
