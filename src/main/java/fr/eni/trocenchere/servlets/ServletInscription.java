package fr.eni.trocenchere.servlets;

import java.io.IOException;

import fr.eni.trocenchere.bll.BusinessException;
import fr.eni.trocenchere.bll.UtilisateurManager;
import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.messages.LecteurMessage;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ServletInscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Dirige vers la page d'inscription

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/inscription.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BusinessException be = new BusinessException();

		// recupération des valeurs du formulaire
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("motdepasse");
		String confirmationMdp = request.getParameter("confirmmotdepasse");

		Utilisateur nouveauUtilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
				motDePasse);

		if(!motDePasse.equals(confirmationMdp)) {
			
		request.setAttribute("confirmationMdpInvalide", LecteurMessage.getMessagesErreur(CodesErreurServlet.ERREUR_CONFIRMATION_MDP));
			
		}
		
		
		if(!be.hasErreur()&& motDePasse.equals(confirmationMdp)) {
			// envoie des données a la bll
			try {
				UtilisateurManager.getInstance().insert(nouveauUtilisateur);
				System.out.println(nouveauUtilisateur);
				//on part vers l'accueil si tout est ok
				RequestDispatcher rd = request.getRequestDispatcher("ServletAccueil");
				rd.forward(request, response);
				
				System.out.println("insert ok");
				
			} catch (BusinessException e) {
				e.printStackTrace();
				//si erreur de l'insertion on part vers le formulairs d'inscription
				request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
				
				System.out.println("insert erreur" + e.getListeCodesErreur());
				
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/JSP/inscription.jsp");
				rd.forward(request, response);
			}


		}else {
			
			System.out.println(be.getListeCodesErreur());
			request.setAttribute("listeCodesErreur", be.getListeCodesErreur());
			
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/JSP/inscription.jsp");
			rd.forward(request, response);
		}
	}

}
