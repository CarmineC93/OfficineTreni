
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ page contentType="text/html;charset=UTF-8" language="java" %>
     
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettaglio treno</title>
</head>
<body class="text-light bg-dark pt-5" >

<!-- Inclusione della dashboard sopra la pagina -->
<jsp:include page="dashboard.jsp" />


<div class="container">
	
	<div class="d-flex py-2 justify-content-between align-items-center">
   		<img class="py-2" src="${pageContext.request.contextPath}/resources/logoscritta.png" alt="Logo" style="max-width:150px; display:block;">
	    <h1 class="py-2" style="display:inline">Dettagli Treno</h1>    
	    <div class="py-5">
			<a class="btn btn-warning" href="javascript:history.back()">Torna Indietro</a>
		</div> 	    	
 	</div>
	 
	 <table class="table py-4">
		 		<tr>
	 	            <th class="text-center">Nome:</th>
		            <th class="text-center">Creato da:</th>
		            <th class="text-center">Composizione:</th>
		            <th class="text-center">Compagnia:</th>
		            <th class="text-center">Data di creazione:</th>
		           	<th class="text-center">Numero di vagoni:</th>
		           	<th class="text-center">Lunghezza:</th>
		           	<th class="text-center">Peso totale:</th>
		           	<th class="text-center">Prezzo totale:</th>
					<th class="text-center">Foto:</th>
		        </tr>
		        
 	            <tr>
	      <!--      <td class="text-center">${treno.idTreno}</td>-->
	                <td class="text-center">${treno.nome}</td>
	                <td class="text-center">${treno.utente.nome}</td>
	                <td class="text-center">${treno.sigla}</td>
		            <td class="text-center">${treno.compagnia}</td>
		            <td class="text-center">${treno.getFormattedDate()}</td>
		            <td class="text-center">${treno.numVagoni}</td>
		            <td class="text-center">${treno.getFormattedLunghezza()}</td>
		            <td class="text-center">${treno.getFormattedPesoTotale()}</td>
		            <td class="text-center">${treno.getFormattedPrezzoTotale()}</td>
		            
	            	<td class="text-center">
              			<c:forEach var="vagone" items="${treno.vagone}">
                    		<c:choose>
                        		<c:when test="${empty vagone.base64Image}">
                           			 <img src="${pageContext.request.contextPath}/resources/vagone_default.png"  height="20" alt="Immagine vagone di default">
                        		</c:when>
                        		<c:otherwise>
                          			  <img src="data:image/jpeg;base64,${vagone.base64Image}"  height="20" alt="Immagine vagone">
                        		</c:otherwise>
                    		</c:choose>
                		</c:forEach>
	            	</td>            
	            </tr>
 	    </table>

	<div>
		<h4>Dettaglio Vagoni</h4>
	</div>
	

	<div class="d-flex row row-cols-4 g-3">
		 <c:forEach var="vag" items="${vagoni}">
			<div class="col">
				<div class="card" style="min-height:400px; ">   
					<div style="display: flex; justify-content: center; align-items: center;  min-height:120px;">
							
		                <c:choose> 
		                   <c:when test="${empty vag.base64Image}">
		        
		                        <img src="${pageContext.request.contextPath}/resources/vagone_default.png" style="width:80%;" alt="Immagine vagone di default">
		                   </c:when>
		                    <c:otherwise>
		                	    <img src="data:image/png;base64,${vag.base64Image}"  style="width:100%;" alt="Immagine vagone">
		                    </c:otherwise>
		                </c:choose>
		               </div>
					   <div class="card-body">
					      <h5 class="card-title" style="text-align:center;">Tipologia: ${tipologiaMap[vag.tipologia]} ( ${vag.tipologia} )</h5>
			 
						  <ul class="list-group list-group-flush">
						    <li class="list-group-item">Compagnia: ${vag.compagnia}</li>
						    <li class="list-group-item">Costo: ${vag.getFormattedCosto()}</li>
						    <li class="list-group-item">Lunghezza: ${vag.getFormattedLunghezza()}</li>
						    <li class="list-group-item">Peso: ${vag.getFormattedPeso()}</li>
						    <li class="list-group-item">Capacità: 
						    	<c:choose>
										<c:when
											test="${tipologiaMap[vag.tipologia] eq 'Passeggeri'}">
					                        ${vag.capienza} passeggeri
					                    </c:when>
										<c:when
											test="${tipologiaMap[vag.tipologia] eq 'Ristorante'}">
					                        ${vag.capienza} clienti
					                    </c:when>
										<c:when test="${tipologiaMap[vag.tipologia] eq 'Locomotiva'}">
					                        ${vag.capienza} conducenti
					                    </c:when>
										<c:when
											test="${tipologiaMap[vag.tipologia] eq 'Cargo'}">
					                        ${vag.capienza} litri
					                    </c:when>
								</c:choose>
						    </li>
						    <li class="list-group-item">Forza Motrice: 
							    <c:choose>
							        <c:when test="${tipologiaMap[vag.tipologia] eq 'Locomotiva'}">
							            ${vag.getFormattedPeso()}
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
	    </c:forEach>
	</div>	

</div>
     

</body>


</html>


