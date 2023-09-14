<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Category</title>
</head>
<body class="container text-center">

	<h1>Category</h1>

	<img alt="Art et Decoration" src="Images/art.jpg" width="210px"
		height="200px">
	<label for="ArtEtFenetre"><h3>Art</h3></label>

	<div class="row row-cols-1 row-cols-4 g-4">
		<c:forEach items="${listeCategorie}" var="categorie">
			<div>
				<p style="color: black">${categorie.libelle}</p>
				<img>
			</div>
		</c:forEach>



	</div>
	<br>
	<div class="row">
		<div class="col-4">
			<a href="AjoutCategorie">Ajouter-Une-Categorie</a>
		</div>
	</div>
	<br>
</body>
</html>