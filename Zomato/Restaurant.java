import java.util.*;
public class Restaurant {
    List<Food> foodItems;
    String name;
    CITY city;
    String street;
    int id;
    FoodServiceFactory foodServiceFactory;
    FoodService foodService;
    RestaurantService restaurantService;

    public Restaurant(int id, String name, CITY city,String street){
        restaurantService = RestaurantService.getInstance();
        this.id = id;
        this.name = name;
        this.city = city;
        this.street = street;
        foodServiceFactory = new FoodServiceFactory();
        foodService = foodServiceFactory.getFoodService(city);
        foodItems = new ArrayList<>();

        addFood(new Food(CUISINETYPE.INDIAN,"Dal",1,120,true));
        addFood(new Food(CUISINETYPE.INDIAN,"Rice",2,80,true));
        addFood(new Food(CUISINETYPE.INDIAN,"Chicken Korma",3,300,true));
        addFood(new Food(CUISINETYPE.INDIAN,"Mutton",4,500,true));
        addFood(new Food(CUISINETYPE.INDIAN,"Roti",5,50,true));

        System.err.println();
        restaurantService.addRestaurant(this);
    }

    public void addFood(Food food){
        foodItems.add(food);
        foodService.addFood(food, this);
    }

    public void removeFood(Food food){
        foodItems.remove(food);
    }

    public void showFoodItems(){
        for(Food food : foodItems){
            System.out.printf("Food name - %s, Food price - %d, Available - %b",food.getName(),food.getPrice(),food.checkAvailability());
            System.out.println();
        }
        System.out.println();
    }

    public String getName(){
        return name;
    }

    public String getArea(){
        return street;
    }

    public int getId(){
        return id;
    }

    public boolean isFoodAvailable(Food food){
        for(Food f: foodItems){
            if(f==food){
                return true;
            }
        }
        return false;
    }
    
    public CITY getCity(){
        return city;
    }
}
