package fr.eni.trocenchere.servlets;

import java.io.IOException;

import fr.eni.trocenchere.bll.UtilisateurManager;
import fr.eni.trocenchere.bo.Utilisateur;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ServletConnexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Dirige vers la jsp connexion
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/JSP/connexion.jsp");
		rd.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 récuprérer les données
		String pseudoCnx = request.getParameter("identifiant");
		String motDePasseCnx = request.getParameter("mdp");
		System.out.println("Pseudo : " + pseudoCnx + " Mot de passe : " + motDePasseCnx);
		
		//2 envoie les données à la BLL
		UtilisateurManager.getInstance().selectByPseudo();
		
		//3 si identifiants ok on part vers la page d'accueil
		
		
		
		
		doGet(request, response);
	}



}