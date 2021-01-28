<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Creation compte ENI-Enchères</title>
</head>
<body>
	<p><a href="accueil">ENI-Encheres</a></p>
	<h2>Mon profil</h2>
	<p>${mapErreur}</p>
	<form action="creationcompte" method="POST">
		<label for="pseudo">Pseudo : </label>
		<input id="pseudo" type="text" name="pseudo" required/>
		<label for="nom">Nom : </label>
		<input id="nom" type="text" name="nom" required/>
		<br>
		<label for="prenom">Prenom : </label>
		<input id="prenom" type="text" name="prenom" required/>
		<label for="email">Email :</label>
		<input id="email" type="email" name="email" required/>
		<br>
		<label for="telephone">Téléphone : </label>
		<input id="telephone" type="tel" name="telephone" required/>
		<label for="rue">Rue : </label>
		<input id="rue" type="text" name="rue" required/>
		<br>
		<label for="codepostal">Code postal : </label>
		<input id="codepostal" type="number" name="codepostal" required/>
		<label for="ville">Ville : </label>
		<input id="ville" type="text" name="ville" required/>
		<br>
		<label for="motdepasse">Mot de passe : </label>
		<input id="motdepasse" type="password" name="motdepasse" required/>
		<label for="confirmationmdp">Confirmation : </label>
		<input id="confirmationmdp" type="password" name="confirmationmdp" required/>
		<br>
        <input type="submit" name="btValider" value="Créer">
	</form>
	<button onclick="window.location.href='http://localhost:8080/ProjetEncheres/accueil'">Annuler</button>
</body>
</html>