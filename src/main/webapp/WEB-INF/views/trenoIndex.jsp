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
	<h1>Treni</h1>
	
	<table>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>utente</th>
            <th>sigla</th>
            <th>compagnia</th>
        </tr>
        <c:forEach var="treno" items="${listaTreni}">
            <tr>
                <td>${treno.idTreno}</td>
                <td>${treno.nome}</td>
                <td>${treno.utente.nome}</td>
                <td>${treno.sigla}</td>
                <td>${treno.compagnia}</td>
            </tr>
        </c:forEach>
    </table>


</body>
</html>