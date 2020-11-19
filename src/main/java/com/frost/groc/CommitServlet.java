package com.frost.groc;

// Servlet code 
import java.io.IOException; 
import java.util.HashMap; 
import java.util.Map; 
import java.util.regex.Matcher; 
import java.util.regex.Pattern; 

import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 

@WebServlet("/CommitServlet") 
public class CommitServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L; 

	protected void doPost(HttpServletRequest request, 
						HttpServletResponse response) 
		throws ServletException, IOException 
	{ 

		// Create a Bundle of errors in the form of Map 
		Map<String, String> errors = new HashMap<String, String>(); 
		Map<String, String> after = new HashMap<String, String>(); 

		// Get the input values from the website 
		String inputName = request.getParameter("inputName"); 
		String inputGender = request.getParameter("gender"); 

		// If error occur, previous entered data will be reflected 
		after.put("inputName", inputName); 

		// Check for Validation of Name and Gender 
		if (!validateName(inputName)) 

			// If error occur, create a entry for 
			// the bundle and write a alert message 
			errors.put("Name", "Please enter a valid name"); 

		if (inputGender == null) 

			// If Gender is not select, encounter an error 
			errors.put("Gender", "Please select a Gender"); 

		if (errors.isEmpty()) 

			// If no error occur, redirect to the response website 
			response.sendRedirect("success.html"); 

		else { 

			// Set this bundle into the request attribute 
			// and pass the data to the requested website 
			request.setAttribute("after", after); 
			request.setAttribute("errors", errors); 
			request.getRequestDispatcher("comment.jsp").forward(request, response); 
		} 
	} 

	// Method to validate Proper Name, entered by the user 
	public static boolean validateName(String txt) 
	{ 
		String regex = "^[a-zA-Z ]+$"; 
		Pattern pattern = Pattern.compile(regex, 
										Pattern.CASE_INSENSITIVE); 
		Matcher matcher = pattern.matcher(txt); 
		return matcher.find(); 
	} 
} 
