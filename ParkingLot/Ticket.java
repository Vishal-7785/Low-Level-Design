public class Ticket {
    Vehicle vehicle;
    Slot slot;
    public Ticket(Vehicle vehicle, Slot slot){
        this.vehicle = vehicle;
        this.slot = slot;
    }

    public Vehicle getVehicle(){
        return vehicle;
    }

    public Slot getSlot(){
        return slot;
    }

    public int calculatePrice(){
        int slotPrice = slot.getPrice();
        int time = slot.getTime();
        return slotPrice*(time+10-time);
    }
}
