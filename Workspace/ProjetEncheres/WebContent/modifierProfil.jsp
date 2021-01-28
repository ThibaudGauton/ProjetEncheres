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
	<form action="modifierProfil" method="POST">
		<label for="pseudo">Pseudo : </label>
		<input id="pseudo" type="text" name="pseudo" value="${utilisateurConnecte.pseudo}" required/>
		<label for="nom">Nom : </label>
		<input id="nom" type="text" name="nom" value="${utilisateurConnecte.nom}" required/>
		<br>
		<label for="prenom">Prenom : </label>
		<input id="prenom" type="text" name="prenom" value="${utilisateurConnecte.prenom}" required/>
		<label for="email">Email :</label>
		<input id="email" type="email" name="email" value="${utilisateurConnecte.email}" required/>
		<br>
		<label for="telephone">Téléphone : </label>
		<input id="telephone" type="tel" name="telephone" value="${utilisateurConnecte.telephone}" required/>
		<label for="rue">Rue : </label>
		<input id="rue" type="text" name="rue" value="${utilisateurConnecte.rue}"  required/>
		<br>
		<label for="codepostal">Code postal : </label>
		<input id="codepostal" type="number" name="codepostal" value="${utilisateurConnecte.codepostal}" required/>
		<label for="ville">Ville : </label>
		<input id="ville" type="text" name="ville" value="${utilisateurConnecte.ville}" required/>
		<br>
		<label for="motDePasseActuel">Mot de passe : </label>
		<input id="motDePasseActuel" type="password" name="motDePasseActuel" required/>
		<br>
		<label for="motdepasse">Mot de passe : </label>
		<input id="motdepasse" type="password" name="motdepasse"/>
		<label for="confirmationmdp">Confirmation : </label>
		<input id="confirmationmdp" type="password" name="confirmationmdp"/>
		<br>
		<p>Crédit : ${utilisateurConnecte.credit}</p>
        <input type="submit" name="btValider" value="Enregistrer">
        <button onclick="window.location.href='http://localhost:8080/ProjetEncheres/suppressionCompte'">Supprimer mon compte</button>
	</form>
	
</body>
</html>