public class Trip {
    int id;
    Location source;
    Location destination;
    User user;
    Driver driver;
    int billAmount;

    public Trip(int id,Location src, Location dst, User user){
        this.id = id;
        this.source = src;
        this.destination = dst;
        this.user = user;
    }

    public void setBill(int billAmount){
        this.billAmount = billAmount;
    }

    public void setDriver(Driver driver){
        this.driver = driver;
    }

    public Driver getDriver(){
        return driver;
    }

    public int getID(){
        return id;
    }
}
