package fr.eni.ecole.projetencheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni.ecole.projetencheres.bll.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	private static final String INSERT="INSERT INTO Utilisateurs (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	
	public void enregistrerUtilisateur(Utilisateur utilisateur) {
		
			
			Connection cnx;
			try {
				// 1 - se connecter à la bdd
				System.out.println("avant connection");
				cnx = ConnectionProvider.getConnection();
				System.out.println("après connection");
				// 2 - fabriquer la requete
				PreparedStatement pstmt = cnx.prepareStatement(INSERT);
				pstmt.setString(1, utilisateur.getPseudo());
				pstmt.setString(2, utilisateur.getNom());
				pstmt.setString(3, utilisateur.getPrenom());
				pstmt.setString(4, utilisateur.getEmail());
				pstmt.setString(5, utilisateur.getTelephone());
				pstmt.setString(6, utilisateur.getRue());
				pstmt.setString(7, utilisateur.getCodepostal());
				pstmt.setString(8, utilisateur.getVille());
				pstmt.setString(9, utilisateur.getMotdepasse());
				pstmt.setInt(10, utilisateur.getCredit());
				pstmt.setInt(11, utilisateur.getAdministrateur());
				
				System.out.println(pstmt.toString());
				
				// 3 - exécuter la requete
				pstmt.executeUpdate();
				
				System.out.println("requete exécutée");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		
	}
}
