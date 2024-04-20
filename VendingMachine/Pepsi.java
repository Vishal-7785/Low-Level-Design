public class Pepsi implements Item{
    int price;
    int id;
    String name;
    Boolean isSoldout;
    public Pepsi(int price, int id, String name, Boolean isSoldout){
        this.price = price;
        this.id = id;
        this.name = name;
        this.isSoldout = isSoldout;
    }
    public int getPrice(){
        return price;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Boolean getSoldout(){
        return isSoldout;
    }
    public void setSoldout(Boolean soldOut){
        this.isSoldout = soldOut;
    }
}
