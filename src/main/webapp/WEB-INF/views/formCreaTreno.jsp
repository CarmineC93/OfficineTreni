<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	 <label for="compagnia">compagnia treno:</label><br>
	<input type="text" id="compagnia" name="compagnia" value="${treno.compagnia}"><br>
	<p>${errori.getFieldError('compagnia').defaultMessage}</p>    
  <label for="sigla">sigla treno:</label><br>
  <input type="text" id="sigla" name="sigla" value="${treno.sigla}"><br>
  <p>${errori.getFieldError('sigla').defaultMessage}</p>    
  <input type="submit" value="Submit">
	</form> 

</body>
</html>