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
<title>Category</title>
</head>
<body>
		
	<form method="POST" action="ServletCategorie">
		
		<h1>Category</h1>
		
		<img alt="Art et Decoration" src="Images/art.jpg" width="210px" height="200px">
		<label for="ArtEtFenetre"><h3>Art</h3></label>
		
		<c:forEach items="${listeCategorie }" var="categorie">
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