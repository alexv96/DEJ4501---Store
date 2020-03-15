/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.SetupDAO;

/**
 *
 * @author Alex
 */
public class SetupController {

    SetupDAO dao;
    
    public SetupController() {
        this.dao = new SetupDAO();
    }
    
    public boolean instalar(){
        return dao.instalar();
    }
    
    public boolean desintalar(){
        return dao.desintalar();
    }
}
