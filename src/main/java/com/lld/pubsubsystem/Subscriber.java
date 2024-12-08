package com.lld.pubsubsystem;

public interface Subscriber {
    void onMessage(Message message);
}
