public class CashPayment implements Payment{

    @Override
    public boolean pay(int amount) {
        System.out.printf("Please pay %d amount in cash when delivery partner reaches",amount);
        System.out.println();
        return true;
    }
    
}
