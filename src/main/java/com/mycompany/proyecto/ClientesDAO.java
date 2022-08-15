package com.mycompany.proyecto;
import java.awt.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class ClientesDAO {
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
     
    public Object[][] ClientesList(){
        Object filas[][] = null;
        int a=0;
        try{
            ps=con.prepareStatement("SELECT *FROM CLIENTES");
            rs=ps.executeQuery();
            while(rs.next()){
                a++;
            }
            filas=new Object[a][5];
            a=0;            
            ps=con.prepareStatement("SELECT *FROM CLIENTES");
            rs=ps.executeQuery();
            while (rs.next()) {
                filas[a][0]=rs.getString(1);
                filas[a][1]=rs.getString(2);
                filas[a][2]=rs.getString(3);
                filas[a][3]=rs.getString(4);
                filas[a][4]=rs.getString(5);
                a++;
            }     
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error");
            JOptionPane.showMessageDialog(null,e);
        }
        return filas;
    }
    
    public void PdfCliente() throws FileNotFoundException, DocumentException {
        FileOutputStream output= new FileOutputStream("ReporteClientes.pdf");
        Document document= new Document();
        PdfWriter.getInstance(document, output);
        document.open();
        Paragraph paragraph= new Paragraph("Reporte de clientes");
        paragraph.setAlignment(1);
        document.add(paragraph);
        document.add(new Paragraph("\n"));
        try{
            ps=con.prepareStatement("SELECT *FROM CLIENTES");
            rs=ps.executeQuery();
            while (rs.next()) {
                document.add(new Paragraph("Codigo: " + rs.getString(1)));
                document.add(new Paragraph("Nombre: " + rs.getString(2)));
                document.add(new Paragraph("NIT: " + rs.getString(3)));
                document.add(new Paragraph("Correo: " + rs.getString(4)));
                document.add(new Paragraph("Genero: " + rs.getString(5)));
                document.add(new Paragraph("\n\n"));
            }  
        }catch(Exception e){
        }
        document.close();
        JOptionPane.showMessageDialog(null, "El reporte se ha creado exitosamente");
        try {
            File file= new File("ReporteClientes.pdf");
            Desktop.getDesktop().open(file);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error");
            JOptionPane.showMessageDialog(null,e);
        }
        
    }    
    
}
