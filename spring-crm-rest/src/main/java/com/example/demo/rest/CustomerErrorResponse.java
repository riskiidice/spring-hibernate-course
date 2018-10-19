package com.example.demo.rest;

public class CustomerErrorResponse {

	private int status;
	
	private String messsage;
	
	private long timeStamp;

	
	public CustomerErrorResponse(int status, String messsage, long timeStamp) {
		this.status = status;
		this.messsage = messsage;
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMesssage() {
		return messsage;
	}

	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
