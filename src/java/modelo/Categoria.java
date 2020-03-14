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
public class Categoria {
    private int idCategoria;
    private String nombreCategoria;
    private Calendar fechaCreacion;

    public Categoria() {
    }

    public Categoria(String nombreCategoria, Calendar fechaCreacion) {
        this.nombreCategoria = nombreCategoria;
        this.fechaCreacion = fechaCreacion;
    }

    public Categoria(int idCategoria, String nombreCategoria, Calendar fechaCreacion) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public Calendar getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Calendar fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "Categoria{" + "idCategoria=" + idCategoria + ", nombreCategoria=" + nombreCategoria + ", fechaCreacion=" + fechaCreacion + '}';
    }
    
    
}
