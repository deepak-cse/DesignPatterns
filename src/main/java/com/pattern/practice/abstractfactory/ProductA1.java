package com.pattern.practice.abstractfactory;

public class ProductA1 implements IProductA{
    @Override
    public String returnClassName() {
        return "inside ProductA1";
    }

    @Override
    public String returnProductName() {
        return "ProductA1";
    }
}
