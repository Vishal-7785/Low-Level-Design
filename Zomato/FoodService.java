import java.util.*;
public interface FoodService {
    
    public void addFood(Food f,Restaurant restaurant);
    public List<Restaurant> getRestaurants(Food f);
    public void removeFood(Food f, Restaurant restaurant);
    public Food getFood(String foodName);
}
