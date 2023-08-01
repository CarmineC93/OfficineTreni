<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica un vagone</title>
</head>
<body>

<body class="text-light bg-dark ">

<!-- Inclusione della dashboard sopra la pagina -->
<jsp:include page="../dashboard.jsp" />
	
	<div class="containe px-4" style="padding:5rem 0 0 3rem">
	 
		 <div class="d-flex justify-content-center align-items-center">
		 	    <h1 class="p-2" style="display:inline">Modifica vagone</h1>  
		 	    <img class="py-2" style="display:inline; max-width:60px;" src="${pageContext.request.contextPath}/resources/logo.png" alt="Logo"> 	    	
		 </div>
  
        <!-- 	FONDAMENTALE questa action -->
  	<form:form action="${pageContext.request.contextPath}/admin/modificaVagone" method="post" modelAttribute="vagone" enctype="multipart/form-data" class="py-4" style="max-width:1000px">
  
		      <!-- 	FONDAMENTALE Aggiungi l'input nascosto per l'id del vagone -->
		    <form:hidden path="id" />

		    <!-- Campi del form -->
		<div class="d-flex row row-cols-3 row-cols-md-3 row-cols-sm-1">
	    
			<div class="col">
			    <label class="form-label" >Tipologia:</label>
			    <form:radiobutton path="tipologia" value="H" />H
			    <form:radiobutton path="tipologia" value="P" />P
			    <form:radiobutton path="tipologia"  value="R" />R
			    <form:radiobutton path="tipologia"  value="C" />C<br>
			 
			    <label  class="form-label"  for="peso">Peso (tonnellate):</label>
			    <form:input  class="form-control"   path="peso" type="number" step="0.01" required="true" /><br>
			
			    <label  class="form-label" for="lunghezza">Lunghezza (metri):</label>
			    <form:input class="form-control" path="lunghezza" type="number" step="0.01" required="true" /><br>
			
			    <label  class="form-label" for="costo">Costo (Euero i.i.):</label>
			    <form:input class="form-control"   path="costo" type="number" /><br>
			</div>
			<div class="col">
			    <label class="form-label" >Compagnia:</label>
			    <form:radiobutton path="compagnia"   value="Trenitalia" />Trenitalia
			    <form:radiobutton path="compagnia"   value="Italo" />Italo<br>
	
			    <label  class="form-label" for="capienza">Capienza:</label>
			    <form:input class="form-control"   path="capienza" type="number" /><br>
			
			    <label  class="form-label" for="pesoTrainante">Peso Trainante:</label>
			    <form:input  class="form-control"  path="pesoTrainante" type="number" /><br>
			
			    <!-- Mantieni il campo per l'immagine del vagone, se necessario -->
			    <label  class="form-label" for="img">Foto:</label>
			    <input class="form-control"   type="file" name="img" accept="image/*"  onchange="showPreviewImage(this)"><br>
			 </div>
			 <div class="col d-flex flex-column justify-content-end">
			        <!-- Anteprima dell'immagine -->
			    	<c:if test="${vagone.imgBytes != null}">
			        	<img id="imgPreview" src="data:image/png;base64,${vagone.base64Image}" style="max-width: 300px;">
			    	</c:if>
			</div>
		</div>
	  <input class="btn btn-success" type="submit" value="Salva Modifiche">
			 	    
	</form:form>
		
	<a class="btn btn-warning" href="javascript:history.back()">Torna Indietro</a> 

	 </div>

</body>

<!-- -->
<script>
function showPreviewImage(inputElement) {
  if (inputElement.files && inputElement.files[0]) {
    var reader = new FileReader();

    reader.onload = function(e) {
      var imgPreviewElement = document.getElementById('imgPreview');
      imgPreviewElement.src = e.target.result;
    };

    reader.readAsDataURL(inputElement.files[0]);
  }
}
</script>


</html>