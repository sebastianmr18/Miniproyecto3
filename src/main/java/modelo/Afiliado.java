/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jsmr0
 */
public class Afiliado {
    private String nombre;
    private String apellidos;
    private String numeroID;
    private String sexo;
    private String celular;
    private String servicio;
    private String medico;
    private String fecha;
    private String hora;
    private String lugar;    
    
    public Afiliado(String nombre, String apellidos, String numeroID, String sexo, 
            String celular, String servicio, String medico, String fecha, String hora, String lugar){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numeroID = numeroID;
        this.sexo = sexo;
        this.celular = celular;
        this.servicio = servicio;
        this.medico = medico;
        this.fecha = fecha;
        this.hora = hora;                        
        this.lugar = lugar;   
    }
    
    public Afiliado(){
        this.nombre = "";
        this.apellidos = "";
        this.numeroID = "";
        this.sexo = "";
        this.celular = "";
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
    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * @return the numeroID
     */
    public String getNumeroID() {
        return numeroID;
    }

    /**
     * @param numeroID the numeroID to set
     */
    public void setNumeroID(String numeroID) {
        this.numeroID = numeroID;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    @Override
    public String toString(){
        return "Afiliado: " + "\n" + "nombre= " + nombre +"\n"+ " apellido: "+ apellidos +"\n"+ " numero ID: " + numeroID +"\n"+ " celular: " + celular +"\n"+ " sexo: " + sexo +"\n"+ " servicio requerido: " + servicio +"\n"+ " medico asignado: " + medico +"\n"+ " fecha: " + fecha +"\n"+ " hora: " + hora +"\n"+ " lugar: " + lugar;
    }
    
    public String datos(){
        return nombre + ";"+ apellidos + ";" + numeroID + ";" + celular + ";" + sexo + ";" + servicio + ";" + medico + ";" + fecha + ";" + hora + ";" + lugar;
    }    
}
