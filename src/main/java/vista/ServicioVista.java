/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.AfiliadoControlador;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Afiliado;
import modelo.Conexion;

/**
 *
 * @author jsmr0
 */
public class ServicioVista extends javax.swing.JFrame {
    DefaultTableModel dtm;
    DefaultTableModel anotherDTM;
    AfiliadoControlador afiliadoControlador;
    Conexion conexion;
    
    public ServicioVista() {
        
        this.dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        this.anotherDTM = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };        
        
        initComponents();
        crearTabla();
        
        afiliadoControlador = new AfiliadoControlador();
        afiliadoControlador.crearArrayList();
    }
        
    private void crearTabla(){
        String[] titulo=new String[]{"Nombre", "Apellidos",  
            "Numero de ID", "Sexo", "Dia cita", "Hora cita", "Telefono", 
            "Medico", "Lugar", "Servicio"};
        dtm.setColumnIdentifiers(titulo);
        TablaPacientes.setModel(dtm);
    }
    
    private void crearTablaArchivos(){
        String[] titulo=new String[]{"Nombre", "Apellidos",  
            "Numero de ID", "Sexo", "Dia cita", "Hora cita", "Telefono", 
            "Medico", "Lugar", "Servicio"};
        anotherDTM.setColumnIdentifiers(titulo);
        TablaPacientesArchivo.setModel(anotherDTM);
    }    
    
    public String[]servicios(String servicios){
        String[]nombresDeDoctores = new String[5];       
        if(servicios.equalsIgnoreCase("Odontología")){
            nombresDeDoctores[0]="Odontologo 1";
            nombresDeDoctores[1]="Odontologo 2";
            nombresDeDoctores[2]="Odontologo 3";
            nombresDeDoctores[3]="Odontologo 4";
            nombresDeDoctores[4]="Odontologo 5";            
        }
        if(servicios.equalsIgnoreCase("Examen de Laboratorio")){
            nombresDeDoctores[0]="Lab 1";
            nombresDeDoctores[1]="Lab 2";
            nombresDeDoctores[2]="Lab 3";
            nombresDeDoctores[3]="Lab 4";
            nombresDeDoctores[4]="Lab 5";            
        }        
        if(servicios.equalsIgnoreCase("Cita General")){
            nombresDeDoctores[0]="Medico General 1";
            nombresDeDoctores[1]="Medico General 2";
            nombresDeDoctores[2]="Medico General 3";
            nombresDeDoctores[3]="Medico General 4";
            nombresDeDoctores[4]="Medico General 5";            
        }  
        if(servicios.equalsIgnoreCase("Cita con Especialista")){
            nombresDeDoctores[0]="Especialista 1";
            nombresDeDoctores[1]="Especialista 2";
            nombresDeDoctores[2]="Especialista 3";
            nombresDeDoctores[3]="Especialista 4";
            nombresDeDoctores[4]="Especialista 5";            
        }         
        return nombresDeDoctores;
    }
    
    public String getNombre(){
        return CampoNombres.getText();
    }
    
    public String getApellidos(){
        return CampoApellidos.getText();
    }    
    
    public String getNumeroID(){
        return CampoID.getText();
    }
    
    public String getSexo(){
        return (String) ChooserSexo.getSelectedItem();
    } 
       
    public String getCelular(){
        return CampoCelular.getText();
    } 
    
    public String getServicio(){
        return (String) ChooserServicio.getSelectedItem();
    }    
    
    public String getMedico(){
        return (String) ChooserMedico.getSelectedItem();
    }     
    
    public String getFecha(){
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        String fechaFormato= dFormat.format(ChooserFecha.getDate());
        return fechaFormato;
    }  

    public String getHora(){
        return (String) ChooserHora.getSelectedItem();
    } 
    
    public String getLugar(){
        return (String) ChooserLugar.getSelectedItem();
    }     
    
    public void displayErrorMessage(String erroMessage) {
        JOptionPane.showMessageDialog(this, erroMessage);
    }  
    
    public void addBotonNuevoListener(ActionListener listenControles){
        BotonNuevo.addActionListener(listenControles);
    }
    
    public void llenarTabla(){
        dtm.addRow(new Object[]{
            CampoNombres.getText(),
            CampoApellidos.getText(),
            CampoID.getText(),            
            getSexo(),
            getFecha(),     
            getHora(),            
            CampoCelular.getText(),
            getMedico(),
            getLugar(),
            getServicio()
        });
    }    
    
    public void activar(){
        BotonNuevo.setEnabled(false);
        BotonAgregar.setEnabled(true);
        BotonModificar.setEnabled(false);
        
        CampoNombres.setEnabled(true);
        CampoApellidos.setEnabled(true);
        CampoID.setEnabled(true);
        ChooserSexo.setEnabled(true);
        CampoCelular.setEnabled(true);
        ChooserServicio.setEnabled(true);
        ChooserMedico.setEnabled(true);
        ChooserFecha.setEnabled(true);
        ChooserHora.setEnabled(true);          
        ChooserLugar.setEnabled(true);          
    }    
    
    public void desactivar(){
        BotonNuevo.setEnabled(true); 
        BotonAgregar.setEnabled(false);        
        
        CampoNombres.setEnabled(false);
        CampoApellidos.setEnabled(false);
        CampoID.setEnabled(false); 
        ChooserSexo.setEnabled(false);
        CampoCelular.setEnabled(false);
        ChooserServicio.setEnabled(false);
        ChooserMedico.setEnabled(false);
        ChooserFecha.setEnabled(false);
        ChooserHora.setEnabled(false);          
        ChooserLugar.setEnabled(false);
        
        CampoNombres.setText("");
        CampoApellidos.setText("");
        CampoID.setText("");
        ChooserSexo.setSelectedItem("--");
        CampoCelular.setText("");
        ChooserServicio.setSelectedItem("--");
        ChooserMedico.setSelectedItem("--");
        ChooserHora.setSelectedItem("--");         
        ChooserLugar.setSelectedItem("--");     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LabelTitulo = new javax.swing.JLabel();
        jPanelContenido = new javax.swing.JPanel();
        PanelCamposTexto = new javax.swing.JPanel();
        jPanelTabla = new javax.swing.JPanel();
        ContenedorDatosPersonales = new javax.swing.JPanel();
        LabelSubtitulo1 = new javax.swing.JLabel();
        LabelNombres = new javax.swing.JLabel();
        CampoNombres = new javax.swing.JTextField();
        Label1erApellido = new javax.swing.JLabel();
        CampoApellidos = new javax.swing.JTextField();
        LabelID = new javax.swing.JLabel();
        CampoID = new javax.swing.JTextField();
        LabelSexo = new javax.swing.JLabel();
        ChooserSexo = new javax.swing.JComboBox<>();
        LabelCelular = new javax.swing.JLabel();
        CampoCelular = new javax.swing.JTextField();
        PanelCita = new javax.swing.JPanel();
        LabelSubtitulo3 = new javax.swing.JLabel();
        LabelServicio = new javax.swing.JLabel();
        ChooserServicio = new javax.swing.JComboBox<>();
        LabelMedico = new javax.swing.JLabel();
        ChooserMedico = new javax.swing.JComboBox<>();
        LabelFecha = new javax.swing.JLabel();
        LabelHora = new javax.swing.JLabel();
        ChooserHora = new javax.swing.JComboBox<>();
        LabelLugar = new javax.swing.JLabel();
        ChooserLugar = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        BotonAgregar = new javax.swing.JButton();
        BotonModificar = new javax.swing.JButton();
        BotonEliminar = new javax.swing.JButton();
        BotonNuevo = new javax.swing.JButton();
        BotonRestaurar = new javax.swing.JButton();
        BotonGenerarTablaArchivo = new javax.swing.JButton();
        CampoFecha = new javax.swing.JLabel();
        ChooserFecha = new com.toedter.calendar.JDateChooser();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLabelInfoTabla = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPacientes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaPacientesArchivo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 204));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 750));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelTitulo.setBackground(new java.awt.Color(0, 0, 0));
        LabelTitulo.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        LabelTitulo.setText("Servicio de Salud de Univalle");
        LabelTitulo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(LabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        jPanelContenido.setBackground(new java.awt.Color(102, 255, 204));

        PanelCamposTexto.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelCamposTextoLayout = new javax.swing.GroupLayout(PanelCamposTexto);
        PanelCamposTexto.setLayout(PanelCamposTextoLayout);
        PanelCamposTextoLayout.setHorizontalGroup(
            PanelCamposTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelCamposTextoLayout.setVerticalGroup(
            PanelCamposTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelTabla.setPreferredSize(new java.awt.Dimension(1000, 120));

        javax.swing.GroupLayout jPanelTablaLayout = new javax.swing.GroupLayout(jPanelTabla);
        jPanelTabla.setLayout(jPanelTablaLayout);
        jPanelTablaLayout.setHorizontalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );
        jPanelTablaLayout.setVerticalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        ContenedorDatosPersonales.setBackground(new java.awt.Color(102, 255, 204));

        LabelSubtitulo1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        LabelSubtitulo1.setText("Datos Personales:");

        LabelNombres.setText("Nombres: ");

        CampoNombres.setEnabled(false);

        Label1erApellido.setText("Apellidos:");

        CampoApellidos.setEnabled(false);

        LabelID.setText("Nro. de Identificación:");

        CampoID.setEnabled(false);

        LabelSexo.setText("Sexo de nacimiento:");

        ChooserSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "Masculino", "Femenino" }));
        ChooserSexo.setEnabled(false);

        LabelCelular.setText("Celular:");

        CampoCelular.setEnabled(false);

        javax.swing.GroupLayout ContenedorDatosPersonalesLayout = new javax.swing.GroupLayout(ContenedorDatosPersonales);
        ContenedorDatosPersonales.setLayout(ContenedorDatosPersonalesLayout);
        ContenedorDatosPersonalesLayout.setHorizontalGroup(
            ContenedorDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorDatosPersonalesLayout.createSequentialGroup()
                .addGroup(ContenedorDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContenedorDatosPersonalesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ContenedorDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelNombres)
                            .addComponent(Label1erApellido)))
                    .addGroup(ContenedorDatosPersonalesLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(LabelSubtitulo1))
                    .addGroup(ContenedorDatosPersonalesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LabelID)
                        .addGap(28, 28, 28)
                        .addGroup(ContenedorDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CampoID, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(CampoApellidos)
                            .addComponent(CampoNombres)))
                    .addGroup(ContenedorDatosPersonalesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ContenedorDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelSexo)
                            .addComponent(LabelCelular))
                        .addGap(38, 38, 38)
                        .addGroup(ContenedorDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CampoCelular)
                            .addComponent(ChooserSexo, 0, 134, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ContenedorDatosPersonalesLayout.setVerticalGroup(
            ContenedorDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorDatosPersonalesLayout.createSequentialGroup()
                .addComponent(LabelSubtitulo1)
                .addGap(18, 18, 18)
                .addGroup(ContenedorDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNombres)
                    .addComponent(CampoNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ContenedorDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label1erApellido)
                    .addComponent(CampoApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ContenedorDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelID)
                    .addComponent(CampoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ContenedorDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCelular)
                    .addComponent(CampoCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ContenedorDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelSexo)
                    .addComponent(ChooserSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        PanelCita.setBackground(new java.awt.Color(102, 255, 204));

        LabelSubtitulo3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        LabelSubtitulo3.setText("Detalles de la cita medica:");

        LabelServicio.setText("Servicio requerido:");

        ChooserServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "Odontología", "Examen de Laboratorio", "Cita General", "Cita con Especialista" }));
        ChooserServicio.setEnabled(false);
        ChooserServicio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ChooserServicioItemStateChanged(evt);
            }
        });
        ChooserServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooserServicioActionPerformed(evt);
            }
        });

        LabelMedico.setText("Doctor encargado:");

        ChooserMedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "--", "--", "--", "--" }));
        ChooserMedico.setEnabled(false);

        LabelFecha.setText("Fecha:");

        LabelHora.setText("Hora:");

        ChooserHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "6:00 AM", "7:00 AM", "8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 M", "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM", "7:00 PM", "8:00 PM" }));
        ChooserHora.setEnabled(false);

        LabelLugar.setText("Lugar:");

        ChooserLugar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "HUV San Fernando", "HUV Sede Norte", "Servicio Medico Melendez" }));
        ChooserLugar.setEnabled(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        BotonAgregar.setText("AGREGAR");
        BotonAgregar.setEnabled(false);
        BotonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarActionPerformed(evt);
            }
        });

        BotonModificar.setText("MODIFICAR");
        BotonModificar.setEnabled(false);
        BotonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonModificarActionPerformed(evt);
            }
        });

        BotonEliminar.setText("ELIMINAR");
        BotonEliminar.setEnabled(false);
        BotonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEliminarActionPerformed(evt);
            }
        });

        BotonNuevo.setText("NUEVO");
        BotonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonNuevoActionPerformed(evt);
            }
        });

        BotonRestaurar.setText("BORRAR TODO");
        BotonRestaurar.setEnabled(false);
        BotonRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRestaurarActionPerformed(evt);
            }
        });

        BotonGenerarTablaArchivo.setText("GENERAR ARCHIVO DE CITAS MEDICAS");
        BotonGenerarTablaArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGenerarTablaArchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BotonNuevo)
                        .addGap(26, 26, 26)
                        .addComponent(BotonAgregar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BotonModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonEliminar))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(BotonGenerarTablaArchivo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(BotonRestaurar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonNuevo)
                    .addComponent(BotonAgregar))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonModificar)
                    .addComponent(BotonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BotonRestaurar)
                .addGap(18, 18, 18)
                .addComponent(BotonGenerarTablaArchivo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ChooserFecha.setEnabled(false);
        ChooserFecha.setMaxSelectableDate(new java.util.Date(1704002463000L));
        ChooserFecha.setMinSelectableDate(new java.util.Date(1641016863000L));
        ChooserFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ChooserFechaPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout PanelCitaLayout = new javax.swing.GroupLayout(PanelCita);
        PanelCita.setLayout(PanelCitaLayout);
        PanelCitaLayout.setHorizontalGroup(
            PanelCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCitaLayout.createSequentialGroup()
                .addGroup(PanelCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelCitaLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(LabelSubtitulo3))
                    .addGroup(PanelCitaLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(PanelCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelServicio)
                            .addComponent(LabelMedico)
                            .addComponent(LabelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelHora)
                            .addComponent(LabelLugar))
                        .addGap(32, 32, 32)
                        .addGroup(PanelCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ChooserServicio, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ChooserMedico, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelCitaLayout.createSequentialGroup()
                                .addComponent(CampoFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ChooserHora, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ChooserLugar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );
        PanelCitaLayout.setVerticalGroup(
            PanelCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCitaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCitaLayout.createSequentialGroup()
                        .addComponent(LabelSubtitulo3)
                        .addGap(18, 18, 18)
                        .addGroup(PanelCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCitaLayout.createSequentialGroup()
                                .addGroup(PanelCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LabelServicio)
                                    .addComponent(ChooserServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(PanelCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LabelMedico)
                                    .addComponent(ChooserMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(PanelCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(PanelCitaLayout.createSequentialGroup()
                                        .addComponent(CampoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(PanelCitaLayout.createSequentialGroup()
                                        .addComponent(ChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addComponent(ChooserHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelCitaLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(LabelHora, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(PanelCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ChooserLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelLugar))
                        .addGap(219, 219, 219))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(112, 112, 112))
        );

        javax.swing.GroupLayout jPanelContenidoLayout = new javax.swing.GroupLayout(jPanelContenido);
        jPanelContenido.setLayout(jPanelContenidoLayout);
        jPanelContenidoLayout.setHorizontalGroup(
            jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContenidoLayout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(jPanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelContenidoLayout.createSequentialGroup()
                        .addComponent(ContenedorDatosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PanelCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelCamposTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanelContenidoLayout.setVerticalGroup(
            jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContenidoLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(PanelCamposTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(42, 42, 42))
                    .addGroup(jPanelContenidoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelContenidoLayout.createSequentialGroup()
                                .addComponent(ContenedorDatosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(PanelCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        jPanel1.add(jPanelContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 1000, 450));

        jTabbedPane1.setBackground(new java.awt.Color(153, 255, 255));

        jLabelInfoTabla.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jTabbedPane1.addTab("Instrucciones", jLabelInfoTabla);

        TablaPacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TablaPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TablaPacientes.getTableHeader().setReorderingAllowed(false);
        TablaPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaPacientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaPacientes);
        if (TablaPacientes.getColumnModel().getColumnCount() > 0) {
            TablaPacientes.getColumnModel().getColumn(2).setMinWidth(50);
            TablaPacientes.getColumnModel().getColumn(2).setPreferredWidth(50);
            TablaPacientes.getColumnModel().getColumn(2).setMaxWidth(50);
            TablaPacientes.getColumnModel().getColumn(4).setMinWidth(100);
            TablaPacientes.getColumnModel().getColumn(4).setPreferredWidth(100);
            TablaPacientes.getColumnModel().getColumn(4).setMaxWidth(100);
            TablaPacientes.getColumnModel().getColumn(7).setMinWidth(60);
            TablaPacientes.getColumnModel().getColumn(7).setPreferredWidth(60);
            TablaPacientes.getColumnModel().getColumn(7).setMaxWidth(60);
        }

        jTabbedPane1.addTab("Tabla de citas (ultimas)", jScrollPane1);

        TablaPacientesArchivo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TablaPacientesArchivo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TablaPacientesArchivo.getTableHeader().setReorderingAllowed(false);
        TablaPacientesArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaPacientesArchivoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaPacientesArchivo);
        if (TablaPacientesArchivo.getColumnModel().getColumnCount() > 0) {
            TablaPacientesArchivo.getColumnModel().getColumn(2).setMinWidth(50);
            TablaPacientesArchivo.getColumnModel().getColumn(2).setPreferredWidth(50);
            TablaPacientesArchivo.getColumnModel().getColumn(2).setMaxWidth(50);
            TablaPacientesArchivo.getColumnModel().getColumn(4).setMinWidth(100);
            TablaPacientesArchivo.getColumnModel().getColumn(4).setPreferredWidth(100);
            TablaPacientesArchivo.getColumnModel().getColumn(4).setMaxWidth(100);
            TablaPacientesArchivo.getColumnModel().getColumn(7).setMinWidth(60);
            TablaPacientesArchivo.getColumnModel().getColumn(7).setPreferredWidth(60);
            TablaPacientesArchivo.getColumnModel().getColumn(7).setMaxWidth(60);
        }

        jTabbedPane1.addTab("Archivo de citas medicas", jScrollPane2);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 975, 148));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ChooserServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooserServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChooserServicioActionPerformed

    private void BotonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarActionPerformed
        try{        
        String nombre = getNombre();
        String apellidos = getApellidos();
        String numeroID = getNumeroID();
        String sexo = getSexo();
        String fecha = (String) getFecha();
        String celular = getCelular();
        String servicio = getServicio();
        String medico = getMedico();
        String hora = getHora();
        String lugar = getLugar();

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
            afiliadoControlador.añadirAfiliado(afiliado);
            BotonRestaurar.setEnabled(true);
            System.out.println("Entro hasta acá");
            llenarTabla();
            desactivar();
            JOptionPane.showMessageDialog(null, "Afiliado y cita programado con exito");             
        }
        } catch(NullPointerException ex){
            displayErrorMessage("Debes llenar todos los campos correctamente");
        }
    }//GEN-LAST:event_BotonAgregarActionPerformed

    private void ChooserServicioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ChooserServicioItemStateChanged
        if(evt.getStateChange()==ItemEvent.SELECTED){
            if(this.ChooserServicio.getSelectedIndex()>0){
                this.ChooserMedico.setModel(new DefaultComboBoxModel(this.servicios(this.ChooserServicio.getSelectedItem().toString())));
            }
        }
    }//GEN-LAST:event_ChooserServicioItemStateChanged

    private void ChooserFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ChooserFechaPropertyChange
        if(evt.getOldValue() != null){
            try{
                SimpleDateFormat anothersdf = new SimpleDateFormat("dd/MM/yyyy");
                CampoFecha.setText(anothersdf.format(ChooserFecha.getCalendar().getTime()));
            }catch(NullPointerException ex){
                
            }

        }
    }//GEN-LAST:event_ChooserFechaPropertyChange

    private void BotonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNuevoActionPerformed
        activar();
    }//GEN-LAST:event_BotonNuevoActionPerformed

    private void BotonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEliminarActionPerformed
        if(TablaPacientes.getSelectedRow() == -1){
            return;
        }
        
        int numeroFila = TablaPacientes.getSelectedRow();
        dtm.removeRow(numeroFila);
        
        JOptionPane.showMessageDialog(null,"Cita eliminada con exito");

        desactivar();
        BotonModificar.setEnabled(false);
        BotonEliminar.setEnabled(false);        

        
    }//GEN-LAST:event_BotonEliminarActionPerformed

    private void BotonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonModificarActionPerformed
        System.out.println(TablaPacientes.getSelectedRow());        
        if(TablaPacientes.getSelectedRow() == -1){
            return;
        }     
   
        String nombre = getNombre();
        String apellidos = getApellidos();
        String numeroID = getNumeroID();
        String sexo = getSexo();
        String fecha = (String) getFecha();
        String celular = getCelular();
        String servicio = getServicio();
        String medico = getMedico();
        String hora = getHora();
        String lugar = getLugar();
        int numeroFila = TablaPacientes.getSelectedRow();
        
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

                TablaPacientes.setValueAt(afiliado.getNombre(), numeroFila, 0);
                TablaPacientes.setValueAt(afiliado.getApellidos(), numeroFila, 1);
                TablaPacientes.setValueAt(afiliado.getNumeroID(), numeroFila, 2);
                TablaPacientes.setValueAt(afiliado.getSexo(), numeroFila, 3);
                TablaPacientes.setValueAt(afiliado.getFecha(), numeroFila, 4);                
                TablaPacientes.setValueAt(afiliado.getHora(), numeroFila, 5);  
                TablaPacientes.setValueAt(afiliado.getCelular(), numeroFila, 6);                
                TablaPacientes.setValueAt(afiliado.getMedico(), numeroFila, 7);
                TablaPacientes.setValueAt(afiliado.getLugar(), numeroFila, 8);       
                TablaPacientes.setValueAt(afiliado.getServicio(), numeroFila, 9);        

                JOptionPane.showMessageDialog(null,"Cita modificada con exito");

                desactivar();
                BotonModificar.setEnabled(false);
                BotonEliminar.setEnabled(false);
            }        
        

    }//GEN-LAST:event_BotonModificarActionPerformed

    private void BotonRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRestaurarActionPerformed
        int numeroFilas = TablaPacientes.getRowCount();
        
        for(int i = numeroFilas-1; i>=0; i--){
            dtm.removeRow(i);
        }
    }//GEN-LAST:event_BotonRestaurarActionPerformed

    private void TablaPacientesArchivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaPacientesArchivoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaPacientesArchivoMouseClicked

    private void TablaPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaPacientesMouseClicked
        if(evt.getClickCount() == 2){
            int numeroFila = TablaPacientes.getSelectedRow();

            activar();
            BotonAgregar.setEnabled(false);
            BotonModificar.setEnabled(true);
            BotonEliminar.setEnabled(true);

            String nombre = (String) TablaPacientes.getValueAt(numeroFila, 0);
            String apellidos = (String) TablaPacientes.getValueAt(numeroFila, 1);
            String numeroID = (String) TablaPacientes.getValueAt(numeroFila, 2);
            String sexo = (String) TablaPacientes.getValueAt(numeroFila, 3);
            String fecha = (String) TablaPacientes.getValueAt(numeroFila, 4);
            String hora = (String) TablaPacientes.getValueAt(numeroFila, 5);
            String celular = (String) TablaPacientes.getValueAt(numeroFila, 6);
            String medico = (String) TablaPacientes.getValueAt(numeroFila, 7);
            String lugar = (String) TablaPacientes.getValueAt(numeroFila, 8);
            String servicio = (String) TablaPacientes.getValueAt(numeroFila, 9);

            CampoNombres.setText(nombre);
            CampoApellidos.setText(apellidos);
            CampoID.setText(numeroID);
            ChooserSexo.setSelectedItem(sexo);
            ChooserHora.setSelectedItem(hora);
            CampoCelular.setText(celular);
            ChooserServicio.setSelectedItem(servicio);
            ChooserMedico.setSelectedItem(medico);
            ChooserLugar.setSelectedItem(lugar);

        }
    }//GEN-LAST:event_TablaPacientesMouseClicked

    private void BotonGenerarTablaArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGenerarTablaArchivoActionPerformed
        try {
            this.conexion = conexion;
            String[] DatosCita = conexion.leerDatos().split("\n");
            crearTablaArchivos();            
            for (String registro : DatosCita){
                String[] datos = registro.split("\n");
                Afiliado afiliado = new Afiliado(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],datos[6],datos[7],datos[8],datos[9]);
                DefaultTableModel anotherDTM = (DefaultTableModel) TablaPacientesArchivo.getModel();
                anotherDTM.addRow(datos);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo");
        }
    }//GEN-LAST:event_BotonGenerarTablaArchivoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServicioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServicioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServicioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServicioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServicioVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAgregar;
    private javax.swing.JButton BotonEliminar;
    private javax.swing.JButton BotonGenerarTablaArchivo;
    private javax.swing.JButton BotonModificar;
    private javax.swing.JButton BotonNuevo;
    private javax.swing.JButton BotonRestaurar;
    private javax.swing.JTextField CampoApellidos;
    private javax.swing.JTextField CampoCelular;
    private javax.swing.JLabel CampoFecha;
    private javax.swing.JTextField CampoID;
    private javax.swing.JTextField CampoNombres;
    private com.toedter.calendar.JDateChooser ChooserFecha;
    private javax.swing.JComboBox<String> ChooserHora;
    private javax.swing.JComboBox<String> ChooserLugar;
    private javax.swing.JComboBox<String> ChooserMedico;
    private javax.swing.JComboBox<String> ChooserServicio;
    private javax.swing.JComboBox<String> ChooserSexo;
    private javax.swing.JPanel ContenedorDatosPersonales;
    private javax.swing.JLabel Label1erApellido;
    private javax.swing.JLabel LabelCelular;
    private javax.swing.JLabel LabelFecha;
    private javax.swing.JLabel LabelHora;
    private javax.swing.JLabel LabelID;
    private javax.swing.JLabel LabelLugar;
    private javax.swing.JLabel LabelMedico;
    private javax.swing.JLabel LabelNombres;
    private javax.swing.JLabel LabelServicio;
    private javax.swing.JLabel LabelSexo;
    private javax.swing.JLabel LabelSubtitulo1;
    private javax.swing.JLabel LabelSubtitulo3;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JPanel PanelCamposTexto;
    private javax.swing.JPanel PanelCita;
    private javax.swing.JTable TablaPacientes;
    private javax.swing.JTable TablaPacientesArchivo;
    private javax.swing.JLabel jLabelInfoTabla;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelContenido;
    private javax.swing.JPanel jPanelTabla;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

}
