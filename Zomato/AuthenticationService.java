import java.util.List;

public class AuthenticationService {
    
    RestaurantService restaurantService;

    public AuthenticationService(){
        restaurantService = RestaurantService.getInstance();
    }

    public void login(User user, String password){
        if(user.getName() == "vishal" && password == "1234"){
            System.out.println("Login success! Showing you a list fo restaurants in your city");
            System.out.println();
            showRestaurants(user);
        }else{
            System.out.println("Login Failed :( incorrect username or password)");
            System.out.println();
        }
    }

    public void showRestaurants(User user){
        List<Restaurant> restaurants = restaurantService.getRestaurants(user.getAddress().getCity());
        if(restaurants == null){
            System.out.println("No restaurants in your city");
            System.out.println();
            return;
        }
        for(Restaurant restaurant: restaurants){
            System.out.printf("Restaurant name - %s, area name - %s, id - %d", restaurant.getName(),restaurant.getArea(),restaurant.getId());
            System.out.println();
        }
        System.out.println();
    }
}
