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
	
	<h1>show singolo treno</h1>
	
	
	${treno.nome}
	
	${treno.sigla}
	
	
	 <c:forEach var="vagone" items="${vagoni}">
          
          	
                <p>${vagone.id}</p>
                <p>${vagone.tipologia}</p>
                <p>${vagone.peso}</p>
                <p>${vagone.compagnia}</p>
                <p>${vagone.costo}</p>
                <p>${vagone.capienza}</p>
                <p>${vagone.pesoTrainante}</p>
               	
               	
                
        </c:forEach>
	
	
	
        
     
        
     
	
	
</body>
</html>