package com.lld.vendingmachine;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

public class IdleState implements VendingMachineState{

    private final VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        if(vendingMachine.inventory.isAvailable(product)){
            vendingMachine.setSelectedProduct(product);
            vendingMachine.setState(vendingMachine.getReadyState());
            System.out.println("Product is Available and selected"+ product.getName());
        }
        else {
            System.out.println("Product Not available +"+ product.getName());
        }
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("please select prodcut first");
    }

    @Override
    public void insertnote(Note note) {
        System.out.println("please select product first");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("please select product first and make payment");
    }

    @Override
    public void returnChange() {
        System.out.println("Nothing to return");
    }
}
