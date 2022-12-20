/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import modelo.Afiliado;
import vista.ServicioVista;
import modelo.ListaDeAfiliados;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import static java.time.temporal.TemporalQueries.localTime;
import java.util.Scanner;

/**
 *
 * @author jsmr0
 */
public class ServicioControlador implements ActionListener, MouseListener, ItemListener, PropertyChangeListener{
    ServicioVista vista;
    ListaDeAfiliados modelo;

    
    public ServicioControlador(ListaDeAfiliados modelo, ServicioVista vista){
        this.modelo = modelo;
        this.vista = vista;

        vista.setVisible(true);
        vista.setLocationRelativeTo(null); 
        vista.setTitle ("Servicio de Salud Univalle");
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setVisible(true); 
        vista.setResizable(false);
        vista.setLayout(null);     
        vista.getBotonAgregar().addActionListener(this);
        vista.getBotonNuevo().addActionListener(this);
        vista.getBotonEliminar().addActionListener(this);
        vista.getBotonModificar().addActionListener(this);        
        vista.getTablaPacientes().addMouseListener(this);
        vista.getChooserServicio().addItemListener(this);
        vista.getChooserFecha().addPropertyChangeListener(this);
        vista.getBotonExportarA().addActionListener(this); 
        vista.getBotonGuardarBU().addActionListener(this);   
        vista.getBotonCargarBU().addActionListener(this);          
        vista.getBotonRestaurar().addActionListener(this); 

    }
        
    public void activar(){
        vista.getBotonNuevo().setEnabled(false);
        vista.getBotonAgregar().setEnabled(true);
        vista.getBotonModificar().setEnabled(false);
        vista.getBotonCargarBU().setEnabled(false);
        
        vista.getCampoNombres().setEnabled(true);
        vista.getCampoApellidos().setEnabled(true);
        vista.getCampoID().setEnabled(true);
        vista.getChooserSexo().setEnabled(true);
        vista.getCampoCelular().setEnabled(true);
        vista.getChooserServicio().setEnabled(true);
        vista.getChooserMedico().setEnabled(true);
        vista.getChooserFecha().setEnabled(true);
        vista.getChooserHora().setEnabled(true);          
        vista.getChooserLugar().setEnabled(true);        
    }
    
    public void desactivar(){
        vista.getBotonNuevo().setEnabled(true); 
        vista.getBotonAgregar().setEnabled(false);      
        vista.getBotonRestaurar().setEnabled(true);        
        
        vista.getCampoNombres().setEnabled(false);
        vista.getCampoApellidos().setEnabled(false);
        vista.getCampoID().setEnabled(false); 
        vista.getChooserSexo().setEnabled(false);
        vista.getCampoCelular().setEnabled(false);
        vista.getChooserServicio().setEnabled(false);
        vista.getChooserMedico().setEnabled(false);
        vista.getChooserFecha().setEnabled(false);
        vista.getChooserHora().setEnabled(false);          
        vista.getChooserLugar().setEnabled(false);
        
        vista.getCampoNombres().setText("");
        vista.getCampoApellidos().setText("");
        vista.getCampoID().setText("");
        vista.getChooserSexo().setSelectedItem("--");
        vista.getCampoCelular().setText("");
        vista.getChooserServicio().setSelectedItem("--");
        vista.getChooserMedico().setSelectedItem("--");
        vista.getChooserHora().setSelectedItem("--");         
        vista.getChooserLugar().setSelectedItem("--");  
    }
    
