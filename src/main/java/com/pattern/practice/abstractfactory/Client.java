package com.pattern.practice.abstractfactory;

public class Client {

    public static void main(String[] args) {
       AbstractFactory factory = new ConcreteFactoryA1B1();
       IProductA productA = factory.createProductA();
       IProductB productB = factory.createProductB();

       System.out.println(productA.returnProductName());
        System.out.println(productB.returnClassName());

        AbstractFactory factory1 = new ConcreteFactoryA2B2();
        IProductA productA1 = factory1.createProductA();
        IProductB productB1 = factory1.createProductB();

        System.out.println(productA1.returnClassName());
        System.out.println(productB1.returnClassName());

    }
}
