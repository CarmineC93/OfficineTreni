package org.lessons.java.eccezioni;

import java.util.Collection;

import org.lessons.java.bean.Vagone;

 

@SuppressWarnings("serial")
public class NothingToRemoveException extends TrainException{
	
	public NothingToRemoveException(Collection<Vagone> composition,String message) {
		super(composition, message);
	}
}
