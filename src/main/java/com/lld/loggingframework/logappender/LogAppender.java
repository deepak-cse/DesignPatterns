package com.lld.loggingframework.logappender;

import com.lld.loggingframework.LogMessage;

public interface LogAppender {

    void append(LogMessage logMessage);

}
