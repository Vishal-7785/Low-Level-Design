public class Slot {
    SlotType slotType;
    Boolean isAvailable;
    int price;
    Vehicle vehicle;
    int time;

    public Slot(SlotType slotType,Boolean isAvailable,int price){
        this.slotType = slotType;
        this.isAvailable = isAvailable;
        this.price = price;
    }

    public Boolean getAvailability(){
        return isAvailable;
    }

    public void setAvailability(Boolean isAvailable){
        this.isAvailable = isAvailable;
    }

    public SlotType getSlotType(){
        return slotType;
    }

    public void setTime(int time){
        this.time = time;
    }

    public int getPrice(){
        return price;
    }

    public int getTime(){
        return time;
    }

    public void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle(){
        return vehicle;
    }
}
