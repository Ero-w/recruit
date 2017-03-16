package com.telek.ghj.util;

import java.util.*;

public class LogBean 
{
	private String userName;
	private String logLocation;
    private Date logDataTimeDate;
    private List<LogData> logList;
    
    protected LogBean() { 
    	this.userName = "Guest";
    	this.logLocation = "Default";
    	this.logDataTimeDate = new Date();
    	this.logList = new ArrayList<LogData>();
    }
    
    protected String getUserName() { 
        return this.userName;
    }
    
    public void setUserName(String userName) { 
        this.userName = userName;
    }
    
    protected String getLogLocation() {
		return logLocation;
	}

	protected void setLogLocation(String logLocation) {
		this.logLocation = logLocation;
	}
	
    protected Date getLogDataTimeDate() { 
        return this.logDataTimeDate;
    }

	public List<LogData> getLogList() {
		return logList;
	}
	
	public void recordLog(String logContent) { 
    	this.logList.add(new LogData(LogType.DEBUG,logContent));
    }
	
    public void recordLog(LogType logType,String logContent) { 
    	this.logList.add(new LogData(logType,logContent));
    }
}