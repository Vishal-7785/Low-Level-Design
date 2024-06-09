import java.util.*;
public interface DriverManager {

    public void connectDriver(Driver driver);
    public void disconnectDriver(Driver driver);
    public List<Driver> getDrivers();
    public Driver getDriver(int id);
    
}
