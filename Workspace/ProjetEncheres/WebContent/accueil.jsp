<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil ENI-Encheres</title>
</head>
<body>
	<p><a href="accueil">ENI-Encheres</a></p>
	
	<nav>
		<ul>
			<c:choose>
				<c:when test="${utilisateurConnecte != null}">
					<li><a href="encheres">Enchères</a></li>
					<li><a href="vendrearticle">Vendre un article</a></li>
					<li><a href="profil">Mon profil</a></li>
					<li><a href="deconnexion">Déconnexion</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="connexion">S'inscrire - Se connecter</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</nav>
	<p>${utilisateurConnecte}</p>
	<h1>Liste des enchères</h1>
	<h2> Filtres</h2>
</body>
</html>