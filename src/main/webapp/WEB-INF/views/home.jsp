<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Welcome to Home</h1>
 
	
	<div>
	<p>Benvenuto: ${utente.nome}</p>
		<c:forEach items="${utente.ruolo}" var="ruolo">
			<span>${ruolo.nome}</span>
		</c:forEach>
	</div>  
	
	
	<a href="" >sezione per tutti</a>
	<div>
		<a href="${pageContext.request.contextPath}/admin" >sezione esclusiva per admin</a>
	</div>
	
	
	<h2>Numero visitatori connessi: ${contatore}</h2>
	
	

<a href="${pageContext.request.contextPath}/logout">Logout</a>


</body>
</html>
