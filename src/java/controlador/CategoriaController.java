/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.CategoriaDAO;
import java.util.List;
import modelo.Categoria;

/**
 *
 * @author Alex
 */
public class CategoriaController {

    private static CategoriaDAO dao;
    
    public CategoriaController() {
        this.dao = new CategoriaDAO();
    }
    
    public List<Categoria> listarCategorias(){
        return dao.getCategorias();
    }
    
    public Categoria agregarCategoria(Categoria c){
        return dao.addCategoria(c);
    }
}
