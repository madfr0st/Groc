package com.frost.groc;

import com.frost.groc.DBMS.DBMS;
import com.frost.groc.DBMS.Pair;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/addToCart")
public class addToCart extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {

        ArrayList<Pair<String,Integer>> list = new ArrayList<>();
        String path = System.getProperty("user.dir")+"\\src\\main\\webapp\\images\\name.txt";
        BufferedReader inp = new BufferedReader(new FileReader(new File(path)));

        int a = 0;
        while (true){
            String s1 = inp.readLine();
            if(s1 != null && !s1.split(" ")[0].equals("**")){
                if(s1.equals("fruits")){
                    a = 1;
                }
                else if (s1.equals("vegetables")){
                    a = 2;
                }
                else if(s1.equals("grocery")){
                    a = 3;
                }

                if(a==1 && !s1.equals("fruits")){
                    try {
                        int amount = Integer.parseInt(request.getParameter(s1));
                        if(amount>0){
                            list.add(new Pair<String, Integer>(s1,amount));
                        }
                    }
                    catch (Exception e){
                        continue;
                    }

                }
                if(a==2 && !s1.equals("vegetables")){
                    try {
                        int amount = Integer.parseInt(request.getParameter(s1));
                        if(amount>0){
                            list.add(new Pair<String, Integer>(s1,amount));
                        }
                    }
                    catch (Exception e){
                        continue;
                    }
                }
                if(a==3 && !s1.equals("grocery")){
                    try {
                        int amount = Integer.parseInt(request.getParameter(s1));
                        if(amount>0){
                            list.add(new Pair<String, Integer>(s1,amount));
                        }
                    }
                    catch (Exception e){
                        continue;
                    }
                }

            }
            if(s1==null){
                break;
            }
        }

        DBMS dbms = new DBMS();
        HttpSession session = request.getSession();
        boolean done = true;
        if(session.getAttribute("userid")==null){
            response.sendRedirect("/Groc/login.jsp");
        }
        else {
            for (int i = 0; i < list.size(); i++) {
                done &=dbms.singleUserCart((int)session.getAttribute("userid"),list.get(i).a
                        ,"grams",list.get(i).b);
            }
        }

        if(done){
            session.setAttribute("cart","items has been added");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
        rd.forward(request, response);

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
