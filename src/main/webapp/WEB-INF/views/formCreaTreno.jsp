<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>




	<h1>${errore}</h1>


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

				</tr>
			</thead>
			<tbody>
				<c:forEach var="vagone" items="${listaVagoni}">
					<tr selectcompagnia="${vagone.compagnia}">
						<td>${vagone.id}</td>
						<td><input type="checkbox" name="selezioneVagone"
							value="${vagone.id}"
							onchange="aggiungiComposizione(this, '${vagone.id}')"
							<c:if test="${selezioneVagone.contains(vagone.id)}">checked</c:if>>
						</td>
						<td>${tipologiaMap[vagone.tipologia]}</td>
						<td>${vagone.peso}t</td>
						<td>${vagone.lunghezza}m</td>
						<td>${vagone.costo}$</td>
						<td>${vagone.compagnia}</td>
						<td><c:choose>
								<c:when
									test="${tipologiaMap[vagone.tipologia] eq 'Vagone Passeggeri'}">
			                        ${vagone.capienza} passeggeri
			                    </c:when>
								<c:when
									test="${tipologiaMap[vagone.tipologia] eq 'Vagone Ristorante'}">
			                        ${vagone.capienza} clienti
			                    </c:when>
								<c:when test="${tipologiaMap[vagone.tipologia] eq 'Locomotiva'}">
			                        ${vagone.capienza} conducenti
			                    </c:when>
								<c:when
									test="${tipologiaMap[vagone.tipologia] eq 'Vagone Cargo'}">
			                        ${vagone.capienza} lt
			                    </c:when>
							</c:choose></td>

						<td><c:if
								test="${tipologiaMap[vagone.tipologia] eq 'Locomotiva'}">
						       	${vagone.pesoTrainante} t
						    </c:if></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div id="dettagliVagone">
			<!-- Qui verranno visualizzati i dettagli del vagone selezionato -->
		</div>

		<input type="submit" value="Submit">
	</form>




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
    function aggiungiComposizione(checkbox, vagoneID) {
        

        if (checkbox.checked) {
        	const composizioneField = document.getElementById("sigla");
        	const composizioneAttuale = composizioneField.value;
        	const tipologia = checkbox.parentNode.nextElementSibling.textContent.trim();
            composizioneField.value = composizioneAttuale ? composizioneAttuale + getIniziale(tipologia) : getIniziale(tipologia);
			idSelezionati.push(vagoneID);
        } else {
        	const composizioneField = document.getElementById("sigla");
        	const composizioneAttuale = composizioneField.value;
        	const tipologia = checkbox.parentNode.nextElementSibling.textContent.trim();
        	const index = idSelezionati.indexOf(vagoneID);
        	console.log("id da Cancellare:", index);
        	if (index !== -1) {
        		idSelezionati.splice(index, 1);
        		composizioneField.value = composizioneAttuale.replace(composizioneAttuale.charAt(index), "");
            }
        }
        
        console.log("vagoniSelezionati:", idSelezionati);
        console.log("idvagone:", ${vagone.id});
        const composizioneField = document.getElementById("sigla");
        console.log("Composizione aggiornata:", composizioneField.value);
        
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







</body>
</html>