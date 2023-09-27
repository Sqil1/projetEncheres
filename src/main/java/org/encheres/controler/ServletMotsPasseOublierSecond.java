package org.encheres.controler;

import org.encheres.bll.UtilisateurManager;
import org.encheres.bll.UtilisateurManagerImpl;
import org.encheres.bll.tokenPassword.TokenPasswordManager;
import org.encheres.bll.tokenPassword.TokenPasswordManagerImpl;
import org.encheres.bo.TokenPassword;
import org.encheres.bo.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/changeMotsDePasse")
public class ServletMotsPasseOublierSecond extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UtilisateurManager utilisateurManager = UtilisateurManagerImpl.getInstance();
    private TokenPasswordManager tokenPasswordManager = TokenPasswordManagerImpl.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String token = request.getParameter("token");
        request.setAttribute("token", token);
        TokenPassword tokenPassword = tokenPasswordManager.getToken(token);
        if (tokenPassword != null
                && tokenPassword.getDateExpiration().isAfter(LocalDateTime.now())
                && !tokenPassword.isTokenUsed()) {
            this.getServletContext().getRequestDispatcher("/mots-passe-oublier-second.jsp").forward(request, response);
        }
        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String token = request.getParameter("token");
        String motsDePasse = request.getParameter("motDePasse");
        TokenPassword token1 = tokenPasswordManager.getToken(token);
        if (token1 != null
                && token1.getDateExpiration().isAfter(LocalDateTime.now())
                && !token1.isTokenUsed()) {
            tokenPasswordManager.setUsedToken(token);
            utilisateurManager.updatePassword(motsDePasse, token1.getNoUtilisateur());
        }
        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }


}
