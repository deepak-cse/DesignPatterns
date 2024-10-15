package com.pattern.practice.abstractfactory;

public class ProductB1 implements IProductB{
    @Override
    public String returnClassName() {
        return "inside product b1";
    }

    @Override
    public String returnProduct() {
        return "product b1";
    }
}
