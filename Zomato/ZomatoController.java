public class ZomatoController {
    User user;
    AuthenticationService authenticationService;
    Search search;
    RestaurantService restaurantService;
    FoodServiceFactory foodServiceFactory;
    FoodService foodService;
    OrderService orderService;
    Payment payment;
    Restaurant restaurant;
    Cart cart;
    boolean isRestaurantSelected = false;
    int total_amount = -1;

    public ZomatoController(User user){
        this.user = user;
        authenticationService = new AuthenticationService();
        restaurantService = RestaurantService.getInstance();
        foodServiceFactory = new FoodServiceFactory();
        foodService = foodServiceFactory.getFoodService(user.getAddress().getCity());
        orderService = new OrderService();
        cart = new Cart();
    }

    public void login(){
        authenticationService.login(user, "1234");
    }

    public void searchRestaurant(String restaurantName){
        search = new RestaurantSearch(user);
        search.searchRestaurant(restaurantName);
    }

    public void searchFood(String foodName){
        search = new FoodSearch(user);
        search.searchRestaurant(foodName);
    }

    public void selectRestaurant(String name){
        restaurant = restaurantService.getRestaurant(name, user);
        if(restaurant == null){
            System.out.println("Can not find the restaurant you choose, please provide a diferent restaurant name");
            System.out.println();
        }else{
            if(cart.isEmpty()==false){
                System.out.println("Emptying old cart as you have selected new restaurant for your order");
                System.out.println();
                cart.emptyCart();
            }
            cart = new Cart();
            isRestaurantSelected = true;
            System.out.printf("Below is the list of items that %s restaurant offers",name);
            System.out.println();
            System.out.println();
            restaurant.showFoodItems();
        }
    }

    public void selectFood(String name){
        if(isRestaurantSelected==false){
            System.out.println("Please select a restaurant first");
            System.out.println();
            return;
        }else{
            Food food = foodService.getFood(name);
            if(restaurant.isFoodAvailable(food)){
                cart.addFood(food);
            }else{
                System.out.println("Food selected is not available in this restaurant");
                System.out.println();
            }
        }
    }

    public void placeOrder(){
        if(cart.isEmpty()){
            System.out.println("You haven't selected food yet");
            System.out.println();
        }else{
            int bill_amount = orderService.placeOrder(cart);
            total_amount = bill_amount;
        }
    }

    public void checkCoupons(){
        orderService.checkAvailableCoupons();
    }

    public void applyCoupons(){
        int amount = orderService.applyPromoCodeCoupon(total_amount);
        total_amount = amount;
    }

    public void makeCardPayment(Card card){
        Payment payment = new CardPayment(card);
        if(payment.pay(total_amount)){
            System.out.println("Order is out for delivery");
            System.out.println();
        }
    }

    public void makeUpiPayment(UPI upi){
        Payment payment = new UpiPayment(upi);
        if(payment.pay(total_amount)){
            System.out.println("Order is out for delivery");
            System.out.println();
        }
    }
}
