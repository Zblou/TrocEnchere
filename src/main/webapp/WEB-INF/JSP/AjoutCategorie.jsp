<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<br>
<div class="row">
	<div class="col-4">
		<a href="ServletAccueil">ENI-Enchères</a>
	</div>
</div>
<br>
<br>
<br>
<title>Ajout Categorie</title>
</head>
<body class="container text-center">

	<h1>Ajouter une Category</h1>
	<br>
	<form method="POST" action="AjoutCategorie">
		<label for="Nom">Veuillez saisir le nom de la catégorie : </label>
		<input type="text" id="Nom" name="Nom" required/>
		<br>
	<input type="submit" value="Créer">

	</form>
	
	
</body>
</html>