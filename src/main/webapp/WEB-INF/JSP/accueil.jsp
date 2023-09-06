<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<div class="col-4 offset-4"><p class="text-end"><a href="ServletConnexion">Se connecter</a> - <a href="">S'inscire</a></p></div>
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