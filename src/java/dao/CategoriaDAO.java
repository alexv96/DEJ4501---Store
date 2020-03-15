/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import interfaces.ICategoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Categoria;

/**
 *
 * @author Alex
 */
public class CategoriaDAO implements ICategoria{

    private Connection conexion;
    private Logger logger;
    
    public CategoriaDAO() {
        this.conexion = new Conexion().getConexion();
    }

    @Override
    public List<Categoria> getCategorias() {
        String sql = "SELECT * FROM CATEGORIAS";
        List<Categoria> categorias = new ArrayList<>();
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                Categoria c = new Categoria();
                c.setIdCategoria(rs.getInt("id"));
                c.setNombreCategoria(rs.getString("nombre"));
                
                Timestamp fechaCreacionTime = rs.getTimestamp("fecha_creacion");
                Calendar fechaCreacion = Calendar.getInstance();
                fechaCreacion.setTimeInMillis(fechaCreacionTime.getTime());
                
                c.setFechaCreacion(fechaCreacion);
                
                categorias.add(c);
            }
            return categorias;
            
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public Categoria addCategoria(Categoria c) {
        String sql = "INSERT INTO categorias (nombre, fecha_creacion) VALUES (?,?)";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ps.setString(1, c.getNombreCategoria());
            ps.setTimestamp(2, new Timestamp(c.getFechaCreacion().getTimeInMillis()));
            ps.executeUpdate();
            
            /*ResultSet clave = ps.getGeneratedKeys();
            int id = -1;
            
            while (clave.next()) {                
                id = clave.getInt(1);
            }
            
            c.setIdCategoria(id);*/
            
            return c;
            
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Ocurrio un error al guardar la categoría: {0}", e.getMessage());
        }
        
        return null;
    }
    
}
