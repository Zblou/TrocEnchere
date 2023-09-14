package fr.eni.trocenchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.trocenchere.bll.ArticleManager;

@WebServlet("/ServletAnnulerVente")
public class ServletAnnulerVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletAnnulerVente() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("doGet d'annulerVenteArticle");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ON ARRIVE ICI SI ON A CLIQUE SUR "ANNULER VENTE" DANS LA JSP MODIF ARTICLE !
		
		int idArticleDelete = Integer.valueOf(request.getParameter("idObjetDelete"));
		System.out.println("ID de l'objet à delete : " + idArticleDelete);
		RequestDispatcher rd = request.getRequestDispatcher("/ServletAccueil");
		rd.forward(request, response);
		try {
			ArticleManager.getInstance().deleteArticle(idArticleDelete);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
