<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body class="text-light bg-dark pt-5" >

<!-- Inclusione della dashboard sopra la pagina -->
<jsp:include page="dashboard.jsp" />


<div class="container">

	 <div class="py-2">
   		<img class="py-2" src="${pageContext.request.contextPath}/resources/logoscritta.png" alt="Logo" style="max-width:150px; display:block;">
	    <h1 class="py-2" style="display:inline">Welcome Home</h1>     	    	
	 </div>
	
 	
	<div>
	<p>Benvenuto ${utente.nome}, costruiamo qualche treno!</p>
	</div>
		

	
	<!-- <footer class="py-4" style="position: fixed; bottom: 0; width: 100%;">
	<div >
		<h6>Numero visitatori connessi: ${contatore}</h6>
	</div>
	</footer>	
	  -->

</div>


</body>
</html>
