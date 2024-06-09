
public class UpiPayment implements Payment{

    UPI upi;
    public UpiPayment(UPI upi){
        this.upi = upi;
    }
    @Override
    public boolean pay(int payment) {
        int upiMoney = upi.getMoney();
        if(upiMoney<payment){
            System.out.println("You don't have sufficient payment to pay bill");
            System.out.println();
            return false;
        }

        upi.setMoney(upiMoney-payment);
        System.out.println("Payment succeeded!");
        System.out.println();
        return true;
    }
    
}
