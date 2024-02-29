     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ page contentType="text/html;charset=UTF-8" language="java" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elenco Treni</title>

<!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

<!-- font awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body class="text-light bg-dark ">

<!-- Inclusione della dashboard sopra la pagina -->
<jsp:include page="dashboard.jsp" />
	
	<div class="containe px-4" style="padding:3rem 0 0 0">
	 
	<div class="d-flex py-2 justify-content-between align-items-center">
		 	<div class="d-flex align-items-center">
	 	  		 <h1 class="p-2" style="display:inline">Elenco dei treni già composti</h1>  
		    	<img class="py-2" style="display:inline; max-width:60px;" src="${pageContext.request.contextPath}/resources/logo.png" alt="Logo"> 	    	
		    </div> 
    
		 	<div class="pt-5 pb-3">
				<button class="btn btn-warning" onclick="goBack()">Torna Indietro</button>
			</div>			
	</div>
	
	<div class="pb-4 container bg-white bg-opacity-25 rounded-3 mb-4" >
		<form action="ricerca" method="get">
			 <h4 class="pt-3">Filtra per: </h4>
				<div class="row">
					<div class="col-4">
						<label for="nome" style="width: 90px; padding-bottom: 15px" >Nome treno:</label>
					    <input type="text" id="nome" name="nome" /> 
					    <br>
					    <label for="creatore" style="width: 90px; padding-bottom: 15px" >Creato da:</label>
					    <input type="text" id="creatore" name="creatore" /> 
					    <br>
					</div>
				
				 	<div class="col-4">
						<label for="pesoTotale" style="width: 115px; padding-bottom: 15px">Peso max:</label>
				        <input type="range" id="pesoTotale" name="pesoTotale" value="${maxPesoTotale}" min="${minPesoTotale}" max="${maxPesoTotale}">
						<span id="pesoTotaleValue">${maxPesoTotale} t</span> <br>
				
				       	<label for="lunghezzaTotale" style="width: 115px; padding-bottom: 15px">Lunghezza max:</label>
				        <input type="range" id="lunghezzaTotale" name="lunghezzaTotale" value="${maxLunghezzaTotale}" min="${minLunghezzaTotale}" max="${maxLunghezzaTotale}" >
						<span id="lunghezzaTotaleValue">${maxLunghezzaTotale} m</span> <br>
				
					    <label for="prezzoTotale" style="width: 115px; padding-bottom: 15px">Prezzo max:</label>
				        <input type="range" id="prezzoTotale" name="prezzoTotale" value="${maxPrezzoTotale}" min="${minPrezzoTotale}" max="${maxPrezzoTotale}" >
						<span id="prezzoTotaleValue">${maxPrezzoTotale} €</span> <br>
					</div>
					
					<div class="col-4">
						<div class="mb-4">
							<label for="compagnia" class="d-none">Compagnia:</label>
				        	<select id="compagnia" name="compagnia" class="form-select">
					            <option value="">Seleziona compagnia</option>
					            <option value="trenitalia">Trenitalia</option>
					            <option value="italo">Italo</option>
				        	</select>
		        		</div>
		        	
			        	<div class="mb-4">
				        	<label for="ordData" class="d-none">Data di creazione:</label>
						    <select id="ordData" name="ordData" class="form-select">
						        <option value="desc">Più recente</option>
						        <option value="asc">Meno recente</option>
						    </select>
					   	</div>
					</div>

				<div class="row justify-content-center">
					<button class="btn btn-success " style="width:25%" type="submit">Cerca</button>
				</div>
				
			</div>
		</form>
	</div>    

	
		<table class="table py-4">
	        <tr>
	            <!--<th class="text-center">ID</th>-->
	            <th class="text-center">Nome:</th>
 	            <th class="text-center">Compagnia:</th>
	            <th class="text-center">Peso:</th>
	            <th class="text-center">Lunghezza:</th>
	            <th class="text-center">Prezzo:</th>
	            <th class="text-center">Data:</th>
	            <th class="text-center">Anteprima:</th> 
	            <th class="text-center">Dettagli</th>
	            <th class="text-center">Ordina</th>

	        </tr>
	      		 <c:forEach var="treno" items="${not empty risultatiRicerca ? risultatiRicerca : listaTreni}">
	      		 
			<tr>
	      <!--      <td class="text-center">${treno.idTreno}</td>-->
	                <td class="text-center">${treno.nome}</td>
 		            <td class="text-center">${treno.compagnia}</td>
		            <td class="text-center">${treno.getFormattedPesoTotale()}</td>
		            <td class="text-center">${treno.getFormattedLunghezza()}</td>
		            <td class="text-center">${treno.getFormattedPrezzoTotale()}</td>
		            <td class="text-center">${treno.getFormattedDate()}</td>     
	            	<td class="text-center">
              			<c:forEach var="vagone" items="${treno.vagone}">
                    		<c:choose>
                        		<c:when test="${empty vagone.base64Image}">
                           			 <img src="${pageContext.request.contextPath}/resources/vagone_default.png"  height="35" alt="Immagine vagone di default">
                        		</c:when>
                        		<c:otherwise>
                          			  <img src="data:image/png;base64,${vagone.base64Image}"  height="35" alt="Immagine vagone">
                        		</c:otherwise>
                    		</c:choose>
                		</c:forEach>
	            	</td>
	            	<td class="text-center align-middle">    
			         	<a style="color:light-blue;" href="${pageContext.request.contextPath}/treno/show/${treno.idTreno}" class="px-1"><i class="fa-solid fa-eye"></i></a>
			         
			    		<!--  <a style="color:orange;" href="${pageContext.request.contextPath}/admin/modifica-vagone/${vagone.id}"><i class="fa-solid fa-pen-to-square"></i></a>
			            <a style="color:red;" href="${pageContext.request.contextPath}/admin/eliminaVagone/${vagone.id}" class="px-1" onclick="return confirm('Sei sicuro di voler eliminare questo vagone?')"><i class="fa-solid fa-trash"></i></a>
		           		-->
		           		
		            </td>
            	       
            	    <td class="text-center align-middle">    
  						<form action="${pageContext.request.contextPath}/ordine/aggiungi-ordine" method="post" onsubmit="return confirmOrder();">
							<input type="hidden" name="idTreno" value="${treno.idTreno}" />
				            <input type="hidden" name="idUtente" value="${utente.id}" />
				            <button class="btn " style="color:green;" type="submit"><i class="fa-solid fa-cart-shopping"></i></button>
				        </form>
				   </td>     
	            </tr>
	        </c:forEach>
	    </table>
	</div>


