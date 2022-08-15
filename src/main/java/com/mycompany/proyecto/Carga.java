package com.mycompany.proyecto;
import com.google.gson.*;
import java.io.*;
import javax.swing.*;
    
public class Carga{
    public String Archivo(){
        JFileChooser file1= new JFileChooser();
        int a= file1.showOpenDialog(null);
        String datos="";
        if(a==JFileChooser.APPROVE_OPTION){
            File archivo= file1.getSelectedFile();
            String ruta= archivo.getAbsolutePath();
            File archivo2=null;
            FileReader freader=null;
            BufferedReader breader=null;
            try {
                archivo2= new File(ruta);
                freader= new FileReader(archivo2);
                breader= new BufferedReader(freader);
                String linea="";
                while ((linea = breader.readLine()) != null) {                    
                    datos+=linea;
                }
                return datos;               
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "No se encontro el archivo");
                return "";
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "No se pudo abrir el archivo");
                return "";
            } finally{
                try {
                    if (freader != null) {
                        freader.close();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se encontro el arhivo");
                    return "";
                }
            }           
        }
        return datos;
    }
    
    public void Carga(int a, String archivo){
        JsonParser parse= new JsonParser();
        JsonArray array= parse.parse(archivo).getAsJsonArray();
        CrearDAO cd= new CrearDAO();
        cd.Init();
        if(a==1){
                for (int b = 0; b < array.size(); b++) {
                    JsonObject object = array.get(b).getAsJsonObject();
                    cd.Crear(a,object.get("Codigo").getAsString(),object.get("Nombre").getAsString(),object.get("Direccion").getAsString(),object.get("Correo").getAsString(),object.get("Telefono").getAsString());
                }
             AdministradorView av= new AdministradorView();
             av.dispose();
             av.Init();
             av.tabed1.setSelectedIndex(0);
        }else if(a==2){
                for (int b = 0; b < array.size(); b++) {
                    JsonObject object = array.get(b).getAsJsonObject();
                    cd.Crear(a,object.get("Codigo").getAsString(),object.get("Nombre").getAsString(),object.get("Descripcion").getAsString(),object.get("Cantidad").getAsString(),object.get("Precio").getAsString());
                }
             AdministradorView av= new AdministradorView();
             av.dispose();
             av.Init();
             av.tabed1.setSelectedIndex(1);
        }else if(a==3){
                for (int b = 0; b < array.size(); b++) {
                    JsonObject object = array.get(b).getAsJsonObject();
                    cd.Crear(a,object.get("Codigo").getAsString(),object.get("Nombre").getAsString(),object.get("NIT").getAsString(),object.get("Correo").getAsString(),object.get("Genero").getAsString());
                }
             AdministradorView av= new AdministradorView();
             av.dispose();
             av.Init();
             av.tabed1.setSelectedIndex(2);
        }else if(a==4){
                for (int b = 0; b < array.size(); b++) {
                    JsonObject object = array.get(b).getAsJsonObject();
                    cd.Crear(a,object.get("Codigo").getAsString(),object.get("Nombre").getAsString(),object.get("Caja").getAsString(),object.get("Ventas").getAsString(),object.get("Genero").getAsString());
                }
             AdministradorView av= new AdministradorView();
             av.dispose();
             av.Init();
             av.tabed1.setSelectedIndex(3);
        }
    }
}