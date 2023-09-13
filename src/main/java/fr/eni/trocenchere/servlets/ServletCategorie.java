package fr.eni.trocenchere.servlets;

import java.io.IOException;

import fr.eni.trocenchere.bll.CategorieManeger;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ServletCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/Categorie.jsp");
		rd.forward(request, response);
		
		//renvoi la liste de categorie et les affiche dans categorie.
		request.setAttribute("listeCategorie", CategorieManeger.getInstance().selectALLLibelle());	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		doGet(request, response);
	}

}
