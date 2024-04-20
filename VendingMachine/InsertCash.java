import java.util.ArrayList;

public class InsertCash implements VendingMachineState{
    public void startMachine(VendingMachine vm){
        try {
            throw new Exception("Machine Already Started");
        } catch (Exception e) {
            System.out.println("*** Exception Machine Already Started");
            // TODO: handle exception 
        }
        
    }
    public void insertCash(VendingMachine vm, Coin cn){
        System.out.println();
        System.out.println("Cash Inserted "+cn.getValue());
        vm.addCoin(cn);
    }
    public void selectProduct(VendingMachine vm,int id){
        try {
            throw new Exception("Press Select product button");
        } catch (Exception e) {
            System.out.println("***** Exception Press Select product button");
            // TODO: handle exception
        }
        
    }
    public void selectProductButton(VendingMachine vm){
        System.out.println();
        System.out.println("System came in Insert Button State ");
        vm.setState(new SelectProduct());
    }
    public void dispenseProduct(VendingMachine vm){
        try {
            throw new Exception("First Select Product");
        } catch (Exception e) {
            System.out.println("*** Exception First Select Product");
            // TODO: handle exception
        }
        
    }
    public void insertCashButton(VendingMachine vm){
        try {
            throw new Exception("You can insert cash");
        } catch (Exception e) {
            System.out.println("*** Exception You can insert cash");
            // TODO: handle exception
        }
        
    }
    public void refundCancelButton(VendingMachine vm){
        System.out.println();
        System.out.println("Returning money cancel product");
        vm.coinList = new ArrayList<Coin>();
        vm.setState(new ReadyState());
    }
}
