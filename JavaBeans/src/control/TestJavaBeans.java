/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import domain.Persona;

/**
 *
 * @author Skullcrow
 */
public class TestJavaBeans {
    public static void main(String[] args){
        Persona persona = new Persona();
        
        persona.setNombre("Daniel");
        persona.setApellido("Ortega");
        
        System.out.print(persona.toString());
    }
}
