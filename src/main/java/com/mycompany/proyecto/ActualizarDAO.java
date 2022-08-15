package com.mycompany.proyecto;
import java.sql.*;
import javax.swing.*;

public class ActualizarDAO {
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
    
    public int Actualizar(int a, String b, String c, String d, String e, String f){
        try {
            switch (a) {
                case 1:
                    ps=con.prepareStatement("UPDATE SUCURSALES SET NOMBRE='" + c + "', DIRECCION='" + d + "', CORREO='" + e + "', TELEFONO=" + f + " WHERE CODIGO=" + b);
                    break;
                case 2:
                    ps=con.prepareStatement("UPDATE PRODUCTOS SET NOMBRE='" + c + "', DESCRIPCION='" + d + "', CANTIDAD=" + e + ", PRECIO=" + f + " WHERE CODIGO=" + b);
                    break;
                case 3:
                    ps=con.prepareStatement("UPDATE CLIENTES SET NOMBRE='" + c + "', NIT=" + d + ", CORREO='" + e + "', GENERO='" + f + "' WHERE CODIGO=" + b);
                    break;
                case 4:
                    ps=con.prepareStatement("UPDATE VENDEDORES SET NOMBRE='" + c + "', CAJA=" + d + ", VENTAS=" + e + ", GENERO='" + f + "' WHERE CODIGO=" + b);
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