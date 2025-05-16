/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.controllers;

import javax.swing.JFrame;

import com.tecno_comfenalco.easywashproject.views.auth.LoginClienteView;
import com.tecno_comfenalco.easywashproject.views.auth.LoginUserView;
import com.tecno_comfenalco.easywashproject.views.clients.DashboardClientView;
import com.tecno_comfenalco.easywashproject.views.clients.MainClientView;
import com.tecno_comfenalco.easywashproject.views.clients.RegisterClientView;

/**
 *
 * @author jacob
 */
public class NavigationManager {

    // Instancias de las vistas
    private static JFrame currentVisibleView;
    private static MainClientView mainView;
    private static LoginClienteView loginView;
    private static RegisterClientView registerView;
    private static DashboardClientView dashboardView;
    private static LoginUserView loginUserView;

    // Muestra MainClientView
    // Muestra la vista principal
    public static void showMainView() {
        if (mainView == null) {
            mainView = new MainClientView();
            configureMainView();
        }
        hideCurrentView();
        mainView.setVisible(true);
        currentVisibleView = mainView;
    }

    // Muestra el formulario de login
    public static void showLoginView() {
        if (loginView == null) {
            loginView = new LoginClienteView();
        }
        hideCurrentView();
        loginView.setVisible(true);
        currentVisibleView = loginView;
    }

    public static void showLoginUserView() {
        if (loginUserView == null) {
            loginUserView = new LoginUserView();
        }
        if (currentVisibleView != null) {
            currentVisibleView.setVisible(false);
        }

        loginUserView.setVisible(true);
        currentVisibleView = loginUserView;
    }

    // Muestra el formulario de registro
    public static void showRegisterView() {
        if (registerView == null) {
            registerView = new RegisterClientView();
        }
        hideCurrentView();
        registerView.setVisible(true);
        currentVisibleView = registerView;
    }

    // Muestra el dashboard del cliente
    public static void showDashboard() {
        if (dashboardView == null) {
            dashboardView = new DashboardClientView();
        }
        dashboardView.setVisible(true);
    }

    // Configuracion de vistas
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

    private static void showDashboardView() {
        if (dashboardView == null) {
            dashboardView = new DashboardClientView();
        }
        dashboardView.setVisible(true);
    }

    private static void hideCurrentView() {
        if (currentVisibleView != null) {
            currentVisibleView.setVisible(false);
        }
    }

}
