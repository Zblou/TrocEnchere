package fr.eni.trocenchere.servlets;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ServletEnchere")
public class ServletEnchere extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    public ServletEnchere() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// On arrive ici via le bouton "Vendre un article" de l'acceuil
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/ServletEnchere.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
