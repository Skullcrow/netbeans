/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso;

import control.AccesoDatosEx;
import control.LecturaDatosEx;
import datos.AccesoDatosImpl;
import datos.IAccesoDatos;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Pelicula;

/**
 *
 * @author daniel
 */
public class CatalogoPeliculasImpl implements ICatalogoPeliculas{
    
    private final IAccesoDatos datos;
    
    public CatalogoPeliculasImpl(){
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombre) {
        Pelicula pelicula = new Pelicula(nombre);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            for(var pelicula: peliculas){
                System.out.println("Peliculas = " + pelicula );
            }
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPeliculas(String buscar) {
        String resultado = null;
        
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de acceso datos");
            ex.printStackTrace(System.out);
        }
        System.out.println("resultado = " + resultado);
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if(this.datos.existe(NOMBRE_RECURSO)){
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            }else{
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar catalogo de peliculas");
            ex.printStackTrace(System.out);
        }
    }
    
}
