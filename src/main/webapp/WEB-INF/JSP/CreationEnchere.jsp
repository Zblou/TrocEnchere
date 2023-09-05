<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<title>CreationEnchere</title>
</head>
<body>
<div class="container text-center">
<header>
	<br>
	<div class="row">
		<div class="col-4"><a href="Acceuil">ENI-Enchères</a></div>
		<div class="col-4"><h3>Nouvelle vente</h3></div>
	</div>
	<br>
	<br>
	<br>
</header>
	
	<div class="row">
		<div class="col-4"><img alt="ENCHERE" class="img-fluid" src="https://cdn.pixabay.com/photo/2014/04/03/10/45/hammer-311343_1280.png"></div>
		
		<div class="col-6">
			<form class="row">
			  <div class="row">
			    <div class="col-4 pt-2"><label for="ArticleName" class="form-label">Article</label></div>
			    <div class="col-8"><input type="text" class="form-control" name="ArticleName" id="ArticleName" required></div>
			  </div>
			  <br>
			  <br>
			  <div class="row input-group">
				  <div class="col-4 pt-2"><label class="form-label">Description</label></div>
				  <div class="col-8"><textarea name="DescriptionArticle" class="form-control"></textarea></div>
			  </div>
			  <br>
			  <br>
			  <br>
			  <div class="row">
			  <div class="col-4 pt-2"><label for="ArticleCategorie" class="form-label">Catégorie</label></div>
			  <div class="col-8">
				    <select class="form-select" name="ArticleCategorie" id="ArticleCategorie" required>
				      <option value="Informatique">Informatique</option>
				      <option value="Ameublement">Ameublement</option>
				      <option value="Vetement">Vêtement</option>
				      <option value="SportLoisirs">Sports & Loisirs</option>
				    </select>
			  </div>
			  </div>
			  <br>
			  <br>
			  <div class="row">
			    <div class="col-4 pt-2"><label for="ArticlePhoto" class="form-label">Photo</label></div>
			    <div class="col-8"><input type="text" name="ArticlePhoto" class="form-control" id="ArticlePhoto" required></div>
			  </div>
			  <br>
			  <br>
			  <div class="row">
			  		<div class="col-4 pt-2"><label class="form-label" for="MiseAPrix">Mise à Prix</label></div>
				    <div class="col-8"><input min="10" max="20" type="number" name="MiseAPrix" id="MiseAPrix" class="form-control" /></div>
			  </div>
			  <br>
			  <br>
			  <div class="row">
			    <div class="col-4 pt-2"><label for="DebutEnchere" class="form-label">Date début enchère</label></div>
			    <div class="col-8"><input type="date" class="form-control" name="DebutEnchere" id="DebutEnchere" required></div>
			  </div>
			  <br>
			  <br>
			  <div class="row">
			    <div class="col-4 pt-2"><label for="FinEnchere" class="form-label">Date fin enchère</label></div>
			    <div class="col-8"><input type="date" class="form-control" name="FinEnchere" id="FinEnchere" required></div>
			  </div>
			  <br>
			  <br>
			  <br>
			  <div>
			  </div>
			  
			  <div class="col-12">
			    <button class="btn btn-primary" type="submit">Submit form</button>
			  </div>
			</form>
		</div>
	
	</div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</html>