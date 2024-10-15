package com.pattern.practice.abstractfactory;

public class ProductB2 implements IProductB{
    @Override
    public String returnClassName() {
        return "inside product b2";
    }

    @Override
    public String returnProduct() {
        return "inside product b2";
    }
}
