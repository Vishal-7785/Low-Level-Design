import java.util.*;
public class CabBookingService {
    DriverManagerFactory driverManagerFactory;
    DriverManager driverManager;
    User user;
    public CabBookingService(User user){
        this.user = user;
        driverManagerFactory = new DriverManagerFactory();
        driverManager = driverManagerFactory.getDriverManager(user.getAddress().getCity());
    }

    public void bookCab(Location src, Location dst,Trip trip){
        List<Driver> driverList= driverManager.getDrivers();
        callDrivers(driverList,src,trip);
    }

    public void callDrivers(List<Driver> driverList,Location source,Trip trip){

        if(driverList.size()==0){
            System.out.println("no driver present to take trip");
            System.out.println();
            trip = null;
            return;
        }
        for(Driver driver : driverList){
            if(driver.getStatus()!=DRIVERSTATUS.ACTIVE){
                System.out.println("Skipping call to driver, bcz driver is busy");
            }else{
                boolean driverResponse = driver.call(source);
                if(driverResponse){
                    trip.setDriver(driver);
                    System.out.println("Driver came to pick up please validate OTP and start your ride");
                    System.out.println();
                    return;
                }
            }
        }
        System.out.println("no driver present to take trip");
        System.out.println();
        trip = null;
        return;
    }
}
