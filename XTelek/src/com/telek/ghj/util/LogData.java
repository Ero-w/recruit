package com.telek.ghj.util;

public class LogData { 
	
	private LogType type;
	private String message;
	
	public LogData() { 
		this(LogType.DEBUG,"");
	}
	
	public LogData(LogType type,String message) { 
		this.type=type;
		this.message=message;
	}
	
	public LogType getType() {
		return type;
	}
	
	public void setType(LogType type) {
		this.type = type;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}