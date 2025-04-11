/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.tecno_comfenalco.easywashproject;

import com.tecno_comfenalco.easywashproject.models.Service;
import com.tecno_comfenalco.easywashproject.repository.FileBasedRepsitoryImpl.ServiceRepositoryImpl;
import com.tecno_comfenalco.easywashproject.views.MainViewWindow;
import java.time.LocalTime;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



/**
 *
 * @author danil
 */
public class Main {

    public static void main(String[] args) {
        ServiceRepositoryImpl serviceRepositoryImpl = new ServiceRepositoryImpl();
        MainViewWindow vistaPrincipal = new MainViewWindow();
        vistaPrincipal.setVisible(true);
        
        Service service = new Service("Servicio1", 12.99, "Descripcion", LocalTime.of(1, 30));
        
        Service serviceCreated = serviceRepositoryImpl.create(service);
        System.out.println("Servicio creado: " + serviceCreated.toString());
     }
}
