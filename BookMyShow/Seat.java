public class Seat {
    Boolean isAvailable;
    int number;
    int price;

    public Seat(Boolean isAvailable, int number, int price){
        this.isAvailable = isAvailable;
        this.number = number;
        this.price = price;
    }

    public Boolean getAvailable(){
        return isAvailable;
    }
    public void setAvailable(Boolean isAvailable){
        this.isAvailable = isAvailable;
    }

    public int getNumber(){
        return number;
    }

    public int getPrice(){
        return price;
    }
}
