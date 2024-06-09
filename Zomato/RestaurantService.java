import java.util.*;
public class RestaurantService {
    List<Restaurant> restaurantList;
    HashMap<CITY,List<Restaurant>> cityRestroMap;
    HashMap<String,Restaurant> nameRestroMap;

    private static RestaurantService restaurantService=null;

    private RestaurantService(){
        cityRestroMap = new HashMap<>();
        nameRestroMap = new HashMap<>();
        restaurantList = new ArrayList<>();
    }

    public static synchronized RestaurantService getInstance(){
        if(restaurantService == null){
            restaurantService = new RestaurantService();
            return restaurantService;
        }
        return restaurantService;
    }

    public void addRestaurant(Restaurant restaurant){
        System.out.println("Adding restaurants in restaurant service");
        System.out.println();
        restaurantList.add(restaurant);
        nameRestroMap.put(restaurant.name, restaurant);
        addCityRestro(restaurant);
    }

    private void addCityRestro(Restaurant restaurant){
        System.out.println("Adding restaurant to city map");
        System.out.println();
        if (cityRestroMap.containsKey(restaurant.getCity())) {
            cityRestroMap.get(restaurant.getCity()).add(restaurant);
        } else {
            List<Restaurant> newList = new ArrayList<>();
            newList.add(restaurant);
            cityRestroMap.put(restaurant.getCity(), newList);
        }
    }

    public Restaurant getRestaurant(String name,User user){
        List<Restaurant> restaurants = cityRestroMap.get(user.getAddress().getCity());
        if(restaurants==null){
            System.out.println("Restaurant you searched is not present in your city");
            System.out.println();
            return null;
        }
        for(Restaurant restaurant: restaurants){
            if(restaurant.getName()==name){
                return restaurant;
            }
        }
        System.out.println("Restaurant you searched is not present in your city");
        System.out.println();
        return null;
        
    }

    public List<Restaurant> getRestaurants(CITY city){
        if(cityRestroMap.containsKey(city)){
            return cityRestroMap.get(city);
        }
        System.out.println("Oops! No restaurant present in your city");
        System.out.println();
        return null;
    }

}
