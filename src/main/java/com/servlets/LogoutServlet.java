package com.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html;");
        try
                (PrintWriter out= response.getWriter()) {
            HttpSession httpSession= request.getSession();
            httpSession.removeAttribute("current_user");
            response.sendRedirect("Login.jsp");



        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        }

        }
