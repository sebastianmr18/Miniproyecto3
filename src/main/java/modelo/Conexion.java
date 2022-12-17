/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.*;

/**
 *
 * @author jsmr0
 */
public class Conexion {
    private BufferedReader bufEntrada;
    private FileReader archivoLectura;
    private FileWriter archivoEscritura;
    private PrintWriter bufSalida;
    
    public Conexion(BufferedReader bufEntrada, FileReader archivoLectura, FileWriter archivoEscritura, PrintWriter bufSalida){
        this.bufEntrada = bufEntrada;
        this.archivoLectura = archivoLectura;
        this.archivoEscritura = archivoEscritura;
        this.bufSalida = bufSalida;
    }
    
    public Conexion(){
        this.bufEntrada = null;
        this.archivoLectura = null;
        this.archivoEscritura = null;
        this.bufSalida = null;
    } 
    
    public String leerDatos() throws IOException{
        this.archivoLectura = new FileReader("citas.txt");
        bufEntrada = new BufferedReader(archivoLectura);
        String datos ="";
        String linea = this.bufEntrada.readLine();
        while(linea!=null){
            datos+=linea+"\n";
            linea=this.bufEntrada.readLine();
        }
        bufEntrada.close();
        return datos;
    }
    
    public void EscribeDatos(String datos) throws IOException{
        archivoEscritura = new FileWriter("citas.txt", true);
        bufSalida = new PrintWriter(archivoEscritura);
        bufSalida.println(datos);
        bufSalida.close();
    }

}