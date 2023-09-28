package org.encheres.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.encheres.bll.ArticleVendu.ArticleVenduManager;
import org.encheres.bll.ArticleVendu.ArticleVenduManagerImpl;
import org.encheres.bo.ArticleVendu;
import org.encheres.errors.DatabaseException;

/**
 * Servlet implementation class ServletIndex
 */
@WebServlet("/Index")
public class ServletIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    try {
	        ArticleVenduManager articleManager = new ArticleVenduManagerImpl(); 
	        List<ArticleVendu> articles = articleManager.selectAll();
	        request.setAttribute("articles", articles);
	        System.out.println(articles);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
	        dispatcher.forward(request, response);
	    } catch (DatabaseException e) {
	        e.printStackTrace();
	    }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
