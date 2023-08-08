package org.lessons.java.eccezioni;

import java.util.Collection;

import org.lessons.java.bean.Vagone;

@SuppressWarnings("serial")
public class RestaurantNotBeetwenPassengersException extends IllegalArgumentException{
	public RestaurantNotBeetwenPassengersException(String message) {
		super(message);
	}
}

	
