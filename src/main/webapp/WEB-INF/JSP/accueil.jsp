<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

<title>Accueil</title>
</head>
<body class="container text-center bg-body-tertiary">

<header>
	<div class="row mb-5">
	<div class="col-4 text-start"><a href="ServletAccueil"><img src="Images/LOGOINSANE_FINAL_VERSION.png" width="33%" /></a></div>
		<c:choose>
			<c:when test="${!empty sessionUtilisateur }">
				<div class="col-6 offset-2 mt-5">
					<ul class="nav">
						<li class="nav-item">
							<a class="nav-link disabled">Bonjour ${sessionScope.sessionUtilisateur.pseudo}</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="ServletArticle">Vendre un article</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="ServletProfil">Mon profil</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="ServletDeconnexion">Déconnexion</a>
						</li>
					</ul>
				</div>	
			</c:when>
			<c:otherwise>
				<div class="col-4 offset-4 mt-5">
						<ul class="nav text-end">
							<li class="nav-item">
								<a class="nav-link" href="ServletConnexion">Se connecter</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="ServletInscription">S'inscire</a>
							</li>
						</ul>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</header>

	<div class="row">
		<h3>Liste des enchères</h3>
		<br>
		<br>		
		<h5 class="text-start">Filtres</h5>
		<br>
		<form>
			<div class="row text-align-center">
				<div class="input-group">
				  <span class="input-group-text" id="searchIcon">🔍</span>
				  <input type="text" class="form-control" placeholder="Recherche" aria-describedby="searchIcon">
				  
					<span class="input-group-text" id="searchIcon">Catégorie</span>
					<select class="form-select" id="categorie" name="categorie">
						<option selected>Toutes</option>
						<option value="informatique">Informatique</option>
						<option value="ameublement">Ameublement</option>
						<option value="vetement">Vêtement</option>
						<option value="sportLoisirs">Sport&Loisirs</option>
					</select>			
				</div>
				<br>
				<br>
				<div></div>
				<br>
			<div class="col-12"><input class="btn btn-primary" type="submit" value="Rechercher"></div>
			</div>
		</form>
	</div>

	<br>
	<br>
	<br>
	
	<div class="row row-cols-1 row-cols-4 g-4">
		<c:choose>
			<c:when test="${empty sessionUtilisateur }">
				<c:forEach items="${ListeArticle }" var="Article">
				
				  <div class="col">
				    <div class="card h-100 bg-warning-subtle">
				      <img src="https://cdn.pixabay.com/photo/2014/04/03/10/45/hammer-311343_1280.png" class="card-img-top" alt="ENCHERE">
				      <div class="card-body">
				        <h4 class="card-title">${Article.getNomArticle() }</h4>
				        <br>
						<p>Prix : ${Article.getPrixVente() }</p>
						<p>Date de fin d'enchère : ${Article.getDateFinEncheres() }</p>
						<p>Vendeur : ${Article.getPossesseurArticle().getPseudo() }</p>
				      </div>
				    </div>
				  </div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<c:forEach items="${ListeArticle }" var="Article">
				  <div class="col">
				    <div class="card h-100 bg-warning-subtle">
				      <img src="https://cdn.pixabay.com/photo/2014/04/03/10/45/hammer-311343_1280.png" class="card-img-top" alt="ENCHERE">
				      <div class="card-body">
				      	<c:choose>
				      		<c:when test="${Article.getPossesseurArticle().getIdUtilisateur() == sessionUtilisateur.idUtilisateur }">
				        		<h4 class="card-title"><a href="ServletModifArticle?idArticleModif=${Article.getIdArticle() }" class="stretched-link link-body-emphasis" style="position: relative;">${Article.getNomArticle() }</a></h4>
				        	</c:when>
				        	<c:otherwise>
				        		<h4 class="card-title"><a href="ServletDetailVente?idArticleVendu=${Article.getIdArticle() }" class="stretched-link link-body-emphasis" style="position: relative;">${Article.getNomArticle() }</a></h4>
				        	</c:otherwise>
				        </c:choose>
				        <br>
						<p>Prix : ${Article.getPrixVente() }</p>
						<p>Date de fin d'enchère : ${Article.getDateFinEncheres() }</p>
						<p>Vendeur : <a class="link-body-emphasis" href="ServletProfil?pseudoUtilisateur=${Article.getPossesseurArticle().getPseudo() }" >${Article.getPossesseurArticle().getPseudo() }</a></p>
				      </div>
				    </div>
				  </div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>

</body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>	
</html>