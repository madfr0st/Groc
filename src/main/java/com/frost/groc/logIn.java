package com.frost.groc;

import com.frost.groc.DBMS.DBMS;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet(urlPatterns = "/login")
public class logIn extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {

        System.out.println("working");

        String userName = (String) request.getParameter("username");
        String pass = (String) request.getParameter("password");

        System.out.println(userName+" "+pass);

        boolean check = true;

        boolean error = false;

        if (userName == null || pass == null) {
            error = true;
            request.setAttribute("error0", "*some fields are empty....");
        }

        if (!error) {

            DBMS dbms = new DBMS();

            int a = dbms.checkUser(userName, pass);
            if (a == 0) {
                request.setAttribute("error1", "*user name does not exists........");
                RequestDispatcher rd = request.getRequestDispatcher("/Groc/login.jsp");
                rd.forward(request, response);
            } else if (a == 1) {
                request.setAttribute("error2", "*password is not correct....");
                RequestDispatcher rd = request.getRequestDispatcher("/Groc/login.jsp");
                rd.forward(request, response);
            } else if (a == 2) {
             
                HttpSession session =  request.getSession();
                session.setAttribute("user", true);
                int id = new DBMS().getUserId(userName);
                session.setAttribute("userid", id);
                response.sendRedirect("/Groc/index.jsp");
            }

        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
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
