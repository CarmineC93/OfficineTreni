<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registrazione</title>
</head>
<body>
    <h1>Registrazione</h1>
    <form action="registrazione" method="post">


		<label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required><br>

        <label for="cognome">Cognome:</label>
        <input type="text" id="cognome" name="cognome" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>


        <button type="submit">Registrati</button>
    </form>
    <p>Hai già un account? <a href="/login">Accedi</a></p>
</body>
</html>