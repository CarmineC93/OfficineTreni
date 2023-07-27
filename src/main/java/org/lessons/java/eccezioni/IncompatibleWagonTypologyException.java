package org.lessons.java.eccezioni;

import java.util.Collection;

import org.lessons.java.bean.Vagone;

@SuppressWarnings("serial")
public class IncompatibleWagonTypologyException  extends TrainException{
	
	private char incompatibleWagon;

	public IncompatibleWagonTypologyException(Collection<Vagone> trainComposition, String message, char incompatibleWagon) {
		super(trainComposition, message);
		this.incompatibleWagon = incompatibleWagon;
	}

	
}
