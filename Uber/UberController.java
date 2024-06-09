public class UberController {

    AuthenticationStrategy authenticationStrategy;
    CabBookingService cabBookingService;
    OtpService otpService;
    BillingService billingService;
    User user;
    Trip trip;
    int totalBill = 0;
    public UberController(AuthenticationStrategy authenticationStrategy,User user){
        System.out.println("Uber controller initiated! ");
        System.out.println();
        this.user = user;
        this.authenticationStrategy = authenticationStrategy;

        cabBookingService = new CabBookingService(user);
        otpService = new OtpService();
    }

    public void login(){
        authenticationStrategy.login();
    }

    public void bookCab(Location src, Location dst){
        trip = new Trip(1, src, dst, user);
        cabBookingService.bookCab(src, dst,trip);
    }

    public void validateOtp(){
        if(user.validateOtp()){
            System.out.println("Creating trip object");
            System.out.println();
        }
    }

    public void completeRide(Driver driver){
        driver.rideComplete();
        System.out.println("Initiating billing service ");
        System.out.println();        
    }

    public void initiateBill(){
        billingService = new BillingService(trip);
        int billAmount = billingService.generateBill();
        totalBill = billAmount;
        System.out.printf("Your total cost for trip is %d, please pay",billAmount);
        System.out.println();
        System.out.println();
    }

    public void makePayment(Payment payment){
        if(payment.pay(totalBill)){
            System.out.println("Thank you for choosing uber!");
            System.out.println();
            System.out.println("Settling up drivers patment");
            System.out.println();

            Driver driver = trip.getDriver();
            int currentMoney = driver.getCard().getMoney();
            System.out.printf("Driver current balance is %d",currentMoney);
            System.out.println();
            driver.getCard().setMoney(currentMoney+500);

            System.out.printf("Driver updated balance is %d",currentMoney+500);
            System.out.println();
            System.out.println();
        }else{
            System.out.println("please choose a different payment method to pay");
        }
    }
}
