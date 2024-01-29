package fisa.lab.exception;

import lombok.Getter;

@Getter 
public class NotExistExceptions extends Exception {
	
	public NotExistExceptions() {}

	public NotExistExceptions(String message) {
		super(message);
	}
}
