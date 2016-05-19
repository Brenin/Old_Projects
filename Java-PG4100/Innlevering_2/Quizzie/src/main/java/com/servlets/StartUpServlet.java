package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.server.GetQuestions;

@WebServlet("/startUpServlet")
public class StartUpServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	GetQuestions gq = new GetQuestions();
	
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
