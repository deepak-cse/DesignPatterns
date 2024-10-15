package com.pattern.practice.factorymethod;

public class ConcreteFactoryNews implements Factory{

    @Override
    public IPost getInstance() {
        return new NewsPost();
    }
}
