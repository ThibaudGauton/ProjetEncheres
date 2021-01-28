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
					<li><a href="affichageProfil?pseudo=${utilisateurConnecte.pseudo}">Mon profil</a></li>
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
	<form action="accueil" method="POST">
		<input type="search" placeholder="Le nom de l'article contient">
		<br>
		<label for="categorie">Catégorie : </label>
		<select name="categorie" id="categorie">
		    <option value="">Toutes</option>
		    <option value="informatique">Informatique</option>
		    <option value="ameublement">Ameublement</option>
		    <option value="vetement">Vêtement</option>
		    <option value="sportetloisir">Sport&Loisirs</option>
		</select>
        <input type="submit" name="btValider" value="Rechercher">
	</form>
	
	<article>ceci est un article
		<p>Vendeur : <span><a href="affichageProfil?pseudo=aze">aze</a></span></p>
	
	</article>
	
</body>
</html>