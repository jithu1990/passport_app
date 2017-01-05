/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.passport.application;

import com.passport.application.DAO.AllDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.passport.application.Applybean;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
/**
 *
 * @author muhammed.noushad
 */
public class PassportApply extends HttpServlet {

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
        HttpSession sess=request.getSession(false);
        boolean res=false;
        AllDAO ADAO=new AllDAO();
        Applybean abean = new Applybean();
        
        int UID= ADAO.getUID((String)sess.getAttribute("Loginuser"));
        if(ADAO.checkStatus(UID))
        {
        abean.setGname(request.getParameter("givenName"));
        abean.setSname(request.getParameter("sirName"));
        abean.setFname(request.getParameter("FatherName"));
        abean.setMname(request.getParameter("MotherName"));
        abean.setPbirth(request.getParameter("PlaceBirth"));
        abean.setAddress(request.getParameter("Address"));
        abean.setPin(Integer.parseInt(request.getParameter("PinCode")));
        abean.setEmail(request.getParameter("Email"));
        abean.setPhone(Integer.parseInt(request.getParameter("Phone")));
        
        if (!ADAO.validateToken(request.getParameter("ACSRF"), (String)sess.getAttribute("ACSRF")))
        {
        response.sendRedirect("Login.jsp");
        return;
        }
        if (UID!=0){ res=ADAO.ApplyDAO(abean,UID); }
        }
        else
        {
        request.setAttribute("errorMessage", "You have already applied for a Passport");
        RequestDispatcher rd = request.getRequestDispatcher("/Apply.jsp");
        rd.forward(request, response);
        
        }
        if(res)
        {
            response.sendRedirect("ApplySuccess.jsp");
        }
        else
        {
        request.setAttribute("errorMessage", "Some entered data is not valid");
        RequestDispatcher rd = request.getRequestDispatcher("/Apply.jsp");
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
            Logger.getLogger(PassportApply.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PassportApply.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PassportApply.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PassportApply.class.getName()).log(Level.SEVERE, null, ex);
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
