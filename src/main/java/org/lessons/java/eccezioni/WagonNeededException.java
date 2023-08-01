package org.lessons.java.eccezioni;

@SuppressWarnings("serial")
public class WagonNeededException extends IllegalArgumentException{
	public WagonNeededException() {
		super("Il tuo treno ha bisogno di qualche vagone tra due locomotive");
	}

}
