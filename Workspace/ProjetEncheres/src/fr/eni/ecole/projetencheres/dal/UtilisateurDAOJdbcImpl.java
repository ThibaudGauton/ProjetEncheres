package fr.eni.ecole.projetencheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.ecole.projetencheres.bll.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	private static final String INSERT="INSERT INTO Utilisateurs (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String CONNEXION="SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM Utilisateurs WHERE (pseudo = ? or email = ?) and mot_de_passe = ?;";
	
	public void enregistrerUtilisateur(Utilisateur utilisateur) {
		
			
			Connection cnx;
			try {
				// 1 - se connecter � la bdd
				cnx = ConnectionProvider.getConnection();
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
				pstmt.setBoolean(11, utilisateur.getAdministrateur());
				
				System.out.println(pstmt.toString());
				
				// 3 - ex�cuter la requete
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		
	}

	@Override
	public Utilisateur getConnexion(String identifiant, String motDePasse) {
		Connection cnx;
		try {
			// 1 - se connecter � la bdd
			cnx = ConnectionProvider.getConnection();
			// 2 - fabriquer la requete
			PreparedStatement pstmt = cnx.prepareStatement(CONNEXION);
			pstmt.setString(1, identifiant);
			pstmt.setString(2, identifiant);
			pstmt.setString(3, motDePasse);
			
			
			// 3 - Ex�cution de la requ�te
		    ResultSet rs = pstmt.executeQuery();
		    
		    // 4 - Traitement du resultat
		    
		    while ( rs.next() )
		    {
		    	Utilisateur utilisateur = new Utilisateur();
		    	
		    	utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
		    	utilisateur.setPseudo(rs.getString("pseudo"));
		    	utilisateur.setNom(rs.getString("Nom"));
		    	utilisateur.setPrenom(rs.getString("prenom"));
		    	utilisateur.setEmail(rs.getString("email"));
		    	utilisateur.setTelephone(rs.getString("telephone"));
		    	utilisateur.setRue(rs.getString("rue"));
		    	utilisateur.setCodepostal(rs.getString("code_postal"));
		    	utilisateur.setVille(rs.getString("ville"));
		    	utilisateur.setMotdepasse(rs.getString("mot_de_passe"));
		    	utilisateur.setCredit(rs.getInt("credit"));
		    	utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
		    	
		    	return utilisateur;
		    }
		    rs.close();
		    pstmt.close();
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
