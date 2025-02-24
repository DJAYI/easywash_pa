/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.tecno_comfenalco.easywashproject;

import com.tecno_comfenalco.easywashproject.views.MainView;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author danil
 */
public class Main {

    public static void main(String[] args) {
        MainView VistaPrincipal = new MainView();
        
        VistaPrincipal.setSize(1920, 1080);        
        VistaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        VistaPrincipal.setResizable(false);
        
        VistaPrincipal.setVisible(true);
    }
}
