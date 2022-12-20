/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import modelo.Afiliado;

/**
 *
 * @author jsmr0
 */
public class ListaDeAfiliados {
    
    private ArrayList <Afiliado> afiliados;
    
    public ListaDeAfiliados(ArrayList <Afiliado> afiliados){
        this.afiliados = afiliados;
    }
    
    public ListaDeAfiliados(){
        this.afiliados = new ArrayList<Afiliado>();
    }
    
    public void crearArrayList(){
        setAfiliados((ArrayList<Afiliado>) new ArrayList());
    }
    
    public void añadirAfiliado(Afiliado afiliado){
        getAfiliados().add(afiliado);
    }

    public ArrayList <Afiliado> getAfiliados() {
        return afiliados;
    }

    public void setAfiliados(ArrayList <Afiliado> afiliados) {
        this.afiliados = afiliados;
    }
    
    @Override
    public String toString() {
        String datos = " ";
        for (int i = 0; i < afiliados.size(); i++){
            datos+=afiliados.get(i).toString()+("\n");
            
        }
        return "ListaDeAfiliados " + afiliados;
    }
}
