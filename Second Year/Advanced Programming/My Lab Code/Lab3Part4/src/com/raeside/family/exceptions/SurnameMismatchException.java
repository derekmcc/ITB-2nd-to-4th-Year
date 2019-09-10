package com.raeside.family.exceptions;

public class SurnameMismatchException extends Exception{

	private static final long serialVersionUID = 1L;

	public SurnameMismatchException(String message) {
		super("The surname Robison is required to become part of this family");
	}
}
