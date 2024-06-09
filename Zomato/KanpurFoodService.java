import java.util.*;

public class KanpurFoodService implements FoodService{

    HashMap<Food,List<Restaurant>> foodRestroMap;
    HashMap<String,Food> fooddNameMap;
    private static KanpurFoodService kanpurFoodService=null;
    private KanpurFoodService(){
        System.out.println("Signleton contructor callled for Kanpur Food Service");
        System.out.println();
        foodRestroMap = new HashMap<>();
        fooddNameMap = new HashMap<>();
    }


    public static KanpurFoodService getInstance(){
        if(kanpurFoodService == null){
            kanpurFoodService = new KanpurFoodService();
            return kanpurFoodService;
        }
        return kanpurFoodService;
    }
    @Override
    public void addFood(Food food,Restaurant restaurant) {
        if (foodRestroMap.containsKey(food)) {
            foodRestroMap.get(food).add(restaurant);
        } else {
            List<Restaurant> newList = new ArrayList<>();
            newList.add(restaurant);
            foodRestroMap.put(food, newList);
        }
        fooddNameMap.put(food.getName(),food);
    }

    @Override
    public List<Restaurant> getRestaurants(Food food) {
        if (foodRestroMap.containsKey(food)){
            List<Restaurant> restaurants = foodRestroMap.get(food);
            return restaurants;
        }
        System.out.println("No restaurant contains the food you searched");
        System.err.println();
        return null;
    }


    @Override
    public void removeFood(Food food, Restaurant restaurant) {
            if (foodRestroMap.containsKey(food)) {
                List<Restaurant> list = foodRestroMap.get(food);
    
                list.remove(restaurant);
    
                if (list.isEmpty()) {
                    foodRestroMap.remove(food);
                }
            }
    }


    @Override
    public Food getFood(String foodName) {
        if(fooddNameMap.containsKey(foodName)){
            return fooddNameMap.get(foodName);
        }
        return null;
    }
    
}
