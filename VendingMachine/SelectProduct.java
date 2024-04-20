import java.util.*;
public class SelectProduct implements VendingMachineState{
    public void startMachine(VendingMachine vm){
        try {
            throw new Exception("Machine Already Started");
        } catch (Exception e) {
            System.out.println("*** Exception Machine Already Started");
        }
        
    }
    public void insertCash(VendingMachine vm,Coin cn){
        try {
            throw new Exception("Please select product");
        } catch (Exception e) {
            System.out.println("*** Exception Please select product");
        }
        
    }
    public void selectProductButton(VendingMachine vm){
        try {
            throw new Exception("Please select product");
        } catch (Exception e) {
            System.out.println("*** Exception Please select product");
        }
    }
    public void selectProduct(VendingMachine vm,int id){
        Item cur_item = vm.inventory.itemMap.get(id);
        if(cur_item!=null){
            int price = cur_item.getPrice();
            int cur_money = 0;
            for(Coin i:vm.coinList){
                cur_money+= i.getValue();
            }
            if(cur_money<price){
                System.out.println("Insufficent money please collect your money from tray and retry");
                vm.coinList = new ArrayList<Coin>();
                vm.setState(new ReadyState());
            }else{
                System.out.println();
                System.out.println("Product Selected ready for dispense");
                System.out.println();
                System.out.println("Machine came in dispense product state");
                System.out.println();
                vm.setState(new DispenseProduct(cur_item,cur_money-price));
            }
        }else{
            try {
                throw new Exception("*** Exception Item not found");
            } catch (Exception e) {
                System.out.println("*** Exception Item not found");
            }
            
        }
    }
    public void dispenseProduct(VendingMachine vm){
        try {
            throw new Exception("Please Select Product First");
        } catch (Exception e) {
            System.out.println("*** Exception Please Select Product First");
        }
        
    }
    public void insertCashButton(VendingMachine vm){
        try {
            throw new Exception("Please Select Product First");
        } catch (Exception e) {
            System.out.println("*** Exception Please Select Product First");
        }
        
    }
    public void refundCancelButton(VendingMachine vm){
        System.out.println();
        System.out.println("Product dispense cancel");
        vm.coinList = new ArrayList<Coin>();
        vm.setState(new ReadyState());
    }

}
