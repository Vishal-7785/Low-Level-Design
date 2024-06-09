public class Driver {
    String name;
    String email;
    String phone;
    int id;
    Card card;
    CITY city;
    String otp = "";
    OtpService otpService;
    DriverManagerFactory driverManagerFactory;
    DriverManager driverManager;
    DRIVERSTATUS driverStatus;
    Location location;

    public Driver(int id,String name, String phone, CITY city,Card card){
        location = new Location(1,1);
        driverStatus = DRIVERSTATUS.INACTIVE;
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.city = city;
        this.card = card;
        otpService = new OtpService();
        driverManagerFactory = new DriverManagerFactory();
        driverManager = driverManagerFactory.getDriverManager(city);
    }

    public void connect(){
        driverStatus = DRIVERSTATUS.ACTIVE;
        driverManager.connectDriver(this);
    }

    public void disconnect(){
        driverStatus = DRIVERSTATUS.INACTIVE;
        driverManager.disconnectDriver(this);
    }

    public String getName(){
        return name;
    }

    public Card getCard(){
        return card;
    }

    public int getID(){
        return id;
    }

    public boolean call(Location loc){
        int a = Math.abs(loc.getX()-location.getX());
        int b = Math.abs(loc.getY()-location.getY());
        int distance = a+b;
        if(distance<10){
            System.out.printf("Driver %s has accepted the ride, he'll be going to pick customer",name);
            System.out.println();
            System.out.println();
            driverStatus = DRIVERSTATUS.DRIVING;
            otp = otpService.generateOtp();
            return true;
        }else{
            System.out.printf("Driver %s has rejected the ride", name);
            System.out.println();
            System.out.println();
            return false;
        }
    }

    public void rideComplete(){
        System.out.println("Ride Completed! ");
        System.out.println();
        otp = "";
        driverStatus = DRIVERSTATUS.ACTIVE;
    }

    public DRIVERSTATUS getStatus(){
        return driverStatus;
    }
}
