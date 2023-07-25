<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>

<title>Login - OfficineTreni</title>

<meta name="author" content="OfficineTreni">
<meta name="keywords" content="OfficineTreni">
<meta name="description" content="OfficineTreni">
<meta name="theme-color" content="#FEFF9F">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">

<link
	href="https://fonts.googleapis.com/css?family=Love+Ya+Like+A+Sister"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Baloo"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Varela+Round"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Ubuntu"
	rel="stylesheet">

<link rel="icon" href="/OfficineTreni/resources/img/logo.png">
<link rel="shortcut icon"
	href="/OfficineTreni/resources/img/logo.png"
	type="image/png">
<link rel="stylesheet" href="/OfficineTreni/resources/css/graphics.css" type="text/css">
<script src="/OfficineTreni/resources/views/script.js"></script>

</head>

<body>

	<nav id="sezioni">
		<div>
			<a href="#primo" id="uno1">Home</a> <a href="#secondo" id="due2">Accedi</a>

		</div>
	</nav>



	<header>

		<div id="logo">
			<img
				src="/OfficineTreni/resources/img/logoscritta.png"
				id="foto">
		</div>


		</div>



	</header>


	<div id="cont">
	

		<div id="sezione">
			<h1>Login</h1>
			<form action="login" method="post">
				<label for="username">Username:</label> <input type="text"
					id="username" name="username" required><br> <label
					for="password">Password:</label> <input type="password"
					id="password" name="password" required><br>

				<button type="submit">Accedi</button>
			</form>
			<p>
				Non hai un account? <a href="registrazione">Registrati</a>
			</p>
		</div>



















		<div id="news">
			OfficineTreni &egrave; un&rsquo;azienda che si occupa della
			progettazione e costruzione di treni ad alta velocit&agrave;. Grazie
			alla sua esperienza e alle sue competenze tecniche, OfficineTreni
			&egrave; in grado di offrire soluzioni innovative e personalizzate
			per soddisfare le esigenze dei propri clienti. L&rsquo;azienda si
			distingue per la qualit&agrave; dei suoi prodotti e per
			l&rsquo;attenzione che riserva alla sicurezza dei passeggeri.
			OfficineTreni &egrave; impegnata nella ricerca e nello sviluppo di
			nuove tecnologie per migliorare l&rsquo;efficienza dei propri treni e
			ridurre l&rsquo;impatto ambientale. La missione di OfficineTreni
			&egrave; quella di fornire treni sicuri, confortevoli ed efficienti,
			che rispettino gli standard di qualit&agrave; pi&ugrave; elevati.
			Collaboriamo con: <br> <br> - Trenitalia <br> <a
				href="https://www.trenitalia.com/it.html"> <img
				src="https://upload.wikimedia.org/wikipedia/commons/e/e2/Logo_Trenitalia.png">
			</a> <br> -Italo <br> <a href="https://www.italotreno.it/it">
				<img
				src="https://upload.wikimedia.org/wikipedia/it/6/63/Logo_Italo-Nuovo_Trasporto_Viaggiatori.png">
			</a>

		</div>

	</div>



	<div id="copyright">
		<h3 id="idm">Copyright CIV Web S.p.A. &copy; 2023</h3>
	</div>

</body>

</html>