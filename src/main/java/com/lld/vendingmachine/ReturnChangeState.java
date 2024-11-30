package com.lld.vendingmachine;

public class ReturnChangeState implements VendingMachineState{

    private final VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("please collect the dispensed product first");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("please collect the dispensed product first");
    }

    @Override
    public void insertnote(Note note) {
        System.out.println("please collect the change first");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("product already dispensed, please collect the change");
    }

    @Override
    public void returnChange() {
        double change = vendingMachine.getTotalPayment()- vendingMachine.getSelectedProduct().getPrice();
        if (change>0){
            System.out.println("change returned"+ change);
            vendingMachine.resetPayment();
        } else {
            System.out.println("No change to return");
        }

        vendingMachine.resetSelectedProduct();
        vendingMachine.setState(vendingMachine.getIdleState());
    }
}
