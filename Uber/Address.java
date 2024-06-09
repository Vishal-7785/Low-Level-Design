public class Address {
    int pincode;
    String street;
    CITY city;
    String state;

    public Address(int pincode, String street, CITY city,String state){
        this.pincode = pincode;
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public int getPincode(){
        return pincode;
    }

    public String getStreet(){
        return street;
    }

    public CITY getCity(){
        return city;
    }

    public String getState(){
        return state;
    }
}
