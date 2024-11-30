package com.lld.vendingmachine;

public class VendingMachineDemo {
    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getInstance();
        Product coke = new Product("Coke", 1.5);
        Product pepsi = new Product("Pepsi",1.5);
        Product water = new Product("water",1.0);

        vendingMachine.inventory.addProduct(coke,5);
        vendingMachine.inventory.addProduct(pepsi,10);
        vendingMachine.inventory.addProduct(water,11);

        vendingMachine.selectProduct(water);
        //vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.QUARTER);

        vendingMachine.dispenseProduct();
        vendingMachine.returnChange();
    }




}
