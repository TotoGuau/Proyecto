package com.mycompany.proyecto;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VendedorView extends JFrame{
    Toolkit t = Toolkit.getDefaultToolkit();
    Dimension screen = t.getScreenSize();
    JTabbedPane tabed1= new JTabbedPane();
    
    NuevaVentaView nvv= new NuevaVentaView();
    ConsultaVentaView cvv= new ConsultaVentaView();
    
    
    private void BeginVendedor(int a){
        setTitle("Vendedor");
        setLocationRelativeTo(null);
        setLayout(null);
        setBounds((int) Math.ceil(screen.width * 0.1),(int) Math.ceil(screen.height * 0.1),(int) Math.ceil(screen.width * 0.8),(int) Math.ceil(screen.height * 0.8));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); 
        
        nvv.Init((int) Math.ceil(getBounds().width * 0.01),(int) Math.ceil(getBounds().height * 0.01),(int) Math.ceil(getBounds().width * 0.97),(int) Math.ceil(getBounds().height * 0.93),a);
        cvv.Init((int) Math.ceil(getBounds().width * 0.01),(int) Math.ceil(getBounds().height * 0.01),(int) Math.ceil(getBounds().width * 0.97),(int) Math.ceil(getBounds().height * 0.93));
        tabed1.setBounds((int) Math.ceil(getBounds().width * 0.01),(int) Math.ceil(getBounds().height * 0.01),(int) Math.ceil(getBounds().width * 0.97),(int) Math.ceil(getBounds().height * 0.93));        
        
        tabed1.addTab("Nueva venta", nvv.panel1);
        tabed1.addTab("Venta", cvv.panel1);
        
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
    
    public void Init(int a) {
        BeginVendedor(a);
    }
}
