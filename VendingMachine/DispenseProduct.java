import java.util.ArrayList;



public class DispenseProduct implements VendingMachineState {
    Item cur_item;
    int leftMoney;
    public DispenseProduct(Item cur_item,int leftMoney){
        this.cur_item = cur_item;
        this.leftMoney = leftMoney;
    }
    public void startMachine(VendingMachine vm){
        try {
            throw new Exception("Machine Already Started");
        } catch (Exception e) {
            System.out.println();
            System.out.println("**** Exception Machine Already Started");
            // TODO: handle exception
        }
        
    }
    public void insertCash(VendingMachine vm,Coin cn){
        try {
            throw new Exception("Cash Already inserted");
        } catch (Exception e) {
            System.out.println();
            System.out.println("**** Exception Cash Already inserted");
            // TODO: handle exception
        }
        
    }
    public void selectProduct(VendingMachine vm,int id){
        try {
            throw new Exception("Prodcut Already Selected");
        } catch (Exception e) {
            System.out.println();
            System.out.println("**** Exception Prodcut Already Selected");
            // TODO: handle exception
        }
        
    }
    public void selectProductButton(VendingMachine vm){
        try {
            throw new Exception("Prodcut Already Selected");
        } catch (Exception e) {
            System.out.println();
            System.out.println("**** Exception Prodcut Already Selected");
            // TODO: handle exception
        }
        
    }
    public void dispenseProduct(VendingMachine vm){
        updateInventory(vm);
        if(leftMoney==0){
            System.out.println("Product dispensed Please collect your product "+cur_item.getName());
            System.out.println();
            return;
        }
        
        System.out.println("Product dispensed Please collect your product "+cur_item.getName()+" and "+leftMoney);
        System.out.println();
    }
    public void insertCashButton(VendingMachine vm){
        try {
            throw new Exception("Cash Already Inserted");
        } catch (Exception e) {
            System.out.println();
            System.out.println("**** Exception Cash Already Inserted");
            // TODO: handle exception
        }
        
    }
    public void refundCancelButton(VendingMachine vm){
        System.out.println();
        System.out.println("Refinding money, cancel button");
        System.out.println();
        vm.coinList = new ArrayList<Coin>();
        vm.setState(new ReadyState());
    }
    public void updateInventory(VendingMachine vm){
        vm.inventory.itemMap.remove(cur_item.getId());
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(vm.inventory.items[i][j].getId()== cur_item.getId()){
                    vm.inventory.items[i][j].setSoldout(false);
                    break;
                }
            }
        }
    }
}