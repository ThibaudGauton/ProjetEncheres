<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ENI-Enchères Connexion</title>
</head>
<body>
	<p>${utilisateurConnecte}</p>
	<form action="">
		<label for="identifiant">Identifiant : </label>
		<input id="identifiant" type="text" name="identifiant" required/>
		<br>
		<label for="motdepasse">Mot de passe : </label>
		<input id="motdepasse" type="password" name="motdepasse" required/>
		<br>
		<input type="submit" name="btConnexion" value="Connexion">
		<input type="checkbox" value="Se souvenir de moi">
		<a href="#">Mot de passe oublié</a>
	</form>
	<button onclick="window.location.href='http://localhost:8080/ProjetEncheres/creationcompte'">Créer un compte</button>
</body>
</html>