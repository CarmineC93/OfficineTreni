<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>

<!-- bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<!-- Includi la libreria JavaScript di Bootstrap -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.min.js"></script>    
    
</head>
	<body>
	
		<nav class="navbar navbar-expand-lg bg-light " style="wight:100%; position: fixed; top:0; left:0; right:0; z-index:50;">
			<div class="container-fluid" >
				<img src="${pageContext.request.contextPath}/resources/logo.png" alt="Logo" style="max-width:50px;">
	      		<a class="navbar-brand" href="${pageContext.request.contextPath}/home">Home</a>
	      		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	        		<span class="navbar-toggler-icon"></span>
	    	 	</button>
	     	 	<div class="collapse navbar-collapse" id="navbarSupportedContent">
	        		<ul class="navbar-nav me-auto mb-2 mb-lg-0">
		          		<li class="nav-item">
		           			 <a class="nav-link" href="${pageContext.request.contextPath}/treno/index" >Treni</a>
		         		</li>
	
	        			<li class="nav-item">
	            			<a class="nav-link" href="${pageContext.request.contextPath}/treno/formCrea">Crea Treno</a>
	          			</li>
	          		
	          			<li class="nav-item">
	            			<a class="nav-link" href="${pageContext.request.contextPath}/chisiamo">Chi Siamo</a>
	          			</li>
	          			
	          			<li class="nav-item">
	            			<a class="nav-link" href="${pageContext.request.contextPath}/chisiamo">Ordini</a>
	          			</li>
		       	 	</ul>
		        
		        	<span class="px-4" style="color:green;" >Utente: ${utente.email}</span>
					<span class="px-4" style="color:green;" >Ruolo: ${utente.ruolo}</span>
	
	         		 <a class="btn btn-danger"  href="${pageContext.request.contextPath}/logout">Logout</a>
	        	</div>
	      	</div>
  		</nav>
	</body>
</html>