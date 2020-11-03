package control;

import datos.PersonaDAO;
import modelo.Persona;
import java.util.List;

public class ManejoPersonas {
    
    public static void main(String[] args) { 
        
        PersonaDAO personaDAO = new PersonaDAO();
        List<Persona> personas = personaDAO.select();
        
        for(Persona persona: personas){
            System.out.println("persona:" + persona);
        }
        
////        Prueba insert
//        Persona persona = new Persona();
//        persona.setNombre("Maria");
//        persona.setApellido("Lara");
//        persona.setEmail("mlara@mail.com");
//        persona.setTelefono("55668899");
//
//        personaDAO.insert(persona);
      
//        //Prueba update
//        Persona persona = new Persona();
//        persona.setId_persona(2);
//        persona.setNombre("Mayra");
//        persona.setApellido("Lara");
//        persona.setEmail("mlara@mail.com");
//        persona.setTelefono("55668899");
//        
//        personaDAO.update(persona);

          Persona persona = new Persona();
          persona.setId_persona(2);
          
          personaDAO.delete(persona);
    }
}
