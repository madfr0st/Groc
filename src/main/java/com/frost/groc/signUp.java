/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frost.groc;

import com.frost.groc.DBMS.DBMS;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author suman
 */
@WebServlet(name = "signUp", urlPatterns = {"/signup"})
public class signUp extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {

        System.out.println("working");

        String userName = (String) request.getParameter("username");
        String pass = (String) request.getParameter("password");
        String pass1 = (String) request.getParameter("password2");
        String phone = (String) request.getParameter("phone");
        String email = (String) request.getParameter("email");

        System.out.println(phone);

        System.out.println(userName + " " + pass + " " + pass1 + " " + phone);

        boolean check = true;
        try {
            long a = Long.parseLong(phone);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            check = false;
        }

        boolean error = false;

        if (userName != null && pass != null && pass1 != null & phone != null) {
            if (!pass.equals(pass1) || pass.length() < 8) {
                error = true;
                request.setAttribute("error2", "*Password not same or password length is less than 8");
            }
            if (phone.length() != 10 || !check) {
                error = true;
                request.setAttribute("error3", "*phone number is not correct or not integer");
            }
        } else {
            error = true;
            request.setAttribute("error0", "*some fields are empty....");
        }

        if (!error) {

            DBMS dbms = new DBMS();
          
            if (dbms.insertUser(userName, pass, Long.parseLong(phone))) {
                
                request.setAttribute("user", true);
                HttpSession session = request.getSession();
                session.setAttribute("user", true);
                int id = new DBMS().getUserId(userName);
                session.setAttribute("userid",id);
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
            } else {
               
                request.setAttribute("error1", "*user already exists. choose a unique username....");
                RequestDispatcher rd = request.getRequestDispatcher("/signup.jsp");
                rd.forward(request, response);
            }

        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/signup.jsp");
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
            Logger.getLogger(signUp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(signUp.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(signUp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(signUp.class.getName()).log(Level.SEVERE, null, ex);
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
