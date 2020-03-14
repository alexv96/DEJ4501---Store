/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Calendar;

/**
 *
 * @author Alex
 */
public class Producto {
    private int idProducto;
    private String nombreProducto;
    private int precio;
    private Calendar fechaCreacion;
    private int categoria;
    private Categoria categoriaID;

    public Producto() {
    }

    public Producto(String nombreProducto, int precio, Calendar fechaCreacion, int categoria) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.fechaCreacion = fechaCreacion;
        this.categoria = categoria;
    }

    public Producto(String nombreProducto, int precio, Calendar fechaCreacion, Categoria categoriaID) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.fechaCreacion = fechaCreacion;
        this.categoriaID = categoriaID;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Calendar getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Calendar fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(Categoria categoriaID) {
        this.categoriaID = categoriaID;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", precio=" + precio + ", fechaCreacion=" + fechaCreacion + ", categoria=" + categoria + ", categoriaID=" + categoriaID + '}';
    }
    
    
}
