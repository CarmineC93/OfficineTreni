package org.lessons.java.eccezioni;

@SuppressWarnings("serial")
public class WagonNeededException extends IllegalArgumentException{
	public WagonNeededException() {
		super("Your train needs some wagon between two locomotivs");
	}

}
