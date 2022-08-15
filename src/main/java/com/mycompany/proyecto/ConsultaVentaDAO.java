package com.mycompany.proyecto;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import java.time.*;

public class ConsultaVentaDAO {
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
    
    public Object[][] VentasList(String a, String b, String c, String d){
        Object filas[][] = null;
        int e=0;
        try{
            ps=con.prepareStatement("SELECT F.CODIGO,C.NIT,C.NOMBRE,F.FECHA,F.TOTAL FROM FACTURAS AS F INNER JOIN CLIENTES AS C ON F.CLIENTE=C.CODIGO WHERE F.CODIGO LIKE '" + a + "%' AND C.NIT LIKE '" + b + "%' AND C.NOMBRE LIKE '" + c + "%' AND F.FECHA LIKE '" + d + "%'");
            rs=ps.executeQuery();
            while(rs.next()){
                e++;
            }
            filas=new Object[e][5];
            e=0;            
            ps=con.prepareStatement("SELECT F.CODIGO,C.NIT,C.NOMBRE,F.FECHA,F.TOTAL FROM FACTURAS AS F INNER JOIN CLIENTES AS C ON F.CLIENTE=C.CODIGO WHERE F.CODIGO LIKE '" + a + "%' AND C.NIT LIKE '" + b + "%' AND C.NOMBRE LIKE '" + c + "%' AND F.FECHA LIKE '" + d + "%'");
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
    
    public void PdfConsultaVenta(String a) throws FileNotFoundException, DocumentException {
        FileOutputStream output= new FileOutputStream("Venta.pdf");
        Document document= new Document();
        PdfWriter.getInstance(document, output);
        document.open();
        var c=new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.UNDEFINED, 18, com.itextpdf.text.Font.BOLD);
        Paragraph paragraph= new Paragraph("Factura",c);
        paragraph.setAlignment(1);
        document.add(paragraph);
        document.add(new Paragraph("\n"));
        double b=0;
        try{
            ps=con.prepareStatement("SELECT F.CODIGO,V.NOMBRE,C.NIT,C.NOMBRE,F.FECHA,F.TOTAL FROM FACTURAS AS F INNER JOIN CLIENTES AS C ON F.CLIENTE=C.CODIGO INNER JOIN VENDEDORES AS V ON F.VENDEDOR=V.CODIGO  WHERE F.CODIGO=" + a);
            rs=ps.executeQuery();
            while (rs.next()) {
                document.add(new Paragraph("Codigo: " + rs.getString(1)));
                document.add(new Paragraph("Nombre del vendedor: " + rs.getString(2)));
                document.add(new Paragraph("NIT del cliente: " + rs.getString(3)));
                document.add(new Paragraph("Nombre del cliente: " + rs.getString(4)));
                document.add(new Paragraph("Fecha: " + rs.getString(5)));
                document.add(new Paragraph("Total: " + rs.getString(6)));
                document.add(new Paragraph("\n\n"));
            }
            ps=con.prepareStatement("SELECT P.NOMBRE,P.PRECIO,D.CANTIDAD FROM DETALLEFACTURAS AS D INNER JOIN PRODUCTOS AS P ON D.CODIGOPRODUCTO=P.CODIGO WHERE D.CODIGOFACTURA=" + a);
            rs=ps.executeQuery();
            paragraph= new Paragraph("Detalle factura",c);
            paragraph.setAlignment(1);
            document.add(paragraph);
            while (rs.next()) {
                document.add(new Paragraph("Producto: " + rs.getString(1)));
                document.add(new Paragraph("Precio: " + rs.getString(2)));
                document.add(new Paragraph("Cantidad: " + rs.getString(3)));
                document.add(new Paragraph("Total: " + (rs.getDouble(2) * rs.getDouble(3))));
                document.add(new Paragraph("\n\n"));
                b+=(rs.getDouble(2) * rs.getDouble(3));
            }
            paragraph= new Paragraph("Total factura " + b ,c);
            paragraph.setAlignment(2);
            document.add(paragraph);
        }catch(Exception e){
        }
        document.close();
        JOptionPane.showMessageDialog(null, "El reporte se ha creado exitosamente");
        try {
            File file= new File("Venta.pdf");
            Desktop.getDesktop().open(file);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error");
            JOptionPane.showMessageDialog(null,e);
        }
        
    }  
}
