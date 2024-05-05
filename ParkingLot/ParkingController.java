public class ParkingController {
    ParkingLot parkingLot;


    public ParkingController(){
        parkingLot = new ParkingLot("Shanu Parking", 1, new Address("Yashodan Nagar", "kanpur", "UP", 208011), 10);
    }

    public Ticket parkVehicle(Vehicle vehicle){

        System.out.println("Schedule parking for "+vehicle.getName()+" Vehicle Type is "+vehicle.getVehicleType()+" owner name "+vehicle.getOwner().getName());
        System.out.println();
        return parkingLot.parkVehicle(vehicle);
    }

    public void unparkVehicle(User user, Ticket ticket){
        int price = ticket.calculatePrice();
        System.out.println("Your parking charge for vehicle number "+ticket.getVehicle().getNumber()+" is "+ price);
        System.out.println();
        if(user.getCard().getMoney()<price){
            System.out.println("You can't take vehicle out, you don't have sufficient funds");
            return;
        }
        Slot slot = ticket.getSlot();
        slot.setAvailability(true);
        slot.setVehicle(null);
        slot.setTime(0);
        int currentMoney = user.getCard().getMoney();
        user.getCard().setMoney(currentMoney-price);

        System.out.println("Money "+price+ "  debitted from your card -: Curren Money "+user.getCard().getMoney());
    }
}
