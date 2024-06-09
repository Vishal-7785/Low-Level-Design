public class PromoCodeCoupon implements Coupon{

    int total_bill;
    int couponAmount = 100;
    int minimumBill = 999;
    public PromoCodeCoupon(int bill){
        this.total_bill = bill;
    }

    @Override
    public int apply() {
        if(total_bill>=999){
            System.out.println("Yeah! Congrats you got 100 rupees off");
            System.out.println();
            total_bill-= 100;
        }else{
            int required = 999-total_bill;
            System.out.printf("Coupon can not be applied, add items worth %d more",required);
            System.out.println();
            System.out.println();
        }
        return total_bill;
    }
    
}
