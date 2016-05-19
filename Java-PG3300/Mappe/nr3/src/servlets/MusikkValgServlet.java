package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.MusikkHandler;
import domain.Album;

public class MusikkValgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ArrayList<Album> listOfAlbums = null;
		
		try {
			MusikkHandler handler = new MusikkHandler();
			listOfAlbums = handler.readRows(req.getParameter("sjanger"));
			System.out.println(listOfAlbums.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("albums", convertToHtml(listOfAlbums));
		
		req.getRequestDispatcher("/WEB-INF/musikkValg.jsp").forward(req, resp);
	}
	
	private String convertToHtml(List<Album> albums) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<ul>");
		
		for(Album a : albums) {
			stringBuilder.append("<li>");
			stringBuilder.append(a.getTittel());
			stringBuilder.append("</li>");
		}
		
		stringBuilder.append("</ul>");
		return stringBuilder.toString();
	}
}
