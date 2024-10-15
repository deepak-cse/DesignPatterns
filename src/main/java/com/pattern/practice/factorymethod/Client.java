package com.pattern.practice.factorymethod;

public class Client {
    public static void main(String[] args) {
        Factory factory = new ConcreteFactoryJson();
        IPost jsonPost = factory.getInstance();
        System.out.println(jsonPost.returnClassName());
    }
}
