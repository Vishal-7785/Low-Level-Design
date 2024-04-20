public class Main {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();
        vm.showInventory();
        vm.startMachine();
        vm.insertCashButton();
        vm.insertCash(Coin.GOLD);
        vm.insertCash(Coin.GOLD);
        vm.selectProductButton();
        vm.selectProduct(200);
        vm.dispenseProduct();
        vm.showInventory();
    }
}
