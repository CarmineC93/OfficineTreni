package org.lessons.java.eccezioni;

@SuppressWarnings("serial")
public class MaxWeightReachedException extends Exception{
	
	public MaxWeightReachedException() {
		super("The train has reached the maximum weight that the locomotive can carry. "); 
	}

}
