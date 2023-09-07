package fr.eni.trocenchere.servlets;

import java.io.IOException;

import fr.eni.trocenchere.bll.UtilisateurManager;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/ServletConnexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Dirige vers la jsp connexion
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/JSP/connexion.jsp");
		rd.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Création de ma session
		HttpSession session = request.getSession();
		
		
		// récuprérer les données
		String pseudoCnx = request.getParameter("identifiant");
		String motDePasseCnx = request.getParameter("mdp");
		System.out.println("Pseudo : " + pseudoCnx + " Mot de passe : " + motDePasseCnx);
		
		// envoie les données à la BLL
		
		boolean connexionValide = UtilisateurManager.getInstance().verifIdentifiant(pseudoCnx, motDePasseCnx);
		
		// si identifiants ok on part vers la page d'accueil
		
		System.out.println(connexionValide);
		if(connexionValide) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/JSP/accueil.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/JSP/connexion.jsp");
			rd.forward(request, response);
		}
		
	}



}
