package com.lld.linkedin;

import java.sql.Timestamp;

public class Message {

    private String id;
    private User receiver;
    private User sender;
    private String content;
    private Timestamp timestamp;

    public Message(String id, User receiver, User sender, String content, Timestamp timestamp) {
        this.id = id;
        this.receiver = receiver;
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
    }
}
