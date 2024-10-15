package com.pattern.practice.abstractfactory;

public class ProductA2 implements IProductA{
    @Override
    public String returnClassName() {
        return "inside ProductA2";
    }

    @Override
    public String returnProductName() {
        return "ProductA2";
    }
}
