package com.lld.vendingmachine;

public interface VendingMachineState {

    void selectProduct(Product product);
    void insertCoin(Coin coin);
    void insertnote(Note note);
    void dispenseProduct();
    void returnChange();
}
