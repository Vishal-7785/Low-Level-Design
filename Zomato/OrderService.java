import java.util.*;
public class OrderService {
    
    public OrderService(){

    }

    public int placeOrder(Cart cart){
        int total_bill = 0;
        List<Food> foodItems= cart.getCartItems();

        for(Food food: foodItems){
            total_bill+= food.getPrice();
        }
        System.out.printf("Your total bill amount  is %d",total_bill);
        System.out.println();
        System.out.println();
        System.out.println("You can apply coupons to get some discount");
        System.out.println();
        return total_bill;
    }

    public void checkAvailableCoupons(){
        System.out.println("Below is the list of available coupons");
        System.out.println();
    }

    public int applyPromoCodeCoupon(int bill){
        PromoCodeCoupon promoCodeCoupon = new PromoCodeCoupon(bill);
        int amount = promoCodeCoupon.apply();
        return amount;
    }

    public int applyPercentageOffCoupon(int bill){
        PercentageOffCoupon percentageOffCoupon = new PercentageOffCoupon(bill);
        int amount = percentageOffCoupon.apply();
        return amount;
    }
}
