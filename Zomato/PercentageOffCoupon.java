public class PercentageOffCoupon implements Coupon{

    int total_bill;
    int couponAmount = -1;
    int minimumBill = 499;
    public PercentageOffCoupon(int bill){
        this.total_bill = bill;
    }
    @Override
    public int apply() {
        if(total_bill>=499){
            System.out.println("Yeah! Congrats you got 20 percent rupees off");
            System.out.println();
            int couponAmount = (total_bill*20)/100;
            total_bill-=couponAmount;
        }else{
            int required = 499-total_bill;
            System.out.printf("Coupon can not be applied add items worth %d more",required);
            System.out.println();
        }
        return total_bill;
    }
    
}
