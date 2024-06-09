public class User {
    int id;
    String name;
    String phone;
    String email;
    Card card;
    UPI upi;
    Address address;

    public User(int id,String email, UPI upi,Address address,String name){
        this.id = id;
        this.email = email;
        this.upi = upi;
        this.address = address;
        this.name = name;
    }

    public Card getCard(){
        return card;
    }

    public Address getAddress(){
        return address;
    }

    public UPI getUPI(){
        return upi;
    }

    public int getID(){
        return id;
    }

    public String getName(){
        return name;
    }

}
