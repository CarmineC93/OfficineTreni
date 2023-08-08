package org.lessons.java.eccezioni;

@SuppressWarnings("serial")
public class RestaurantAlreadyPresentException extends IllegalArgumentException{
	public RestaurantAlreadyPresentException(String message) {
		super(message);
	}
}