    public void displayErrorMessage(String erroMessage) {
        JOptionPane.showMessageDialog(vista, erroMessage);
    }      

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vista.getBotonAgregar())){
            try{
                String nombre = vista.getNombre();
                String apellidos = vista.getApellidos();
                String numeroID = vista.getNumeroID();
                String sexo = vista.getSexo();
                String fecha = (String) vista.getFecha();
                String celular = vista.getCelular();
                String servicio = vista.getServicio();
                String medico = vista.getMedico();
                String hora = vista.getHora();
                String lugar = vista.getLugar();

                if ("".equals(nombre)){
                    displayErrorMessage("Debes llenar todos los campos correctamente");
                }else if ("".equals(apellidos)){
                    displayErrorMessage("Debes llenar todos los campos correctamente");
                }else if ("".equals(numeroID)){
                    displayErrorMessage("Debes llenar todos los campos correctamente");
                }else if ("--".equals(sexo)){
                    displayErrorMessage("Debes llenar todos los campos correctamente");
                }else if ("".equals(celular)){
                    displayErrorMessage("Debes llenar todos los campos correctamente");
                }else if ("--".equals(servicio)){
                    displayErrorMessage("Debes llenar todos los campos correctamente");
                }else if ("--".equals(hora)){
                    displayErrorMessage("Debes llenar todos los campos correctamente");
                }else if ("--".equals(lugar)){
                    displayErrorMessage("Debes llenar todos los campos correctamente");
                }else{
                    Afiliado afiliado = new Afiliado(nombre, apellidos, numeroID, sexo, celular, servicio, medico, fecha, hora, lugar);
                    modelo.añadirAfiliado(afiliado);
                    System.out.println("Entro hasta acá");
                    vista.llenarTabla();
                    desactivar();
                    try {
                        LocalDate fechaActual = LocalDate.now();
                        LocalTime horaActual = LocalTime.now();
                        FileWriter salvar = new FileWriter("archivoDeTodasLasCitasMedicas.txt", true);

                        salvar.write("Cita programada en el día: " + fechaActual + " a las "+ horaActual+"\n");
                        salvar.write("Nombres: " + nombre+"   "+"\n");
                        salvar.write("Apellidos: " + apellidos+"   "+"\n");
                        salvar.write("ID: " + numeroID+"   "+"\n");
                        salvar.write("Sexo: " + sexo+"   "+"\n");
                        salvar.write("Celular: " + celular+"   "+"\n");
                        salvar.write("Servicio: " + servicio+"   "+"\n");
                        salvar.write("Medico: " + medico+"   "+"\n");
                        salvar.write("Fecha: " + fecha+"   "+"\n");
                        salvar.write("Hora: " + hora+"   "+"\n");
                        salvar.write("Consultorio: " + lugar+"   "+"\n");   
                        salvar.write("\n");

                        System.out.println("ENTRO AQUI");
                        salvar.close();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error escribiendo el archivo");
                    } 
                    JOptionPane.showMessageDialog(null, "Afiliado y cita programado con exito.");
                    System.out.println(modelo.toString());
                    vista.getBotonGuardarBU().setEnabled(true);
                    vista.getBotonExportarA().setEnabled(true);
                    
                }
            } catch(NullPointerException ex){
                displayErrorMessage("Debes llenar todos los campos correctamente");
                System.out.println("Ex 1");
            }
        }
        if(e.getSource().equals(vista.getBotonNuevo())){
            activar();
        }
        if(e.getSource().equals(vista.getBotonEliminar())){
            DefaultTableModel dtm = (DefaultTableModel) vista.getTablaPacientes().getModel();
            if(vista.getTablaPacientes().getSelectedRow() == -1){
                return;
            }
            
            int numeroFila = vista.getTablaPacientes().getSelectedRow();
            dtm.removeRow(numeroFila);

            JOptionPane.showMessageDialog(null,"Cita eliminada con exito");

            desactivar();
            vista.getBotonModificar().setEnabled(false);
            vista.getBotonEliminar().setEnabled(false);
        }
        if(e.getSource().equals(vista.getBotonModificar())){
            if(vista.getTablaPacientes().getSelectedRow() == -1){
                return;
            }

            String nombre = vista.getNombre();
            String apellidos = vista.getApellidos();
            String numeroID = vista.getNumeroID();
            String sexo = vista.getSexo();
            String fecha = (String) vista.getFecha();
            String celular = vista.getCelular();
            String servicio = vista.getServicio();
            String medico = vista.getMedico();
            String hora = vista.getHora();
            String lugar = vista.getLugar();
            int numeroFila = vista.getTablaPacientes().getSelectedRow();

            if ("".equals(nombre)){
                displayErrorMessage("Necesitas llenar todos los campos correctamente");
                System.out.println("error");
            }else if ("".equals(apellidos)){
                displayErrorMessage("Necesitas llenar todos los campos correctamente");
                System.out.println("error");
            }else if ("".equals(numeroID)){
                displayErrorMessage("Necesitas llenar todos los campos correctamente");
                System.out.println("error");
            }else if ("--".equals(sexo)){
                displayErrorMessage("Debes llenar todos los campos correctamente");
                System.out.println("error");
            }else if ("".equals(celular)){
                displayErrorMessage("Necesitas llenar todos los campos correctamente");
                System.out.println("error");
            }else if ("--".equals(servicio)){
                displayErrorMessage("Debes llenar todos los campos correctamente");
                System.out.println("error");
            }else if ("--".equals(hora)){
                displayErrorMessage("Debes llenar todos los campos correctamente");
                System.out.println("error");
            }else if ("--".equals(lugar)){
                displayErrorMessage("Debes llenar todos los campos correctamente");
                System.out.println("error");
            }else{
                Afiliado afiliado = new Afiliado(nombre, apellidos, numeroID, sexo, celular, servicio, medico, fecha, hora, lugar);

                vista.getTablaPacientes().setValueAt(afiliado.getNombre(), numeroFila, 0);
                vista.getTablaPacientes().setValueAt(afiliado.getApellidos(), numeroFila, 1);
                vista.getTablaPacientes().setValueAt(afiliado.getNumeroID(), numeroFila, 2);
                vista.getTablaPacientes().setValueAt(afiliado.getSexo(), numeroFila, 3);
                vista.getTablaPacientes().setValueAt(afiliado.getFecha(), numeroFila, 4);
                vista.getTablaPacientes().setValueAt(afiliado.getHora(), numeroFila, 5);
                vista.getTablaPacientes().setValueAt(afiliado.getCelular(), numeroFila, 6);
                vista.getTablaPacientes().setValueAt(afiliado.getMedico(), numeroFila, 7);
                vista.getTablaPacientes().setValueAt(afiliado.getLugar(), numeroFila, 8);
                vista.getTablaPacientes().setValueAt(afiliado.getServicio(), numeroFila, 9);

                JOptionPane.showMessageDialog(null,"Cita modificada con exito");

                desactivar();
                vista.getBotonModificar().setEnabled(false);
                vista.getBotonEliminar().setEnabled(false);
            }            
        }
        if(e.getSource().equals(vista.getBotonExportarA())){
            DefaultTableModel model = (DefaultTableModel)this.vista.getTablaPacientes().getModel();
            try {
                FileWriter salvar = new FileWriter("datosAfiliados.txt");
                for(int i = 0;i<vista.getTablaPacientes().getRowCount(); i++){
                    salvar.write(model.getValueAt(i,0).toString()+";");
                    salvar.write(model.getValueAt(i,1).toString()+";");
                    salvar.write(model.getValueAt(i,2).toString()+";");
                    salvar.write(model.getValueAt(i,3).toString()+";");
                    salvar.write(model.getValueAt(i,6).toString()+"\n");

                    System.out.println("ENTRO AQUI");
                }
                salvar.close();
                    
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error escribiendo el archivo");
            }
        }
        if(e.getSource().equals(vista.getBotonGuardarBU())){
            DefaultTableModel model = (DefaultTableModel)this.vista.getTablaPacientes().getModel();
            try {
                FileWriter salvar = new FileWriter("BackupCitasMedicas.txt");
                for(int i = 0;i<vista.getTablaPacientes().getRowCount(); i++){
                    salvar.write(model.getValueAt(i,0).toString()+"\n");
                    salvar.write(model.getValueAt(i,1).toString()+"\n");
                    salvar.write(model.getValueAt(i,2).toString()+"\n");
                    salvar.write(model.getValueAt(i,3).toString()+"\n");
                    salvar.write(model.getValueAt(i,4).toString()+"\n");
                    salvar.write(model.getValueAt(i,5).toString()+"\n");
                    salvar.write(model.getValueAt(i,6).toString()+"\n");
                    salvar.write(model.getValueAt(i,7).toString()+"\n");
                    salvar.write(model.getValueAt(i,8).toString()+"\n");
                    salvar.write(model.getValueAt(i,9).toString()+"\n");                    

                    System.out.println("ENTRO AQUI");
                }
                salvar.close();
                    
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error escribiendo el archivo");
            }        
        }
        if(e.getSource().equals(vista.getBotonCargarBU())){
            DefaultTableModel model = (DefaultTableModel)this.vista.getTablaPacientes().getModel();
            String nombre, apellidos, numeroID, sexo, celular, servicio, medico, fecha, hora, lugar; 
            String archivo = "BackupCitasMedicas.txt";
            Scanner linea = null;
            File archivoLeer = new File(archivo);
            
            try{
                linea = new Scanner(archivoLeer);
                while(linea.hasNextLine()){
                    nombre=linea.nextLine();
                    apellidos=linea.nextLine();
                    numeroID=linea.nextLine();
                    sexo=linea.nextLine();
                    celular=linea.nextLine();
                    servicio=linea.nextLine();
                    medico=linea.nextLine();
                    fecha=linea.nextLine();
                    hora=linea.nextLine();
                    lugar=linea.nextLine();      
                    
                    model.addRow(new Object[]{nombre, apellidos, numeroID, sexo, 
                        celular, servicio, medico, fecha, hora, lugar});
                }
            }catch(Exception x){
                JOptionPane.showMessageDialog(null,"Error cargando el back up");
            }
        }
        if(e.getSource().equals(vista.getBotonRestaurar())){
            int numeroFilas = vista.getTablaPacientes().getRowCount();

            for(int i = numeroFilas-1; i>=0; i--){
                vista.getDtm().removeRow(i);
            }
            /*            File archivoAfiliados, archivoCitas;
            try{
            archivoAfiliados=new File ("datosAfiliados.txt");
            archivoCitas=new File ("BackupCitasMedicas.txt");
            
            if(!archivoAfiliados.exists()){
            JOptionPane.showMessageDialog(null,"El archivo de afiliados no existe.");
            } else{
            archivoAfiliados.delete();
            JOptionPane.showMessageDialog(null,"El archivo de afiliados fue eliminado.");
            }
            
            if(!archivoCitas.exists()){
            JOptionPane.showMessageDialog(null,"El archivo de citas medicas no existe.");
            } else{
            archivoCitas.delete();
            JOptionPane.showMessageDialog(null,"El archivo de citas medicas fue eliminado.");
            }
            }catch(Exception ep){
            
            }*/
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount()==2){
            int numeroFila = vista.getTablaPacientes().getSelectedRow();
            
            activar();
            vista.getBotonAgregar().setEnabled(false);
            vista.getBotonModificar().setEnabled(true);
            vista.getBotonEliminar().setEnabled(true);    
            
            String nombre = (String) vista.getTablaPacientes().getValueAt(numeroFila, 0);
            String apellidos = (String) vista.getTablaPacientes().getValueAt(numeroFila, 1);
            String numeroID = (String) vista.getTablaPacientes().getValueAt(numeroFila, 2);
            String sexo = (String) vista.getTablaPacientes().getValueAt(numeroFila, 3);
            String hora = (String) vista.getTablaPacientes().getValueAt(numeroFila, 5);
            String celular = (String) vista.getTablaPacientes().getValueAt(numeroFila, 6);
            String medico = (String) vista.getTablaPacientes().getValueAt(numeroFila, 7);
            String lugar = (String) vista.getTablaPacientes().getValueAt(numeroFila, 8);
            String servicio = (String) vista.getTablaPacientes().getValueAt(numeroFila, 9);

            vista.getCampoNombres().setText(nombre);
            vista.getCampoApellidos().setText(apellidos);
            vista.getCampoID().setText(numeroID);
            vista.getChooserSexo().setSelectedItem(sexo);
            vista.getChooserHora().setSelectedItem(hora);
            vista.getCampoCelular().setText(celular);
            vista.getChooserServicio().setSelectedItem(servicio);
            vista.getChooserMedico().setSelectedItem(medico);
            vista.getChooserLugar().setSelectedItem(lugar);            
        }
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange()==ItemEvent.SELECTED){
            if(this.vista.getChooserServicio().getSelectedIndex()>0){
                this.vista.getChooserMedico().setModel(new DefaultComboBoxModel(this.vista.servicios(this.vista.getChooserServicio().getSelectedItem().toString())));
            }
        }
    }    

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getOldValue() != null){
            try{
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                vista.getCampoFecha().setText(sdf.format(vista.getChooserFecha().getCalendar().getTime()));
            }catch(NullPointerException ex){
            }
        }        
    }



}
