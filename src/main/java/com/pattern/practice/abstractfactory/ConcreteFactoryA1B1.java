package com.pattern.practice.abstractfactory;

public class ConcreteFactoryA1B1 implements AbstractFactory{

    @Override
    public IProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public IProductB createProductB() {
        return new ProductB1();
    }
}
