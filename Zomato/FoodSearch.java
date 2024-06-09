import java.util.*;
public class FoodSearch implements Search{
    FoodServiceFactory foodServiceFactory;
    FoodService foodService;
    User user;
    public FoodSearch(User user){
        this.user = user;
        foodServiceFactory = new FoodServiceFactory();
        foodService = foodServiceFactory.getFoodService(user.getAddress().getCity());
    }
    @Override
    public void searchRestaurant(String query) {
        Food food = foodService.getFood(query);
        if(food == null){
            return;
        }
        List<Restaurant> restaurants = foodService.getRestaurants(food);
        for(Restaurant restaurant: restaurants){
            System.out.printf("Restaurant name - %s, area name - %s, id - %d", restaurant.getName(),restaurant.getArea(),restaurant.getId());
        }
        System.out.println();
    }


}
