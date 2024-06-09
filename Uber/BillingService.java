public class BillingService {
    
    Trip trip;

    public BillingService(Trip trip){
        this.trip = trip;
    }

    public int generateBill(){
        int a = calculateBaseCost();
        int b = calculateAdditionalCost();
        return a+b;
    }

    private int calculateBaseCost(){
        // TODO - here we can do some maths and calculate price based on distance, leaving for now
        System.out.println("Your base cost for trip is 1000 rupess");
        return 1000;
    }

    private int calculateAdditionalCost(){
        // TODO - here we can do get some info of weather, traffic and road condition and based on that 
        // we can include price, as of now leaving default as 200
        System.out.println("We have included additional 200 rupees due to bad weather");
        System.out.println();
        return 200;
    }
}
