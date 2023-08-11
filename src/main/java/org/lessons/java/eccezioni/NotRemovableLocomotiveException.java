package org.lessons.java.eccezioni;

import java.util.Collection;

import org.lessons.java.bean.Vagone;

 
@SuppressWarnings("serial")
public class NotRemovableLocomotiveException extends TrainException{

	public NotRemovableLocomotiveException(Collection<Vagone> composition,String message) {
		super(composition, message);
	}

}
