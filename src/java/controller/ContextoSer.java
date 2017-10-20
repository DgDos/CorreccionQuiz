/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ColumnaDAO;
import dao.ContextoDAO;
import dao.ModeloDAO;
import dao.TablaDAO;
import dao.UnidadDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Columna;
import model.Model;
import model.Tabla;
import model.Unidad;
import model.contextoNavegacion;

/**
 *
 * @author LabingXEON
 */
public class ContextoSer extends HttpServlet {

 
    
    
    

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        ContextoDAO cd = new ContextoDAO();
        ModeloDAO md=new ModeloDAO();
        TablaDAO td=new TablaDAO();
        ArrayList<Model> respuesta = new ArrayList<>();
        ArrayList<contextoNavegacion> respuesta2 = new ArrayList<>();
        ArrayList<Tabla> respuesta3 = new ArrayList<>();
        if (action.equals("contexto")) {
            try {
                respuesta = md.getAllModelos();
            } catch (SQLException ex) {
                Logger.getLogger(TablaSer.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/contexto.jsp");
            request.setAttribute("respuesta", respuesta);
            rd.forward(request, response);
        }
        if (action.equals("unidad")) {
            try {
                respuesta2 = cd.getAllContextos();
                respuesta3= td.getAllTables();
            } catch (SQLException ex) {
                Logger.getLogger(TablaSer.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/unidad.jsp");
            request.setAttribute("respuesta", respuesta2);
            request.setAttribute("respuesta2", respuesta3);
            rd.forward(request, response);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ContextoDAO contexto_dao = new ContextoDAO();
        String link = request.getParameter("link");
        int idM = Integer.parseInt(request.getParameter("id"));


        

        try {
            contexto_dao.addContexto(link,idM);
        } catch (SQLException ex) {
            Logger.getLogger(SchemaSer.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect("menu.html");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
