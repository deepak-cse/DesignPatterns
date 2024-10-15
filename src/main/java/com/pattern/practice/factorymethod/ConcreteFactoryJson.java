package com.pattern.practice.factorymethod;

public class ConcreteFactoryJson implements Factory{

    @Override
    public IPost getInstance() {
        return new JsonPost();
    }
}
