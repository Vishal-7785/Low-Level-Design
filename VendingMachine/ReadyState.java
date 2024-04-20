public class ReadyState implements VendingMachineState{

    public void startMachine(VendingMachine vm){
        vm.setState(new StartMachine());
    }
    public void insertCash(VendingMachine vm,Coin cn){
        try {
            throw new Exception("First Start Machine");
        } catch (Exception e) {
            System.out.println("*** Exception First Start Machine");
        }
        
    }
    public void selectProduct(VendingMachine vm,int id){
        try {
            throw new Exception("First Start Machine");
        } catch (Exception e) {
            System.out.println("*** Exception First Start Machine");
            // TODO: handle exception
        }
        
    }
    public void selectProductButton(VendingMachine vm){
        try {
            throw new Exception("First Start Machine");
        } catch (Exception e) {
            System.out.println("*** Exception First Start Machine");
            // TODO: handle exception
        }
        
    }
    public void dispenseProduct(VendingMachine vm){
        try {
            throw new Exception("First Start Machine");
        } catch (Exception e) {
            System.out.println("*** Exception First Start Machine");
            // TODO: handle exception
        }
        
    }
    public void insertCashButton(VendingMachine vm){
        try {
            throw new Exception("First Start Machine");
        } catch (Exception e) {
            System.out.println("*** Exception First Start Machine");
            // TODO: handle exception
        }
        
    }
    public void refundCancelButton(VendingMachine vm){
        try {
            throw new Exception("First Start Machine");
        } catch (Exception e) {
            System.out.println("*** Exception First Start Machine");
            // TODO: handle exception
        }
        
    }
}
