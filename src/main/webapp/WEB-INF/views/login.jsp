<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

    <title>Login</title>
    <!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
  
    
</head>
<body class="text-light bg-dark" >

	<div class="container">    
	
			<div class="py-2" >
	   			<img class="py-2" src="${pageContext.request.contextPath}/resources/logoscritta.png" alt="Logo" style="max-width:150px; display:block;">
	
		    	
		    	 <h3 class="py-2" style="display:inline">Login</h3>     
		    	 <span  class="px-5">Non hai ancora un account? <a href="${pageContext.request.contextPath}/registrazione" style="color:green; text-decoration:none;">Registrati</a></span>
	
		    </div>
	
		    <div class="row  pr-4" style="max-width:500px;">
				<h5 class="text-danger">${errore}</h5>
			    
			    
			    <form class="form-group" action="login" method="post">
			        <div class="col">
			           <label class="form-label" for="username">Username:</label>
			           <input class="form-control" type="text" id="username" name="username" required><br>
					</div>
			
				    <div class="col">
				        <label  class="form-label" for="password">Password:</label>
				        <input class="form-control" type="password" id="password" name="password" required><br>
			    	</div>
			
			        <button type="submit" class="btn btn-primary">Accedi</button>
			    </form>
			</div>
	
	</div>

</body>
</html>