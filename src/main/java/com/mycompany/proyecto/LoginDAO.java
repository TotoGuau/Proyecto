package com.mycompany.proyecto;
import java.sql.*;
import javax.swing.*;

public class LoginDAO {
     Connection con;
     String url="jdbc:mysql://localhost:3306/tienda";
     String user="root";
     String pass="";
     PreparedStatement ps;
     ResultSet rs;
     
    public void Init(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error");
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public int LoginIntent(String t1,String t2){
        int a=0;
        try{
            ps=con.prepareStatement("SELECT *FROM USUARIOS WHERE USUARIO='" + t1 + "' AND PASS='" + t2 + "'");
            rs=ps.executeQuery();
            if(rs.next()){
                if(rs.getString(3).equals("1")){
                    JOptionPane.showMessageDialog(null,"Bienvenido " + "Administrador " + rs.getString(1));
                    a=rs.getInt(4);
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Bienvenido " + "Vendedor " + rs.getString(1)); 
                    a=rs.getInt(4);              
                }
            }else{
               JOptionPane.showMessageDialog(null,"Usuario y/o contraseña incorrectos");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error");
            JOptionPane.showMessageDialog(null,e);
        }
        return a;
    }
}
