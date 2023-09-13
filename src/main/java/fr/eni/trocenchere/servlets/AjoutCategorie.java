package fr.eni.trocenchere.servlets;

import java.io.IOException;

import fr.eni.trocenchere.bll.CategorieManeger;
import fr.eni.trocenchere.bo.Categoriedavid;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AjoutCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rdd = request.getRequestDispatcher("/WEB-INF/JSP/AjoutCategorie.jsp");
		rdd.forward(request, response);
		
		
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//récup des valeurs du formulaire

		String nouvelleCategorie = request.getParameter("Nom");	

		
		Categoriedavid categorie = new Categoriedavid(nouvelleCategorie);
		
		//envoy des des donne a la bll
		CategorieManeger.getInstance().insert(categorie);
		System.out.println(nouvelleCategorie);
  
		RequestDispatcher rdd = request.getRequestDispatcher("/WEB-INF/JSP/Categorie.jsp");
		rdd.forward(request, response);
	}

}
