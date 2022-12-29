/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.miniproyecto3;

import modelo.ListaDeAfiliados;
import controlador.ServicioControlador;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Afiliado;
import vista.ServicioVista;


/**
 *
 * @author jsmr0
 */
public class Miniproyecto3 {

    public static ArrayList<Afiliado> afiliados;
    
    public static void main(String[] args) {
        
        afiliados = new ArrayList<>();

        
        ServicioVista vista = new ServicioVista();
        ListaDeAfiliados modelo = new ListaDeAfiliados();
        ServicioControlador controlador = new ServicioControlador(modelo, vista);
        
        JOptionPane.showMessageDialog(null,"Haz click en 'cargar backup' para cargar las citas anteriores (si las hay)"
            + "\nSi no las vas a usar, haz click en 'nuevo' (empezaras a agendar desde cero)");           
    }
}
