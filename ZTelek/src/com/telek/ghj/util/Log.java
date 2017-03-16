package com.telek.ghj.util;

public class Log { 
    public static LogBean getLogHandler() { 
		ThreadLocal<LogBean> threadLocal = LogInterceptor.getThreadLocal();
		if(threadLocal==null) { 
			threadLocal=LogInterceptor.getThreadLocal();
			threadLocal.set(new LogBean());
		} else if(threadLocal.get()==null) { 
			threadLocal.set(new LogBean());
		}
		return LogInterceptor.getThreadLocal().get();
	}
}
