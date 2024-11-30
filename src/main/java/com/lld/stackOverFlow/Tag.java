package com.lld.stackOverFlow;

public class Tag {

    private final int id;
    private final String name;

    public Tag( String name) {
        this.id = generatedId();
        this.name = name;
    }

    private int generatedId() {
        return (int) (System.currentTimeMillis()%Integer.MAX_VALUE);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
