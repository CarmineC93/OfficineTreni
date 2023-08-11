package org.lessons.java.eccezioni;

import java.util.Collection;

import org.lessons.java.bean.Vagone;

 
@SuppressWarnings("serial")
public class LocomotiveNotFoundException extends TrainException{

 
		
	public LocomotiveNotFoundException(Collection<Vagone> composition, String message) {
		super(composition, message); 
	}


}