<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       
   

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
	//<%@ page import="org.lessons.java.treno.Treno
		//Treno treno = (Treno) request.getAttribute("treno");
		
		//String sigla = treno.getComposizioneTreno();
	
		//char c = sigla.charAt(0);
	%>
		
		
		<img src="/OfficineTreni/resources/img/<%=%>.jpg"/>
		
	<% 
		
		
	%>
	
</body>
</html>