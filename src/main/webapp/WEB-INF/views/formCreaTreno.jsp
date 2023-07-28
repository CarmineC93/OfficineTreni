<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
<<<<<<< Updated upstream
    pageEncoding="ISO-8859-1"%>
=======
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
>>>>>>> Stashed changes
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<<<<<<< Updated upstream

	<form action="crea" method="get">
  <label for="sigla">sigla treno:</label><br>
  <input type="text" id="sigla" name="sigla" value=""><br>
  <input type="submit" value="Submit">
	</form> 

=======

	<h1>${errore}</h1>

	<form  onsubmit="return validateForm()" action="crea" method="post">

		<label for="nome">nome treno:</label><br> <input type="text"
			id="nome" name="nome" value="${treno.nome}"><br>
		<p>${errori.getFieldError('nome').defaultMessage}</p>



		<label for="compagnia">compagnia treno:</label> 
		<select	name="compagnia" id="compagnia"  onchange="clearSiglaField()">
		<option value="Nullo"
				${compagniaSelezionata == 'Nullo' ? 'selected' : ''}>scegli tra...</option>
			<option value="Italo"
				${compagniaSelezionata == 'Italo' ? 'selected' : ''}>Italo</option>
			<option value="Trenitalia"
				${compagniaSelezionata == 'Trenitalia' ? 'selected' : ''}>Trenitalia</option>
		</select>
		<p>${errori.getFieldError('compagnia').defaultMessage}</p>




		<label for="sigla">sigla treno:</label><br> <input type="text"
			id="sigla" name="sigla" disabled readonly  value="${treno.sigla}"><br> 
		<p>${errori.getFieldError('sigla').defaultMessage}</p>


		<c:forEach var="vagone" items="${listaVagoni}">
			<div class="vagone-item ${vagone.compagnia}">
				<input type="checkbox" id="${vagone.id}" name="selezioneVagone"
					value="${vagone.id}" onclick="updateSiglaField()"> <label
					for="${vagone.id}">${vagone.tipologia}</label><br>
			</div>
		</c:forEach>

		<!-- Inserisci questo codice JavaScript nella tua JSP -->
		<script>
  // Stampa il valore di compagniaSelezionata nella console del browser
  console.log("compagniaSelezionata: ", '${compagniaSelezionata}');
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

    // Azzerare il valore del campo SiglaTreno
    siglaTrenoElement.value = '';
    
    const checkboxes = document.querySelectorAll('input[name="selezioneVagone"]');

    // Deseleziona tutte le caselle di controllo
    checkboxes.forEach(checkbox => {
      checkbox.checked = false;
    });
  }
</script>




		<input type="submit" value="Submit">

	</form>

	<script>
// Create an array to store the selected values in the order they are clicked
const selectedValues = [];

function updateSiglaField() {
    // Get all the checkboxes with name "selezioneVagone"
    const checkboxes = document.getElementsByName("selezioneVagone");

    // Clear the selectedValues array before updating the selected values
    selectedValues.length = 0;

    // Loop through the checkboxes to check if they are selected
    for (let i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            // Get the value of "${vagone.tipologia}" associated with the selected checkbox
            const value = checkboxes[i].nextElementSibling.textContent.trim();
            // Add the value to the selectedValues array
            selectedValues.push(value);
        }
    }

    // Update the value of the "sigla" input field with the selected values in the desired insertion order
    const composedString = selectedValues.join('\n');
    document.getElementById("sigla").value = composedString;
}

// Add an event listener to the checkboxes to call the updateSiglaField function on click
document.addEventListener("DOMContentLoaded", function () {
    const checkboxes = document.getElementsByName("selezioneVagone");
    checkboxes.forEach(checkbox => {
        checkbox.addEventListener("click", updateSiglaField);
    });
});
</script>





<script>
  // Funzione per filtrare i vagoni in base alla compagnia selezionata
  function filterVagoniByCompagnia() {
    // Ottieni il valore dell'opzione selezionata nel menu a discesa
    const selectedCompagnia = document.getElementById('compagnia').value;

    // Trova tutti gli elementi del DOM con la classe "vagone-item"
    const vagoniItems = document.getElementsByClassName('vagone-item');

    // Nascondi tutti i vagoni
    for (const item of vagoniItems) {
      item.style.display = 'none';
    }

    // Mostra solo i vagoni della compagnia selezionata
    const vagoniCompagniaSelezionata = document.getElementsByClassName(selectedCompagnia);
    for (const item of vagoniCompagniaSelezionata) {
      item.style.display = 'block';
    }
  }

  document.addEventListener('DOMContentLoaded', filterVagoniByCompagnia);
</script>



>>>>>>> Stashed changes
</body>
</html>