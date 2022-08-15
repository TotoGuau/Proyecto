package com.mycompany.proyecto;
import com.itextpdf.text.DocumentException;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ClientesView{
    JPanel panel1= new JPanel();
    JTable table1 = new JTable();
    JButton button1 = new JButton();
    JButton button2 = new JButton();
    JButton button3 = new JButton();
    JButton button4 = new JButton();
    JButton button5 = new JButton();
    JButton button6 = new JButton();
    
    ClientesDAO cd= new ClientesDAO();
    
    String[] datos= new String[5];
    
    private void BeginClientes(){  
        cd.Init();
        
        String[] columnas = {"Codigo","Nombre","NIT","Correo","Genero"};
        
        DefaultTableModel model= new DefaultTableModel(cd.ClientesList(),columnas);
        table1.setModel(model);
        
        JScrollPane scroll1= new JScrollPane(table1);
        
        scroll1.setBounds((int) Math.ceil(panel1.getBounds().width * 0.01),(int) Math.ceil(panel1.getBounds().height * 0.01),(int) Math.ceil(panel1.getBounds().width * 0.7),(int) Math.ceil(panel1.getBounds().height * 0.95));        
        button1.setBounds((int) Math.ceil(panel1.getBounds().width * 0.75),(int) Math.ceil(panel1.getBounds().height * 0.01),(int) Math.ceil(panel1.getBounds().width * 0.2),(int) Math.ceil(panel1.getBounds().height * 0.10));
        button1.setText("Crear");
        button2.setBounds((int) Math.ceil(panel1.getBounds().width * 0.75),(int) Math.ceil(panel1.getBounds().height * 0.13),(int) Math.ceil(panel1.getBounds().width * 0.2),(int) Math.ceil(panel1.getBounds().height * 0.10));
        button2.setText("Carga masiva");
        button3.setBounds((int) Math.ceil(panel1.getBounds().width * 0.75),(int) Math.ceil(panel1.getBounds().height * 0.25),(int) Math.ceil(panel1.getBounds().width * 0.2),(int) Math.ceil(panel1.getBounds().height * 0.10));
        button3.setText("Actualizar");
        button4.setBounds((int) Math.ceil(panel1.getBounds().width * 0.75),(int) Math.ceil(panel1.getBounds().height * 0.37),(int) Math.ceil(panel1.getBounds().width * 0.2),(int) Math.ceil(panel1.getBounds().height * 0.10));
        button4.setText("Eliminar");
        button5.setBounds((int) Math.ceil(panel1.getBounds().width * 0.75),(int) Math.ceil(panel1.getBounds().height * 0.49),(int) Math.ceil(panel1.getBounds().width * 0.2),(int) Math.ceil(panel1.getBounds().height * 0.10));
        button5.setText("Exportar a PDF");
        button6.setBounds((int) Math.ceil(panel1.getBounds().width * 0.72),(int) Math.ceil(panel1.getBounds().height * 0.61),(int) Math.ceil(panel1.getBounds().width * 0.27),(int) Math.ceil(panel1.getBounds().height * 0.34));button6.setBounds((int) Math.ceil(panel1.getBounds().width * 0.72),(int) Math.ceil(panel1.getBounds().height * 0.61),(int) Math.ceil(panel1.getBounds().width * 0.27),(int) Math.ceil(panel1.getBounds().height * 0.34));
        
        panel1.setLayout(null);
        panel1.add(scroll1);
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);
        panel1.add(button5);
        panel1.add(button6);
       
        ActionListener crear = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrearView cv= new CrearView();
                cv.Init(3,0);
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                frame.dispose(); 
            };
        };
        ActionListener actualizar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActualizarView av= new ActualizarView();
                av.Init(3,datos);
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                frame.dispose(); 
            };
        };
        ActionListener eliminar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarView Ev= new EliminarView();
                Ev.Init(3,datos);
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                frame.dispose(); 
            };
        };
        ActionListener carga = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Carga c= new Carga();
                String archivo= c.Archivo();
                if(archivo != ""){
                   c.Carga(3,archivo);
                   JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                   frame.dispose();  
                }
            };
        };
        ActionListener pdf = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cd.Init();
                    cd.PdfCliente();
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null,"Ha ocurrido un error");
                    JOptionPane.showMessageDialog(null,ex);
                } catch (DocumentException ex) {
                    JOptionPane.showMessageDialog(null,"Ha ocurrido un error");
                    JOptionPane.showMessageDialog(null,ex);
                }
            };
        }; 
        table1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                datos[0]=table1.getValueAt(table1.rowAtPoint(e.getPoint()),0).toString();
                datos[1]=table1.getValueAt(table1.rowAtPoint(e.getPoint()),1).toString();
                datos[2]=table1.getValueAt(table1.rowAtPoint(e.getPoint()),2).toString();
                datos[3]=table1.getValueAt(table1.rowAtPoint(e.getPoint()),3).toString();
                datos[4]=table1.getValueAt(table1.rowAtPoint(e.getPoint()),4).toString();             
            }
        });
        
        button1.addActionListener(crear);
        button2.addActionListener(carga);
        button3.addActionListener(actualizar);
        button4.addActionListener(eliminar);
        button5.addActionListener(pdf);
    }
    
    public void Init(int a,int b, int c ,int d) {
        panel1.setBounds(a,b,c,d);
        BeginClientes();
    }
}
