<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
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


	<form method="POST" action="ServletCategorie">

		<h1>Category</h1>
		<br>
		<br>
		<br>
		<img alt="Art et Decoration" src="Images/art.png" width="210px"
			height="200px"> <label for="ArtEtFenetre"></label>
			<h3>Art</h3>
		<c:forEach items="${listeCategorie }" var="categorie">
			<div>
				<p style="color: black">${categorie.libelle}</p>
			</div>
		</c:forEach>
		<br>

		<div class="row">
			<div class="col-4">
				<a href="AjoutCategorie">Ajouter-Une-Categorie</a>
			</div>
		</div>
		<br>

	</form>
</body>
</html>