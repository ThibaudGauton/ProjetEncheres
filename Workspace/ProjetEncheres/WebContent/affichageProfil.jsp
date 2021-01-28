<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profil de ${profil.pseudo} ENI-Enchères</title>
</head>
<body>
	<p><a href="accueil">ENI-Encheres</a></p>
	
	<c:choose>
		<c:when test="${utilisateurAAfficher != null}">
			<label>Pseudo : ${utilisateurAAfficher.pseudo}</label>
			<br>
			<label>Nom : ${utilisateurAAfficher.nom}</label>
			<br>
			<label>Prenom : ${utilisateurAAfficher.prenom}</label>
			<br>
			<label>Email : ${utilisateurAAfficher.email}</label>
			<br>
			<label>Téléphone : ${utilisateurAAfficher.telephone}</label>
			<br>
			<label>Rue : ${utilisateurAAfficher.rue}</label>
			<br>
			<label>Code postal : ${utilisateurAAfficher.codepostal}</label>
			<br>
			<label>Ville : ${utilisateurAAfficher.ville}</label>
			<br>
			<c:if test="${utilisateurAAfficher.pseudo == utilisateurConnecte.pseudo}">
				<p>Crédit : ${utilisateurConnecte.credit}</p>
				<button onclick="window.location.href='http://localhost:8080/ProjetEncheres/modifierProfil'">Modifier</button>
			</c:if>
		</c:when>
		
		<c:otherwise>
			<p> pas d'utilisateur a afficher</p>
		</c:otherwise>
	</c:choose>
</body>
</html>