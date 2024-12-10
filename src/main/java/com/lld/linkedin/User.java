package com.lld.linkedin;

import java.util.List;

public class User {

    String id;
    String name;
    String email;
    String password;
    Profile profile;
    List<Connection> connections;
    List<Message> inbox;
    List<Message> sentMessage;

    public User(String id, String name, String email, String password, Profile profile, List<Connection> connections, List<Message> inbox, List<Message> sentMessage) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profile = profile;
        this.connections = connections;
        this.inbox = inbox;
        this.sentMessage = sentMessage;
    }

    public void setProfile(Profile profile){
        this.profile = profile;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Profile getProfile() {
        return profile;
    }

    public List<Connection> getConnections() {
        return connections;
    }

    public List<Message> getInbox() {
        return inbox;
    }

    public List<Message> getSentMessage() {
        return sentMessage;
    }
}
