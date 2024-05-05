public class User {
    
    String name;
    int id;
    Address address;
    Card card;

    public User(String name, int id,Address address, Card card){
        this.name = name;
        this.id = id;
        this.address = address;
        this.card = card;
    }

    public String getName(){
        return name;
    }

    public Card getCard(){
        return card;
    }

    public int getId(){
        return id;
    }

    public Address getAddress(){
        return address;
    }


    

    
}
