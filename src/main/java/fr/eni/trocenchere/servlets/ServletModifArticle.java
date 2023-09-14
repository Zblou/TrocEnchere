package fr.eni.trocenchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import fr.eni.trocenchere.bll.ArticleManager;
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
		
		if(request.getParameter("idArticleModif") != null) {
			
			// CRER UN OBJET RANDOM POUR TEST
			request.setAttribute("ObjetAModif", ArticleManager.getInstance().selectArticleById(Integer.valueOf(request.getParameter("idArticleModif"))));
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/ModifArticle.jsp");
			rd.forward(request, response);
			
			System.out.println("Objet à modifier envoyé à la JSP MODIF");
		}else {
			System.out.println("doGet de ServletModifArticle Mais sans avoir recu l'objet à modifier (donc creation d'un objet test)");
			
			// A ENLEVER !!! JUSTE LA CAR ON A PAS ENCORE L'OBJET A MODIF ENVOYER DE L'ACCEUIL
//			Utilisateur usr = new Utilisateur();
//			request.setAttribute("ObjetAModif", new Article(4, "Article2ouf", "Un article vraiment super", LocalDate.now(),
//															LocalDate.of(2023, 9, 10), 100, 200, usr, Categorie.SPORTSLOISIRS));
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/ModifArticle.jsp");
			rd.forward(request, response);
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// On arrive ici si le formulaire de la page modif article est validé (et on veut donc modifier l'article)
		System.out.println("On est dans le doPost de ModifArticle");
		
		if(request.getParameter("idObjetModif") != null) {
			String idArticleModif = request.getParameter("idObjetModif");
			System.out.println(idArticleModif);
			// ON A BIEN L'ID, PLUS QU'A FAIRE MODIFICATION
			
			String ArticleName = request.getParameter("ArticleName");
			String DescriptionArticle = request.getParameter("DescriptionArticle");
			String ArticleCategorie = request.getParameter("ArticleCategorie");
			String MiseAPrix = request.getParameter("MiseAPrix");
			String DebutEnchere = request.getParameter("DebutEnchere");
			String FinEnchere = request.getParameter("FinEnchere");
			String RueDepot = request.getParameter("RueDepot");
			String CodePostalDepot = request.getParameter("CodePostalDepot");
			String VilleDepot = request.getParameter("VilleDepot");
			
			ArticleManager.getInstance().modifArticleById(idArticleModif, ArticleName, DescriptionArticle,
					ArticleCategorie, MiseAPrix, MiseAPrix, DebutEnchere, FinEnchere, RueDepot, CodePostalDepot, VilleDepot);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ServletAccueil");
			rd.forward(request, response);
			
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/ServletAccueil");
			rd.forward(request, response);
			System.out.println("On est dans le doPost de modifArticle mais sans avoir récupérer d'id");
		}

		
		
	}

}
