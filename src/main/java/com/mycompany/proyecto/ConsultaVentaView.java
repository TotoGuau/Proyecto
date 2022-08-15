package com.mycompany.proyecto;
import com.itextpdf.text.DocumentException;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class ConsultaVentaView {
        JPanel panel1= new JPanel();
        JLabel label1= new JLabel();
        JLabel label2= new JLabel();
        JLabel label3= new JLabel();
        JLabel label4= new JLabel();
        JLabel label5= new JLabel();
        JLabel label6= new JLabel();
        JLabel label7= new JLabel();
        JTextField text1 = new JTextField();
        JTextField text2 = new JTextField();
        JTextField text3 = new JTextField();
        JTextField text4 = new JTextField();
        JTable table1= new JTable();
        
        ConsultaVentaDAO cvd= new ConsultaVentaDAO();
               
        public void BeginConsultaVenta(){              
            panel1.setLayout(null);
            label1.setBounds((int) Math.ceil(panel1.getBounds().width * 0.01),(int) Math.ceil(panel1.getBounds().height * 0.01),(int) Math.ceil(panel1.getBounds().width * 0.1),(int) Math.ceil(panel1.getBounds().height * 0.05));        
            label1.setText("Seleccionar venta");
            label2.setBounds((int) Math.ceil(panel1.getBounds().width * 0.03),(int) Math.ceil(panel1.getBounds().height * 0.05),(int) Math.ceil(panel1.getBounds().width * 0.1),(int) Math.ceil(panel1.getBounds().height * 0.05));        
            label2.setText("Filtros");
            label3.setBounds((int) Math.ceil(panel1.getBounds().width * 0.05),(int) Math.ceil(panel1.getBounds().height * 0.09),(int) Math.ceil(panel1.getBounds().width * 0.1),(int) Math.ceil(panel1.getBounds().height * 0.05));        
            label3.setText("No. Factura");
            text1.setBounds((int) Math.ceil(panel1.getBounds().width * 0.10),(int) Math.ceil(panel1.getBounds().height * 0.09),(int) Math.ceil(panel1.getBounds().width * 0.2),(int) Math.ceil(panel1.getBounds().height * 0.05));        
            label4.setBounds((int) Math.ceil(panel1.getBounds().width * 0.35),(int) Math.ceil(panel1.getBounds().height * 0.09),(int) Math.ceil(panel1.getBounds().width * 0.1),(int) Math.ceil(panel1.getBounds().height * 0.05));        
            label4.setText("NIT");
            text2.setBounds((int) Math.ceil(panel1.getBounds().width * 0.37),(int) Math.ceil(panel1.getBounds().height * 0.09),(int) Math.ceil(panel1.getBounds().width * 0.2),(int) Math.ceil(panel1.getBounds().height * 0.05));        
            label5.setBounds((int) Math.ceil(panel1.getBounds().width * 0.65),(int) Math.ceil(panel1.getBounds().height * 0.09),(int) Math.ceil(panel1.getBounds().width * 0.1),(int) Math.ceil(panel1.getBounds().height * 0.05));        
            label5.setText("Nombre");
            text3.setBounds((int) Math.ceil(panel1.getBounds().width * 0.69),(int) Math.ceil(panel1.getBounds().height * 0.09),(int) Math.ceil(panel1.getBounds().width * 0.2),(int) Math.ceil(panel1.getBounds().height * 0.05));             
            label6.setBounds((int) Math.ceil(panel1.getBounds().width * 0.05),(int) Math.ceil(panel1.getBounds().height * 0.19),(int) Math.ceil(panel1.getBounds().width * 0.1),(int) Math.ceil(panel1.getBounds().height * 0.05));        
            label6.setText("Fecha");
            text4.setBounds((int) Math.ceil(panel1.getBounds().width * 0.09),(int) Math.ceil(panel1.getBounds().height * 0.19),(int) Math.ceil(panel1.getBounds().width * 0.2),(int) Math.ceil(panel1.getBounds().height * 0.05));        
            label7.setBounds((int) Math.ceil(panel1.getBounds().width * 0.01),(int) Math.ceil(panel1.getBounds().height * 0.29),(int) Math.ceil(panel1.getBounds().width * 0.1),(int) Math.ceil(panel1.getBounds().height * 0.05));        
            label7.setText("Resultados");
            
            JScrollPane scroll1= new JScrollPane(table1);
            scroll1.setBounds((int) Math.ceil(panel1.getBounds().width * 0.01),(int) Math.ceil(panel1.getBounds().height * 0.35),(int) Math.ceil(panel1.getBounds().width * 0.97),(int) Math.ceil(panel1.getBounds().height * 0.59));        
            panel1.add(scroll1);
            
            panel1.add(label1);
            panel1.add(label2);
            panel1.add(label3);
            panel1.add(label4);
            panel1.add(label5);
            panel1.add(label6);
            panel1.add(label7);
            panel1.add(text1);
            panel1.add(text2);
            panel1.add(text3);
            panel1.add(text4);
            
            table1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount()==2){       
                    String a= table1.getValueAt(table1.rowAtPoint(e.getPoint()),0).toString();
                    try {
                    cvd.Init();
                    cvd.PdfConsultaVenta(a);
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null,"Ha ocurrido un error");
                    JOptionPane.showMessageDialog(null,ex);
                } catch (DocumentException ex) {
                    JOptionPane.showMessageDialog(null,"Ha ocurrido un error");
                    JOptionPane.showMessageDialog(null,ex);
                }
                }
            }
            });
            text1.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                BeginTabla();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                BeginTabla();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                BeginTabla();
            }    
            });
            text2.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                BeginTabla();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                BeginTabla();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                BeginTabla();
            }    
            });
            text3.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                BeginTabla();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                BeginTabla();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                BeginTabla();
            }    
            });
            text4.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                BeginTabla();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                BeginTabla();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                BeginTabla();
            }    
            });
            
        }
    
        private void BeginTabla(){
            cvd.Init();
            String[] columnas1 = {"No. Factura","NIT","Nombre","Fecha","Total"};
        
            DefaultTableModel model1= new DefaultTableModel(cvd.VentasList(text1.getText(), text2.getText(), text3.getText(), text4.getText()),columnas1){
            @Override
            public boolean isCellEditable(int fila, int columna){
                return false;
            }
            }; 
            table1.setModel(model1);
            table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
        
        public void Init(int a,int b, int c ,int d) {
        panel1.setBounds(a,b,c,d);
        BeginConsultaVenta();
        BeginTabla();
        }    
}
