public class Vehicle {
    
    User owner;
    String name;
    VehicleType vehicleType;
    int number;

    public Vehicle(User owner,String name, VehicleType vehicleType, int number){
        this.owner = owner;
        this.name = name;
        this.vehicleType = vehicleType;
        this.number = number;
    }

    public User getOwner(){
        return owner;
    }

    public String getName(){
        return name;
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }

    public int getNumber(){
        return number;
    }
}
