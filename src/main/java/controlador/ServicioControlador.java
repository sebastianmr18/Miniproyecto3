/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Afiliado;
import vista.ServicioVista;
import controlador.AfiliadoControlador;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author jsmr0
 */
public class ServicioControlador {
    private Afiliado modelo;
    private ServicioVista vista;
    public static boolean noHuboExcepcion;
    
    public ServicioControlador(Afiliado modelo, ServicioVista vista){
        this.modelo = modelo;
        this.vista = vista;
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null); 
        vista.setTitle ("Servicio de Salud Univalle");
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setVisible(true); 
        vista.setResizable(false);
        vista.setLayout(null);         

    }
}
