package org.encheres.controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ServletTestConnexion
 */
@WebServlet("/ServletTestConnexion")
public class ServletTestConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Context context = new InitialContext();
			// recherche de la date source
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/sqlserver/jdbc/pool_connection");
			//demande une connexion? la méthode getConnection met la demande en attente tant qu'il n'y a pas de 
			//connexion disponible dans le pull
			Connection cnx = dataSource.getConnection();
			System.out.println("La connexion est " + (cnx.isClosed()?"fermée":"ouverte" + "."));
			//liberer la connection lorsque l'on en a plus besoin
			cnx.close();//La connexion n'est pas fermée mais remise dans le pool
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			// sortir proprement de l'erreur
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			System.out.println("Une erreur est survenue lors de l'utilisation de la base de donnée : " + e.getMessage());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
