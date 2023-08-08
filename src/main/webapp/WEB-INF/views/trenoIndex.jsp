<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elenco Treni</title>

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
		 	  		 <h1 class="p-2" style="display:inline">Elenco dei treni già composti</h1>  
		 	    	<img class="py-2" style="display:inline; max-width:60px;" src="${pageContext.request.contextPath}/resources/logo.png" alt="Logo"> 	    	
		 	   </div> 
		 	    
		 	    <div class="py-5">
					<a class="btn btn-warning" href="javascript:history.back()">Torna Indietro</a>
				</div>
		 </div>
	
		<table class="table py-4">
	        <tr>
	            <!--<th class="text-center">ID</th>-->
	            <th class="text-center">Nome:</th>
	            <th class="text-center">Fatto da:</th>
	            <th class="text-center">Composizione:</th>
	            <th class="text-center">Compagnia:</th>
	            <th class="text-center">Foto:</th> 
	            <th class="text-center">Dettagli</th>
	            
	            
	        </tr>
	        <c:forEach var="treno" items="${listaTreni}">
	            <tr>
	      <!--      <td class="text-center">${treno.idTreno}</td>-->
	                <td class="text-center">${treno.nome}</td>
	                <td class="text-center">${treno.utente.nome}</td>
	                <td class="text-center">${treno.sigla}</td>
		            <td class="text-center">${treno.compagnia}</td>
	            	<td class="text-center">
              			<c:forEach var="vagone" items="${treno.vagone}">
                    		<c:choose>
                        		<c:when test="${empty vagone.base64Image}">
                           			 <img src="${pageContext.request.contextPath}/resources/vagone_default.png"  height="45" alt="Immagine vagone di default">
                        		</c:when>
                        		<c:otherwise>
                          			  <img src="data:image/png;base64,${vagone.base64Image}"  height="45" alt="Immagine vagone">
                        		</c:otherwise>
                    		</c:choose>
                		</c:forEach>
	            	</td>
	            	<td class="text-center align-middle">    
			         	<a style="color:light-blue;" href="${pageContext.request.contextPath}/treno/show/${treno.idTreno}" class="px-1"><i class="fa-solid fa-eye"></i></a>
			         	<a style="color:green;" href=" "><i class="fa-solid fa-cart-shopping"></i></a>
			         	
			    		<!--  <a style="color:orange;" href="${pageContext.request.contextPath}/admin/modifica-vagone/${vagone.id}"><i class="fa-solid fa-pen-to-square"></i></a>
			            <a style="color:red;" href="${pageContext.request.contextPath}/admin/eliminaVagone/${vagone.id}" class="px-1" onclick="return confirm('Sei sicuro di voler eliminare questo vagone?')"><i class="fa-solid fa-trash"></i></a>
		           		-->
		            </td>
            	                
	            </tr>
	        </c:forEach>
	    </table>
	</div>


</body>
</html>