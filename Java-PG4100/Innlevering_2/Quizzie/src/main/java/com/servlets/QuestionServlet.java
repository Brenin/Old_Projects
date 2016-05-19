package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

// memo to self, class will redirect info to server with sockets

@WebServlet("/questionServlet")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
								throws ServletException, IOException {
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//Starts server and redirects
		reDirect(req, resp);
	}
	
	private void reDirect(HttpServletRequest req, HttpServletResponse resp){
		try {
			req.getRequestDispatcher("/Asking.jsp").forward(req, resp);
		} catch (ServletException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
}
