package com.lld.linkedin;

import java.sql.Timestamp;

public class Notification {

    private final String id;
    private final User user;
    private final NotificationType notificationType;
    private final String content;
    private final Timestamp timestamp;

    public Notification(String id, User user, NotificationType notificationType, String content, Timestamp timestamp) {
        this.id = id;
        this.user = user;
        this.notificationType = notificationType;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
