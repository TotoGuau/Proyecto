package com.mycompany.proyecto;
import java.sql.*;
import javax.swing.*;

public class CrearDAO {
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
    
    public int Crear(int a, String b, String c, String d, String e, String f){
        try {
            switch (a) {
                case 1:
                    ps=con.prepareStatement("INSERT INTO SUCURSALES VALUES(" + b + ",'" + c + "','" + d + "','" + e + "'," + f + ")");
                    break;
                case 2:
                    ps=con.prepareStatement("INSERT INTO PRODUCTOS VALUES(" + b + ",'" + c + "','" + d + "'," + e + "," + f + ")");
                    break;
                case 3:
                    ps=con.prepareStatement("INSERT INTO CLIENTES VALUES(" + b + ",'" + c + "'," + d + ",'" + e + "','" + f + "')");
                    break;
                case 4:
                    ps=con.prepareStatement("INSERT INTO VENDEDORES VALUES(" + b + ",'" + c + "'," + d + "," + e + ",'" + f + "')");
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