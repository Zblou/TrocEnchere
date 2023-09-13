package fr.eni.trocenchere.servlets;

import java.io.IOException;

import fr.eni.trocenchere.bll.UtilisateurManager;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ServletProfil")
public class ServletProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("pseudoUtilisateur") != null) {
			
			request.setAttribute("profilVendeur", UtilisateurManager.getInstance().selectionnerUtilisateur(request.getParameter("pseudoUtilisateur")));
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/JSP/profil.jsp");
			rd.forward(request, response);
		}else {
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/JSP/profil.jsp");
		rd.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
