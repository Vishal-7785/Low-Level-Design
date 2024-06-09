public class FoodServiceFactory {
    FoodService foodService;

    public FoodService getFoodService(CITY city){
        switch(city){
            case CITY.KANPUR:
                System.out.println("FoodServiceFactory is getting the instance for kanpurFoodService object");
                System.out.println();
                return KanpurFoodService.getInstance();
            case CITY.LUCKNOW:
                System.out.println("FoodServiceFactory is getting the instance for lucknowFoodService object");
                return LucknowFoodService.getInstance();
            default :
                return null;
        }
    }
}
