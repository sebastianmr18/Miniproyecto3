/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.CitaMedicaModelo;
import vista.ServicioVista;

/**
 *
 * @author jsmr0
 */
public class ServicioControlador {
    private CitaMedicaModelo modelo;
    private ServicioVista vista;
    
    public ServicioControlador(CitaMedicaModelo modelo, ServicioVista vista){
        this.modelo = modelo;
        this.vista = vista;
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);    
        
        this.vista.addBotonAgregarListener(new BotonAgregarListener());
    }
    
    class BotonAgregarListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre;
            String apellidos;
            int numeroID;
            
            nombre = vista.getNombre();
            apellidos = vista.getApellidos();
            numeroID = (int) vista.getNumeroID();
            
            modelo.setNombre(nombre);
            modelo.setApellidos(apellidos);
            modelo.setNumeroID(numeroID);
                    
            System.out.println(nombre);
            
            if ("".equals(nombre)){
                vista.displayErrorMessage("Necesitas llenar todos los campos");
                System.out.println("error");
            }else if ("".equals(apellidos)){
                vista.displayErrorMessage("Necesitas llenar todos los campos");
                System.out.println("error");
            }else if ("".equals(apellidos)){
                vista.displayErrorMessage("Necesitas llenar todos los campos");
                System.out.println("error");                
            }else{
                vista.llenarTabla();
            }
        }   
    }
}
