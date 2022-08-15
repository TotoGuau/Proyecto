package com.mycompany.proyecto;
import java.sql.*;
import javax.swing.*;
import java.time.*;

public class NuevaVentaDAO {
     Connection con;
     String url="jdbc:mysql://localhost:3306/tienda";
     String user="root";
     String pass="";
     PreparedStatement ps;
     ResultSet rs;
     
    public void Init(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error");
            JOptionPane.showMessageDialog(null,e);            
        }
    } 
     
    public Object[][] ClientesList(String a, String b, String c, String d){
        Object filas[][] = null;
        int e=0;
        try{
            ps=con.prepareStatement("SELECT *FROM CLIENTES WHERE NOMBRE LIKE '" + a +"%' AND NIT LIKE'" + b + "%' AND CORREO LIKE'" + c + "%' AND GENERO LIKE'" + d + "%'");
            rs=ps.executeQuery();
            while(rs.next()){
                e++;
            }
            filas=new Object[e][5];
            e=0;            
            ps=con.prepareStatement("SELECT *FROM CLIENTES WHERE NOMBRE LIKE '" + a +"%' AND NIT LIKE'" + b + "%' AND CORREO LIKE'" + c + "%' AND GENERO LIKE'" + d + "%'");
            rs=ps.executeQuery();
            while (rs.next()) {
                filas[e][0]=rs.getString(1);
                filas[e][1]=rs.getString(2);
                filas[e][2]=rs.getString(3);
                filas[e][3]=rs.getString(4);
                filas[e][4]=rs.getString(5);
                e++;
            }
        }catch (Exception f){
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error");
            JOptionPane.showMessageDialog(null,f);
        }
        return filas;
    }
    
    public int FacturaNo(){
        int a=0;
        try{
            ps=con.prepareStatement("SELECT *FROM FACTURAS");
            rs=ps.executeQuery();
            while(rs.next()){
                a++;
            }           
        }catch (Exception f){
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error");
            JOptionPane.showMessageDialog(null,f);
        }
        return a+1;
    }
    
    public Object[][] ProductosList(String a, String b){
        Object filas[][] = null;
        int e=0;
        try{
            ps=con.prepareStatement("SELECT *FROM PRODUCTOS WHERE CODIGO LIKE '" + a +"%' AND NOMBRE LIKE'" + b +  "%'");
            rs=ps.executeQuery();
            while(rs.next()){
                e++;
            }
            filas=new Object[e][5];
            e=0;            
            ps=con.prepareStatement("SELECT *FROM PRODUCTOS WHERE CODIGO LIKE '" + a +"%' AND NOMBRE LIKE'" + b +  "%'");
            rs=ps.executeQuery();
            while (rs.next()) {
                filas[e][0]=rs.getString(1);
                filas[e][1]=rs.getString(2);
                filas[e][2]=rs.getString(3);
                filas[e][3]=rs.getString(4);
                filas[e][4]=rs.getString(5);
                e++;
            }
        }catch (Exception f){
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error");
            JOptionPane.showMessageDialog(null,f);
        }
        return filas;
    }
    
    public int VentaInsert(String a, int b, double c,int d,Object filas[][]){
        try {
            ps=con.prepareStatement("INSERT INTO FACTURAS VALUES(" + FacturaNo() + "," + a + "," + b + ",'" + LocalDate.now().toString() +  "'," + c + ")");
            ps.executeUpdate();
            int f=0;
            for(f=0;f<d;f++){
                ps=con.prepareStatement("INSERT INTO DETALLEFACTURAS VALUES(" + (FacturaNo()-1) + "," + (f + 1) + "," + filas[f][0] + "," + filas[f][1] +")");
                ps.executeUpdate();
            }
            ps=con.prepareStatement("UPDATE VENDEDORES SET VENTAS=VENTAS+1 WHERE CODIGO=" + b);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error");
            JOptionPane.showMessageDialog(null,e); 
        }
        return 1;
    }
}