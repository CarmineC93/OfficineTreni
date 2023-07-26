<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>${errore}</h1>
	
	<form action="crea" method="post">
	 <label for="nome">nome treno:</label><br>
	<input type="text" id="nome" name="nome" value="${treno.nome}"><br>
	<p>${errori.getFieldError('nome').defaultMessage}</p>    
	<label for="compagnia">compagnia treno:</label>

<select name="compagnia" id="compagnia">
  <option value="Italo">italo</option>
  <option value="Trenitalia">trenitalia</option>
</select>
	<p>${errori.getFieldError('compagnia').defaultMessage}</p>  
	
	  
  <label for="sigla">sigla treno:</label><br>
  <input type="text" id="sigla" name="sigla" value="${treno.sigla}"><br>
  <p>${errori.getFieldError('sigla').defaultMessage}</p>   
  
  
   <c:forEach var="vagone" items="${listaVagoni}">
           <input type="checkbox" id="${categoria.id }" name="vagone" value="${vagone.id}">
			<label for="${categoria.id}"> ${vagone.tipologia }/${vagone.compagnia}</label><br>
        </c:forEach>
  
  
  
   
  <input type="submit" value="Submit">
  
	</form> 

</body>
</html>