package fr.eni.trocenchere.servlets;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ServletArticle")
public class ServletArticle extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    public ServletArticle() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// On arrive ici via le bouton "Vendre un article" de l'acceuil
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/CreationArticle.jsp");
		rd.forward(request, response);
	}	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("ArticleName"));
		System.out.println(request.getParameter("DescriptionArticle"));
		System.out.println(request.getParameter("ArticleCategorie"));
		System.out.println(request.getParameter("ArticlePhoto"));
		System.out.println(request.getParameter("MiseAPrix"));
		System.out.println(request.getParameter("DebutEnchere"));
		System.out.println(request.getParameter("FinEnchere"));
		System.out.println(request.getParameter("RueDepot"));
		System.out.println(request.getParameter("CodePostalDepot"));
		System.out.println(request.getParameter("VilleDepot"));

	}

}
