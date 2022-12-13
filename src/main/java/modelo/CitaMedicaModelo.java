/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jsmr0
 */
public class CitaMedicaModelo {
    private String nombre;
    private String apellidos;
    private int numeroID;
    private String tipoID;
    private String sexo;
    private String direccion;
    private int telefono;
    private int celular;
    private String email;
    private String EPS;
    private String servicio;
    private String medico;
    private String fecha;
    private String hora;
    private String lugar;    
    
    public CitaMedicaModelo(String nombre, String apellidos, int numeroID, String tipoID, String sexo, String direccion
        , int telefono, int celular, String email, String EPS, String servicio, String medico, String fecha
        , String hora, String lugar){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numeroID = numeroID;
        this.tipoID = tipoID;
        this.sexo = sexo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;        
        this.EPS = EPS;
        this.servicio = servicio;
        this.medico = medico;
        this.fecha = fecha;
        this.hora = hora;                        
        this.lugar = lugar;   
    }
    
    public CitaMedicaModelo(){
        this.nombre = "";
        this.apellidos = "";
        this.numeroID = 0;
        this.tipoID = "";
        this.sexo = "";
        this.direccion = "";
        this.telefono = 0;
        this.celular = 0;
        this.email = "";        
        this.EPS = "";
        this.servicio = "";
        this.medico = "";
        this.fecha = "";
        this.hora = "";                        
        this.lugar = "";   
    }   
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }    
    
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }   
    public int getNumeroID() {
        return numeroID;
    }

    public void setNumeroID(int numeroID) {
        this.numeroID = numeroID;
    }      
}
