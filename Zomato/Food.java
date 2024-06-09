public class Food {
    CUISINETYPE cuisine_type;
    String name;
    int id;
    int price;
    boolean isAvailale;

    public Food(CUISINETYPE cuisine_type, String name, int id, int price, boolean isAvailale ){
        
        System.out.printf("Constructing food item of name : %s",name);
        System.out.println();
        this.cuisine_type = cuisine_type;
        this.name = name;
        this.id = id;
        this.price = price;
        this.isAvailale = isAvailale;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public void setAvailability(boolean isAvailale){
        this.isAvailale = isAvailale;
    }

    public String getName(){
        return name;
    } 

    public int getPrice(){
        return price;
    }

    public boolean checkAvailability(){
        return isAvailale;
    }
}
