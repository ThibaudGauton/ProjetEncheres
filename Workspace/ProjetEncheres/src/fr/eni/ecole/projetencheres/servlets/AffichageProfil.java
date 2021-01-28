package fr.eni.ecole.projetencheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.projetencheres.bll.AffichageProfilManager;
import fr.eni.ecole.projetencheres.bll.bo.Utilisateur;

/**
 * Servlet implementation class accueil
 */
@WebServlet("/affichageProfil")
public class AffichageProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudoUtilisateur = request.getParameter("pseudo");
		AffichageProfilManager affichageProfilManager = new AffichageProfilManager();
		Utilisateur utilisateurAAfficher = affichageProfilManager.getInfosUtilisateur(pseudoUtilisateur);
		request.getSession().setAttribute("utilisateurAAfficher", utilisateurAAfficher);
		request.getServletContext().getRequestDispatcher("/affichageProfil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recherche des encheres à l'aide des élements du formulaire.		
	}

}
