public class Card {
    User user;
    int money;

    public Card( int money){
        this.money = money; 
    }

    public int getMoney(){
        return money;
    }

    public User getUser(){
        return user;
    }

    public void setMoney(int money){
        this.money = money;
    }
}