package com.lld.vendingmachine;

public class VendingMachine {

    private static VendingMachine instance;

    public Inventory inventory;

    private VendingMachineState idleState;

    private VendingMachineState readyState;

    private VendingMachineState dispenseState;

    private VendingMachineState returnChangeState;

    private VendingMachineState currentState;

    private Product selectedProduct;

    private double totalPayment;

    public VendingMachine() {
        this.inventory = new Inventory();
        this.idleState = new IdleState(this);
        this.readyState = new ReadyState(this);
        this.dispenseState = new DispenseState(this);
        this.returnChangeState = new ReturnChangeState(this);
        this.currentState = idleState;
        this.totalPayment = 0.0;

    }

    public static synchronized VendingMachine getInstance() {
        if(instance==null) {
            instance=new VendingMachine();
        }
        return instance;
    }

    public void selectProduct(Product product) {
        currentState.selectProduct(product);
    }

    public void insertCoin(Coin coin) {
        currentState.insertCoin(coin);
    }

    public void insertNote(Note note) {
        currentState.insertnote(note);
    }

    public void dispenseProduct() {
        currentState.dispenseProduct();
    }

    public void returnChange(){
        currentState.returnChange();
    }

    void setState (VendingMachineState state) {
        this.currentState=state;
    }

    public VendingMachineState getIdleState() {
        return idleState;
    }

    public VendingMachineState getReadyState() {
        return readyState;
    }

    public VendingMachineState getDispenseState() {
        return dispenseState;
    }

    public VendingMachineState getReturnChangeState() {
        return returnChangeState;
    }

    public VendingMachineState getCurrentState() {
        return currentState;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    void setSelectedProduct(Product product) {
        this.selectedProduct = product;
    }

    void resetSelectedProduct(){
        this.selectedProduct=null;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    void addCoin(Coin coin) {
        this.totalPayment+=coin.getValue();
    }

    void addNote(Note note) {
        this.totalPayment+=note.getValue();
    }

    void resetPayment(){
        this.totalPayment=0.0;
    }
}
