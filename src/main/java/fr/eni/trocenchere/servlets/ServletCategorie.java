package fr.eni.trocenchere.servlets;

import java.io.IOException;
import java.util.ArrayList;

import fr.eni.trocenchere.bll.CategorieManegerDavid;
import fr.eni.trocenchere.bo.CategorieDavid;
import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ServletCategorie")

public class ServletCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//renvoi la liste de categorie et les affiche dans categorie.
		ArrayList<CategorieDavid> list = CategorieManegerDavid.getInstance().selectALLLibelle();
		request.setAttribute("listeCategorie", list);	
		
		System.out.println(list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/Categorie.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		doGet(request, response);
	}

}
