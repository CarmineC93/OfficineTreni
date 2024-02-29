
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ page contentType="text/html;charset=UTF-8" language="java" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elenco Ordini</title>

<!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

<!-- font awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body class="text-light bg-dark ">

<!-- Inclusione della dashboard sopra la pagina -->
<jsp:include page="dashboard.jsp" />
	
	<div class="containe px-4" style="padding:3rem 0 0 0">
	 
	<div class="d-flex py-2 justify-content-between align-items-center">
		 	  
		 	  <div class="d-flex align-items-center">
		 	  		 <h1 class="p-2" style="display:inline">Elenco degli ordini</h1>  
		 	    	<img class="py-2" style="display:inline; max-width:60px;" src="${pageContext.request.contextPath}/resources/logo.png" alt="Logo"> 	    	
		 	   </div> 
		 	    
		 	    <div class="py-5">
					<a class="btn btn-warning" href="javascript:history.back()">Torna Indietro</a>
				</div>
		 </div>
	
		<table class="table py-4">
	        <tr>
 	            <th class="text-center">Id Ordine: </th>
	            <th class="text-center">Nome Utente: </th>
	            <th class="text-center">Treno Ordinato:</th>
	            <th class="text-center">Data Ordine: </th>
	            <th class="text-center">Importo (i.i.): </th> 
	            <th class="text-center">Stato Ordine: </th> 
	            <c:if test="${utente.ruolo.equals('admin')}">
	              <th class="text-center">Aggiorna stato ordine: </th> 
	           	</c:if>	 
	        </tr>
	        
	        
	        <c:forEach var="ordine" items="${listaOrdini}">
	            <tr>
 	                <td class="text-center">${ordine.id}</td>
	              	<td class="text-center">${ordine.utente.nome}</td>
	                <td class="text-center">${ordine.treno.nome}</td>
        			<td class="text-center">${ordine.formattedDateTime}</td>
		            <td class="text-center">${ordine.getFormattedImporto()}</td> 
		            <td class="text-center">${ordine.stato}</td> 
		            
		       	    <c:if test="${utente.ruolo.equals('admin')}">
		            
		            <td class="text-center">
		                <form action="${pageContext.request.contextPath}/ordine/update-status" method="post" class="text-center">
					     
					     	<div class="d-flex row row-cols-2">
					     		<div class="col">
						     		<input type="hidden" name="orderId" value="${ordine.id}" />
							        <select class="form-select" name="newStatus">
							            <option value="In valutazione">In valutazione</option>
							            <option value="Approvato">Approvato</option>
							            <option value="In costruzione">In costruzione</option>
							            <option value="In transito">In transito</option>
							            <option value="Consegnato">Consegnato</option>
							            <option value="Annullato">Annullato</option>
							        </select>
					     		</div>
					     		
					     		 <div class="col">
					     			<button class="btn btn-warning" type="submit"><i class="fa-solid fa-pen-to-square"></i>Aggiorna</button>
					     			<button class="btn btn-success" type="submit"><i class="fa-solid fa-cart-shopping"></i>Paga</button>
					     			
					     		</div>
					     	</div>	
					    </form>
	            	  </td> 	           	
	            	 </c:if>	 

            	                
	            </tr>
	        </c:forEach>
	    </table>
	</div>


</body>
</html>