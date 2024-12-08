package com.lld.loggingframework.logappender;

import com.lld.loggingframework.LogMessage;

public class FileAppender implements LogAppender{
    @Override
    public void append(LogMessage logMessage) {
        System.out.println("file appender message");
    }
}
