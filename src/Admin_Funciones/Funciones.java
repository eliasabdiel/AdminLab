/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin_Funciones;

/**
 *
 * @author SMK GAMING
 */
public class Funciones {

    public Funciones() {
        
    }
    
    
    
public boolean validaRut(String cadena){
        
        char caracter;
        boolean es=true;
        
        for (int i = 0; i < cadena.length(); i++) {
            
            caracter=cadena.charAt(i);
            
            if(!Character.isDigit(caracter) && !Character.isDigit('K')){
                es=false;
            }
        }
        
        return es;
    }

public boolean soloNumeros(String cadena){
        
        char caracter;
        boolean es=true;
        
        for (int i = 0; i < cadena.length(); i++) {
            
            caracter=cadena.charAt(i);
            
            if(!Character.isDigit(caracter)){
                es=false;
            }
        }
        
        return es;
    }
        
}
