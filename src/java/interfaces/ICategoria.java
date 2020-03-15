/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import modelo.Categoria;

/**
 *
 * @author Alex
 */
public interface ICategoria {
    public List<Categoria> getCategorias();
    public Categoria addCategoria(Categoria c);
}
