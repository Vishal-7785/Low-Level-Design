import java.util.*;
public class ParkingLot {
    String name;
    int id;
    Address address;
    List<Floor> floorList;
    int numberOfFloors;
    public ParkingLot(String name, int id, Address address, int numberOfFloors){
        floorList = new ArrayList<Floor>();
        this.name = name;
        this.id = id;
        this.address = address;
        this.numberOfFloors = numberOfFloors;
        initializeFloors(numberOfFloors);
    }

    public void initializeFloors(int numberOfFloors){
        for(int i=0;i<numberOfFloors;i++){
            Floor floor = new Floor();
            floorList.add(floor);
        }
    }

    public Ticket parkVehicle(Vehicle vehicle){
        SlotType slotType = getSlotType(vehicle);
        Slot slot = getAvailableSlot(slotType);
        if(slot == null){
            System.out.println("Sorry! We don't have any parking space available");
            System.out.println();
            return null;
        }
        System.out.println("Got a slot for "+ vehicle.getNumber()+" going to park");
        System.out.println();
        park(vehicle,slot);
        System.out.println("Collect ticlet and make sure to keep safe this will be needed when unparking your vehicle");
        System.out.println();
        return new Ticket(vehicle,slot);

    }

    public SlotType getSlotType(Vehicle vehicle){
        if(vehicle.getVehicleType()==VehicleType.BUS || vehicle.getVehicleType()==VehicleType.TRUCK){
            return SlotType.BIG;
        }else if(vehicle.getVehicleType()==VehicleType.CAR || vehicle.getVehicleType()==VehicleType.TEMPO){
            return SlotType.MEDIUM;
        }else{
            return SlotType.SMALL;
        }
    }

    public Slot getAvailableSlot(SlotType slotType){
        for(int i=0;i<numberOfFloors;i++){
            Floor f = floorList.get(i);
            Slot s = f.getSlot(slotType);
            if(s!=null){
                return s;
            }
        }
        return null;
    }

    public void park(Vehicle vehicle, Slot slot){

        System.out.println("Vehicle "+vehicle.getName()+ " parked, getting ticket ready");
        System.out.println();

        slot.setVehicle(vehicle);
        slot.setAvailability(false);
        slot.setTime(1);
        
    }


}
