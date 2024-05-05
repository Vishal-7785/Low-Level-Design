public class Address {
    

    String area;
    String city;
    String state;
    int pinCode;

    public Address(String area, String city, String state, int pinCode){
        this.area = area;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }
    
    public String getArea(){
        return area;
    }

    public String getCity(){
        return city;
    }

    public String getState(){
        return state;
    }

    public int getPin(){
        return pinCode;
    }
}
