/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import control.AccesoDatosEx;
import control.EscrituraDatosEx;
import control.LecturaDatosEx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import modelo.Pelicula;

/**
 *
 * @author daniel
 */
public class AccesoDatosImpl implements IAccesoDatos{

    @Override
    public boolean existe(String nombre){
        File archivo = new File(nombre);
        return archivo.exists();        
    }

    @Override
    public List<Pelicula> listar(String nombre) throws LecturaDatosEx {
        var archivo = new File(nombre);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while(linea != null){
                var pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas: " + ex.getMessage());
        } catch (IOException ex) {
            throw new LecturaDatosEx("Excepcion al listar peliculas: " + ex.getMessage());
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombre, boolean anexar) throws EscrituraDatosEx {
        var archivo = new File(nombre);
        try {
            var salida = new PrintWriter(new FileWriter(archivo,anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se a escrito en el archivo");
        } catch (IOException ex) {
            throw new EscrituraDatosEx("Excepcion al listar peliculas: " + ex.getMessage());
        }
    }

    @Override
    public String buscar(String nombre, String buscar) throws LecturaDatosEx {
        var archivo = new File(nombre);
        String resultado = null;
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            var indice = 1;
            while(linea != null){
                if(buscar != null && buscar.equalsIgnoreCase(linea)){
                    resultado = "Pelicula " + linea + " encontrada en el indice " + indice;
                    break;
                }else{
                    resultado = "Pelicula no encontrada!!";
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            throw new LecturaDatosEx("Excepcion al buscar peliculas: " + ex.getMessage());
        } catch (IOException ex) {
            throw new LecturaDatosEx("Excepcion al bucar peliculas: " + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public void crear(String nombre) throws AccesoDatosEx {
        var archivo = new File(nombre);
        try {
            var salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se a creado el archivo");
        } catch (IOException ex) {
             throw new AccesoDatosEx("Excepcion al bucar peliculas: " + ex.getMessage());
        }
    }

    @Override
    public void borrar(String nombre){
        var archivo = new File(nombre);
        if(archivo.exists())
            archivo.delete();
        System.out.println("Se ha borrado el archivo");
    }
    
}
