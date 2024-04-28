/*
 * User
 */

public class User {
    int id;
    String name;
    Card card;
    public User(int id, String name, Card card){
        this.id = id;
        this.name = name;
        this.card = card;
    }
    public int getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Card getCard(){
        return card;
    }
    
}
