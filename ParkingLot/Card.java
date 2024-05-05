public class Card {
    int id;
    String name;
    int money;
    public Card(int id,String name,int money){
        this.id = id;
        this.name = name;
        this.money = money;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getMoney(){
        return money;
    }
    public void setMoney(int money){
        this.money = money;
    }
}
