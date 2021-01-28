package fr.eni.ecole.projetencheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.projetencheres.bll.SuppressionProfilManager;
import fr.eni.ecole.projetencheres.bll.bo.Utilisateur;

/**
 * Servlet implementation class accueil
 */
@WebServlet("/suppressionCompte")
public class SuppressionCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SuppressionProfilManager suppressionProfilManager = new SuppressionProfilManager();
		suppressionProfilManager.supprimerProfil((Utilisateur) request.getSession().getAttribute("utilisateurConnecte"));
		request.getSession().invalidate();
		request.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ajouter les infos du formulaire
		//${}
		//ajouter un attribut dans la session
		//request.getSession().setAttribute("message", "je suis un message de la servlet");
		//supprimer la session
		//request.getSession().invalidate();
		//supprimer un attribut dans la session
		//request.getSession().removeAttribute("nomattribut");
	}

}
