<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
<h1>Crea Vagone</h1>
  
  <form:form action="salvaVagone" method="post" modelAttribute="vagone" enctype="multipart/form-data">
    <!-- Campi del form -->
    <label for="peso">Peso:</label>
    <form:input path="peso" type="number" step="0.01" required="true" /><br>

    <label for="lunghezza">Lunghezza:</label>
    <form:input path="lunghezza" type="number" step="0.01" required="true" /><br>

    <label>Tipologia:</label>
    <form:radiobutton path="tipologia" value="H" />H
    <form:radiobutton path="tipologia" value="P" />P
    <form:radiobutton path="tipologia"  value="R" />R
    <form:radiobutton path="tipologia"  value="C" />C<br>

    <label for="colore">Colore:</label>
    <form:input path="colore" /><br>

    <label>Compagnia:</label>
    <form:radiobutton path="compagnia"   value="Trenitalia" />Trenitalia
    <form:radiobutton path="compagnia"   value="Italo" />Italo<br>

    <label for="costo">Costo:</label>
    <form:input path="costo" type="number" /><br>

    <label for="capienza">Capienza:</label>
    <form:input path="capienza" type="number" /><br>

    <label for="pesoTrainante">Peso Trainante:</label>
    <form:input path="pesoTrainante" type="number" /><br>

	 <label for="img">Foto:</label>
	 <input type="file" name="img" accept="image/*"><br>

    <input type="submit" value="Salva">
</form:form>


  
<!--  
	<form action="salvaVagone" method="post" enctype="multipart/form-data">
	    
	    <label for="peso">Peso:</label>
		<input type="number" name="peso" value="${vagone.peso}">
	
	    <label for="lunghezza">Lunghezza:</label>
	    <input type="number" step="1" name="lunghezza" value="${vagone.lunghezza}"   ><br>
	
		<label>Tipologia:</label>
		<input type="radio" value="H" name="tipologia" >H
		<input type="radio" value="P" name="tipologia" >P
		<input type="radio" value="R" name="tipologia" >R
		<input type="radio" value="C" name="tipologia" >C
			<br>
		
		<label>Compagnia:</label>
		<input type="radio" name="compagnia" value="Trenitalia" >Trenitalia
		<input type="radio" name="compagnia" value="Italo" >Italo<br>
	
	    <label for="costo">Costo:</label>
	     <input  type="number" name="costo" value="${vagone.costo}" ><br>
	
	    <label for="capienza">Capienza:</label>
	    <input type="number" name="capienza" value="${vagone.capienza}" ><br>
	
	    <label for="pesoTrainante">Peso Trainante:</label>
	    <input  type="number" name="pesoTrainante" value="${vagone.pesoTrainante}" ><br>
	    
	    <label for="img">Foto:</label>
	    <input type="file" name="img" accept="image/*"><br>
	
	    <input type="submit" value="Salva">
	</form>
-->
</body>
</html>