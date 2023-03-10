package com.pratiti.model;

public class RegistrationStatus {
	private boolean status;
	private String message;
	private int registeredCustomerId;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getRegisteredCustomerId() {
		return registeredCustomerId;
	}
	public void setRegisteredCustomerId(int registeredCustomerId) {
		this.registeredCustomerId = registeredCustomerId;
	}	
}
