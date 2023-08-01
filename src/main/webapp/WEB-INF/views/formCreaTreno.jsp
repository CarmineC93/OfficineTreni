<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crea un nuovo treno</title>
</head>
	<body>
	
	<!-- Inclusione della dashboard sopra la pagina -->
<jsp:include page="dashboard.jsp" />
	 	
	 	
	 	<c:if test="${utente.ruolo.equals('admin')}">
	 	<a href="${pageContext.request.contextPath}/admin/crea-vagone">Crea Vagone</a>
	 	</c:if>
	
		<h4>${errore}</h4>
			
	
		<form action="crea" method="post" onsubmit="return validateForm()">
			<label for="nome">Nome treno:</label><br> <input type="text"
				id="nome" name="nome" placeholder="My Train" value="${treno.nome}"><br>
			<p>${errori.getFieldError('nome').defaultMessage}</p>
	
	
	
			<label for="compagnia">compagnia treno:</label> <select
				name="compagnia" id="compagnia"
				onchange="clearSiglaField(); filterByCompagnia()">
				<option value="Nullo"
					${compagniaSelezionata == 'Nullo' ? 'selected' : ''}>scegli
					tra...</option>
				<option value="Italo"
					${compagniaSelezionata == 'Italo' ? 'selected' : ''}>Italo</option>
				<option value="Trenitalia"
					${compagniaSelezionata == 'Trenitalia' ? 'selected' : ''}>Trenitalia</option>
			</select>
			<p>${errori.getFieldError('compagnia').defaultMessage}</p>
	
	
	
			<label for="sigla">Sigla treno:</label><br> <input type="text"
				id="sigla" name="sigla" value="${treno.sigla}"
				placeholder="My Composition" disabled readonly><br>
			<p>${errori.getFieldError('sigla').defaultMessage}</p>
	
	
			<label for="selezione">Selezione vagoni:</label><br>
			<input type="text" id="selezione" name="selezione"
				placeholder="My Selection" disabled readonly><br>
	
	
			<table id="vagoniTable">
				<thead>
					<tr>
						<th>Id</th>
						<th>Seleziona</th>
						<th>Tipologia</th>
						<th>Peso</th>
						<th>Lunghezza</th>
						<th>Costo</th>
						<th>Compagnia</th>
						<th>Capienza</th>
						<th>pesoTrainante</th>
	                    <th>foto</th>
	                    <th>azioni</th>
	                    
	
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vagone" items="${listaVagoni}">
					
	     <!-- ????????-->   <tr selectcompagnia="${vagone.compagnia}">
						
							<td>${vagone.id}</td>
							<td><input type="checkbox" name="selezioneVagone"
								value="${vagone.id}"
								onchange="aggiungiComposizione(this, '${vagone.id}', ${vagone.peso}, ${vagone.lunghezza}, ${vagone.costo}); highlightRow(this)"
									<c:if test="${selezioneVagone.contains(vagone.id)}">checked</c:if>
								>
							</td>
							<td>${tipologiaMap[vagone.tipologia]}</td>
							<td>${vagone.peso}t</td>
							<td>${vagone.lunghezza}m</td>
							<td>${vagone.costo}$</td>
							<td>${vagone.compagnia}</td>
							<td><c:choose>
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
				                        ${vagone.capienza} lt
				                    </c:when>
								</c:choose>
							</td>
							<td>
								<c:if
									test="${tipologiaMap[vagone.tipologia] eq 'Locomotiva'}">
							       	${vagone.pesoTrainante} t
							    </c:if>
							</td> 	                    
		                    <td> 
		                       	<img src="data:image/png;base64,${vagone.base64Image}" alt="Immagine Vagone"> 
		                    </td>
	            
	            			<td>   
	            						<c:if test="${utente.ruolo.equals('admin')}">
	            					 <a href="${pageContext.request.contextPath}/admin/modifica-vagone/${vagone.id}">Modifica</a>
	            					<a href="${pageContext.request.contextPath}/admin/eliminaVagone/${vagone.id}" onclick="return confirm('Sei sicuro di voler eliminare questo vagone?')">Elimina</a>
	            				</c:if>
	            			</td>
	            			
	                    </tr>
	                </c:forEach>
	            </tbody>
	        </table>
	
			<br>
			<div id="dettagliTreno" style="display: none;">
			<!-- Qui verranno visualizzati i dettagli del treno realizzato -->
			<h3>Totale Vagoni:</h3>
			<h3 id="numvag">0</h3>
			<br>
			<h3>Peso Totale (in t):</h3>
			<h3 id="pestot">0</h3>
			<br>
			<h3>Lunghezza Totale (in m):</h3>
			<h3 id="luntot">0</h3>
			<br>
			<h2>Prezzo Complessivo (in $):</h2>
			<h2 id="pretot">0</h2>


		</div>
		<br> 
	
 
	
			<input type="submit" value="Realizza Treno">
			
			
		</form>
	
		<a class="btn btn-light" href="javascript:history.back()">Torna Indietro</a>
	
	
	
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
		        alert('Il campo Nome del treno non può essere vuoto.');
		        return false; // Blocca l'invio del form
		      }
		
		      if (siglaTrenoInput.value.trim() === '') {
			        siglaTrenoInput.style.border = '1px solid red';
			        alert('Il campo Sigla del treno non può essere vuoto. Scegli i vagoni che compongono il treno.');
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

	
	
	</body>
</html>