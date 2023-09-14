<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profil</title>
</head>
<body class="container text-center bg-body-tertiary">

	<header>
		<br>
		<div class="row">
			<div class="col-4">
				<a href="ServletAccueil">ENI-Enchères</a>
			</div>
		</div>
		<br> <br> <br>
	</header>
	<h1>Profil</h1>
	<c:choose>
		<c:when test="${!empty profilVendeur}">
		<div class="justify-content-center">
			<div class="card">
				<div class="card-header">
    				<h5 class="card-title">${profilVendeur.nom} ${profilVendeur.prenom}</h5>
  				</div>
  				<div class="card-body">
  					<div class="row justify-content-center">
  						<div class="col-3">
  							<p class="text-end">Pseudo :</p>
  						</div>
  						 <div class="col-3">
  						 	<p class="text-start">${profilVendeur.pseudo}</p>
  						</div>
  					</div>
  					<div class="row justify-content-center">
  						<div class="col-3">
  							<p class="text-end">Email :</p>
  						</div>
  						 <div class="col-4">
  						 	<p class="text-start">${requestScope.profilVendeur.email}</p>
  						</div>
  					</div>
  					<div class="row justify-content-center">
  						<div class="col-3">
  							<p class="text-end">Téléphone :</p>
  						</div>
  						 <div class="col-3">
  						 	<p class="text-start">${profilVendeur.telephone}</p>
  						</div>
  					</div>  
  					<div class="row justify-content-center">
  						<div class="col-3">
  							<p class="text-end">Rue :</p>
  						</div>
  						 <div class="col-3">
  						 	<p class="text-start">${profilVendeur.rue}</p>
  						</div>
  					</div> 					
  					<div class="row justify-content-center">
  						<div class="col-3">
  							<p class="text-end">Code postal :</p>
  						</div>
  						 <div class="col-3">
  						 	<p class="text-start">${profilVendeur.codePostal}</p>
  						</div>
  					</div>
  					<div class="row justify-content-center">
  						<div class="col-3">
  							<p class="text-end">Ville :</p>
  						</div>
  						 <div class="col-3">
  						 	<p class="text-start">${profilVendeur.ville}</p>
  						</div>
  					</div>
  				</div>
			</div>
		</div>
		</c:when>
		<c:otherwise>
		<div class="container text-center">
			<div class="card">
				<div class="card-header">
    				<h5 class="card-title">${sessionScope.sessionUtilisateur.nom} ${sessionScope.sessionUtilisateur.prenom}</h5>
  				</div>
  				<div class="card-body">
  					<div class="row justify-content-center">
  						<div class="col-3">
  							<p class="text-end">Pseudo :</p>
  						</div>
  						 <div class="col-3">
  						 	<p class="text-start">${sessionScope.sessionUtilisateur.pseudo}</p>
  						</div>
  					</div>
  					<div class="row justify-content-center">
  						<div class="col-3">
  							<p class="text-end">Email :</p>
  						</div>
  						 <div class="col-3">
  						 	<p class="text-start">${sessionScope.sessionUtilisateur.email}</p>
  						</div>
  					</div>
  					<div class="row justify-content-center">
  						<div class="col-3">
  							<p class="text-end">Téléphone :</p>
  						</div>
  						 <div class="col-3">
  						 	<p class="text-start">${sessionScope.sessionUtilisateur.telephone}</p>
  						</div>
  					</div>  
  					<div class="row justify-content-center">
  						<div class="col-3">
  							<p class="text-end">Rue :</p>
  						</div>
  						 <div class="col-3">
  						 	<p class="text-start">${sessionScope.sessionUtilisateur.rue}</p>
  						</div>
  					</div> 					
  					<div class="row justify-content-center">
  						<div class="col-3">
  							<p class="text-end">Code postal :</p>
  						</div>
  						 <div class="col-3">
  						 	<p class="text-start">${sessionScope.sessionUtilisateur.codePostal}</p>
  						</div>
  					</div>
  					<div class="row justify-content-center">
  						<div class="col-3">
  							<p class="text-end">Ville :</p>
  						</div>
  						 <div class="col-3">
  						 	<p class="text-start">${sessionScope.sessionUtilisateur.ville}</p>
  						</div>
  					</div>
  					<div class="row">
  						<a href="ServletModifutilisateur">Modifier</a>
  					</div>
  				</div>
  			</div>
  		</div>
		</c:otherwise>
	</c:choose>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>	

</html>