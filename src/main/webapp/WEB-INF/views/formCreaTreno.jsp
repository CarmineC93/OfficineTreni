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
	           <input type="checkbox" id="${vagone.id }" name="selezioneVagone" value="${vagone.id}" onclick="updateSiglaField()" >
				<label for="${vagone.id}"> ${vagone.tipologia}</label><br>
	        </c:forEach>



   
	  <input type="submit" value="Submit">
  
	</form> 

<script>
// Create an array to store the selected values in the order they are clicked
const selectedValues = [];

function updateSiglaField() {
    // Get all the checkboxes with name "selezioneVagone"
    const checkboxes = document.getElementsByName("selezioneVagone");

    // Clear the selectedValues array before updating the selected values
    selectedValues.length = 0;

    // Loop through the checkboxes to check if they are selected
    for (let i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            // Get the value of "${vagone.tipologia}" associated with the selected checkbox
            const value = checkboxes[i].nextElementSibling.textContent.trim();
            // Add the value to the selectedValues array
            selectedValues.push(value);
        }
    }

    // Update the value of the "sigla" input field with the selected values in the desired insertion order
    const composedString = selectedValues.join('\n');
    document.getElementById("sigla").value = composedString;
}

// Add an event listener to the checkboxes to call the updateSiglaField function on click
document.addEventListener("DOMContentLoaded", function () {
    const checkboxes = document.getElementsByName("selezioneVagone");
    checkboxes.forEach(checkbox => {
        checkbox.addEventListener("click", updateSiglaField);
    });
});
</script>





</body>
</html>