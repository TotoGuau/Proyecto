package com.mycompany.proyecto;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginView extends JFrame{
    Toolkit t = Toolkit.getDefaultToolkit();
    Dimension screen = t.getScreenSize();
    JLabel label1= new JLabel();
    JLabel label2= new JLabel();
    JTextField text1 = new JTextField();
    JPasswordField text2 = new JPasswordField();
    JButton button1= new JButton();
    
    LoginDAO ld = new LoginDAO();
    
    private void BeginLogin(){
        ld.Init();
        
        setTitle("Login");
        setLocationRelativeTo(null);
        setLayout(null);
        setBounds((int) Math.ceil(screen.width * 0.25),(int) Math.ceil(screen.height * 0.3),(int) Math.ceil(screen.width * 0.5),(int) Math.ceil(screen.height * 0.4));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        
//      X1.5 Bounds
        label1.setBounds((int) Math.ceil(getBounds().x * 0.4),(int) Math.ceil(getBounds().y * 0.1),(int) Math.ceil(getBounds().width * 0.6),(int) Math.ceil(getBounds().height * 0.1));
        text1.setBounds((int) Math.ceil(getBounds().x * 0.4),(int) Math.ceil(getBounds().y * 0.2),(int) Math.ceil(getBounds().width * 0.6),(int) Math.ceil(getBounds().height * 0.1));
        label2.setBounds((int) Math.ceil(getBounds().x * 0.4),(int) Math.ceil(getBounds().y * 0.4),(int) Math.ceil(getBounds().width * 0.6),(int) Math.ceil(getBounds().height * 0.1));
        text2.setBounds((int) Math.ceil(getBounds().x * 0.4),(int) Math.ceil(getBounds().y * 0.5),(int) Math.ceil(getBounds().width * 0.6),(int) Math.ceil(getBounds().height * 0.1));
        button1.setBounds((int) Math.ceil(getBounds().x * 0.75),(int) Math.ceil(getBounds().y * 0.8),(int) Math.ceil(getBounds().width * 0.25),(int) Math.ceil(getBounds().height * 0.1));
        label1.setText("Ingresa el usuario");
        label2.setText("Ingresa el la contraseña");
        button1.setText("Ingresar");
        
        getContentPane().add(label1);
        getContentPane().add(label2);
        getContentPane().add(text1);
        getContentPane().add(text2);
        getContentPane().add(button1);
        
        ActionListener login = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a=ld.LoginIntent(text1.getText(),text2.getText());
                if(a==0){
                   AdministradorView av= new AdministradorView();
                   av.Init();
                   dispose();
                }else if(a!=0){
                   VendedorView vv= new VendedorView();
                   vv.Init(a);
                   dispose();
                }
            };
        };
        
        button1.addActionListener(login);
        
        setVisible(true);
        
    }
    
    public void Init() {
        BeginLogin();
    }
}


