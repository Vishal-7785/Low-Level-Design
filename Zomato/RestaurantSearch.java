public class RestaurantSearch implements Search{
    
    RestaurantService restaurantService;
    User user;
    public RestaurantSearch(User user){
        restaurantService = RestaurantService.getInstance();
        this.user = user;
    }
    @Override
    public void searchRestaurant(String query) {
        Restaurant restaurant = restaurantService.getRestaurant(query,user);
        if(restaurant == null){
            System.out.println("No restauran with given name in your city");
            System.out.println();
            return;
        }
        System.out.printf("Restaurant name - %s, area name - %s, id - %d", restaurant.getName(),restaurant.getArea(),restaurant.getId());
        System.out.println();
        System.out.println();
    }

}
