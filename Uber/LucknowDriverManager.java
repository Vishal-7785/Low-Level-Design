import java.util.ArrayList;
import java.util.List;

public class LucknowDriverManager implements DriverManager{
    
    List<Driver> driverList;
    private LucknowDriverManager(){
        driverList = new ArrayList<>();
        System.out.println("Single for Lucknow Driver Manager called");
        System.out.println();
    }

    private static LucknowDriverManager lucknowDriverManager = null;

    public static LucknowDriverManager getInstance(){
        if(lucknowDriverManager == null){
            lucknowDriverManager = new LucknowDriverManager();
        }
        return lucknowDriverManager;
    }

    @Override
    public void connectDriver(Driver driver) {
        System.out.printf("Driver %s is online, he can take rides", driver.getName());
        System.out.println();
        System.out.println();
        driverList.add(driver);
    }

    @Override
    public void disconnectDriver(Driver driver) {
        System.out.printf("Driver %s is offline, he can not take rides",driver.getName());
        System.out.println();
        System.out.println();
        driverList.remove(driver);
    }
    
    @Override
    public List<Driver> getDrivers() {
        return driverList;
    }

    public Driver getDriver(int id){
        if(driverList.size()>0){
            for(Driver driver:driverList){
                if(driver.getID()==id){
                    return driver;
                }
            }
        }else{
            System.out.println("Driver searched is not active");
            System.out.println();
        }
        return null;
    }
}