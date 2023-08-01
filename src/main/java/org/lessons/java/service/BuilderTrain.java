package org.lessons.java.service;

import java.util.ArrayList;
 import java.util.Collection;
import java.util.List;

 import org.lessons.java.bean.Vagone;
import org.lessons.java.eccezioni.IncompatibleWagonTypologyException;
import org.lessons.java.eccezioni.LocomotiveNotFoundException;
import org.lessons.java.eccezioni.MaxWeightReachedException;
import org.lessons.java.eccezioni.NotRemovableLocomotiveException;
import org.lessons.java.eccezioni.NothingToRemoveException;
import org.lessons.java.eccezioni.RestaurantAlreadyPresentException;
import org.lessons.java.eccezioni.RestaurantNotBeetwenPassengersException;
import org.lessons.java.eccezioni.TrainAlreadyCompletedException;
import org.lessons.java.eccezioni.WagonNeededException;
import org.lessons.java.eccezioni.WagonsNotFoundException;
import org.springframework.stereotype.Component;
 
@Component
public class BuilderTrain {

	//ATTRIBUTES
 
	private Collection<Vagone> trainComposition = new ArrayList<>();
		
	
//////CONSTRUCTORS
	
	
	/*
	 * aggiunge Vagoni alla Collection trainComposition
	 * */
	public void aggiungiVagone(Vagone wagon) throws LocomotiveNotFoundException, MaxWeightReachedException, TrainAlreadyCompletedException, IncompatibleWagonTypologyException {
		// se non è il primo inserimento
		if(trainComposition.size() > 0) {
			Vagone lastWagon = ((ArrayList<Vagone>) trainComposition).get(trainComposition.size() -1);
			double totalWeight = this.getPesoTotale();	
			
			System.out.println("SUCCESSIVI VAGONI---------------------");

			
			//recupero il peso che la locomotiva può portare
			double drivingWeight = trainComposition.stream()
		            .filter(w -> w.getTipologia() == 'H')
		            .mapToDouble(Vagone::getPesoTrainante)
		            .findFirst()
		            .orElseThrow(() -> new LocomotiveNotFoundException(trainComposition, "Nessuna locomotiva trovata. Aggiungine una come primo vagone."));
				
			//se il peso massimo NON è stato raggiunto
			if(totalWeight + wagon.getPeso() <= drivingWeight ) {
					//SE CI SONO GIà DUE locomotive (= FINE TRENO)
					if(quanteLocomotive() == 2) {
						throw new TrainAlreadyCompletedException(trainComposition, "Hai già una locomotiva finale. Rimuovila per aggiungere altri vagoni al treno");
					//se c'è solo una locomotiva
					} else {
						//SE W = P, R, C
						if(!(wagon.getTipologia() == 'H')) {
							//SE W = C
							if (wagon.getTipologia() == 'C') {
								if (trainComposition.size() > 1 && !trainComposition.stream().anyMatch(w -> w.getTipologia() == 'C')) {
								throw new IncompatibleWagonTypologyException(trainComposition, "I vagoni Cargo sono incompatibili con i vagoni Passeggeri/Ristorante", wagon.getTipologia());
								} else {
								trainComposition.add(wagon);	
								}
								//SE W = P, R
							} else if(!(wagon.getTipologia() == 'C')) {
								if(trainComposition.stream().anyMatch((w -> w.getTipologia() == 'C')) ) {
									throw new IncompatibleWagonTypologyException(trainComposition , "I vagoni Passeggeri/Ristorante sono incompatibili con i vagoni Cargo " , wagon.getTipologia());
								//SE W = R
								} else if (wagon.getTipologia() == 'R') {
									if(trainComposition.stream().anyMatch((w -> w.getTipologia() == 'R'))) {
										throw new RestaurantAlreadyPresentException("C'è già un vagone ristorante (il massimo è 1 per treno). Rimuovi quello presente per aggiungerne un altro.");
										
									} else if (lastWagon.getTipologia() == 'P') {
										trainComposition.add(wagon);
									} else {
										throw new RestaurantNotBeetwenPassengersException("Un vagone ristorante può essere aggiunto solo tra due vagoni passeggeri.");
									}
								//SE W = P
								} else if (wagon.getTipologia() == 'P') {
									trainComposition.add(wagon);
								}
								
							} else {
								trainComposition.add(wagon);
							}
							//SE W = H
						} else {
							if(lastWagon.getTipologia()== 'H') {
								
								throw new WagonNeededException();
								
							}	else {
								trainComposition.add(wagon);
							}
						}
					}
					//SE PESO ECCESSIVO
				} else {
					throw new MaxWeightReachedException();				
						}
			//se è il primo inserimento
		} else {
			if(!(wagon.getTipologia() == 'H')) {
				throw new LocomotiveNotFoundException(trainComposition, "Non c'è nessuna Locomotiva. Aggiungine una come primo vagone");
			} else {
				trainComposition.add(wagon);
				
				System.out.println("PRIMO VAGONE---------------------");
			}
		}
	}	
	
	
	
