/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.views.appointments;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.TimePicker;
import com.tecno_comfenalco.easywashproject.controllers.AppointmentController;
import com.tecno_comfenalco.easywashproject.models.Client;
import com.tecno_comfenalco.easywashproject.models.Service;
import com.tecno_comfenalco.easywashproject.models.Vehicle;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.ClientRepositoryImpl;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.ServiceRepositoryImpl;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.VehicleRepositoryImpl;

/**
 *
 * @author jacob
 */
public class AgendarCitaPanel extends javax.swing.JPanel {

    private final AppointmentController appointmentController;
    private final List<Service> allServices;
    private List<Vehicle> clientVehicles;
    private final Client sessionClient;
    private final VehicleRepositoryImpl vehicleRepository = new VehicleRepositoryImpl();

    /**
     * Recibe el número de documento del cliente autenticado,
     * busca el cliente y carga solo sus vehículos en el combo box.
     */
    public AgendarCitaPanel(String documentNumber) {
        allServices = new ServiceRepositoryImpl().readAll();
        appointmentController = new AppointmentController(
                new com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.EmployeeRepositoryImpl()
                        .readAll());

        // Buscar el cliente por número de documento
        ClientRepositoryImpl clientRepo = new ClientRepositoryImpl();
        Client foundClient = clientRepo.findByDocumentNumber(documentNumber);
        this.sessionClient = foundClient;

        // Cargar solo los vehículos del cliente autenticado
        if (foundClient != null && foundClient.getVehicles() != null) {
            clientVehicles = foundClient.getVehicles();
        } else {
            clientVehicles = new java.util.ArrayList<>();
        }

        initComponents();
        customizeUI();
        addListeners();
        loadClientVehicles();
    }

    private void loadClientVehicles() {
        // Actualiza el combo de vehículos solo con los del cliente autenticado
        comboVehicles.setModel(new DefaultComboBoxModel<>(
                clientVehicles.stream()
                        .map(Vehicle::getPlate)
                        .toArray(String[]::new)));
    }

    private void customizeUI() {
        // Fondo más claro y bordes redondeados
        bg.setBackground(new Color(245, 245, 245));
        bg.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true),
                javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        btnCreateAppointment.setBackground(new Color(33, 150, 243));
        btnCreateAppointment.setForeground(Color.WHITE);
        btnCreateAppointment.setFocusPainted(false);
        btnCreateAppointment.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 10, 0));
        btnCreateAppointment.setFont(new Font("Roboto Black", Font.BOLD, 14));
    }

    private void addListeners() {
        btnCreateAppointment.addActionListener(e -> onCreateAppointment());
    }

    private void onCreateAppointment() {
        int[] selectedServiceIndices = comboServices.getSelectedIndices();
        int selectedVehicleIdx = comboVehicles.getSelectedIndex();
        LocalDate date = dateField.getDatePicker().getDate();
        LocalTime time = timePickerField.getTime();

        if (selectedServiceIndices.length == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione al menos un servicio.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (selectedVehicleIdx == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un vehículo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (date == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una fecha.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (time == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una hora.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (sessionClient == null) {
            JOptionPane.showMessageDialog(this, "Debe iniciar sesión como cliente para agendar una cita.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener el vehículo seleccionado (por placa)
        String selectedPlate = (String) comboVehicles.getSelectedItem();
        Vehicle selectedVehicle = vehicleRepository.readAll().stream()
                .filter(v -> v.getPlate().equals(selectedPlate))
                .findFirst()
                .orElse(null);

        if (selectedVehicle == null) {
            JOptionPane.showMessageDialog(this, "No se encontró el vehículo seleccionado.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener los servicios seleccionados
        List<Service> selectedServices = new java.util.ArrayList<>();
        for (int idx : selectedServiceIndices) {
            selectedServices.add(allServices.get(idx));
        }

        // Crear la cita incluyendo el vehículo
        var appointment = new com.tecno_comfenalco.easywashproject.models.Appointment(
                selectedServices,
                sessionClient,
                null, // El empleado se asigna en el servicio
                null, // El estado se asigna en el servicio
                date,
                time,
                selectedVehicle);

        // Usar el controlador para guardar la cita (esto asignará empleado y estado)
        var created = appointmentController.bookAppointment(date, time, selectedServices, sessionClient,
                selectedVehicle);

        // Actualiza el vehículo en la cita creada
        if (created != null) {
            created.setVehicle(selectedVehicle);
            JOptionPane.showMessageDialog(this, "Cita agendada exitosamente.", "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No fue posible agendar la cita. Verifique disponibilidad.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new JPanel();
        labelTitle = new JLabel();
        labelChooseService = new JLabel();
        labelChooseDate = new JLabel();
        comboServices = new JList<>();
        dateField = new DateTimePicker();
        timePickerField = new TimePicker();
        btnCreateAppointment = new JButton();
        comboVehicles = new JComboBox<>();
        labelChooseVehicle = new JLabel();

        setLayout(new AbsoluteLayout());

        bg.setLayout(new AbsoluteLayout());

        labelTitle.setFont(new Font("Roboto Black", 0, 28)); // Más grande
        labelTitle.setText("Agendar Cita");
        bg.add(labelTitle, new AbsoluteConstraints(220, 20, 300, 40));

        labelChooseVehicle.setFont(new Font("Roboto Black", 0, 18));
        labelChooseVehicle.setText("Elegir Vehículo");
        bg.add(labelChooseVehicle, new AbsoluteConstraints(90, 90, -1, -1));

        comboVehicles.setFont(new Font("Roboto", 0, 14));
        // El modelo se actualiza en loadClientVehicles()
        bg.add(comboVehicles, new AbsoluteConstraints(90, 120, 220, 40));

        labelChooseService.setFont(new Font("Roboto Black", 0, 18));
        labelChooseService.setText("Elegir Servicio");
        bg.add(labelChooseService, new AbsoluteConstraints(90, 180, -1, -1));

        comboServices.setFont(new Font("Roboto", 0, 14));
        comboServices.setModel(new DefaultComboBoxModel<>(
                allServices.stream()
                        .map(Service::getName)
                        .toArray(String[]::new)));
        comboServices.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        bg.add(comboServices, new AbsoluteConstraints(90, 210, 220, 80));

        labelChooseDate.setFont(new Font("Roboto Black", 0, 18));
        labelChooseDate.setText("Fecha & Hora");
        bg.add(labelChooseDate, new AbsoluteConstraints(370, 90, -1, -1));
        bg.add(dateField, new AbsoluteConstraints(370, 120, 180, 40));
        bg.add(timePickerField, new AbsoluteConstraints(370, 170, 180, 40));

        btnCreateAppointment.setText("Agendar");
        bg.add(btnCreateAppointment, new AbsoluteConstraints(220, 300, 200, 45));

        add(bg, new AbsoluteConstraints(0, 0, 640, 400));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JPanel bg;
    private JButton btnCreateAppointment;
    private JList<String> comboServices;
    private JLabel labelTitle;
    private JLabel labelChooseService;
    private JLabel labelChooseDate;
    private DateTimePicker dateField;
    private TimePicker timePickerField;
    private JComboBox<String> comboVehicles;
    private JLabel labelChooseVehicle;
    // End of variables declaration//GEN-END:variables

}
