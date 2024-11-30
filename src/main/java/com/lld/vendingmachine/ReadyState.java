package com.lld.vendingmachine;

public class ReadyState implements VendingMachineState{

    private final VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already selected, please make payment");
    }

    @Override
    public void insertCoin(Coin coin) {
        vendingMachine.addCoin(coin);
        System.out.println("Coin inserted"+ coin);
        checkPaymentStatus();
    }

    private void checkPaymentStatus() {
        if(vendingMachine.getTotalPayment()>= vendingMachine.getSelectedProduct().getPrice()){
            vendingMachine.setState(vendingMachine.getDispenseState());
        }
    }

    @Override
    public void insertnote(Note note) {
        vendingMachine.addNote(note);
        System.out.println("Note inserted"+note);
        checkPaymentStatus();
    }

    @Override
    public void dispenseProduct() {
        System.out.println("please make payment");
    }

    @Override
    public void returnChange() {
        System.out.println("please make payment first");
    }
}
