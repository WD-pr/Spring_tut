package com.springdemo.rest;

public class StudentErrorResponse {

	private int status;
	private String messsage;
	private long timeStamp;

	public StudentErrorResponse() {

	}

	public StudentErrorResponse(int status, String messsage, long timeStamp) {
		this.status = status;
		this.messsage = messsage;
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public String getMesssage() {
		return messsage;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

}