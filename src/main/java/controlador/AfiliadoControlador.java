/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Afiliado;

/**
 *
 * @author jsmr0
 */
public class AfiliadoControlador {
    
    ArrayList <Afiliado> afiliados;
    public AfiliadoControlador(){
    
    }
    
    public void crearArrayList(){
        afiliados = new ArrayList();
    }
    
    public void añadirAfiliado(Afiliado afiliado){
        afiliados.add(afiliado);
    }
    
    
}
