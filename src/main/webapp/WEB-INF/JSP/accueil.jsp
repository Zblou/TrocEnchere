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
<body class="container text-center">
<header>
	
	<div class="row mb-5">
	<div class="col-4 text-start"><a href="ServletAccueil">ENI-Enchères</a></div>
		<c:choose>
			<c:when test="${!empty sessionUtilisateur }">
				<div class="col-6 offset-2">
					<ul class="nav">
						<li class="nav-item">
							<a class="nav-link">Bonjour ${sessionScope.sessionUtilisateur.pseudo}</a>
						</li>
						<li class="nav-item">
							<a class="nav-link">Enchères</a>
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
				<div class="col-4 offset-4">
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
	<div class="row p-4">
		<h3>Liste des enchères</h3>
		
		<h5 class="text-start">Filtres</h5>
		<form>
			<div class="row">
				<div class="col-2">
					<input type="text" name="rechercheFiltre" id="rechercheFiltre">
				</div>
				<div class="col-2">
				<br>
					<label for="categorie" class="text-start">Catégorie :</label>
					<select class="form-select" id="categorie">
				<option selected>Toutes</option>
				<option value="informatique">Informatique</option>
				<option value="ameublement">Ameublement</option>
				<option value="vetement">Vêtement</option>
				<option value="sportLoisirs">Sport&Loisirs</option>
			</select>
				</div>
			
			
			<input type="submit" value="Rechercher">
			</div>
		</form>
	</div>

	
	
	
		
</body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>	
</html>