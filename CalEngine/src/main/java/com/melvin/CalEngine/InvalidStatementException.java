package com.melvin.CalEngine;

public class InvalidStatementException extends Exception{

	public InvalidStatementException(String reason, String statement) {
		super (reason + ":" + statement); // ((Inherits from Exception class) this is first constructor that accepts the information we need
	}
	
	
	public InvalidStatementException(String reason, String statement, Throwable cause) {
		super(reason + ":" + statement, cause);  		// ((Inherits from Exception class) this is second constructor that lets us associate another exception with the above
	}
}
