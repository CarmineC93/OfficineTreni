package org.lessons.java.eccezioni;

import java.util.Collection;

import org.lessons.java.bean.Vagone;


@SuppressWarnings("serial")
public abstract class TrainException extends Exception{

	private Collection<Vagone> composition;
	
	public TrainException(Collection<Vagone> trainComposition, String message) {
		super(message);
		this.composition = composition;
	}
	
	
	public Collection<Vagone> getCompositione() {
		return composition;
	}
	
	
}
