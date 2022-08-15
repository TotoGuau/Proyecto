package com.mycompany.proyecto;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class NuevaVentaView{
    JPanel panel1= new JPanel();
    JPanel panel2= new JPanel();
    JLabel label1= new JLabel();
    JLabel label2= new JLabel();
    JLabel label3= new JLabel();
    JLabel label4= new JLabel();
    JLabel label5= new JLabel();
    JLabel label6= new JLabel();
    JLabel label7= new JLabel();
    JTextField text1= new JTextField();
    JTextField text2= new JTextField();
    JTextField text3= new JTextField();
    JTextField text4= new JTextField();
    JButton button1= new JButton();
    JTable table1= new JTable();
    
    NuevaVentaDAO nvd= new NuevaVentaDAO();
    
    String cliente;
    int vendedor;
    int activo=1;
    
    private void BeginNuevaVentaP1(){       
        panel1.setLayout(null);
        panel2.setLayout(null);
        panel2.setBounds((int) Math.ceil(panel1.getBounds().width * 0.01),(int) Math.ceil(panel1.getBounds().height * 0.01),(int) Math.ceil(panel1.getBounds().width * 0.97),(int) Math.ceil(panel1.getBounds().height * 0.94));       
        label1.setBounds((int) Math.ceil(panel2.getBounds().width * 0.01),(int) Math.ceil(panel2.getBounds().height * 0.01),(int) Math.ceil(panel2.getBounds().width * 0.1),(int) Math.ceil(panel2.getBounds().height * 0.05));        
        label1.setText("Seleccionar cliente");
        label2.setBounds((int) Math.ceil(panel2.getBounds().width * 0.03),(int) Math.ceil(panel2.getBounds().height * 0.05),(int) Math.ceil(panel2.getBounds().width * 0.1),(int) Math.ceil(panel2.getBounds().height * 0.05));        
        label2.setText("Filtros");
        label3.setBounds((int) Math.ceil(panel2.getBounds().width * 0.05),(int) Math.ceil(panel2.getBounds().height * 0.09),(int) Math.ceil(panel2.getBounds().width * 0.1),(int) Math.ceil(panel2.getBounds().height * 0.05));        
        label3.setText("Nombre");
        text1.setBounds((int) Math.ceil(panel2.getBounds().width * 0.09),(int) Math.ceil(panel2.getBounds().height * 0.09),(int) Math.ceil(panel2.getBounds().width * 0.2),(int) Math.ceil(panel2.getBounds().height * 0.05));        
        label4.setBounds((int) Math.ceil(panel2.getBounds().width * 0.35),(int) Math.ceil(panel2.getBounds().height * 0.09),(int) Math.ceil(panel2.getBounds().width * 0.1),(int) Math.ceil(panel2.getBounds().height * 0.05));        
        label4.setText("NIT");
        text2.setBounds((int) Math.ceil(panel2.getBounds().width * 0.37),(int) Math.ceil(panel2.getBounds().height * 0.09),(int) Math.ceil(panel2.getBounds().width * 0.2),(int) Math.ceil(panel2.getBounds().height * 0.05));        
        label5.setBounds((int) Math.ceil(panel2.getBounds().width * 0.65),(int) Math.ceil(panel2.getBounds().height * 0.09),(int) Math.ceil(panel2.getBounds().width * 0.1),(int) Math.ceil(panel2.getBounds().height * 0.05));        
        label5.setText("Correo");
        text3.setBounds((int) Math.ceil(panel2.getBounds().width * 0.69),(int) Math.ceil(panel2.getBounds().height * 0.09),(int) Math.ceil(panel2.getBounds().width * 0.2),(int) Math.ceil(panel2.getBounds().height * 0.05));             
        label6.setBounds((int) Math.ceil(panel2.getBounds().width * 0.05),(int) Math.ceil(panel2.getBounds().height * 0.19),(int) Math.ceil(panel2.getBounds().width * 0.1),(int) Math.ceil(panel2.getBounds().height * 0.05));        
        label6.setText("Genero");
        text4.setBounds((int) Math.ceil(panel2.getBounds().width * 0.09),(int) Math.ceil(panel2.getBounds().height * 0.19),(int) Math.ceil(panel2.getBounds().width * 0.2),(int) Math.ceil(panel2.getBounds().height * 0.05));        
        button1.setBounds((int) Math.ceil(panel2.getBounds().width * 0.37),(int) Math.ceil(panel2.getBounds().height * 0.19),(int) Math.ceil(panel2.getBounds().width * 0.1),(int) Math.ceil(panel2.getBounds().height * 0.05));        
        button1.setText("Nuevo cliente");
        label7.setBounds((int) Math.ceil(panel2.getBounds().width * 0.01),(int) Math.ceil(panel2.getBounds().height * 0.29),(int) Math.ceil(panel2.getBounds().width * 0.1),(int) Math.ceil(panel2.getBounds().height * 0.05));        
        label7.setText("Resultados");
        
        JScrollPane scroll1= new JScrollPane(table1);
        scroll1.setBounds((int) Math.ceil(panel2.getBounds().width * 0.01),(int) Math.ceil(panel2.getBounds().height * 0.35),(int) Math.ceil(panel2.getBounds().width * 0.97),(int) Math.ceil(panel2.getBounds().height * 0.63));        
        panel2.add(scroll1);
        
        panel1.add(panel2);
        panel2.add(label1);
        panel2.add(label2);
        panel2.add(label3);
        panel2.add(label4);
        panel2.add(label5);
        panel2.add(label6);
        panel2.add(label7);
        panel2.add(text1);
        panel2.add(text2);
        panel2.add(text3);
        panel2.add(text4);
        panel2.add(button1);
       
        ActionListener crear = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrearView cv= new CrearView();
                cv.Init(5,vendedor);
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                frame.dispose(); 
            };
        };           
        table1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount()==2){
                 cliente=table1.getValueAt(table1.rowAtPoint(e.getPoint()),0).toString();
                 BeginNuevaVentaP2();
                 BeginTabla2();
                }
            }
        });
        text1.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                BeginTabla1();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                BeginTabla1();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                BeginTabla1();
            }    
        });
        text2.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                BeginTabla1();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                BeginTabla1();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                BeginTabla1();
            }    
        });
        text3.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                BeginTabla1();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                BeginTabla1();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                BeginTabla1();
            }    
        });
        text4.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                BeginTabla1();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                BeginTabla1();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                BeginTabla1();
            }    
        });
        
        button1.addActionListener(crear);      
    }
 
    JPanel panel3= new JPanel();
    JLabel label8= new JLabel();
    JLabel label9= new JLabel();
    JLabel label10= new JLabel();
    JLabel label11= new JLabel();
    JLabel label12= new JLabel();
    JLabel label13= new JLabel();
    JLabel label14= new JLabel();
    JTextField text5= new JTextField();
    JTextField text6= new JTextField();
    JButton button2= new JButton();
    JTable table2= new JTable();
    JTable table3= new JTable();
    
    private void BeginNuevaVentaP2(){
        String[] columnas2 = {"Codigo","Nombre","Cantidad","Precio","Subtotal"};
        DefaultTableModel model2= new DefaultTableModel(null,columnas2){
            @Override
            public boolean isCellEditable(int fila, int columna){
                return false;
            }
        };
        String[] columnas3 = {"Codigo","Nombre","Cantidad","Precio","Subtotal"};
        DefaultTableModel model3= new DefaultTableModel(null,columnas3){
            @Override
            public boolean isCellEditable(int fila, int columna){
                return false;
            }
        };

        panel2.setVisible(false);
        panel3.setLayout(null);
        panel3.setVisible(true);
        panel3.setBounds((int) Math.ceil(panel1.getBounds().width * 0.01),(int) Math.ceil(panel1.getBounds().height * 0.01),(int) Math.ceil(panel1.getBounds().width * 0.97),(int) Math.ceil(panel1.getBounds().height * 0.96));        
        label8.setBounds((int) Math.ceil(panel2.getBounds().width * 0.01),(int) Math.ceil(panel2.getBounds().height * 0.01),(int) Math.ceil(panel2.getBounds().width * 0.1),(int) Math.ceil(panel2.getBounds().height * 0.05));        
        label8.setText("Seleccionar producto");
        label9.setBounds((int) Math.ceil(panel2.getBounds().width * 0.85),(int) Math.ceil(panel2.getBounds().height * 0.01),(int) Math.ceil(panel2.getBounds().width * 0.1),(int) Math.ceil(panel2.getBounds().height * 0.05));        
        label9.setText("Fecha " + LocalDate.now().toString());
        label10.setBounds((int) Math.ceil(panel2.getBounds().width * 0.95),(int) Math.ceil(panel2.getBounds().height * 0.01),(int) Math.ceil(panel2.getBounds().width * 0.1),(int) Math.ceil(panel2.getBounds().height * 0.05));        
        label10.setText("No." + nvd.FacturaNo());
        label11.setBounds((int) Math.ceil(panel2.getBounds().width * 0.03),(int) Math.ceil(panel2.getBounds().height * 0.05),(int) Math.ceil(panel2.getBounds().width * 0.1),(int) Math.ceil(panel2.getBounds().height * 0.05));        
        label11.setText("Filtros");
        label12.setBounds((int) Math.ceil(panel2.getBounds().width * 0.05),(int) Math.ceil(panel2.getBounds().height * 0.09),(int) Math.ceil(panel2.getBounds().width * 0.1),(int) Math.ceil(panel2.getBounds().height * 0.05));        
        label12.setText("Codigo");
        text5.setBounds((int) Math.ceil(panel2.getBounds().width * 0.09),(int) Math.ceil(panel2.getBounds().height * 0.09),(int) Math.ceil(panel2.getBounds().width * 0.2),(int) Math.ceil(panel2.getBounds().height * 0.05));        
        label13.setBounds((int) Math.ceil(panel2.getBounds().width * 0.35),(int) Math.ceil(panel2.getBounds().height * 0.09),(int) Math.ceil(panel2.getBounds().width * 0.1),(int) Math.ceil(panel2.getBounds().height * 0.05));        
        label13.setText("Nombre");
        text6.setBounds((int) Math.ceil(panel2.getBounds().width * 0.39),(int) Math.ceil(panel2.getBounds().height * 0.09),(int) Math.ceil(panel2.getBounds().width * 0.2),(int) Math.ceil(panel2.getBounds().height * 0.05));        
        label14.setBounds((int) Math.ceil(panel2.getBounds().width * 0.03),(int) Math.ceil(panel2.getBounds().height * 0.50),(int) Math.ceil(panel2.getBounds().width * 0.1),(int) Math.ceil(panel2.getBounds().height * 0.05));        
        label14.setText("Agregar");
        button2.setBounds((int) Math.ceil(panel2.getBounds().width * 0.88),(int) Math.ceil(panel2.getBounds().height * 0.93),(int) Math.ceil(panel2.getBounds().width * 0.1),(int) Math.ceil(panel2.getBounds().height * 0.05));        
        button2.setText("Vender");
        
        JScrollPane scroll2= new JScrollPane(table2);
        scroll2.setBounds((int) Math.ceil(panel2.getBounds().width * 0.01),(int) Math.ceil(panel2.getBounds().height * 0.17),(int) Math.ceil(panel2.getBounds().width * 0.97),(int) Math.ceil(panel2.getBounds().height * 0.30));        
        panel3.add(scroll2);
        
        
        table3.setModel(model3);
        table3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll3= new JScrollPane(table3);
        scroll3.setBounds((int) Math.ceil(panel2.getBounds().width * 0.01),(int) Math.ceil(panel2.getBounds().height * 0.56),(int) Math.ceil(panel2.getBounds().width * 0.97),(int) Math.ceil(panel2.getBounds().height * 0.36));        
           
        panel1.add(panel3);
        panel3.add(scroll3);
        panel3.add(label8);
        panel3.add(label9);
        panel3.add(label10);
        panel3.add(label11);
        panel3.add(label12);
        panel3.add(label13);
        panel3.add(label14);
        panel3.add(text5);
        panel3.add(text6);
        panel3.add(button2);      
        
        ActionListener vender = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(activo==1){
                    model3.addRow(new Object[]{"","","","",""});
                    model3.addRow(new Object[]{"","","","",""});
                    model3.addRow(new Object[]{"","","","",""});
                    Object[] filas = new Object[5];  
                    filas[0]= "Total";
                    filas[1]= "";
                    filas[2]= "";
                    filas[3]= "";
                    int a;
                    double b=0;
                    DefaultTableModel c = (DefaultTableModel) table3.getModel();
                    for(a=0;a<=table3.getRowCount()-1;a++){
                        if(String.valueOf(c.getValueAt(a, 4))!=""){
                        b +=Double.parseDouble(String.valueOf(c.getValueAt(a, 4)));
                        }
                    }
                    filas[4]= ("" + b); 
                    model3.addRow(filas);
                    table3.setFont(table3.getFont().deriveFont(Font.BOLD));
                    table2.setCellSelectionEnabled(false);
                    table3.setCellSelectionEnabled(false);
                    scroll2.setEnabled(false);
                    scroll3.setEnabled(false);
                    table2.setEnabled(false);
                    table3.setEnabled(false);
                    activo=0;
                }else{
                    Object filas[][] = null;  
                    int a;
                    double b=0;
                    DefaultTableModel c = (DefaultTableModel) table3.getModel();
                    int d=0;
                    for(a=0;a<=table3.getRowCount()-1;a++){
                        if(String.valueOf(c.getValueAt(a, 3))!=""){
                        b +=Double.parseDouble(String.valueOf(c.getValueAt(a, 4)));
                        d+=1;
                        }
                    }
                    filas=new Object[d][2];
                    for(a=0;a<d;a++){
                        filas[a][0]=table3.getValueAt(a, 0);
                        filas[a][1]=table3.getValueAt(a, 2);
                    }
                    if(nvd.VentaInsert(cliente,vendedor,b,a,filas) == 1){
                        JOptionPane.showMessageDialog(null, "Se ha ingresado la venta");
                        VendedorView vv= new VendedorView();
                        vv.Init(vendedor);
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel3);
                        frame.dispose(); 
                    }
                }
            };
        };  
        table2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount()==2  && activo==1){
                    double a;
                    do {                        
                        a=Double.parseDouble(JOptionPane.showInputDialog(null, "¿Cuantas unidades deseas?"));  
                    } while (a<=0);
                    Object[] filas = new Object[5];
                    filas[0]= table2.getValueAt(table2.rowAtPoint(e.getPoint()),0).toString();
                    filas[1]= table2.getValueAt(table2.rowAtPoint(e.getPoint()),1).toString();
                    filas[2]= a;
                    filas[3]= table2.getValueAt(table2.rowAtPoint(e.getPoint()),3).toString();
                    filas[4]=  (Double.parseDouble(table2.getValueAt(table2.rowAtPoint(e.getPoint()),3).toString())* a);
                    model3.addRow(filas);             
                }
            }
        });
        text5.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                BeginTabla2();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                BeginTabla2();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                BeginTabla2();
            }    
        });
        text6.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                BeginTabla2();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                BeginTabla2();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                BeginTabla2();
            }    
        });
        
        button2.addActionListener(vender);         
    }
    
    private void BeginTabla1(){
        nvd.Init();
        String[] columnas1 = {"Codigo","Nombre","NIT","Correo","Genero"};
        
        DefaultTableModel model1= new DefaultTableModel(nvd.ClientesList(text1.getText(),text2.getText(),text3.getText(),text4.getText()),columnas1){
            @Override
            public boolean isCellEditable(int fila, int columna){
                return false;
            }
        }; 
        table1.setModel(model1);
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    private void BeginTabla2(){
        nvd.Init();
        String[] columnas2 = {"Codigo","Nombre","Descripcion","Cantidad","Precio"};
        
        DefaultTableModel model2= new DefaultTableModel(nvd.ProductosList(text5.getText(),text6.getText()),columnas2){
            @Override
            public boolean isCellEditable(int fila, int columna){
                return false;
            }
        }; 
        table2.setModel(model2);
        table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    public void Init(int a,int b, int c ,int d, int e) {
        vendedor=e;
        panel1.setBounds(a,b,c,d);
        BeginNuevaVentaP1();
        BeginTabla1();
    }
}
