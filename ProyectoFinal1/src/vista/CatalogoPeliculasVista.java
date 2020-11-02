/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import acceso.CatalogoPeliculasImpl;
import acceso.ICatalogoPeliculas;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class CatalogoPeliculasVista {
    public static void main(String[] args) {
        var opcion = -1;
        var scanner = new Scanner(System.in);
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
        
        while(opcion != 0){
            System.out.println("Elige una opcion: \n"
                    + "1. Iniciar catalogo Peliculas\n"
                    + "2. Agregar pelicula\n"
                    + "3. Listar peliculas\n"
                    + "4. Buscar pelicula\n"
                    + "0. Salir");
            opcion = Integer.parseInt(scanner.nextLine());
            
            switch(opcion){
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la pelicula");
                    var nombre = scanner.nextLine();
                    catalogo.agregarPelicula(nombre);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("digite la pelicula a buscar");
                    var buscar = scanner.nextLine();
                    catalogo.buscarPeliculas(buscar);
                    break;
                case 0:
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                          
            }
        }
    }
}
