package com.pattern.practice.factorymethod;

public class JsonPost implements IPost{
    @Override
    public String returnClassName() {
        return "JsonPost";
    }
}
