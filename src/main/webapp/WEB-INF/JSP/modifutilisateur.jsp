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

		<c:if test="${!empty confirmationMdpInvalide }">
			<p style="color: red">${confirmationMdpInvalide}</p>
		</c:if>

		<div>
			<form method="POST" action="ServletModifutilisateur" class="row g-3">


				<div>
					<input type="hidden" name="id_utilisateur" id="id_utilisateur"
						value="${sessionScope.sessionUtilisateur.idUtilisateur }">
				</div>

				<div class="row justify-content-center">
					<div class="col-3">
						<label for="pseudo" class="form-label">Pseudo : </label> <input
							type="text" id="pseudo" name="pseudo" class="form-control"
							value="${sessionScope.sessionUtilisateur.pseudo}" required>
					</div>
					<div class="col-3">
						<label for="nom" class="form-label">Nom : </label> <input
							type="text" id="nom" name="nom" class="form-control"
							value="${sessionScope.sessionUtilisateur.nom}" required>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-3">
						<label for="prenom" class="form-label">Prenom : </label> <input
							type="text" id="prenom" name="prenom" class="form-control"
							value="${sessionScope.sessionUtilisateur.prenom}" required>
					</div>
					<div class="col-3">
						<label for="email" class="form-label">Email : </label> <input
							type="email" id="email" name="email" class="form-control"
							value="${sessionScope.sessionUtilisateur.email}" required>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-3">
						<label for="telephone" class="form-label">Téléphone : </label> <input
							type="text" id="telephone" name="telephone" class="form-control"
							value="${sessionScope.sessionUtilisateur.telephone}" required>
					</div>
					<div class="col-3">
						<label for="rue" class="form-label">Rue : </label> <input
							type="text" id="rue" class="form-control" name="rue"
							value="${sessionScope.sessionUtilisateur.rue}" required>
					</div>
				</div>
				<div class="row justify-content-center">
				<div class="col-3">
					<label for="codePostal" class="form-label">Code Postal : </label> 
					<input
						type="text" id="codePostal" name="codePostal" class="form-control"
						value="${sessionScope.sessionUtilisateur.codePostal}" required>
				</div>
					<div class="col-3">
					<label for="ville" class="form-label">Ville : </label> 
					<input type="text" id="ville" class="form-control"
						name="ville" value="${sessionScope.sessionUtilisateur.ville}"
						required>  
					</div>
				</div>	
				<div class="row justify-content-center">
					<div class="col-3">
						<label for="motdepasse" class="form-label">Mot de passe : </label> 
						<input type="password" id="motdepasse" name="motdepasse" class="form-control"
						value="${sessionScope.sessionUtilisateur.motDePasse}" required>
					</div>
					<div class="col-3">
						<label for="confirmmotdepasse" class="form-label">Confirmation : </label> 
						<input type="password" id="confirmationmdp" name="confirmationmdp" class="form-control"
						value="" required>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-3 mt-5">
						<input type="submit" value="Enregistrer" class="btn btn-success"> 
					</div>
				
					<div class="col-3 mt-5">
						<a class="btn btn-danger" href="ServletSuppresionUtilisateur?id_utilisateur=${sessionScope.sessionUtilisateur.idUtilisateur }">Supprimer mon compte</a>
					</div>
				</div>
			</form>
		</div>
	

	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>

</html>