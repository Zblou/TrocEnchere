package fr.eni.trocenchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import fr.eni.trocenchere.bo.Article;
import fr.eni.trocenchere.bo.Categorie;
import fr.eni.trocenchere.bo.Utilisateur;

@WebServlet("/ServletModifArticle")
public class ServletModifArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletModifArticle() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// On arrive ici en cliquant sur un article si on en est le possesseur (et connecté)
		// On dois envoyer depuis 'lacceuil l'objet à modofier
		
		if(request.getParameter("ObjetAModif") != null) {
			
			// CRER UN OBJET RANDOM POUR TEST
			request.setAttribute("ObjetAModif", request.getParameter("ObjetAModif"));
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/ModifArticle.jsp");
			rd.forward(request, response);
			
			System.out.println("Objet à modifier envoyé à la JSP MODIF");
		}else {
			System.out.println("doGet de ServletModifArticle Mais sans avoir pu envoyer l'objet à modifier.");
			
			// A ENLEVER !!! JUSTE LA CAR ON A PAS ENCORE L'OBJET A MODIF ENVOYER DE L'ACCEUIL
			Utilisateur usr = new Utilisateur();
			request.setAttribute("ObjetAModif", new Article(4, "Article2ouf", "Un article vraiment super", LocalDate.now(),
															LocalDate.of(2023, 9, 10), 100, 200, usr, Categorie.SPORTSLOISIRS));
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/ModifArticle.jsp");
			rd.forward(request, response);
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// On arrive ici si le formulaire de la page modif article est validé (et on veut donc modifier l'article)
		
		doGet(request, response);
	}

}