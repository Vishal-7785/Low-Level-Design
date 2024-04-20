public interface VendingMachineState {
    public void startMachine(VendingMachine vm);
    public void insertCash(VendingMachine vm,Coin cn);
    public void insertCashButton(VendingMachine vm);
    public void selectProduct(VendingMachine vm,int id);
    public void dispenseProduct(VendingMachine vm);
    public void refundCancelButton(VendingMachine vm);
    public void selectProductButton(VendingMachine vm);
}
