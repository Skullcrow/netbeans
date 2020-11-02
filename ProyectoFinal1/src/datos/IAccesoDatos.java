/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import control.AccesoDatosEx;
import control.EscrituraDatosEx;
import control.LecturaDatosEx;
import java.util.List;
import modelo.Pelicula;

/**
 *
 * @author daniel
 */
public interface IAccesoDatos {
    boolean existe(String archivo) throws AccesoDatosEx;
    List<Pelicula> listar(String archivo) throws LecturaDatosEx;
    void escribir(Pelicula pelicula, String archivo, boolean anexar) throws EscrituraDatosEx;
    String buscar(String archivo, String buscar) throws LecturaDatosEx;
    void crear(String archivo) throws AccesoDatosEx;
    void borrar(String archivo) throws AccesoDatosEx;
}
