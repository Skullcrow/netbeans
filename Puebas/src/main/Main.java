/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import acceso.IAccesoDatos;
import acceso.ImplementacionMySql;
import acceso.ImplementacionOracle;

/**
 *
 * @author Skullcrow
 */
public class Main {
    
    public static void main(String[] args){
        IAccesoDatos datos;
        
        datos   = new ImplementacionMySql();
        
        datos.listar();
        
        datos = new ImplementacionOracle();
        
        datos.listar();
    }
    
}
