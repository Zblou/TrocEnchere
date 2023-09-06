package fr.eni.trocenchere.servlets;

import java.io.IOException;
import java.util.List;

import fr.eni.diplomes.bll.CandidatManager;
import fr.eni.diplomes.bo.Candidat;
import fr.eni.trocenchere.bo.Utilisateur;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ServletInscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Dirige vers la page d'inscription
			
	
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");;
		String prenom = request.getParameter("prenom");;
		String email = request.getParameter("email");;
		String telephone = request.getParameter("telephone");;
		String rue = request.getParameter("rue");;
		String codePostal = request.getParameter("codePostal");;
		String ville = request.getParameter("ville");;
		String motDePasse = request.getParameter("mdp");;
		
		
		
		
		
		doGet(request, response);
	}

}
