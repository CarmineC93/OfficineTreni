package org.lessons.java.eccezioni;

import java.util.Collection;

import org.lessons.java.bean.Vagone;

 
@SuppressWarnings("serial")
public class TrainAlreadyCompletedException extends TrainException{

	public TrainAlreadyCompletedException(Collection<Vagone> trainComposition, String message) {
		super(trainComposition, message);
 	}
	
	
}
