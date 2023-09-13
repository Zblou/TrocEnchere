<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<title>Vuiller you inscrire </title>
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
 <div>
 
 	 <c:if test="${!empty confirmationMdpInvalide }">
		<p style="color: red">${confirmationMdpInvalide} </p>
	</c:if>
 	<c:if test="${!empty listeCodesErreur }">
		<p style="color:red">Erreur lors de l'inscription</p>
		<ul>
			<c:forEach items="${listeCodesErreur }" var="code">
			<li>${listeCodesErreur.getMessageErreur(code) }</li>
			</c:forEach>
		</ul>
	</c:if>
	<form method="POST" action="ServletInscription">
                     
            <label for="pseudo">Pseudo : </label>
            <input type="text" id="pseudo" name="pseudo" required>
            
            
			<label for="nom">Nom : </label>
            <input type="text" id="nom" name="nom" required>
            <br>
            <br>
            <label for="prenom">Prenom : </label>
            <input type="text" id="prenom" name="prenom" required>
           
           
            <label for="email">Email : </label>
            <input type="email" id="email" name="email" required>
            <br>
            <br>
           
            <label for="telephone">Téléphone : </label>
            <input type="text" id="telephone" name="telephone"  required>
				
			<label for="rue">Rue : </label>
            <input type="text" id="rue" name="rue" required>
            <br>
            <br>
            <label for="codePostal">Code Postal : </label>
            <input type="text" id="codePostal" name="codePostal"  required>
            
            <label for="ville">Ville : </label>
            <input type="text" id="ville" name="ville" required>
	  		<br>
            <br>
  
            <label for="motdepasse">Mot de passe : </label>
            <input type="password" id="motdepasse" name="motdepasse" required>
            
            <label for="confirmmotdepasse">Confirmation : </label>
            <input type="password" id="confirmmotdepasse" name="confirmmotdepasse" required>
            
             <br>
            <br>
            <input type="submit" value="Créer">
            
            <a href="ServletConnexion">Annuler</a>
            
      </form>
   </div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>
</html>