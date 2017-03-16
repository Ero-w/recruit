package com.telek.ghj.util;

import java.util.*;

import org.apache.log4j.*;
import org.aopalliance.intercept.*;

public class LogInterceptor implements MethodInterceptor  
{
    private static ThreadLocal<LogBean> threadLocal = null;
    
    public static ThreadLocal<LogBean> getThreadLocal() { 
    	if (LogInterceptor.threadLocal==null) { 
			synchronized(LogInterceptor.class) { 
				if (LogInterceptor.threadLocal==null) { 
					LogInterceptor.threadLocal=new ThreadLocal<LogBean>();
				}
			}
		}
		return LogInterceptor.threadLocal;
    }
    
    public LogInterceptor() { 
    	//
    }
    
    public Object invoke(MethodInvocation methodInvocation) throws Throwable 
    {
    	try {
        	this.doBefore();
        	//System.out.println(methodInvocation.getClass().getName());//代理对象的类名
        	//System.out.println(methodInvocation.getThis().getClass().getName());//原型对象的类名
        	//System.out.println(methodInvocation.getMethod().getName());//所执行的原型对象的方法名
        	String location = methodInvocation.getThis().getClass().getName()+"."+methodInvocation.getMethod().getName();
        	LogInterceptor.getThreadLocal().get().setLogLocation(location);
    		Object result = methodInvocation.proceed();//执行代理对象的操作方法（在该方法中调用原型对象的对应方法）
			this.doAfter();
			return result;
    	} catch (Throwable e) {
    		LogInterceptor.getThreadLocal().get().recordLog(LogType.WARN, e.getMessage()+"{"+e.getClass().getName()+"}");
    		this.doAfter();
    		throw e;
    	}
    }
    
	public void doBefore()
	{
		System.out.println("log-invoke:前");
    	LogInterceptor.getThreadLocal().set(new LogBean());
	}
	
	public void doAfter()
	{
		LogBean logBean = LogInterceptor.getThreadLocal().get();
		
		List<LogData> logList = logBean.getLogList();
		if(logList.size()>0)
		{
			Map <LogType,StringBuffer> map=new HashMap<LogType, StringBuffer>();
        	for (int index=0;index<logList.size();index++) { 
        		if (map.get(logList.get(index).getType())==null) { 
        			map.put(logList.get(index).getType(), new StringBuffer());
        		}
        		StringBuffer logBuffer = map.get(logList.get(index).getType());
        		logBuffer.append(logList.get(index).getMessage());
        	    logBuffer.append("--->");
        	}
        	
        	Logger logger = Logger.getLogger(logBean.getLogLocation());
        	for (Map.Entry<LogType,StringBuffer> entry : map.entrySet()) { 
        	    String dataLog = logBean.getLogDataTimeDate()+"|"+logBean.getUserName()+"|"+entry.getValue().toString();
        	    LogType type = entry.getKey();
        	    if (type==LogType.DEBUG) {
        	    	logger.debug(dataLog);//System.out.println("\n-----\n"+dataLog+"\n-----\n");
        	    } else if (type==LogType.INFO) {
        	    	logger.info(dataLog);//System.out.println("\n-----\n"+dataLog+"\n-----\n");
        	    } else if (type==LogType.WARN) {
        	    	logger.warn(dataLog);//System.out.println("\n-----\n"+dataLog+"\n-----\n");
        	    } else if (type==LogType.ERROR) {
        	    	logger.error(dataLog);//System.out.println("\n-----\n"+dataLog+"\n-----\n");
        	    } else { 
        	    	logger.debug(dataLog);//System.out.println("\n-----\n"+dataLog+"\n-----\n");
        	    }
        	}
		}
		
		LogInterceptor.getThreadLocal().remove();
		System.out.println("log-invoke:后");
	}
}
