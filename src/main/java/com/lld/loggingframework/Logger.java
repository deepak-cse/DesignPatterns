package com.lld.loggingframework;

import com.lld.loggingframework.logappender.ConsoleAppender;
import com.lld.loggingframework.logappender.LogAppender;

public class Logger {
    public static final Logger logger = new Logger();
    LoggerConfig config;

    private Logger() {
        //private constructor
        this.config = new LoggerConfig(LogLevel.INFO, new ConsoleAppender());
    }


    public static Logger getInstance(){
        return logger;
    }

    private void log(LogLevel logLevel, String logMessage) {
        if(logLevel.ordinal()>=config.getLogLevel().ordinal()){
            LogMessage logMessage1 = new LogMessage(logLevel,logMessage);
            config.getLogAppender().append(logMessage1);
        }
    }

    public void debug(String logMessage){
        log(LogLevel.DEBUG,logMessage);
    }

    public void info(String logMessage){
        log(LogLevel.INFO,logMessage);
    }

    public void warning(String logMessage){
        log(LogLevel.WARNING,logMessage);
    }

    public void error(String logMessage){
        log(LogLevel.ERROR,logMessage);
    }

    public void fatal(String logMessage){
        log(LogLevel.FATAL,logMessage);
    }

}