	/*
	 * 	rimuove ultimo vagone di un determinato tipo dalla Collection trainComposition
	 * */
	
	public void removeLastWagonByType(char typology) throws LocomotiveNotFoundException, NothingToRemoveException, NotRemovableLocomotiveException, WagonsNotFoundException {
	    char[] typologyArray = {'R', 'P', 'H', 'C'};
	    List<Character> typoList = new ArrayList<>();
	    for (char c : typologyArray) {
	        typoList.add(c);
	    }

	    if (!typoList.contains(typology)) {
	        throw new WagonsNotFoundException(trainComposition, "No wagon of this typology found");
	    } else {
	        boolean match = false;
	        for (Vagone tc : trainComposition) {
	            if (tc.getTipologia() == typology) {
	                match = true;
	                break;
	            }
	        }

	        // se treno non ha vagoni
	        if (trainComposition.isEmpty()) {
	            throw new NothingToRemoveException(trainComposition, "This train has no wagons yet. Add a Locomotive first");
	        }
	        // se treno ha vagoni ma non ha tipo che si vuole rimuovere
	        else if (!match) {
	            throw new WagonsNotFoundException(trainComposition, "No wagon of this typology found");
	        } else {
	            int lastIndex = -1;
	            for (int i = trainComposition.size() - 1; i >= 0; i--) {
	                Vagone currentWagon = ((ArrayList<Vagone>) trainComposition).get(i);
	                if (currentWagon.getTipologia() == typology) {
	                    lastIndex = i;
	                    break;
	                }
	            }

	            if (lastIndex != -1) {
	                Vagone lastWagon = ((ArrayList<Vagone>) trainComposition).get(lastIndex);
	                System.out.println("questo?: " + lastWagon + " index: " + lastIndex);

	                if (typology == 'H') {
	                    if (!(trainComposition.size() < 2) && quanteLocomotive() == 1) {
	                        throw new NotRemovableLocomotiveException(trainComposition, "You cannot remove your first locomotive if there are other wagons. Remove first the wagons attached to the locomotive");
	                    } else if (quanteLocomotive() == 2) {
	                        trainComposition.remove(lastWagon);
	                    } else {
	                        trainComposition.remove(lastWagon);
	                    }
	                } else {
	                    trainComposition.remove(lastWagon);
	                }
	            }
	        }
	    }
	}
	
	
	/*
	 * 	conta quante locomotive ci sono nella Collection trainComposition
	 * */
	public int quanteLocomotive() {
		//verifico il numero di locomotive presenti
		int count = 0;
		for(Vagone tc : trainComposition) {
			if(tc.getTipologia() == 'H') {
			count ++;
			}
		}
		return count;
	}
		
	/*
	 * 	mostra il peso totale dei Vagoni nella Collection trainComposition
	 * */
		public double getPesoTotale() {
		double totalWeight = 0;
		  for(Vagone vag : trainComposition)
		{
			totalWeight += vag.getPeso();
		}
		return totalWeight;
	}
	
		@Override
		public String toString() {
			return "trainComposition= " + trainComposition+ "]";
		}
		
		
		public void removeAll() {
			this.trainComposition.removeAll(trainComposition);
		}


}
