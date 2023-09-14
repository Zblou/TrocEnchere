package fr.eni.trocenchere.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.trocenchere.bll.ArticleManager;
import fr.eni.trocenchere.bll.EnchereManager;
import fr.eni.trocenchere.bll.UtilisateurManager;

@WebServlet("/ServletEnchere")
public class ServletEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletEnchere() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Une restriction est mise en place dans le HTML mais l'utilisateur peut modifier le min et le max et donc envoyer un mauvais input
		if(EnchereManager.getInstance().nouvelleEnchereUtilisateur(Integer.valueOf(request.getParameter("enchereUtilisateur")),
				ArticleManager.getInstance().selectArticleById(Integer.valueOf(request.getParameter("idArticleVendu"))),
				UtilisateurManager.getInstance().selectionnerUtilisateur(request.getParameter("pseudoUtilisateurAcheteur")))) {
			System.out.println("Enchère bien achetée !");
		}else {
			System.out.println("Problème avec l'achat de l'enchère, nouvelleEnchereUtilisateur() n'a pas marché !");
		}

	}

}
