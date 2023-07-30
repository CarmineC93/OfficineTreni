<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crea un nuovo vagone</title>

	<!--per anteprima immagine-->
	<style>
	    #imgPreview {
	        max-width: 300px;
	        display: none;
	    }
	</style>

</head>
<body>

<!-- Inclusione della dashboard sopra la pagina -->
<jsp:include page="../dashboard.jsp" />
	
<h1>Crea un nuovo vagone</h1>
  
  <form:form action="salvaVagone" method="post" modelAttribute="vagone" enctype="multipart/form-data">
    <!-- Campi del form -->
    <label for="peso">Peso:</label>
    <form:input path="peso" type="number" step="0.10" required="true" /><br>

    <label for="lunghezza">Lunghezza:</label>
    <form:input path="lunghezza" type="number" step="0.10" required="true" /><br>

    <label>Tipologia:</label>
    <form:radiobutton path="tipologia" value="H" />H
    <form:radiobutton path="tipologia" value="P" />P
    <form:radiobutton path="tipologia"  value="R" />R
    <form:radiobutton path="tipologia"  value="C" />C<br>
 
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
	 <input type="file" name="img" accept="image/*"  onchange="showPreviewImage(this)"><br>

 	<!-- Anteprima dell'immagine -->
     <img id="imgPreview" src="data:image/png;base64,${vagone.base64Image}" style="max-width: 300px;">
     

    <input type="submit" value="Salva">

 
</form:form>

		<a class="btn btn-light" href="javascript:history.back()">Torna Indietro</a>

 
</body>

 <!--per anteprima immagine--> 
<script>
function showPreviewImage(inputElement) {
    var imgPreviewElement = document.getElementById('imgPreview');
    if (inputElement.files && inputElement.files[0]) {
        var reader = new FileReader();

        reader.onload = function(e) {
            imgPreviewElement.src = e.target.result;
            imgPreviewElement.style.display = 'block';
        };

        reader.readAsDataURL(inputElement.files[0]);
    } else {
        imgPreviewElement.src = '#';
        imgPreviewElement.style.display = 'none';
    }
}
</script>

</html>