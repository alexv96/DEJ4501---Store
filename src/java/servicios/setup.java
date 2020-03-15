/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import controlador.CategoriaController;
import controlador.SetupController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Categoria;

/**
 *
 * @author Alex
 */
public class setup extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("btnAccion");
        
        if (accion != null) {
            
            switch(accion){
                case "instalar":
                    instalar(request,response);
                    break;
                case "desintalar":
                    desintalar(request,response);
                    break;
                case "cargar":
                    cargar(request,response);
                    break;
                default:
                    request.getRequestDispatcher("/instalacion.jsp").forward(request, response);
            }
        }
        request.getRequestDispatcher("/instalacion.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //String accion = request.getParameter("btnAccion");
        Map<String, String[]> parametros = request.getParameterMap();
        
        if (!parametros.isEmpty() && parametros.containsKey("btnAccion")) {
            String btnAccion = parametros.get("btnAccion")[0];
            
            switch(btnAccion){
                case "instalar":
                    instalar(request,response);
                    break;
                case "desintalar":
                    desintalar(request,response);
                    break;
                case "cargar":
                    cargar(request,response);
                    break;
                default:
                    request.getRequestDispatcher("/instalacion.jsp").forward(request, response);
            }
        }
        request.getRequestDispatcher("/instalacion.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void instalar(HttpServletRequest request, HttpServletResponse response) {
        
        
        try {
            SetupController daoSetup = new SetupController();
            boolean instalar = daoSetup.instalar();
            
            if (instalar) {
                String mensajes = "Se instaló correcta la BD.";
                request.setAttribute("mensajes", mensajes);
                //request.getRequestDispatcher("instalacion.jsp").forward(request, response);
            }else{
                String error = "<strong>ERROR! </strong> al instalar la BD, verifique con el técnico.";
                request.setAttribute("error", error);
                //request.getRequestDispatcher("instalacion.jsp").forward(request, response);
            }  
        } catch (Exception e) {
        }
    }

    private void desintalar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SetupController daoSetup = new SetupController();
        boolean desintalar = daoSetup.desintalar();
        
        if (desintalar) {
            String mensajes = "Se desintalo correctamente la BD.";
            request.setAttribute("mensajes", mensajes);
            request.getRequestDispatcher("instalacion.jsp").forward(request, response);
        }else{
            String error = "<strong>ERROR! </strong> al eliminar la BD, verifique con el técnico.";
            request.setAttribute("error", error);
            request.getRequestDispatcher("instalacion.jsp").forward(request, response);
        }
    }

    private void cargar(HttpServletRequest request, HttpServletResponse response) {
        List<Categoria> listaCategoria = new ArrayList<>();
        List<String> error = new ArrayList<>();
        List<String> mensajes = new ArrayList<>();
        
        listaCategoria.add(new Categoria("Niños"));
        listaCategoria.add(new Categoria("Niñas"));
        listaCategoria.add(new Categoria("Juvenil Hombre"));
        listaCategoria.add(new Categoria("Juvenil Mujer"));
        listaCategoria.add(new Categoria("Hombres"));
        listaCategoria.add(new Categoria("Mujeres"));
        listaCategoria.add(new Categoria("Otros"));
        
        CategoriaController daoCategoria = new CategoriaController();
        
        for (Categoria x : listaCategoria) {
            Categoria c = daoCategoria.agregarCategoria(x);
            
            if (c == null) {
                error.add("No se pudo crear la categoria: ");
            }else{
                mensajes.add("Se creó correctamente la categoria: "+ c.getNombreCategoria() +"<br>");
            }
        }
        
        request.setAttribute("mensajes", mensajes);
        request.setAttribute("error", error);
    }

}
