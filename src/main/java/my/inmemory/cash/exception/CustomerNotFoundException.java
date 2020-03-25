package my.inmemory.cash.exception;

import java.util.NoSuchElementException;

public class CustomerNotFoundException extends NoSuchElementException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8507311791509849973L;

	public CustomerNotFoundException(String message) {
		super(message);
	
	}

}
