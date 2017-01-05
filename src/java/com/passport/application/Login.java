/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.passport.application;

import com.passport.application.DAO.AllDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author muhammed.noushad
 */
public class Login extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
     
        boolean result=false;
        AllDAO ADAO=new AllDAO();
            String U=request.getParameter("user");
            String P=request.getParameter("pass");
    
    if(null!=U && null!=P)
    {
    if(!(U.equalsIgnoreCase("") &&P.equalsIgnoreCase("")))
    {
    result=ADAO.LoginDAO(U, P);
    }
    }
    if(result)
    {
    HttpSession sess=request.getSession(true);
    sess.setAttribute("Loginuser", U);
    String Role=ADAO.checkRole(U);
    if ("Admin".equals(Role)){response.sendRedirect("PassportAdmin.jsp");}
    else if("Apply".equals(Role))
    {
        RequestDispatcher rd = request.getRequestDispatcher("/Welcome.jsp");
        rd.forward(request, response);
    }
    else
    {   request.setAttribute("errorMessage", "Invalid user or password");
        RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
        rd.forward(request, response); 
    }
    }
    else
    {   request.setAttribute("errorMessage", "Invalid user or password");
        RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
        rd.forward(request, response); 
    }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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

}
