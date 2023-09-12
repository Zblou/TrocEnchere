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
	<form method="POST" action="ServletModifutilisateur">
             
             
             <div>
             	<input type="text" name="id_utilisateur" id="id_utilisateur" value="${sessionScope.sessionUtilisateur.idUtilisateur }">
             </div> 
                    
            <label for="pseudo">Pseudo : </label>
            <input type="text" id="pseudo" name="pseudo" value="${sessionScope.sessionUtilisateur.pseudo}" required>
            
            
			<label for="nom">Nom : </label>
            <input type="text" id="nom" name="nom" value="${sessionScope.sessionUtilisateur.nom}" required>
            <br>
            <br>
            <label for="prenom">Prenom : </label>
            <input type="text" id="prenom" name="prenom" value ="${sessionScope.sessionUtilisateur.prenom}" required>
           
           
            <label for="email">Email : </label>
            <input type="email" id="email" name="email" value ="${sessionScope.sessionUtilisateur.email}" required>
            <br>
            <br>
           
            <label for="telephone">Téléphone : </label>
            <input type="text" id="telephone" name="telephone" value ="${sessionScope.sessionUtilisateur.telephone}" required>
				
			<label for="rue">Rue : </label>
            <input type="text" id="rue" name="rue" value ="${sessionScope.sessionUtilisateur.rue}" required>
            <br>
            <br>
            <label for="codePostal">Code Postal : </label>
            <input type="text" id="codePostal" name="codePostal" value ="${sessionScope.sessionUtilisateur.codePostal}" required>
            
            <label for="ville">Ville : </label>
            <input type="text" id="ville" name="ville" value ="${sessionScope.sessionUtilisateur.ville}" required>
	  		<br>
            <br>
  
            <label for="motdepasse">Mot de passe : </label>
            <input type="password" id="motdepasse" name="motdepasse" value ="${sessionScope.sessionUtilisateur.motDePasse}" required>
            
            <label for="confirmmotdepasse">Confirmation : </label>
            <input type="password" id="confirmationmdp" name="confirmationmdp" value ="" required>
            
            <p> Crédit : ${sessionScope.sessionUtilisateur.credit} </p>
            <br>
            <br>
            <input type="submit" value="Enregistrer">
            
            <a href="">Supprimer mon compte</a>
            
      </form>
   </div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>	

</html>