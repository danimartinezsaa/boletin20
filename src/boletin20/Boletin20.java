/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin20;

import javax.swing.JOptionPane;


/**
 *
 * @author dani
 */
public class Boletin20{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        boolean encendido=true;
        LecturaEscritura li=new LecturaEscritura();
        
        while(encendido==true){
            String[] menu={"Insertar libro","Consultar precio","Visualizar Librería","Borrar libros sin unidades","Modificar precio","Salir"};
            int opcion=JOptionPane.showOptionDialog(
                null //componente
                ,
                 "Seleccione operación" // Mensaje
                ,
                 "Librería" // Titulo en la barra del cuadro
                ,
                 JOptionPane.DEFAULT_OPTION // Tipo de opciones
                ,
                 JOptionPane.INFORMATION_MESSAGE // Tipo de mensaje (icono)
                ,
                 null // Icono (ninguno)
                ,
                 menu // Opciones personalizadas
                ,
                null // Opcion por defecto
            );         
            
            switch(opcion){
                case 0:
                    LecturaEscritura.añadirLibro();
                    break;
                case 1:
                    LecturaEscritura.consultarPrecio();
                    break;
                case 2:
                    LecturaEscritura.visualizarLibros();
                    break;
                case 3:
                    LecturaEscritura.eliminarSinUnidades();
                    break;
                case 4:
                    LecturaEscritura.modificarPrecio();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
    
}
