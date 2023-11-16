package com.servlets;

import com.ekart.FactoryProvider;
import com.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
       
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;");
		try(PrintWriter out=response.getWriter())
		
	    {
	    	
	    	String userName=request.getParameter("user_name");
	    	String userEmail=request.getParameter("user_email");
	    	String userPassword=request.getParameter("user_password");
	    	String userPhone=request.getParameter("user_phone");
	    	String userAddress=request.getParameter("user_address");

	    	
	    	//validations
	    	if(userName.isEmpty()) {
	    		out.println("Name field is empty");
	    	}
			if (userEmail.isEmpty()){
				out.println("userEmail is required");
			}
	    	//creating user object to store data
	    	User user=new User(userName, userEmail, userPassword, userPhone, "default.jpg", userAddress,"normal");
	    	Session hibernateSession= FactoryProvider.getFactory().openSession();
	    	Transaction tx=hibernateSession.beginTransaction();
	    	 int userid=(int)hibernateSession.save(user);

	    	 
	    	 tx.commit();
	    	 hibernateSession.close();
	    	
	    	 HttpSession httpSession=request.getSession();
	    	 httpSession.setAttribute("message", "User Registration Successfull...!");
	    	 response.sendRedirect("register.jsp");
	    	 return;
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    	}
	}
	
	
}




