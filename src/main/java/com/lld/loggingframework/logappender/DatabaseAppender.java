package com.lld.loggingframework.logappender;

import com.lld.loggingframework.LogMessage;

public class DatabaseAppender implements LogAppender{

    @Override
    public void append(LogMessage logMessage) {
        System.out.println("database appender message");
    }
}
