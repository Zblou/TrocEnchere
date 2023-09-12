<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<title>DétailVente</title>
</head>
<body>
<div class="container text-center">
<header>
	<br>
	<div class="row">
		<div class="col-4"><a href="ServletAccueil">ENI-Enchères</a></div>
		<div class="col-4"><h3>Détail Article </h3>N°${requestScope.ArticleVendu.getIdArticle() }</div>
	</div>
	<br>
	<br>
	<br>
</header>
	
	<div class="row">
		<div class="col-4"><img alt="ENCHERE" class="img-fluid" src="https://cdn.pixabay.com/photo/2014/04/03/10/45/hammer-311343_1280.png"></div>
		
		<div class="col-6">
			  <div class="row">
			    <div class="col-4 text-end"><label for="ArticleName" class="form-label">Article :</label></div>
			    <div class="col-4 text-start">${requestScope.ArticleVendu.getNomArticle() }</div>
			  </div>
			  <br>
			  <br>
			  <div class="row input-group">
				  <div class="col-4 text-end"><label class="form-label">Description :</label></div>
				  <div class="col-4 text-start">${requestScope.ArticleVendu.getDescription() }</div>
			  </div>
			  <br>
			  <br>
			  <br>
			  <div class="row">
			  <div class="col-4 text-end"><label for="ArticleCategorie" class="form-label">Catégorie :</label></div>
			  <div class="col-4 text-start">
				${requestScope.ArticleVendu.getCatArticle() }
			  </div>
			  </div>
			  <br>
			  <br>
			  <div class="row">
			    <div class="col-4 text-end"><label for="ArticlePhoto" class="form-label">Photo :</label></div>
			  </div>
			  <br>
			  <br>
			  <div class="row">
			    <div class="col-4 text-end"><label for="Prixvente" class="form-label">Meilleur offre :</label></div>
			    <div class="col-4 text-start" id="Prixvente">${requestScope.ArticleVendu.getPrixVente() }</div>
			  </div>
			  <br>
			  <br>
			  <div class="row">
			    <div class="col-4 text-end"><label for="MiseAPrix" class="form-label">Mise à prix :</label></div>
			    <div class="col-4 text-start" id="MiseAPrix">${requestScope.ArticleVendu.getMiseAPrix() }</div>
			  </div>
			  <br>
			  <br>
			  <div class="row">
			    <div class="col-4 text-end"><label for="FinEnchere" class="form-label">Date fin enchère :</label></div>
			    <div class="col-4 text-start">${requestScope.ArticleVendu.getDateFinEncheres() }</div>
			  </div>
			  <br>
			  <br>
			  <br>
			  <div>
			  </div>
			  <div class="col-10 offset-1">
			  	<fieldset class="border">
			  		<legend>Dépôt</legend>
					  <div class="row">
					    <div class="col-4 pt-2"><label for="RueDepot" class="form-label">Rue</label></div>
					    <div class="col-8"><input type="text" class="form-control" name="RueDepot" id="RueDepot" required></div>
					  </div>
					  <div class="row">
					    <div class="col-4 pt-2"><label for="CodePostalDepot" class="form-label">Code Postal</label></div>
					    <div class="col-8"><input type="text" class="form-control" name="CodePostalDepot" id="CodePostalDepot" required></div>
					  </div>
					  <div class="row">
					    <div class="col-4 pt-2"><label for="VilleDepot" class="form-label">Ville</label></div>
					    <div class="col-8"><input type="text" class="form-control" name="VilleDepot" id="VilleDepot" required></div>
					  </div>
			  	</fieldset>
			  </div>
			  
			  <div class="row justify-content-center">
			    <div class="col-4">
			    <br>
			    	<a class="btn btn-primary" href="ServletAccueil">Retour</a>
			    </div>
			  </div>
			  
		</div>
	
	</div>
</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</html>