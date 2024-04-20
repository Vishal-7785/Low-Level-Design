import java.util.*;
public class VendingMachine {
    public VendingMachineState vmState;
    public List<Coin> coinList;
    Inventory inventory;

    public VendingMachine(){
        vmState = new ReadyState();
        coinList = new ArrayList<Coin>();
        inventory = new Inventory();
    }

    public VendingMachine(VendingMachineState vmState){
        this.vmState = vmState;
    }
    public void startMachine(){
        vmState.startMachine(this);
    }
    public void setState(VendingMachineState newVmState){
        vmState = newVmState;
    }
    public void addCoin(Coin cn){
        coinList.add(cn);
    }
    public void showInventory(){
        inventory.showInventory();
    }
    public void insertCashButton(){
        vmState.insertCashButton(this);
    }
    public void insertCash(Coin c){
        vmState.insertCash(this,c);
    }
    public void refundCancelButton(){
        vmState.refundCancelButton(this);
    }
    public void selectProductButton(){
        vmState.selectProductButton(this);
    }
    public void selectProduct(int id){
        vmState.selectProduct(this,id);
    }
    public void dispenseProduct(){
        vmState.dispenseProduct(this);
    }
    
}
