package com.revature.exceptions;


@SuppressWarnings("serial")
public class StoryNoLonguerExistException extends Exception {
	public StoryNoLonguerExistException () {
		super("The requested Story doesn t exist anymore.");
	}

}
