<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>
	<h1>Connexion</h1>
	
	<form method="POST" action="">
		<label for="identifiant">Identifiant</label>
		<input type="text" name="identifiant" id="identifiant">
		<br>
		<br>
		<label for="mdp">Mot de passe</label>
		<input type="password" name="mdp" id="mdp">
		<br>
		<br>
		<input type="submit" value="Connexion">
		<input type="checkbox" id="se_souvenir" name="se_souvenir">
		<label for="se_souvenir">Se souvenir de moi</label>
		<br>
		<a href="">Mot de passe oublié</a>
	</form>
	
	
	<a href="">Créer un compte</a>
</body>
</html>