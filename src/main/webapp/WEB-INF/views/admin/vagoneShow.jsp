<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettagli del vagone</title>

<!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    

</head>
<body class="text-light bg-dark ">

<!-- Inclusione della dashboard sopra la pagina -->
<jsp:include page="../dashboard.jsp" />

<div class= container style="padding-top:5rem;"> 

	<div class="d-flex py-2 justify-content-between align-items-center">
   		<img class="py-2" src="${pageContext.request.contextPath}/resources/logoscritta.png" alt="Logo" style="max-width:150px; display:block;">
	    <h1 class="py-2" style="display:inline">Dettagli del vagone</h1>    
	    <div class="py-5">
			<a class="btn btn-warning" href="javascript:history.back()">Torna Indietro</a>
		</div> 	    	
 	</div>

	<div class="d-flex row row-cols-2 g-3 justify-content-center">
			<div class="col">
				<div class="card" style="min-height:400px; ">   
					<div style="display: flex; justify-content: center; align-items: center;  min-height:120px;">
							
		                <c:choose> 
		                   <c:when test="${empty vagone.base64Image}">
		        
		                        <img src="${pageContext.request.contextPath}/resources/vagone_default.png" style="width:80%;" alt="Immagine vagone di default">
		                   </c:when>
		                    <c:otherwise>
		                	    <img src="data:image/png;base64,${vagone.base64Image}"  style="width:100%;" alt="Immagine vagone">
		                    </c:otherwise>
		                </c:choose>
		               </div>
					   <div class="card-body">
					      <h5 class="card-title" style="text-align:center;">Tipologia: ${tipologiaMap[vagone.tipologia]} ( ${vagone.tipologia} )</h5>
			 
						  <ul class="list-group list-group-flush">
						    <li class="list-group-item">Compagnia: ${vagone.compagnia}</li>
						    <li class="list-group-item">Costo: ${vagone.getFormattedCosto()}</li>
						    <li class="list-group-item">Lunghezza: ${vagone.getFormattedLunghezza()}</li>
						    <li class="list-group-item">Peso: ${vagone.getFormattedPeso()}</li>
						    <li class="list-group-item">Capacità: 
						    	<c:choose>
										<c:when
											test="${tipologiaMap[vagone.tipologia] eq 'Passeggeri'}">
					                        ${vagone.capienza} passeggeri
					                    </c:when>
										<c:when
											test="${tipologiaMap[vagone.tipologia] eq 'Ristorante'}">
					                        ${vavagoneg.capienza} clienti
					                    </c:when>
										<c:when test="${tipologiaMap[vagone.tipologia] eq 'Locomotiva'}">
					                        ${vagone.capienza} conducenti
					                    </c:when>
										<c:when
											test="${tipologiaMap[vagone.tipologia] eq 'Cargo'}">
					                        ${vagone.capienza} litri
					                    </c:when>
								</c:choose>
						    </li>
						    <li class="list-group-item">Forza Motrice: 
							    <c:choose>
							        <c:when test="${tipologiaMap[vagone.tipologia] eq 'Locomotiva'}">
							            ${vagone.getFormattedPeso()}
							        </c:when>
							        <c:otherwise>
							            N/A
							        </c:otherwise>
							    </c:choose>
						    </li>
						  </ul>
					  </div>	
				</div>    	
			</div>        
	</div>	

</div>




</body>
</html>