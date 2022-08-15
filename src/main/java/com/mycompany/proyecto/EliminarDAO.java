package com.mycompany.proyecto;
import java.sql.*;
import javax.swing.*;

public class EliminarDAO {
     Connection con;
     String url="jdbc:mysql://localhost:3306/tienda";
     String user="root";
     String pass="";
     PreparedStatement ps;
     
    public void Init(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error");
            JOptionPane.showMessageDialog(null,e);            
        }
    }
    
    public int Eliminar(int a, String b){
        try {
            switch (a) {
                case 1:
                    ps=con.prepareStatement("DELETE FROM SUCURSALES WHERE CODIGO=" + b);
                    break;
                case 2:
                    ps=con.prepareStatement("DELETE FROM PRODUCTOS WHERE CODIGO=" + b);
                    break;
                case 3:
                    ps=con.prepareStatement("DELETE FROM CLIENTES WHERE CODIGO=" + b);
                    break;
                case 4:
                    ps=con.prepareStatement("DELETE FROM VENDEDORES WHERE CODIGO=" + b);
                    break;
                default:
                    break;
            }
            
            ps.executeUpdate();
        } catch (Exception z) {
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error");
            JOptionPane.showMessageDialog(null,z);
            return 0;
        }
        return 1;
    }
}