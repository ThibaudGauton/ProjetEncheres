package fr.eni.ecole.projetencheres.dal;

public class DAOFactory {
	private static UtilisateurDAO utilisateurDAO=null;
	
	public static UtilisateurDAO getUtilisateurDAO() {
		if(utilisateurDAO==null) {
			utilisateurDAO = new UtilisateurDAOJdbcImpl();
		}
		return utilisateurDAO;
	}
}
