package com.lld.pubsubsystem;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class Topic {

    private String name;
    private Set<Subscriber> subscribers = new CopyOnWriteArraySet<>();

    public Topic(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void addSubsciber(Subscriber subscriber){
        subscribers.add(subscriber);
    }

    public void removeSubsciber(Subscriber subscriber){
        subscribers.remove(subscriber);
    }

    public void publish(Message message){
        for(Subscriber subscriber:subscribers){
            subscriber.onMessage(message);
        }
    }

}
