<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ENI Enchére</title>
</head>
<body>
 <div>
	<form>
                     
            <label for="pseudo">Pseudo : </label>
            <input type="text" id="pseudo" name="pseudo" required><br><br>
            
            
			<label for="nom">Nom : </label>
            <input type="text" id="nom" name="nom" required><br><br>
            
            
            <label for="prenom">Prenom : </label>
            <input type="text" id="prenom" name="prenom" required><br><br>
           
           
           <label for="email">Email : </label>
            <input type="email" id="email" name="email" required><br><br>
           
           
            <label for="telephone">Téléphone : </label>
            <input type="text" id="telephone" name="telephone"  required pattern="[0-9]{15}"><br><br>
				
				
			<label for="rue">Rue : </label>
            <input type="text" id="rue" name="rue" required><br><br>
            
            <label for="codePostal">Code Postal : </label>
            <input type="text" id="codePostal" name="codePostal"  required pattern="[0-9]{5}"><br><br>

            
            <label for="ville">Ville : </label>
            <input type="text" id="ville" name="ville" required><br><br>
            
            
            <input type="button" value="Modifier">
            
      </form>
   </div>
</body>
</html>