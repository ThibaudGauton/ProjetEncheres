<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion ENI-Enchères</title>
</head>
<body>
	<p><a href="accueil">ENI-Encheres</a></p>
	<p>${utilisateurConnecte}</p>
	<p>${erreurConnexion}</p>
	<c:choose>
		<c:when test="${utilisateurConnecte != null}">
			<p> Vous etes déjà connecté ! </p>
		</c:when>
		<c:otherwise>
			<form action="connexion" method="POST">
				<label for="identifiant">Identifiant : </label>
				<input id="identifiant" type="text" name="identifiant" required/>
				<br>
				<label for="motdepasse">Mot de passe : </label>
				<input id="motdepasse" type="password" name="motdepasse" required/>
				<br>
				<input type="submit" name="btConnexion" value="Connexion">
				<input type="checkbox" value="Se souvenir de moi">
				<!-- <a href="#">Mot de passe oublié</a>  -->
			</form>
      			<input type="submit" name="btValider" value="Rechercher">
		</c:otherwise>
	</c:choose>
	
	<button onclick="window.location.href='http://localhost:8080/ProjetEncheres/creationcompte'">Créer un compte</button>
</body>
</html>