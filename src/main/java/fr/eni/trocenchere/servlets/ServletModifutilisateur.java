package fr.eni.trocenchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.trocenchere.bll.UtilisateurManager;
import fr.eni.trocenchere.bo.Utilisateur;

@WebServlet("/ServletModifutilisateur")
public class ServletModifutilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/JSP/modifutilisateur.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id_utilisateur = request.getParameter("id_utilisateur");
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motdepasse = request.getParameter("motdepasse");
		String confirmationMdp = request.getParameter("confirmationmdp");//Faire la vérif du mots. Si mdp pas identique message d'erreur
		
		System.out.println("id ="+ id_utilisateur);
		
		UtilisateurManager.getInstance().modifUtilisateur(id_utilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal,
															ville, motdepasse);
		
		//stop l'ancienne session et en refaire une pour mettre a jour les données de l'utilisateur stocké en session
		HttpSession session = request.getSession();
		session.invalidate();
		
		HttpSession nouvelleSession = request.getSession();
		Utilisateur sessionUtilisateur = UtilisateurManager.getInstance().selectionnerUtilisateur(pseudo);
		nouvelleSession.setAttribute("sessionUtilisateur", sessionUtilisateur);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/JSP/profil.jsp");
		rd.forward(request, response);
	}

}
