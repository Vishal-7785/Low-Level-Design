public class Coke implements Item{
    public int price;
    public int id;
    public String name;
    public Boolean isSoldout; 
    public Coke(int price, int id, String name, Boolean isSoldout){
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
