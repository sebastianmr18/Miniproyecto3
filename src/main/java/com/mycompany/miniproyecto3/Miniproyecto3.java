/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.miniproyecto3;

import controlador.AfiliadoControlador;
import controlador.ServicioControlador;
import java.util.ArrayList;
import modelo.Afiliado;
import modelo.Conexion;
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
        Afiliado modelo = new Afiliado();
        Conexion conexion = new Conexion();
        ServicioControlador controlador = new ServicioControlador(modelo, vista);
        AfiliadoControlador oControlador = new AfiliadoControlador();
    }
}
