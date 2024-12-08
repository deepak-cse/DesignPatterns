package com.lld.loggingframework;

import com.lld.loggingframework.logappender.LogAppender;

public class LoggerConfig {
    LogAppender logAppender;
    LogLevel logLevel;

    public LoggerConfig( LogLevel logLevel,LogAppender logAppender) {
        this.logAppender = logAppender;
        this.logLevel = logLevel;
    }

    public LogAppender getLogAppender() {
        return logAppender;
    }

    public void setLogAppender(LogAppender logAppender) {
        this.logAppender = logAppender;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }
}
