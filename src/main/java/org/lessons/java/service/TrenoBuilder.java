package org.lessons.java.service;

import org.lessons.java.bean.Vagone;
import org.lessons.java.eccezioni.IncompatibleWagonTypologyException;
import org.lessons.java.eccezioni.LocomotiveNotFoundException;
import org.lessons.java.eccezioni.MaxWeightReachedException;
import org.lessons.java.eccezioni.NotRemovableLocomotiveException;
import org.lessons.java.eccezioni.NothingToRemoveException;
import org.lessons.java.eccezioni.TrainAlreadyCompletedException;
import org.lessons.java.eccezioni.WagonsNotFoundException;

public interface TrenoBuilder {
	
    TrenoBuilder aggiungiVagone(Vagone wagon) throws LocomotiveNotFoundException, MaxWeightReachedException, TrainAlreadyCompletedException, IncompatibleWagonTypologyException;
    TrenoBuilder removeLastWagonByType(char typology) throws LocomotiveNotFoundException, NothingToRemoveException, NotRemovableLocomotiveException, WagonsNotFoundException;
    TrenoBuilder removeAll();
    
}