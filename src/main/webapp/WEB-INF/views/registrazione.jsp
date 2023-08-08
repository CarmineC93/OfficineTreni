<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrazione</title>
    
    <!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    
</head>
<body class="text-light bg-dark" >

<div class="container">

		<div class="py-2">
   			<img class="py-2" src="${pageContext.request.contextPath}/resources/logoscritta.png" alt="Logo" style="max-width:150px; display:block;">

	    	
	    	 <h3 class="py-2" style="display:inline">Registrazione</h3>     
	    	 <span  class="px-5">Hai già un account? <a href="${pageContext.request.contextPath}/login" style="color:green;  text-decoration:none;">Accedi</a></span>
	    	
  
	    </div>
 
	    <div class="row  pr-4" style="max-width:500px;">
	
		    <form class="form-group" action="registrazione" method="post" >
		
		  <div class="col">
		
				<label for="nome" class="form-label">Nome:</label>
		        <input  type="text" id="nome" name="nome" class="form-control" required value="${utente.nome}"><br>
		    	<p class="text-danger">${errori.getFieldError('nome').defaultMessage}</p> 
		  </div>
		    	   
		  <div class="col">
		
		        <label for="cognome" class="form-label">Cognome:</label>
		        <input type="text" id="cognome" name="cognome" class="form-control" required value="${utente.cognome}"><br>
		        <p class="text-danger">${errori.getFieldError('cognome').defaultMessage}</p>
		  </div>
		        
		  <div class="col">
		
		        <label for="email" class="form-label">Email:</label>
		        <input type="email" id="email" name="email"class="form-control"  required value="${utente.email}"><br>
		        <p class="text-danger">${errori.getFieldError('email').defaultMessage}</p>
		  </div>
		        
		  <div class="col">
		
		        <label for="password" class="form-label">Password:</label>
		        <input type="password" id="password" class="form-control" name="password" required><br>
		        <p class="text-danger">${errori.getFieldError('password').defaultMessage}</p>
		  </div>
		
		
				<!--  <input type="text" value="user" name="ruolo"> -->
					
				
		        <button type="submit" class="btn btn-primary">Registrati</button>
		    </form>
	    </div>
    
    </div>
</body>
</html>