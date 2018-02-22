/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin20;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author dani
 */
public class LecturaEscritura{
    static ArrayList<Libro> libros=new ArrayList();
    static String lista[]=new String[4];
    
    static FileWriter escribir;
    static File fichero=new File("Libros.txt");
    static Scanner sc;
    static String linea;
    
    public LecturaEscritura(){
        try{
            sc=new Scanner(fichero);
            while(sc.hasNext()){
                linea=sc.next();
                lista=linea.split(",");
                Libro l=new Libro(lista[0],lista[1],Integer.parseInt(lista[2]),Integer.parseInt(lista[3]));
                libros.add(l);
            }
        }catch(FileNotFoundException ex){
            System.out.println("Error al leer el fichero");
        }finally{
            sc.close();
        }        
    }
    
    public static void añadirLibro(){
        
        Libro l=new Libro(JOptionPane.showInputDialog("Inserte nombre del libro"),
                    JOptionPane.showInputDialog("Inserte autor"),
                    Integer.parseInt(JOptionPane.showInputDialog("Inserte precio")),
                    Integer.parseInt(JOptionPane.showInputDialog("Inserte unidades")));
        libros.add(l);
        
        try{
            escribir=new FileWriter(fichero);
            for(Libro elemento: libros){
                escribir.write(elemento.getNombre()+","+elemento.getAutor()+","+elemento.getPrecio()+","+elemento.getUnidades()+"\n");
            }
            escribir.close();
        }catch(IOException ex){
            System.out.println("No se pudo escribir en el fichero");
        }
    }
    
    public static void consultarPrecio(){
        boolean bandera=false;
        int precio=0;

        String nombre=JOptionPane.showInputDialog("Inserte título");
        for(Libro elemento: libros){
            if(nombre.equals(elemento.getNombre())){
                precio=elemento.getPrecio();
                bandera=true;
            }
        }
        
        if(bandera==false)
            JOptionPane.showMessageDialog(null,"Libro no disponible en la librería");
        else
            JOptionPane.showMessageDialog(null, "Precio: "+precio);
            
    }
    
    public static void visualizarLibros(){
        String todos="";

        for(Libro elemento: libros){
            todos=todos+elemento.toString()+"\n";
        }
        
        JOptionPane.showMessageDialog(null,todos);
        todos=null;
    }
    
    public static void modificarPrecio(){
        boolean bandera=false;
    
        String nombre=JOptionPane.showInputDialog("Inserte título:");
        int precio=Integer.parseInt(JOptionPane.showInputDialog("Inserte nuevo precio:"));
        
        for(Libro elemento: libros){
            if(nombre.equals(elemento.getNombre())){
                elemento.setPrecio(precio);
                bandera=true;
            }
        }
        
        try{
            escribir=new FileWriter(fichero);
            for(Libro elemento: libros){
                escribir.write(elemento.getNombre()+","+elemento.getAutor()+","+elemento.getPrecio()+","+elemento.getUnidades()+"\n");
            }
            
        }catch(IOException ex){
            System.out.println("No se pudo escribir en el fichero");
        }
        
                
        if(bandera==false)
            JOptionPane.showMessageDialog(null,"Libro no disponible en la librería");
        else
            JOptionPane.showMessageDialog(null, "Nuevo Precio: "+precio);
        
    }
    
    public static void eliminarSinUnidades(){
        int borrados=0;
        for(int i=0;i<libros.size();i++){
            if(libros.get(i).getUnidades()==0){
                libros.remove(i);
                i--;
                borrados++;
            }
        }
        JOptionPane.showMessageDialog(null, borrados+" libros borrados");
        try{
            escribir=new FileWriter(fichero);
            for(Libro elemento: libros){
                escribir.write(elemento.getNombre()+","+elemento.getAutor()+","+elemento.getPrecio()+","+elemento.getUnidades()+"\n");
            }
            escribir.close();
        }catch(IOException ex){
            System.out.println("No se pudo escribir en el fichero");
        }        
    }
    
}
