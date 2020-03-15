/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import conexion.Conexion;
import dao.SetupDAO;

/**
 *
 * @author Alex
 */
public class TestSetup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SetupDAO daoS = new SetupDAO();
        boolean exito = daoS.instalar();
        
        if (exito) {
            System.out.println("Desintalo");
        }else{
            System.out.println("error");
        }
    }
    
}
