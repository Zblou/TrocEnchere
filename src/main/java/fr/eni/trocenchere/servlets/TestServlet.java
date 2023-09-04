package fr.eni.trocenchere.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public TestServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        try {
            //1. récupérer les infos du fichier context.xml
            Context context = new InitialContext();
            DataSource dataSource =
                    (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");

            //2. récupérer la connexion à la BDD
            Connection cnx = dataSource.getConnection();
            System.out.println("Connextion ouverte");

            //3. libère la connexion
            cnx.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/JspTest.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
