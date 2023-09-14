<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<body class="container text-center bg-body-tertiary">

<header>
		<br>
		<div class="row">
			<div class="col-12 text-align-center"><a href="ServletAccueil"><img src="Images/LOGOINSANE_FINAL_VERSION.png" width="20%" /></a></div>
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
				<li>${LecteurMessage.getMessagesErreur(code) }</li>
			</c:forEach>
		</ul>
	</c:if>
	
	
	<form method="POST" action="ServletInscription" class="row g-3">
	
            <div class="row justify-content-center">
	            <div class="col-3">      
	           		<label for="pseudo" class="form-label">Pseudo : </label>
	           		<input type="text" id="pseudo" name="pseudo" class="form-control">
	            </div>
	            <div class="col-3">
					<label for="nom" class="form-label">Nom : </label>
	           		<input type="text" id="nom" name="nom" class="form-control" required>
	            </div>
            </div>
            
            
             <div class="row justify-content-center">
	            <div class="col-3">
	            	<label for="prenom" class="form-label">Prenom : </label>
	            	<input type="text" id="prenom" name="prenom" class="form-control" required>
	           	</div>
	           	<div class="col-3">
		            <label for="email" class="form-label">Email : </label>
		            <input type="email" id="email" name="email" class="form-control" required>
	            </div>
            </div>
            
			<div class="row justify-content-center">         
	           	<div class="col-3">
	            	<label for="telephone" class="form-label">Téléphone : </label>
	            	<input type="text" id="telephone" name="telephone"  class="form-control" required>
				</div>
				<div class="col-3">	
					<label for="rue" class="form-label">Rue : </label>
	            	<input type="text" id="rue" name="rue" class="form-control" required>
	            </div>
            </div>
    
    		<div class="row justify-content-center">
	            <div class="col-3">
	            	<label for="codePostal" class="form-label">Code Postal : </label>
	            	<input type="text" id="codePostal" name="codePostal" class="form-control" required>
	            </div>
	            <div class="col-3">
	            	<label for="ville" class="form-label">Ville : </label>
	            	<input type="text" id="ville" name="ville" class="form-control" required>
		  		</div>
	  		</div>
	  		
			<div class="row justify-content-center">
	  			<div class="col-3">
	            	<label for="motdepasse" class="form-label">Mot de passe : </label>
	            	<input type="password" id="motdepasse" name="motdepasse" class="form-control" required>
	            </div>
	            <div class="col-3">	
	            	<label for="confirmmotdepasse" class="form-label">Confirmation : </label>
	            	<input type="password" id="confirmmotdepasse" name="confirmmotdepasse" class="form-control" required>
	            </div>
            </div>
>
              <div class="col-12">
   				 <input type="submit" value="S inscrire" class="btn btn-success">
 			 </div>
            
            <a class="link-body-emphasis" href="ServletConnexion">Annuler</a>
            
      </form>
   </div>
   
   
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>
</html>