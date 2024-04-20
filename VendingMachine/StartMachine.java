
public class StartMachine implements VendingMachineState{

    public void startMachine(VendingMachine vm){
        try {
            throw new Exception("First insert money");
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
    public void insertCashButton(VendingMachine vm){
        System.out.println();
        System.out.println("System Came in Insert Cash State");
        vm.setState(new InsertCash());
    }
    
    public void selectProduct(VendingMachine vm,int id){
        try {
            throw new Exception("First insert money");
        } catch (Exception e) {
            System.out.println("*** Exception First Start Machine");
            // TODO: handle exception
        }
        
    }
    public void selectProductButton(VendingMachine vm){
        try {
            throw new Exception("First insert money");
        } catch (Exception e) {
            System.out.println("*** Exception First Start Machine");
            // TODO: handle exception
        }
        
    }
    public void dispenseProduct(VendingMachine vm){
        try {
            throw new Exception("First insert money");
        } catch (Exception e) {
            System.out.println("*** Exception First Start Machine");
            // TODO: handle exception
        }
    }
    public void insertCash(VendingMachine vm, Coin cn){
        try {
            throw new Exception("First click insert money button");
        } catch (Exception e) {
            System.out.println("*** Exception First click insert money button");
            // TODO: handle exception
        }
        
    }
    public void refundCancelButton(VendingMachine vm){
        try {
            throw new Exception("First insert money");
        } catch (Exception e) {
            System.out.println("*** Exception First insert money");
            // TODO: handle exception
        }
    }
}
