package com.mns.exceptions;

public class InvalidBrowserNameException extends RuntimeException{
	private String browsername;
	public InvalidBrowserNameException(String browsername){
	this.browsername = browsername;
	}
	public String getMassage() {
		return browsername;
	}

}
