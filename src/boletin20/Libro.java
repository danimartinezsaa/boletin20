/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin20;

/**
 *
 * @author dani
 */
public class Libro{
    String nombre;
    String autor;
    int precio;
    int unidades;

    public Libro(){
    }

    public Libro(String nombre, String autor, int precio, int unidades){
        this.nombre=nombre;
        this.autor=autor;
        this.precio=precio;
        this.unidades=unidades;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getAutor(){
        return autor;
    }

    public void setAutor(String autor){
        this.autor=autor;
    }

    public int getPrecio(){
        return precio;
    }

    public void setPrecio(int precio){
        this.precio=precio;
    }

    public int getUnidades(){
        return unidades;
    }

    public void setUnidades(int unidades){
        this.unidades=unidades;
    }

    @Override
    public String toString(){
        return "nombre="+nombre+", autor="+autor+", precio="+precio+", unidades="+unidades;
    }
    
    
}
