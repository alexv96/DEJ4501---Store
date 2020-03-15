/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import modelo.Producto;

/**
 *
 * @author Alex
 */
public interface IProducto {
    public Producto addProdcuto(Producto p);
    public boolean deleteProducto(int id);
    public List<Producto> getProductos();
    public List<Producto> searchProducto(String nombre, int categoria);
    public Producto updateProducto(Producto p);
}