</body>
<script>

		//tasto Torna Indietro
		function goBack() {
		    window.history.back();
		}
	
		//TASTO AGGIUNGI AL CARRELLO
		function confirmOrder() {
	    	return confirm("Sei sicuro di voler fare quest'ordine?");
		}
	
		//VARIABILI PESO MASSIMO
    	var maxPesoTotale = ${sessionScope.maxPesoTotale};
        console.log("peso max di sessione: "+ maxPesoTotale);
		const pesoTotaleInput = document.getElementById("pesoTotale");
	    const pesoTotaleValueSpan = document.getElementById("pesoTotaleValue");
        console.log("peso di input al caricamento pagina: "+ pesoTotaleInput.value);
        
        //VARIABILI LUNGHEZZA MASSIMA
        var maxLunghezzaTotale = ${sessionScope.maxLunghezzaTotale};
        const lunghezzaTotaleInput = document.getElementById("lunghezzaTotale");
	    const lunghezzaTotaleValueSpan = document.getElementById("lunghezzaTotaleValue");

        //VARIABILI PREZZO MASSIMO
        var maxPrezzoTotale = ${sessionScope.maxPrezzoTotale};
        const prezzoTotaleInput = document.getElementById("prezzoTotale");
	    const prezzoTotaleValueSpan = document.getElementById("prezzoTotaleValue");
	    
	 	//Carica il valore memorizzato, se presente
	   const storedValuePeso = localStorage.getItem('pesoTotale');
	   const storedValueLunghezza = localStorage.getItem('lunghezzaTotale');
	   const storedValuePrezzo = localStorage.getItem('prezzoTotale');

	   // PESO
	   //aggiornare il valore span al trascinamento sulla barra range
	   pesoTotaleInput.addEventListener('input', function () {
	        pesoTotaleValueSpan.innerText = pesoTotaleInput.value + " t";
	    });
	   
	   if (storedValuePeso != null) {
	        pesoTotaleInput.value = storedValuePeso;

		    // Salva il valore nel localStorage quando viene inviato il form
		    document.querySelector('form').addEventListener('submit', function () {
	        	localStorage.setItem('pesoTotale', pesoTotaleInput.value);        
	    	});
	    
	    //aggiorno il valore dello span con la variabile aggiornata nello storage prima di pulire tutto alla prossima riga
        pesoTotaleValueSpan.innerText = localStorage.getItem('pesoTotale') + " t";

	    //pulisco il localStorage dopo la ricerca in modo che se cambio pagina avrò null come valore e rientrando non rivedrò i precedenti valori di ricerca
	    localStorage.removeItem('pesoTotale');
 
	   } else {
		 //se è null (e quindi sono rientrato in pagina) imposto come variabile di localStorage il valore massimo (che è quello che voglio vedere quando entro per la prima volta) per modificarlo subito appena reimposto il valore sulla barra di range per iniziare una nuova ricerca
	      	localStorage.setItem('pesoTotale', pesoTotaleInput.value);
			pesoTotaleInput.addEventListener('input', function () {
				 localStorage.setItem('pesoTotale', pesoTotaleInput.value);
			});
	   } 
	   
   
		// LUNGHEZZA
		
		//aggiornare il valore span al trascinamento sulla barra range
		lunghezzaTotaleInput.addEventListener('input', function () {
			lunghezzaTotaleValueSpan.innerText = lunghezzaTotaleInput.value + " m";
		 });
		
	   if (storedValueLunghezza != null) {
	        lunghezzaTotaleInput.value = storedValueLunghezza;
	   		// Salva il valore nel localStorage quando viene inviato il form
	  		document.querySelector('form').addEventListener('submit', function () {
	       			localStorage.setItem('lunghezzaTotale', lunghezzaTotaleInput.value);
	   			});
		    lunghezzaTotaleValueSpan.innerText = localStorage.getItem('lunghezzaTotale') + " m";
		    localStorage.removeItem('lunghezzaTotale');
	   }else{
			localStorage.setItem('lunghezzaTotale', lunghezzaTotaleInput.value);
			lunghezzaTotaleInput.addEventListener('input', function () {
					 localStorage.setItem('lunghezzaTotale', lunghezzaTotaleInput.value);
				});
	   } 
		
		// PREZZO
		//aggiornare il valore span al trascinamento sulla barra range
		 prezzoTotaleInput.addEventListener('input', function () {
			    // Ottenere il valore dal campo di input
			    var inputValue = prezzoTotaleInput.value;

			    // Formattare il valore utilizzando la funzione di formattazione del valore di valuta
			    var formattedValue = formatCurrency(inputValue);

			    // Aggiornare il testo nello span con il valore formattato
			    prezzoTotaleValueSpan.innerText = formattedValue;
			});
		
	   if (storedValuePrezzo != null) {
	       prezzoTotaleInput.value = storedValuePrezzo;
	   		// Salva il valore nel localStorage quando viene inviato il form
	   		document.querySelector('form').addEventListener('submit', function () {
	      		 	localStorage.setItem('prezzoTotale', prezzoTotaleInput.value);
	  			});
	   		
	   		var storagePrezzo = localStorage.getItem('prezzoTotale');
		    var formattedValue = formatCurrency(storagePrezzo);
		    prezzoTotaleValueSpan.innerText = formattedValue;
	   		
		   	localStorage.removeItem('prezzoTotale');
	   }else{	
			localStorage.setItem('prezzoTotale', prezzoTotaleInput.value);
			prezzoTotaleInput.addEventListener('input', function () {
					localStorage.setItem('prezzoTotale', prezzoTotaleInput.value);
				});
	   } 

   
	// Funzione per formattare la lunghezza in metri
	   function formattaLunghezza(lunghezza) {
	       return lunghezza.toFixed(2) + " m";
	   }
	
	   // Funzione per formattare il peso
	   function formattaPeso(peso) {
	       return peso.toFixed(2) + " t";
	   }
	
	   // Funzione per formattare la valuta (euro)
		function formatCurrency(value) {
		    return new Intl.NumberFormat('it-IT', { style: 'currency', currency: 'EUR' }).format(value);
		}
   
	</script>

</html>