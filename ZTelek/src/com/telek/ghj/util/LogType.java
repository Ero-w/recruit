package com.telek.ghj.util;

public enum LogType { 
	//ALL,//ALL Level是最低等级的，用于打开所有日志记录。
	//TRACE,//The TRACE Level designates finer-grained informational events than the DEBUG.Since:1.2.12。
	DEBUG,//DEBUG Level指出细粒度信息事件对调试应用程序是非常有帮助的。
	INFO,//INFO level表明 消息在粗粒度级别上突出强调应用程序的运行过程。
	WARN,//WARN level表明会出现潜在错误的情形。
	ERROR,//ERROR level指出虽然发生错误事件，但仍然不影响系统的继续运行。
	//FATAL,//FATAL level指出每个严重的错误事件将会导致应用程序的退出。
	//OFF//OFF Level是最高等级的，用于关闭所有日志记录。
	//分为OFF、FATAL、ERROR、WARN、INFO、DEBUG、TRACE、ALL或者您定义的级别。
	//Log4j建议只使用四个级别，优先级从高到低分别是ERROR、WARN、INFO、DEBUG。
}
