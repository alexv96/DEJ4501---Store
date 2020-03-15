/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controlador.CategoriaController;
import java.util.Calendar;
import modelo.Categoria;

/**
 *
 * @author Alex
 */
public class TestCategoria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CategoriaController dao = new CategoriaController();
        Calendar fecha = Calendar.getInstance();
        Categoria c = new Categoria("Niños",fecha);
        
        Categoria agregar = dao.agregarCategoria(c);
        if (agregar != null) {
            System.out.println("agrego");
        }else{
            System.out.println("error");
        }
    }
    
}
