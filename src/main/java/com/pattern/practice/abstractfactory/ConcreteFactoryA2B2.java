package com.pattern.practice.abstractfactory;

public class ConcreteFactoryA2B2 implements AbstractFactory{

    @Override
    public IProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public IProductB createProductB() {
        return new ProductB2();
    }
}
