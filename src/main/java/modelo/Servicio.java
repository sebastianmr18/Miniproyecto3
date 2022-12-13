/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author jsmr0
 */
public class Servicio {
    private String nombre;
    private ArrayList<Doctor> doctores;
    
    public Servicio(){
        this.nombre = "";
        this.doctores = new ArrayList();        
    }
    
    public Servicio(String nombre) {
        this.nombre = nombre;
        this.doctores = new ArrayList();
    }    
    
    public Servicio(String nombre, ArrayList<Doctor> doctores) {
        this.nombre = nombre;
        this.doctores = doctores;
    }  
    
    public void agregarDoctores(){
        doctores.add(new Doctor("1232","Juan","Odontología",1500000));
        doctores.add(new Doctor("1334","Pepe","Odontología",2100000));
        doctores.add(new Doctor("8769","Nina","Odontología",1800000));
        doctores.add(new Doctor("5467","John","Odontología",1000000));
        doctores.add(new Doctor("3476","Goti","Odontología",1300000));
    }
}

    
