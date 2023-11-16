package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Userdao;
import com.ekart.FactoryProvider;
import com.entities.User;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
    
    }
    	
    	
    	
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,NullPointerException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;");
		try
				(PrintWriter out = response.getWriter()) {
			String email = request.getParameter("email_id");
			String password = request.getParameter("password");


			//authenticating user
			Userdao userDao = new Userdao(FactoryProvider.getFactory());
			User user1 = userDao.getUserByEmailAndPassword(email, password);
			//System.out.print(user);

			if (user1==null) {
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("message", "Invalid Details");
				response.sendRedirect("Login.jsp");
			} else {
				out.println("<h1> Welcome" + user1.getUsername() + "</h1>");

			}
			HttpSession httpSession = request.getSession();

			httpSession.setAttribute("current_user", user1);

			if (user1.getUsertype().equals("admin")) {
				response.sendRedirect("admin.jsp");
			} else if (user1.getUsertype().equals("normal")) {
				response.sendRedirect("normal.jsp");
			} else {
				out.println("Unidentified User");
			}


		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	}






