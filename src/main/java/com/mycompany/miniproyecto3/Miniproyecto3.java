/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.miniproyecto3;

import controlador.ServicioControlador;
import modelo.CitaMedicaModelo;
import vista.ServicioVista;


/**
 *
 * @author jsmr0
 */
public class Miniproyecto3 {

    public static void main(String[] args) {
        ServicioVista vista = new ServicioVista();
        CitaMedicaModelo modelo = new CitaMedicaModelo();
        ServicioControlador controlador = new ServicioControlador(modelo, vista);        
    }
}
