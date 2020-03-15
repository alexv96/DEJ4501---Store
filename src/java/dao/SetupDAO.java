/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import interfaces.ISetup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class SetupDAO implements ISetup{

    private Connection conexion;
    Logger logger;

    public SetupDAO() {
        this.conexion = new Conexion().getConexion();
        this.logger = Logger.getLogger(this.getClass().getSimpleName());
    }
    
    @Override
    public boolean instalar() {
        try{
            conexion.setAutoCommit(false);
            
            String sqlCat = "CREATE TABLE categorias(\n"
                    + "id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT, \n"
                    + "nombre VARCHAR(255) NOT NULL, \n"
                    + "fecha_creacion TIMESTAMP NOT NULL \n"
                    + ");";
            
            String sqlProd = "CREATE TABLE productos (\n" 
                    + "idProducto BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT, \n" 
                    + "nombre VARCHAR(255) NOT NULL, \n"
                    + "precio BIGINT(20) NOT NULL, \n"
                    + "imagen TEXT NOT NULL, \n"
                    + "fecha_creacion TIMESTAMP NOT NULL, \n"
                    + "categoria_id BIGINT(20) NOT NULL, \n"
                    + "FOREIGN KEY (categoria_id) REFERENCES categorias (id)\n" 
                    + ");";

            //Creaciónd de tabla Categorias
            logger.log(Level.INFO, "Ejecutando SQL: {0}", sqlCat);
            PreparedStatement psCat = conexion.prepareStatement(sqlCat);
            psCat.execute();
            
            //Creación de tabla Producto
            logger.log(Level.INFO, "Ejecutando SQL: {0}", sqlProd);
            PreparedStatement psProd = conexion.prepareStatement(sqlProd);
            psProd.execute();
            
            conexion.commit();
            
            conexion.setAutoCommit(true);
            
            logger.log(Level.INFO, "Se instaló correctamente la aplicación.");
            return true;
            
        }catch(SQLException e){
            logger.log(Level.SEVERE, "Ocurriio un error al intentar realizar la instalaci\u00f3n: {0}", e.getMessage());
            
            try {
                if (conexion != null) {
                    conexion.rollback();
                }
            } catch (SQLException e2) {
                logger.log(Level.SEVERE, "Ocurrio un error al realizar el Rollback{0}", e2.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean desintalar() {
        try {
            conexion.setAutoCommit(false);
            
            String sqlProductos = "DROP TABLE productos";
            String sqlCategorias = "DROP TABLE categorias";
            
            PreparedStatement psProd = conexion.prepareStatement(sqlProductos);
            PreparedStatement psCat = conexion.prepareStatement(sqlCategorias);
            
            psCat.execute();
            psProd.execute();
            conexion.commit();
            
            //Vuelve al estado original
            conexion.setAutoCommit(true);
            
            logger.log(Level.INFO, "Se desinstalo correctamente la aplicación");
            return true;
        } catch (SQLException ex){
            logger.log(Level.SEVERE, "Ocurrio un error al desintalar: {0}", ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean cargar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
