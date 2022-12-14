/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import com.toedter.calendar.JDateChooser;
import modelo.ListaDeAfiliados;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jsmr0
 */
public class ServicioVista extends javax.swing.JFrame {
    DefaultTableModel dtm;
    ListaDeAfiliados afiliadoControlador;
    
    public ServicioVista() {
        
        this.dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        }; 
         
        initComponents();
        crearTabla();         
        
        afiliadoControlador = new ListaDeAfiliados();
        afiliadoControlador.crearArrayList();         
    }
        
    private void crearTabla(){
        String[] titulo=new String[]{"Nombre", "Apellidos",  
            "Numero de ID", "Sexo", "Dia cita", "Hora cita", "Telefono", 
            "Medico", "Lugar", "Servicio"};
        dtm.setColumnIdentifiers(titulo);
        TablaPacientes.setModel(dtm);      
    }
   
    
    public String[]servicios(String servicios){
        String[]nombresDeDoctores = new String[5];       
        if(servicios.equalsIgnoreCase("Odontología")){
            nombresDeDoctores[0]="Ivan Torres";
            nombresDeDoctores[1]="María Pilar Lopez";
            nombresDeDoctores[2]="Inés Alvarez";  
            nombresDeDoctores[3]="Juan Manuel Martinez";
            nombresDeDoctores[4]="Leider Gil";              
        }
        if(servicios.equalsIgnoreCase("Examen de Laboratorio")){
            nombresDeDoctores[0]="Jesus Vazquez";
            nombresDeDoctores[1]="Jose Antonio Jimenez";
            nombresDeDoctores[2]="Juan Saez";  
            nombresDeDoctores[3]="Ricardo Herrera";
            nombresDeDoctores[4]="Julian Guzman";  
        }        
        if(servicios.equalsIgnoreCase("Cita General")){
            nombresDeDoctores[0]="Isabel Gutierrez";
            nombresDeDoctores[1]="Exequiel Montero";
            nombresDeDoctores[2]="Luisa Carmona";
            nombresDeDoctores[3]="David Mina";
            nombresDeDoctores[4]="Ivan Reyes";            
        }  
        if(servicios.equalsIgnoreCase("Cita con Especialista")){
            nombresDeDoctores[0]="Catalina Nuñez";
            nombresDeDoctores[1]="Carlos Delgado";
            nombresDeDoctores[2]="Sergio Salcedo";
            nombresDeDoctores[3]="Celia Vidal";
            nombresDeDoctores[4]="Sergio Duarte";            
        }         
        return nombresDeDoctores;
    }
    
    public String[]consultorios(String consultorios){
        String[]nombresDeCosultorios = new String[3];       
        if(consultorios.equalsIgnoreCase("Odontología")){
            nombresDeCosultorios[0]="Consultorio 1";
            nombresDeCosultorios[1]="Consultorio 2";
            nombresDeCosultorios[2]="Consultorio 3";              
        }
        if(consultorios.equalsIgnoreCase("Examen de Laboratorio")){
            nombresDeCosultorios[0]="Laboratorio 1";
            nombresDeCosultorios[1]="Laboratorio 2";
            nombresDeCosultorios[2]="Laboratorio 3";            
        }        
        if(consultorios.equalsIgnoreCase("Cita General")){
            nombresDeCosultorios[0]="Consultorio 4";
            nombresDeCosultorios[1]="Consultorio 5";
            nombresDeCosultorios[2]="Consultorio 6";         
        }  
        if(consultorios.equalsIgnoreCase("Cita con Especialista")){
            nombresDeCosultorios[0]="Consultorio 7";
            nombresDeCosultorios[1]="Consultorio 8";
            nombresDeCosultorios[2]="Consultorio 9";         
        }         
        return nombresDeCosultorios;
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
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
        BotonExportarA = new javax.swing.JButton();
        BotonGuardarBU = new javax.swing.JButton();
        BotonCargarBU = new javax.swing.JButton();
        CampoFecha = new javax.swing.JLabel();
        ChooserFecha = new com.toedter.calendar.JDateChooser();
        LabelSubtitulo3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPacientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        LabelLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 204));
        setMinimumSize(new java.awt.Dimension(975, 500));
        setPreferredSize(new java.awt.Dimension(970, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(975, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 153, 153));

        jPanelContenido.setBackground(new java.awt.Color(255, 204, 204));

        PanelCamposTexto.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelCamposTextoLayout = new javax.swing.GroupLayout(PanelCamposTexto);
        PanelCamposTexto.setLayout(PanelCamposTextoLayout);
        PanelCamposTextoLayout.setHorizontalGroup(
            PanelCamposTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelCamposTextoLayout.setVerticalGroup(
            PanelCamposTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
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

        ContenedorDatosPersonales.setBackground(new java.awt.Color(255, 204, 204));

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

        PanelCita.setBackground(new java.awt.Color(255, 204, 204));
        PanelCita.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelServicio.setText("Servicio requerido:");
        PanelCita.add(LabelServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

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
        PanelCita.add(ChooserServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 176, -1));

        LabelMedico.setText("Doctor encargado:");
        PanelCita.add(LabelMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        ChooserMedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "--", "--", "--", "--" }));
        ChooserMedico.setEnabled(false);
        PanelCita.add(ChooserMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 176, -1));

        LabelFecha.setText("Fecha:");
        PanelCita.add(LabelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 47, 22));

        LabelHora.setText("Hora:");
        PanelCita.add(LabelHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, 19));

        ChooserHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "6:00 AM", "7:00 AM", "8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 M", "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM", "7:00 PM", "8:00 PM" }));
        ChooserHora.setEnabled(false);
        PanelCita.add(ChooserHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 176, -1));

        LabelLugar.setText("Consultorio:");
        PanelCita.add(LabelLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        ChooserLugar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "Consultorio 1", "Consultorio 2", "Consultorio 3", "Consultorio 4", "Consultorio 5", "Consultorio 6" }));
        ChooserLugar.setEnabled(false);
        PanelCita.add(ChooserLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 176, -1));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        BotonAgregar.setText("AGREGAR");
        BotonAgregar.setEnabled(false);
        BotonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarActionPerformed(evt);
            }
        });

        BotonModificar.setText("MODIFICA");
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

        BotonRestaurar.setText("LIMPIAR TABLA");
        BotonRestaurar.setEnabled(false);
        BotonRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRestaurarActionPerformed(evt);
            }
        });

        BotonExportarA.setText("EXPORTAR AFILIADOS");
        BotonExportarA.setEnabled(false);
        BotonExportarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonExportarAActionPerformed(evt);
            }
        });

        BotonGuardarBU.setText("GUARDAR BACK UP");
        BotonGuardarBU.setEnabled(false);

        BotonCargarBU.setText("CARGAR BACK UP");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BotonRestaurar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BotonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BotonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BotonAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(BotonGuardarBU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonExportarA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonCargarBU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
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
                .addComponent(BotonExportarA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotonGuardarBU)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotonCargarBU)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelCita.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 0, -1, -1));
        PanelCita.add(CampoFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 151, 22));

        ChooserFecha.setDate(new java.util.Date(1669874463000L));
        ChooserFecha.setEnabled(false);
        ChooserFecha.setMaxSelectableDate(new java.util.Date(1704002463000L));
        ChooserFecha.setMinSelectableDate(new java.util.Date(1641016863000L));
        ChooserFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ChooserFechaPropertyChange(evt);
            }
        });
        PanelCita.add(ChooserFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 19, -1));

        LabelSubtitulo3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        LabelSubtitulo3.setText("Detalles de la cita medica:");
        PanelCita.add(LabelSubtitulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, -1));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(PanelCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addGap(0, 67, Short.MAX_VALUE))
            .addComponent(PanelCita, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelContenidoLayout = new javax.swing.GroupLayout(jPanelContenido);
        jPanelContenido.setLayout(jPanelContenidoLayout);
        jPanelContenidoLayout.setHorizontalGroup(
            jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenidoLayout.createSequentialGroup()
                .addGap(370, 370, 370)
                .addComponent(jPanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ContenedorDatosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(932, 932, 932)
                .addComponent(PanelCamposTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                        .addGap(18, 18, 18)
                        .addComponent(ContenedorDatosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Ingreso de datos", jPanelContenido);

        TablaPacientes.setBackground(new java.awt.Color(255, 204, 204));
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
        TablaPacientes.setSelectionBackground(new java.awt.Color(255, 204, 204));
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

        jTabbedPane1.addTab("Tabla de citas programas", jScrollPane1);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 975, 440));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        LabelLogo.setIcon(new javax.swing.ImageIcon("C:\\Users\\jsmr0\\OneDrive\\Documentos\\NetBeansProjects\\Miniproyecto3\\src\\main\\archivos\\logovalle.png")); // NOI18N
        jPanel1.add(LabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public DefaultTableModel getDtm() {
        return dtm;
    }

    public void setDtm(DefaultTableModel dtm) {
        this.dtm = dtm;
    }

    public ListaDeAfiliados getAfiliadoControlador() {
        return afiliadoControlador;
    }

    public void setAfiliadoControlador(ListaDeAfiliados afiliadoControlador) {
        this.afiliadoControlador = afiliadoControlador;
    }

    public JButton getBotonAgregar() {
        return BotonAgregar;
    }

    public void setBotonAgregar(JButton BotonAgregar) {
        this.BotonAgregar = BotonAgregar;
    }

    public JButton getBotonEliminar() {
        return BotonEliminar;
    }

    public void setBotonEliminar(JButton BotonEliminar) {
        this.BotonEliminar = BotonEliminar;
    }

    public JButton getBotonExportarA() {
        return BotonExportarA;
    }

    public void setBotonExportarA(JButton BotonExportarA) {
        this.BotonExportarA = BotonExportarA;
    }

    public JButton getBotonModificar() {
        return BotonModificar;
    }

    public void setBotonModificar(JButton BotonModificar) {
        this.BotonModificar = BotonModificar;
    }

    public JButton getBotonNuevo() {
        return BotonNuevo;
    }

    public void setBotonNuevo(JButton BotonNuevo) {
        this.BotonNuevo = BotonNuevo;
    }

    public JButton getBotonRestaurar() {
        return BotonRestaurar;
    }

    public void setBotonRestaurar(JButton BotonRestaurar) {
        this.BotonRestaurar = BotonRestaurar;
    }

    public JTextField getCampoApellidos() {
        return CampoApellidos;
    }

    public void setCampoApellidos(JTextField CampoApellidos) {
        this.CampoApellidos = CampoApellidos;
    }

    public JTextField getCampoCelular() {
        return CampoCelular;
    }

    public void setCampoCelular(JTextField CampoCelular) {
        this.CampoCelular = CampoCelular;
    }

    public JLabel getCampoFecha() {
        return CampoFecha;
    }

    public void setCampoFecha(JLabel CampoFecha) {
        this.CampoFecha = CampoFecha;
    }

    public JTextField getCampoID() {
        return CampoID;
    }

    public void setCampoID(JTextField CampoID) {
        this.CampoID = CampoID;
    }

    public JTextField getCampoNombres() {
        return CampoNombres;
    }

    public void setCampoNombres(JTextField CampoNombres) {
        this.CampoNombres = CampoNombres;
    }

    public JDateChooser getChooserFecha() {
        return ChooserFecha;
    }

    public void setChooserFecha(JDateChooser ChooserFecha) {
        this.ChooserFecha = ChooserFecha;
    }

    public JComboBox<String> getChooserHora() {
        return ChooserHora;
    }

    public void setChooserHora(JComboBox<String> ChooserHora) {
        this.ChooserHora = ChooserHora;
    }

    public JComboBox<String> getChooserLugar() {
        return ChooserLugar;
    }

    public void setChooserLugar(JComboBox<String> ChooserLugar) {
        this.ChooserLugar = ChooserLugar;
    }

    public JComboBox<String> getChooserMedico() {
        return ChooserMedico;
    }

    public void setChooserMedico(JComboBox<String> ChooserMedico) {
        this.ChooserMedico = ChooserMedico;
    }

    public JComboBox<String> getChooserServicio() {
        return ChooserServicio;
    }

    public void setChooserServicio(JComboBox<String> ChooserServicio) {
        this.ChooserServicio = ChooserServicio;
    }

    public JComboBox<String> getChooserSexo() {
        return ChooserSexo;
    }

    public void setChooserSexo(JComboBox<String> ChooserSexo) {
        this.ChooserSexo = ChooserSexo;
    }

    public JPanel getContenedorDatosPersonales() {
        return ContenedorDatosPersonales;
    }

    public void setContenedorDatosPersonales(JPanel ContenedorDatosPersonales) {
        this.ContenedorDatosPersonales = ContenedorDatosPersonales;
    }

    public JPanel getPanelCamposTexto() {
        return PanelCamposTexto;
    }

    public void setPanelCamposTexto(JPanel PanelCamposTexto) {
        this.PanelCamposTexto = PanelCamposTexto;
    }

    public JPanel getPanelCita() {
        return PanelCita;
    }

    public void setPanelCita(JPanel PanelCita) {
        this.PanelCita = PanelCita;
    }

    public JTable getTablaPacientes() {
        return TablaPacientes;
    }

    public void setTablaPacientes(JTable TablaPacientes) {
        this.TablaPacientes = TablaPacientes;
    }

    public JButton getBotonGuardarBU() {
        return BotonGuardarBU;
    }

    public void setBotonGuardarBU(JButton BotonGuardarBU) {
        this.BotonGuardarBU = BotonGuardarBU;
    }

    public JButton getBotonCargarBU() {
        return BotonCargarBU;
    }

    public void setBotonCargarBU(JButton BotonCargarBU) {
        this.BotonCargarBU = BotonCargarBU;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JPanel getjPanelContenido() {
        return jPanelContenido;
    }

    public void setjPanelContenido(JPanel jPanelContenido) {
        this.jPanelContenido = jPanelContenido;
    }

    public JPanel getjPanelTabla() {
        return jPanelTabla;
    }

    public void setjPanelTabla(JPanel jPanelTabla) {
        this.jPanelTabla = jPanelTabla;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    public void setjTabbedPane1(JTabbedPane jTabbedPane1) {
        this.jTabbedPane1 = jTabbedPane1;
    }
    
    
    private void ChooserFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ChooserFechaPropertyChange

    }//GEN-LAST:event_ChooserFechaPropertyChange

    private void BotonRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRestaurarActionPerformed

    }//GEN-LAST:event_BotonRestaurarActionPerformed

    private void BotonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNuevoActionPerformed

    }//GEN-LAST:event_BotonNuevoActionPerformed

    private void BotonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEliminarActionPerformed

    }//GEN-LAST:event_BotonEliminarActionPerformed

    private void BotonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonModificarActionPerformed

    }//GEN-LAST:event_BotonModificarActionPerformed

    private void BotonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarActionPerformed

    }//GEN-LAST:event_BotonAgregarActionPerformed

    private void ChooserServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooserServicioActionPerformed

    }//GEN-LAST:event_ChooserServicioActionPerformed

    private void ChooserServicioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ChooserServicioItemStateChanged

    }//GEN-LAST:event_ChooserServicioItemStateChanged

    private void TablaPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaPacientesMouseClicked

    }//GEN-LAST:event_TablaPacientesMouseClicked

    private void BotonExportarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonExportarAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonExportarAActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAgregar;
    private javax.swing.JButton BotonCargarBU;
    private javax.swing.JButton BotonEliminar;
    private javax.swing.JButton BotonExportarA;
    private javax.swing.JButton BotonGuardarBU;
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
    private javax.swing.JLabel LabelLogo;
    private javax.swing.JLabel LabelLugar;
    private javax.swing.JLabel LabelMedico;
    private javax.swing.JLabel LabelNombres;
    private javax.swing.JLabel LabelServicio;
    private javax.swing.JLabel LabelSexo;
    private javax.swing.JLabel LabelSubtitulo1;
    private javax.swing.JLabel LabelSubtitulo3;
    private javax.swing.JPanel PanelCamposTexto;
    private javax.swing.JPanel PanelCita;
    private javax.swing.JTable TablaPacientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelContenido;
    private javax.swing.JPanel jPanelTabla;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

}
