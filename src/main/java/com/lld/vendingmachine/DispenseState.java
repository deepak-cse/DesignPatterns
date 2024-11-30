package com.lld.vendingmachine;

public class DispenseState implements VendingMachineState{

    private final VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("product already selected, please select dispensed product");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("payment is done, please select dispensed product");
    }

    @Override
    public void insertnote(Note note) {
        System.out.println("payment is done, please select dispensed product");
    }

    @Override
    public void dispenseProduct() {
        vendingMachine.setState(vendingMachine.getReadyState());
        Product product = vendingMachine.getSelectedProduct();
        vendingMachine.inventory.updateQuantity(product,vendingMachine.inventory.getQuantity(product)-1);
        System.out.println("Product dispensed"+ product.getName());
        vendingMachine.setState(vendingMachine.getReturnChangeState());
    }

    @Override
    public void returnChange() {
        System.out.println("please collect the dispensed product first");
    }
}
