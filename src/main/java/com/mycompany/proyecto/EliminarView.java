package com.mycompany.proyecto;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EliminarView extends JFrame{
    Toolkit t = Toolkit.getDefaultToolkit();
    Dimension screen = t.getScreenSize();
    JLabel label1= new JLabel();
    JLabel label2= new JLabel();
    JLabel label3= new JLabel();
    JLabel label4= new JLabel();
    JLabel label5= new JLabel();
    JLabel label6= new JLabel();
    JTextField text1= new JTextField();
    JTextField text2= new JTextField();
    JTextField text3= new JTextField();
    JTextField text4= new JTextField();
    JTextField text5= new JTextField();
    JButton button1= new JButton();
    
    EliminarDAO ed=new EliminarDAO();
    
    private void BeginEliminar(){
        setTitle("Eliminar");
        setLocationRelativeTo(null);
        setLayout(null);
        setBounds((int) Math.ceil(screen.width * 0.4),(int) Math.ceil(screen.height * 0.25),(int) Math.ceil(screen.width * 0.2),(int) Math.ceil(screen.height * 0.5));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false); 
        
        label1.setBounds((int) Math.ceil(getBounds().width * 0.32),(int) Math.ceil(getBounds().height * 0.02),(int) Math.ceil(getBounds().width * 0.4),(int) Math.ceil(getBounds().height * 0.1));
        label2.setBounds((int) Math.ceil(getBounds().width * 0.03),(int) Math.ceil(getBounds().height * 0.18),(int) Math.ceil(getBounds().width * 0.2),(int) Math.ceil(getBounds().height * 0.1));
        text1.setBounds((int) Math.ceil(getBounds().width * 0.25),(int) Math.ceil(getBounds().height * 0.2),(int) Math.ceil(getBounds().width * 0.6),(int) Math.ceil(getBounds().height * 0.07));
        text1.setEnabled(false);
        label3.setBounds((int) Math.ceil(getBounds().width * 0.03),(int) Math.ceil(getBounds().height * 0.28),(int) Math.ceil(getBounds().width * 0.2),(int) Math.ceil(getBounds().height * 0.1));
        text2.setBounds((int) Math.ceil(getBounds().width * 0.25),(int) Math.ceil(getBounds().height * 0.3),(int) Math.ceil(getBounds().width * 0.6),(int) Math.ceil(getBounds().height * 0.07));
        text2.setEnabled(false);
        label4.setBounds((int) Math.ceil(getBounds().width * 0.03),(int) Math.ceil(getBounds().height * 0.38),(int) Math.ceil(getBounds().width * 0.2),(int) Math.ceil(getBounds().height * 0.1));
        text3.setBounds((int) Math.ceil(getBounds().width * 0.25),(int) Math.ceil(getBounds().height * 0.4),(int) Math.ceil(getBounds().width * 0.6),(int) Math.ceil(getBounds().height * 0.07));
        text3.setEnabled(false);
        label5.setBounds((int) Math.ceil(getBounds().width * 0.03),(int) Math.ceil(getBounds().height * 0.48),(int) Math.ceil(getBounds().width * 0.2),(int) Math.ceil(getBounds().height * 0.1));
        text4.setBounds((int) Math.ceil(getBounds().width * 0.25),(int) Math.ceil(getBounds().height * 0.5),(int) Math.ceil(getBounds().width * 0.6),(int) Math.ceil(getBounds().height * 0.07));
        text4.setEnabled(false);
        label6.setBounds((int) Math.ceil(getBounds().width * 0.03),(int) Math.ceil(getBounds().height * 0.58),(int) Math.ceil(getBounds().width * 0.2),(int) Math.ceil(getBounds().height * 0.1));
        text5.setBounds((int) Math.ceil(getBounds().width * 0.25),(int) Math.ceil(getBounds().height * 0.6),(int) Math.ceil(getBounds().width * 0.6),(int) Math.ceil(getBounds().height * 0.07));
        text5.setEnabled(false);
        button1.setBounds((int) Math.ceil(getBounds().width * 0.3),(int) Math.ceil(getBounds().height * 0.75),(int) Math.ceil(getBounds().width * 0.4),(int) Math.ceil(getBounds().height * 0.1));
        button1.setText("Eliminar");
        
        getContentPane().add(label1);
        getContentPane().add(label2);
        getContentPane().add(label3);
        getContentPane().add(label4);
        getContentPane().add(label5);
        getContentPane().add(label6);
        getContentPane().add(text1);
        getContentPane().add(text2);
        getContentPane().add(text3);
        getContentPane().add(text4);
        getContentPane().add(text5);
        getContentPane().add(button1);
        
        setVisible(true);
    }
    
        private void EditEliminar(int a,String[] datos){
        ed.Init();
        text1.setText(datos[0]);
        text2.setText(datos[1]);
        text3.setText(datos[2]);
        text4.setText(datos[3]);
        text5.setText(datos[4]);
        if(a==1){
            setTitle("Eliminar sucursal");
            label1.setText("Eliminar sucursal");
            label2.setText("Codigo");
            label3.setText("Nombre");
            label4.setText("Dirrecion");
            label5.setText("Correo");
            label6.setText("Telefono");
            
            addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                AdministradorView av= new AdministradorView();
                av.dispose();
                av.Init();
                av.tabed1.setSelectedIndex(0);
            }
            });
            ActionListener sucursal = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ed.Eliminar(a,text1.getText())==1){
                    JOptionPane.showMessageDialog(null, "Se ha eliminado la sucursal");
                    dispose();              
                }else{
                    dispose();
                }
            };
            };            
            button1.addActionListener(sucursal);
        }else if(a==2){
            setTitle("Eliminar producto");
            label1.setText("Eliminar producto");
            label2.setText("Codigo");
            label3.setText("Nombre");
            label4.setText("Descripcion");
            label5.setText("Cantidad");
            label6.setText("Precio");
            
            addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                AdministradorView av= new AdministradorView();
                av.dispose();
                av.Init();
                av.tabed1.setSelectedIndex(1);
                dispose(); 
            }
            });
            ActionListener producto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ed.Eliminar(a,text1.getText())==1){
                    JOptionPane.showMessageDialog(null, "Se ha eliminado el producto");
                    dispose();
                }else{
                    dispose();
                }  
            };
            };            
            button1.addActionListener(producto);
        }else if(a==3){
            setTitle("Eliminar cliente");
            label1.setText("Eliminar cliente");
            label2.setText("Codigo");
            label3.setText("Nombre");
            label4.setText("NIT");
            label5.setText("Correo");
            label6.setText("Genero");
            
            addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                AdministradorView av= new AdministradorView();
                av.dispose();
                av.Init();
                av.tabed1.setSelectedIndex(2);
                dispose(); 
            }
            });
            ActionListener cliente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ed.Eliminar(a,text1.getText())==1){
                    JOptionPane.showMessageDialog(null, "Se ha eliminado el cliente");
                    dispose();
                }else{
                    dispose();
                }  
            };
            };            
            button1.addActionListener(cliente);
        }else if(a==4){
            setTitle("Eliminar vendedor");
            label1.setText("Eliminar vendedor");
            label2.setText("Codigo");
            label3.setText("Nombre");
            label4.setText("Caja");
            label5.setText("Ventas");
            label6.setText("Genero");
            
            addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                AdministradorView av= new AdministradorView();
                av.dispose();
                av.Init();
                av.tabed1.setSelectedIndex(3);
                dispose(); 
            }
            });
            ActionListener vendedor = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ed.Eliminar(a,text1.getText())==1){
                    JOptionPane.showMessageDialog(null, "Se ha eliminado el vendedor");
                    dispose();
                }else{
                    dispose();
                }  
            };
            };            
            button1.addActionListener(vendedor);
        }     
    }
    
    public void Init(int a, String[] datos){
        BeginEliminar();
        EditEliminar(a,datos);
    }
}
