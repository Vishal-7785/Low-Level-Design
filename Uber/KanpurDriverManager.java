import java.util.*;
public class KanpurDriverManager implements DriverManager{
    
    List<Driver> driverList;
    private KanpurDriverManager(){
        driverList = new ArrayList<>();
        System.out.println("Singleton for Kanpur Driver Manager called");
        System.out.println();
    }

    private static KanpurDriverManager kanpurDriverManager = null;

    public static KanpurDriverManager getInstance(){
        if(kanpurDriverManager == null){
            kanpurDriverManager = new KanpurDriverManager();
        }
        return kanpurDriverManager;
    }

    @Override
    public void connectDriver(Driver driver) {
        driverList.add(driver);
    }

    @Override
    public void disconnectDriver(Driver driver) {
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
