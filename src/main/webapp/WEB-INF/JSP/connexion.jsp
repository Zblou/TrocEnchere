<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<title>Connexion</title>
</head>
<body class="container text-center">

<header>
	<br>
	<div class="row">
		<div class="col-4"><a href="Acceuil">ENI-Enchères</a></div>
	</div>
	<br>
	<br>
	<br>
</header>	

	<h3>Authentification</h3>
	<br>
	<br>
	<br>
	<div class="row">
		<form method="POST" action="" class="row">
			<div class="row justify-content-center">
				<div class="col-2">
					<label for="identifiant" class="form-label">Identifiant</label>
				</div>
				<div class="col-2">
				<input type="text" name="identifiant" id="identifiant" class="form-control">
				</div>
			</div>
			<br>
			<br>
			<div class="row justify-content-center">
				<div class="col-2">
					<label for="mdp" class="form-label">Mot de passe</label>
				</div>
				<div class="col-2">
					<input type="password" name="mdp" id="mdp" class="form-control">
				</div>
			</div>
			<br>
			<br>
			<div class="row justify-content-center">
				<div class="col-2">
					<input type="submit" value="Connexion" class="btn btn-success">
				</div>
				<div class="col-2 text-start">
					<input type="checkbox" id="se_souvenir" name="se_souvenir">
					<label for="se_souvenir">Se souvenir de moi</label>
					<br>
					<a href="">Mot de passe oublié</a>
				</div>
			</div>
			<br>
			<br>
			<br>
		</form>
	</div>
		<a href="" class="btn btn-primary">Créer un compte</a>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</html>