package org.lessons.java.eccezioni;

@SuppressWarnings("serial")
public class MaxWeightReachedException extends Exception{
	
	public MaxWeightReachedException() {
		super("Il treno ha già raggiunto il massimo peso che la locomotiva può portare. "); 
	}

}
