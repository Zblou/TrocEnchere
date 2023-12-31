<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<div class="col-4 text-start"><a href="ServletAccueil"><img src="Images/LOGOINSANE_FINAL_VERSION.png" width="33%" /></a></div>
		<div class="col-4"><h3>Nouvelle vente</h3></div>
	</div>
	<br>
	<br>
	<br>
</header>
	
	<div class="row">
		<div class="col-4"><img alt="ENCHERE" class="img-fluid" src="https://cdn.pixabay.com/photo/2014/04/03/10/45/hammer-311343_1280.png"></div>
		
		<div class="col-6">
			<form class="row" method="POST" action="ServletArticle">
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
			  <div class="col-4 pt-2"><label for="ArticleCategorie" class="form-label">Cat�gorie</label></div>
			  <div class="col-8">
				    <select class="form-select" name="ArticleCategorie" id="ArticleCategorie" required>
				      <option value="INFORMATIQUE">Informatique</option>
				      <option value="AMEUBLEMENT">Ameublement</option>
				      <option value="VETEMENTS">V�tement</option>
				      <option value="SPORTSLOISIRS">Sports & Loisirs</option>
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
			  		<div class="col-4 pt-2"><label class="form-label" for="MiseAPrix">Mise � Prix</label></div>
				    <div class="col-8"><input min="100" type="number" name="MiseAPrix" id="MiseAPrix" class="form-control" /></div>
			  </div>
			  <br>
			  <br>
			  <div class="row">
			    <div class="col-4 pt-2"><label for="DebutEnchere" class="form-label">Date d�but ench�re</label></div>
			    <div class="col-8"><input type="date" class="form-control" name="DebutEnchere" id="DebutEnchere" required></div>
			  </div>
			  <br>
			  <br>
			  <div class="row">
			    <div class="col-4 pt-2"><label for="FinEnchere" class="form-label">Date fin ench�re</label></div>
			    <div class="col-8"><input type="date" class="form-control" name="FinEnchere" id="FinEnchere" required></div>
			  </div>
			  <br>
			  <br>
			  <br>
			  <div>
			  </div>
			  <div class="col-10 offset-1">
			  	<fieldset class="border">
			  		<legend>D�p�t</legend> 
				    <c:choose>
				    
				    	<c:when test="${!empty sessionScope.sessionUtilisateur }">
					      <div class="row">
					    		<div class="col-4 pt-2"><label for="RueDepot" class="form-label">Rue</label></div>
					    		<div class="col-8"><input type="text" class="form-control" name="RueDepot" id="RueDepot" value="${sessionScope.sessionUtilisateur.rue }" required></div>
					      </div>
						  <div class="row">
						    <div class="col-4 pt-2"><label for="CodePostalDepot" class="form-label">Code Postal</label></div>
						    <div class="col-8"><input type="text" class="form-control" name="CodePostalDepot" id="CodePostalDepot" value="${sessionScope.sessionUtilisateur.codePostal }" required></div>
						  </div>
						  <div class="row">
						    <div class="col-4 pt-2"><label for="VilleDepot" class="form-label">Ville</label></div>
						    <div class="col-8"><input type="text" class="form-control" name="VilleDepot" id="VilleDepot" value="${sessionScope.sessionUtilisateur.ville }" required></div>
						  </div>				    	
				    	</c:when>
				    	
				    	<c:otherwise>
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
				    	</c:otherwise>
				    	
				    </c:choose>
			  	</fieldset>
			  </div>
			  <div class="row justify-content-center">
			  	<div class="col-4">
			  	<br>
			    	<button class="btn btn-primary" type="submit">Enregistrer</button>
			    </div>
			    <div class="col-4">
			    <br>
			    	<a class="btn btn-primary" href="ServletAccueil">Retour</a>
			    </div>
			  </div>
			</form>
		</div>
	
	</div>
</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</html>