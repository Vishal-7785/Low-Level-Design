public interface Item {
    int price = 0;
    int id = 0;
    String name = "Default";
    public Boolean isSoldout = false;
    public int getPrice();
    public int getId();
    public String getName();
    public Boolean getSoldout();
    public void setSoldout(Boolean soldOut);

}
