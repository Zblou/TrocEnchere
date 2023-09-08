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
<body class="container text-center">

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
	<div>
		<p>Pseudo : ${sessionScope.sessionUtilisateur.pseudo}</p>
		<p>Nom : ${sessionScope.sessionUtilisateur.nom}</p>
		<p>Prénom : ${sessionScope.sessionUtilisateur.prenom}</p>
		<p>Email : ${sessionScope.sessionUtilisateur.email}</p>
		<p>Téléphone : ${sessionScope.sessionUtilisateur.telephone}</p>
		<p>Rue : ${sessionScope.sessionUtilisateur.rue}</p>
		<p>Code postal : ${sessionScope.sessionUtilisateur.codePostal}</p>
		<p>Ville : ${sessionScope.sessionUtilisateur.ville}</p>
		<a href="">Modifier</a>
	</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>	

</html>