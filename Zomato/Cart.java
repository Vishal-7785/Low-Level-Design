import java.util.*;
public class Cart {

    List<Food> foodItems;
    public Cart(){
        foodItems = new ArrayList<>();
    }

    public void addFood(Food food){
        if(food.checkAvailability()){
            System.out.println("Food added to cart");
            System.out.println();
            foodItems.add(food);
        }else{
            System.out.println("Food selected is not available");
            System.out.println();
        }
        
    }

    public void removeFood(Food food){
        foodItems.remove(food);
    }

    public void emptyCart(){
        foodItems = new ArrayList<>();
    }

    public List<Food> getCartItems(){
        return foodItems;
    }

    public void showCart(){
        System.out.println("List of food items present in cart");
        System.out.println();

        for(Food food : foodItems){
            System.out.printf("Food name - %s, Food price - %d, Available - %b",food.getName(),food.getPrice(),food.checkAvailability());
        }
        System.out.println();
    }
    
    public boolean isEmpty(){
        if(foodItems.size()==0){
            return true;
        }
        return false;
    }

}
