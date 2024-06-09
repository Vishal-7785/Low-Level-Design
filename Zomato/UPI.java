public class UPI {
    String upiID;
    int money;

    public UPI(String upiID, int money){
        this.upiID = upiID;
        this.money = money; 
    }

    public int getMoney(){
        return money;
    }

    public String getUser(){
        return upiID;
    }

    public void setMoney(int money){
        this.money = money;
    }
}
