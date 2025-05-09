/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.controllers;

import com.tecno_comfenalco.easywashproject.views.DashBoardClientView;
import com.tecno_comfenalco.easywashproject.views.LoginClienteView;
import com.tecno_comfenalco.easywashproject.views.MainClientView;
import com.tecno_comfenalco.easywashproject.views.RegisterClientView;

/**
 *
 * @author jacob
 */
public class NavigationManager {
    //Instancias de las vistas
    private static MainClientView mainView;
    private static LoginClienteView loginView;
    private static RegisterClientView registerView;
    private static DashBoardClientView dashboardView;
    
    //Controladores relacionados
    private static AuthController authController;
    private static ClientController clientController;
    
    //Inicializacion de controladores
    static {
        authController = new AuthController();
        clientController = new ClientController();
    }
    
    //Muestra la vista principal 
    public static void showMainView() {
        if (mainView == null) {
            mainView = new MainClientView();
            configureMainView();
        }
        mainView.setVisible(true);
    }
    
    //Muestra el formulario de login
    public static void showLoginView() {
        if (loginView == null) {
            loginView = new LoginClienteView();
            configureLoginView();
        }
        loginView.setVisible(true);
    }
    
    //Muestra el formulario de registro
    public static void showRegisterView() {
        if (registerView == null) {
            registerView = new RegisterClientView();
            configureRegisterView();
        }
        registerView.setVisible(true);
    }
    
    //Muestra el dashboard del cliente
    public static void showDashboard() {
        if (dashboardView == null) {
            dashboardView = new DashBoardClientView();
            configureDashboardView();
        }
        dashboardView.setVisible(true);
    }
    
    //Configuracion de vistas
    private static void configureMainView() {
        mainView.setLoginListener(e -> {
            mainView.close();
            showLoginView();
        });
        
        mainView.setRegisterListener(e -> {
            mainView.close();
            showRegisterView();
        });
    }
    
    private static void configureLoginView() {
        if (loginView == null || authController == null) {
            throw new  IllegalStateException("Vista o controlador no inicializado");
        }
        loginView.setLoginListener(e -> {
            try {
                String email = loginView.getEmail();
                String documento = loginView.getDocumento();
                
            //Validacion basica de campos 
            if (email == null || email.isEmpty() || documento == null || documento.isEmpty()) {
                loginView.ShowError("Por favor complete todos los campos");
                return;
            }
            
            if (authController.authenticate(email, documento)) {
                loginView.close();
                showDashboardView();
            } else {
                loginView.showError("Credenciales incorrectas");
            }
        } catch (Exception ex) {
            loginView.showError("Error durante la autenticacion: " + ex.getMessage());
        }
    });
 }       
    
    
    private static void configureRegisterView() {
        registerView.setRegisterListener(e -> {
            //validacion basica
            if (registerView.getNombre().isEmpty()) {
                registerView.showError("El nombre es obligatorio");
                return;
            }
            
            //Registrar Cliente
            boolean success = clientController.registerClient(
            registerView.getNombre(),
            registerView.getTipoDocumento(),
            registerView.getDocumento(),
            registerView.getTelefono(),
            registerView.getCorreo()
            );
            
            if (success) {
                registerView.showSuccess("¡Registro Exitoso!");
                registerView.close();
                showDashboardView();
            }
        });
        
        registerView.setCancelListener(e -> {
            registerView.close();
            showMainView();
        });
    }
   

    private static void showDashboardView() {
        if (dashboardView == null) {
            dashboardView = new DashBoardClientView();
        }
        dashboardView.setVisible(true);
    }

    private static void configureDashboardView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
