<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrazione</title>
</head>
<body>
    <h1>Registrazione</h1>
    
    
    
    
    
    <form action="registrazione" method="post">


		<label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required value="${utente.nome}"><br>
    	<p>${errori.getFieldError('nome').defaultMessage}</p>    

        <label for="cognome">Cognome:</label>
        <input type="text" id="cognome" name="cognome" required value="${utente.cognome}"><br>
        <p>${errori.getFieldError('cognome').defaultMessage}</p>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required value="${utente.email}"><br>
        <p>${errori.getFieldError('email').defaultMessage}</p>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        <p>${errori.getFieldError('password').defaultMessage}</p>


        <button type="submit">Registrati</button>
    </form>
    <p>Hai già un account? <a href="/login">Accedi</a></p>
</body>
</html>