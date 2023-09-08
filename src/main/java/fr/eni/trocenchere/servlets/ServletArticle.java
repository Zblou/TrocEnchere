package fr.eni.trocenchere.servlets;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.time.LocalDate;

import fr.eni.trocenchere.bll.ArticleManager;
import fr.eni.trocenchere.bo.Article;
import fr.eni.trocenchere.bo.Categorie;
import fr.eni.trocenchere.bo.Utilisateur;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ServletArticle")
public class ServletArticle extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    public ServletArticle() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// On arrive ici via le bouton "Vendre un article" de l'acceuil
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/CreationArticle.jsp");
		rd.forward(request, response);
	}	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// FAUT FAIRE VERIF DEPOT CAR PEUT ETRE VIDE
		
		String ArticleName = request.getParameter("ArticleName");
		String DescriptionArticle = request.getParameter("DescriptionArticle");
		String ArticleCategorie = request.getParameter("ArticleCategorie");
		String MiseAPrix = request.getParameter("MiseAPrix");
		String DebutEnchere = request.getParameter("DebutEnchere");
		String FinEnchere = request.getParameter("FinEnchere");
		String RueDepot = request.getParameter("RueDepot");
		String CodePostalDepot = request.getParameter("CodePostalDepot");
		String VilleDepot = request.getParameter("VilleDepot");
		
		ArticleManager.getInstance().verifArticle(ArticleName,
				DescriptionArticle,
				ArticleCategorie,
				MiseAPrix,
				DebutEnchere,
				FinEnchere,
				RueDepot,
				CodePostalDepot,
				VilleDepot);
		
		// SI LA VERIF S'EST BIEN PASSEE ON CREE L'OBJET ET ON L'INSERE EN BDD
		
		// ON CREER UN USER EN ATTENDANT D'EN AVOIR DES VRAIS
		Utilisateur user = new Utilisateur();
		user.setIdUtilisateur(2);
		
		Article art = new Article(ArticleName,
								DescriptionArticle,
								LocalDate.parse(DebutEnchere),
								LocalDate.parse(FinEnchere),
								Integer.valueOf(MiseAPrix),
								user,
								Categorie.valueOf(ArticleCategorie.toUpperCase()));
		
		ArticleManager.getInstance().insertArticle(art, RueDepot, CodePostalDepot, VilleDepot);
	}

}
