<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="org.lessons.java.treno.Treno" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	${message}
	
	${treno.composizioneTreno}
	
	
	
	<% 
		Treno treno = (Treno) request.getAttribute("treno");
		
		String sigla = treno.getComposizioneTreno();
	
		char c = sigla.charAt(0);
	%>
		
		
		<img src="/OfficineTreni/resources/img/<%=c%>.jpg"/>
		
	<% 
		
		
	%>
	
</body>
</html>