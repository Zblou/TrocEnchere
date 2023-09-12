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

@WebServlet("/ServletSuppresionUtilisateur")
public class ServletSuppresionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//invalide la session en cours
		HttpSession session = request.getSession();
		session.invalidate();
		
		String id_utilisateur = request.getParameter("id_utilisateur");
		
		UtilisateurManager.getInstance().suppresionUtilisateur(id_utilisateur);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("ServletAccueil");
		rd.forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
