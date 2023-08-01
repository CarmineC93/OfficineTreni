<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crea un nuovo treno</title>
<!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

<!-- font awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
	<body class="text-light bg-dark ">
	
	<!-- Inclusione della dashboard sopra la pagina -->
<jsp:include page="dashboard.jsp" />
	 
	 <div class="containe px-4" style="padding:5rem 0 0 3rem">
	 
	 
	
	
		<div class="d-flex justify-content-between align-items-center">
   			<img class="py-2" src="${pageContext.request.contextPath}/resources/logoscritta.png" alt="Logo" style="max-width:100px; display:block;">
	    	<h1 class="py-2" style="display:inline">Componi un nuovo treno</h1>    
	    	<div class="py-5">
				<a class="btn btn-warning" href="javascript:history.back()">Torna Indietro</a>
			</div> 
		</div>
			 					    	
	 	<c:if test="${utente.ruolo.equals('admin')}">
			<a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/crea-vagone">Crea Nuovo Vagone</a>	
		</c:if>
	
		<h4 style="color:red;">${errore}</h4>
			
	
		<form action="crea" method="post" onsubmit="return validateForm()">
			
			<div class="row row-cols-2">
			<div class="col" style="max-width:500px;">
			
						<label class="form-label" for="nome">Nome treno:</label><br> 
						<input type="text" class="form-control"
							id="nome" name="nome" placeholder="Nome del treno..." value="${treno.nome}"><br>
						<p>${errori.getFieldError('nome').defaultMessage}</p>
				
	
				
						<div class="input-group mb-3">
								<label class="input-group-text" for="compagnia">Compagnia treno:</label> 
								<select  class="form-select"
									name="compagnia" id="compagnia"
									onchange="clearSiglaField(); filterByCompagnia()">
									<option value="Nullo"
										${compagniaSelezionata == 'Nullo' ? 'selected' : ''}>Scegli
										tra...</option>
									<option value="Italo"
										${compagniaSelezionata == 'Italo' ? 'selected' : ''}>Italo</option>
									<option value="Trenitalia"
										${compagniaSelezionata == 'Trenitalia' ? 'selected' : ''}>Trenitalia</option>
								</select>
								<p>${errori.getFieldError('compagnia').defaultMessage}</p>
						</div>
				
				
				
						<label class="form-label" for="sigla">Sigla treno:</label><br> 
						<input type="text" class="form-control"
							id="sigla" name="sigla" value="${treno.sigla}"
							placeholder="Composizione treno" disabled readonly><br>
						<p>${errori.getFieldError('sigla').defaultMessage}</p>
				
				  
						<label class="form-label" for="selezione">Selezione vagoni:</label><br>
						<input class="form-control" type="text" id="selezione" name="selezione"
							placeholder="My Selection" disabled readonly><br> 
				
				
	  
		    	
						<div class="py-4">
							<input class="btn btn-success" type="submit" value="Realizza Treno">
						</div> 				
				</div> 
				
				

				
				
				<div class="col" id="dettagliTreno" style="display: none;">
					<!-- Qui verranno visualizzati i dettagli del treno realizzato -->
					<h5>Totale Vagoni:</h5>
					<span id="numvag">0</span>
					<h5>Peso Totale (t):</h5>
					<span id="pestot">0</span>
					<h5>Lunghezza Totale (m):</h5>
					<span id="luntot">0</span>
					<h5>Prezzo Complessivo (Euro):</h5>
					<span id="pretot">0</span>
				</div>
	
 
	
				
				
				<table  class="table" id="vagoniTable">
					<thead>
						<tr>
							<!--<th>Id</th>-->
							<th class="text-center">Aggiungi</th>
							<th class="text-center">Tipologia</th>
							<th class="text-center">Peso</th>
							<th class="text-center">Lunghezza</th>
							<th class="text-center">Costo (i.i.)</th>
							<th class="text-center">Compagnia</th>
							<th class="text-center">Capienza</th>
							<th class="text-center">Forza motrice</th>
		                    <th class="text-center">Foto</th>
		                    <th class="text-center">Azioni</th>
		                    
		
						</tr>
					</thead>
					
					<tbody>
						<c:forEach var="vagone" items="${listaVagoni}">
						
		     <!-- ????????-->   <tr selectcompagnia="${vagone.compagnia}">
							
								 <!-- <td>${vagone.id}</td>-->
								<td class="text-center align-middle">
							 	<input type="checkbox" name="selezioneVagone"
								value="${vagone.id}"
								onchange="aggiungiComposizione(this, '${vagone.id}', ${vagone.peso}, ${vagone.lunghezza}, ${vagone.costo}); highlightRow(this)"
									<c:if test="${selezioneVagone.contains(vagone.id)}">checked</c:if>
									>
								</td>
								<td class="text-center align-middle">${tipologiaMap[vagone.tipologia]}</td>
								<td class="text-center align-middle">${vagone.peso}t</td>
								<td class="text-center align-middle">${vagone.lunghezza}m</td>
								<td class="text-center align-middle">${vagone.costo}$</td>
								<td class="text-center align-middle">${vagone.compagnia}</td>
								<td class="text-center align-middle">
									<c:choose>
										<c:when
											test="${tipologiaMap[vagone.tipologia] eq 'Passeggeri'}">
					                        ${vagone.capienza} passeggeri
					                    </c:when>
										<c:when
											test="${tipologiaMap[vagone.tipologia] eq 'Ristorante'}">
					                        ${vagone.capienza} clienti
					                    </c:when>
										<c:when test="${tipologiaMap[vagone.tipologia] eq 'Locomotiva'}">
					                        ${vagone.capienza} conducenti
					                    </c:when>
										<c:when
											test="${tipologiaMap[vagone.tipologia] eq 'Cargo'}">
					                        ${vagone.capienza} litri
					                    </c:when>
									</c:choose>
								</td>
								<td class="text-center align-middle">
									<c:if
										test="${tipologiaMap[vagone.tipologia] eq 'Locomotiva'}">
								       	${vagone.pesoTrainante} t
								    </c:if>
								</td> 	                    
			                    <td> 
			                       	<img src="data:image/png;base64,${vagone.base64Image}" alt="Immagine Vagone" style="max-width:250px;"> 
			                    </td>
		            
		            			<td class="text-center align-middle">    
		            			<a style="color:light-blue;" href="${pageContext.request.contextPath}/admin/show/${vagone.id}" class="px-1"><i class="fa-solid fa-eye"></i></a>
		            			<c:if test="${utente.ruolo.equals('admin')}">

	            				
			            			
			            			<a style="color:orange;" href="${pageContext.request.contextPath}/admin/modifica-vagone/${vagone.id}"><i class="fa-solid fa-pen-to-square"></i></a>
			            			<a style="color:red;" href="${pageContext.request.contextPath}/admin/eliminaVagone/${vagone.id}" class="px-1" onclick="return confirm('Sei sicuro di voler eliminare questo vagone?')"><i class="fa-solid fa-trash"></i></a>
		            			</c:if></td>
		            			
		                    </tr>
		                </c:forEach>
		            </tbody>
		        </table>
	
			</div>
	
		</form>
	
 

		</div>
	
	
	</body>
	
			<script>
	    function filterByCompagnia() {
	        const selectElement = document.getElementById("compagnia");
	        const compagniaSelezionata = selectElement.value;
	        
	
	        const tableRows = document.querySelectorAll("tbody tr");
	        const table = document.getElementById("vagoniTable");
	        
	        tableRows.forEach(row => {
	            const compagniaVagone = row.getAttribute("selectcompagnia");
	            if (compagniaSelezionata === "Nullo") {
		            	table.style.display = "none";
		                row.style.display = "none";
		            }
	            if (compagniaSelezionata === compagniaVagone) {
	            	 table.style.display = "table";
	                row.style.display = "table-row";
		            } else {
		                 row.style.display = "none";
		            }
		        });
		    }
	
		    // Chiamata iniziale per applicare il filtro all'avvio della pagina
		    filterByCompagnia();
		</script>

	<script>
		  // Ottieni il riferimento all'elemento select nel DOM
		  const selectElement = document.getElementById('compagnia');
		
		  // Aggiungi un ascoltatore per l'evento "change" sul menu a discesa
		  selectElement.addEventListener('change', function() {
		    // Ottieni il valore dell'opzione selezionata
		    const selectedValue = selectElement.value;
		
		    // Seleziona tutti gli elementi del DOM con la classe "vagone-item"
		    const vagoniItems = document.getElementsByClassName('vagone-item');
		
		    // Nascondi tutti i vagoni
		    for (const item of vagoniItems) {
		      item.style.display = 'none';
		    }
		
		    // Mostra solo i vagoni della compagnia selezionata
		    const vagoniCompagniaSelezionata = document.getElementsByClassName(selectedValue);
		    for (const item of vagoniCompagniaSelezionata) {
		      item.style.display = 'block';
		    }
		  });
		</script>


	<script>
		  	function validateForm() {
		    const nomeTrenoInput = document.getElementById('nome');
		    const siglaTrenoInput = document.getElementById('sigla');
		    
		    nomeTrenoInput.style.border = '1px solid #ccc';
		    siglaTrenoInput.style.border = '1px solid #ccc';
		    
		    if (nomeTrenoInput.value.trim() === '' && siglaTrenoInput.value.trim() === '') {
		        alert('I campi Nome del treno e Sigla del treno non possono essere vuoti.');
		        nomeTrenoInput.style.border = '1px solid red';
		        siglaTrenoInput.style.border = '1px solid red';
		        return false; // Blocca l'invio del form
		      }
		    
		    if (nomeTrenoInput.value.trim() === '') {
		        nomeTrenoInput.style.border = '1px solid red';
		        alert('Il campo Nome del treno non pu� essere vuoto.');
		        return false; // Blocca l'invio del form
		      }
		
		      if (siglaTrenoInput.value.trim() === '') {
			        siglaTrenoInput.style.border = '1px solid red';
			        alert('Il campo Sigla del treno non pu� essere vuoto. Scegli i vagoni che compongono il treno.');
			        return false; // Blocca l'invio del form
		      	}
		
		
		    // Altri controlli se necessario
		
		    	return true; // Permetti l'invio del form
		  	}
		</script>

	<script>
		  	function clearSiglaField() {
		    // Trova l'elemento del campo SiglaTreno per ID
		    const siglaTrenoElement = document.getElementById('sigla');
		    const selezione = document.getElementById('selezione');
		    idSelezionati.length = 0; // Azzeriamo l'array
		    // Azzerare il valore del campo SiglaTreno
		    siglaTrenoElement.value = '';
		    selezione.value = "";
		    
		    const checkboxes = document.querySelectorAll('input[name="selezioneVagone"]');
		
		    // Deseleziona tutte le caselle di controllo
		    checkboxes.forEach(checkbox => {
		      checkbox.checked = false;
		    });
		  }
		</script>



	<script>
		
		let idSelezionati = [];
	    function aggiungiComposizione(checkbox, vagID, vagPeso, vagLunghezza, vagCosto) {
	    	
	    	const vagone = {
	    	        id: vagID,
	    	        peso: vagPeso,
	    	        lunghezza: vagLunghezza,
	    	        costo: vagCosto
	    	    };
	        
	    	const composizioneField = document.getElementById("sigla");
        	const pesoTotale = document.getElementById("pestot");
        	const numeroVagoni = document.getElementById("numvag");
        	const lunghezzaTotale = document.getElementById("luntot");
        	const prezzoComplessivo = document.getElementById("pretot");
        	
        	const composizioneAttuale = composizioneField.value;
            const peso = parseInt(pesoTotale.textContent);
            const vagoni = parseInt(numeroVagoni.textContent);
            const lunghezza = parseInt(lunghezzaTotale.textContent);
            const prezzo = parseInt(prezzoComplessivo.textContent);
        	const dettagliTrenoDiv = document.getElementById('dettagliTreno');
	
	        if (checkbox.checked) {
	        	
	        	// Aggiorna i dettagli del treno con i valori corretti
	            const numVagoni = idSelezionati.length;

	            dettagliTrenoDiv.style.display = 'block';
	          
	        	pesoTotale.textContent = peso + vagone.peso;
	        	numeroVagoni.textContent = idSelezionati.length + 1;
	        	lunghezzaTotale.textContent = lunghezza + vagone.lunghezza;
	        	prezzoComplessivo.textContent = prezzo + vagone.costo;
	        	
	        	console.log(pesoTotale.textContent + ' ' + numeroVagoni.textContent + ' ' +
	        	lunghezzaTotale.textContent  + ' ' +	prezzoComplessivo.textContent);
	        	
	        	
	        	const tipologia = checkbox.parentNode.nextElementSibling.textContent.trim();
	            composizioneField.value = composizioneAttuale ? composizioneAttuale + getIniziale(tipologia) : getIniziale(tipologia);
	           
	        	
				idSelezionati.push(vagone.id);
	        } else {
	        	
	        	
	        	const tipologia = checkbox.parentNode.nextElementSibling.textContent.trim();
	        	const index = idSelezionati.indexOf(vagone.id);
	        	if (index !== -1) {
	        		idSelezionati.splice(index, 1);
	        		composizioneField.value = composizioneAttuale.replace(composizioneAttuale.charAt(index), "");
	            }
	        	
	        	if(idSelezionati.length === 0) {
	        		dettagliTrenoDiv.style.display = 'none';
	        	}
	        
	        	
	        	pesoTotale.textContent = peso - vagone.peso;
	        	numeroVagoni.textContent = idSelezionati.length;
	        	lunghezzaTotale.textContent = lunghezza - vagone.lunghezza;
	        	prezzoComplessivo.textContent = prezzo - vagone.costo;
	        	
	        	console.log(pesoTotale.textContent + ' ' + numeroVagoni.textContent + ' ' +
	    	        	lunghezzaTotale.textContent  + ' ' +	prezzoComplessivo.textContent);
	        }
	        
	     
	        
	        const vagoniSelezionatiOutput = document.getElementById("selezione");
	        vagoniSelezionatiOutput.value = idSelezionati.join(", ");
		    }
		</script>



	<script>
			function getIniziale(tipologia) {
			        if (tipologia.includes("Ristorante")) {
			            return "R";
			        } else if (tipologia.includes("Cargo")) {
			            return "C";
			        } else if (tipologia.includes("Passeggeri")) {
			            return "P";
			        } else if (tipologia.includes("Locomotiva")) {
			            return "H";
			        } else {
			            return "";
			        }
			    }
		</script>



	<script>
		function highlightRow(checkbox) {
		    const row = checkbox.closest('tr'); // Ottieni la riga genitore della checkbox

		    // Aggiungi o rimuovi gli stili direttamente nell'attributo 'style' della riga
		    if (checkbox.checked) {
		        row.style.backgroundColor = '#f2f2f2'; // Imposta il colore di sfondo desiderato
		    } else {
		    	 row.style.backgroundColor = '#FFC0CB'
		    	 setTimeout(function() {
		             row.style.backgroundColor = '#ffffff'; // Dopo 2 secondi, reimposta il colore di sfondo a bianco
		         }, 2000); // 2000 millisecondi = 2 secondi
		    }
		}
		</script>
	
</html>