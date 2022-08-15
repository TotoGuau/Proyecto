package com.mycompany.proyecto;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdministradorView extends JFrame {
    Toolkit t = Toolkit.getDefaultToolkit();
    Dimension screen = t.getScreenSize();
    JTabbedPane tabed1= new JTabbedPane();
    
    SucursalesView sv = new SucursalesView();
    ProductosView pv = new ProductosView();
    ClientesView cv= new ClientesView();
    VendedoresView vv= new VendedoresView();
    
    private void BeginAdministrador(){
        setTitle("Administrador");
        setLocationRelativeTo(null);
        setLayout(null);
        setBounds((int) Math.ceil(screen.width * 0.1),(int) Math.ceil(screen.height * 0.1),(int) Math.ceil(screen.width * 0.8),(int) Math.ceil(screen.height * 0.8));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);     
        
        tabed1.setBounds((int) Math.ceil(getBounds().width * 0.01),(int) Math.ceil(getBounds().height * 0.01),(int) Math.ceil(getBounds().width * 0.97),(int) Math.ceil(getBounds().height * 0.93));        
        sv.Init((int) Math.ceil(getBounds().width * 0.01),(int) Math.ceil(getBounds().height * 0.01),(int) Math.ceil(getBounds().width * 0.97),(int) Math.ceil(getBounds().height * 0.93));
        pv.Init((int) Math.ceil(getBounds().width * 0.01),(int) Math.ceil(getBounds().height * 0.01),(int) Math.ceil(getBounds().width * 0.97),(int) Math.ceil(getBounds().height * 0.93));                
        cv.Init((int) Math.ceil(getBounds().width * 0.01),(int) Math.ceil(getBounds().height * 0.01),(int) Math.ceil(getBounds().width * 0.97),(int) Math.ceil(getBounds().height * 0.93));                
        vv.Init((int) Math.ceil(getBounds().width * 0.01),(int) Math.ceil(getBounds().height * 0.01),(int) Math.ceil(getBounds().width * 0.97),(int) Math.ceil(getBounds().height * 0.93));                
       
        tabed1.addTab("Sucursales", sv.panel1);
        tabed1.addTab("Productos", pv.panel1);
        tabed1.addTab("Clientes", cv.panel1);
        tabed1.addTab("Vendedores", vv.panel1);
        
        getContentPane().add(tabed1);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            String[] a={"Salir","Cerrar Sesion","Cancelar"} ;
            int b=JOptionPane.showOptionDialog(null,"¿Que deseas hacer?","Administrador",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,a,a[0]);
                switch (b) {
                    case 0:
                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        break;
                    case 1:
                        LoginView lv= new LoginView();
                        lv.Init();
                        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        break;
                    case 2:
                        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                        break;
                    default:
                        break;
                }
            };
        });
            
        setVisible(true);
    }
    
    public void Init() {
        BeginAdministrador();
    }
}
