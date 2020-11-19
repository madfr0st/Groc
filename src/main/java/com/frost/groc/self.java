package com.frost.groc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author suman
 */
@WebServlet(urlPatterns = {"/self"})
public class self extends HttpServlet {
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        int a = 0;
            int b = 0;
            int sum = 0;
            if(request.getParameter("firstNum")!=null){
                a = Integer.parseInt(request.getParameter("firstNum"));
            }
            if(request.getParameter("secondNum")!=null){
                b = Integer.parseInt(request.getParameter("secondNum"));
            }
            
            sum = a+b;
            request.setAttribute("sum",sum );
           
            System.out.println("check");
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
        
    }

   
}
