package projectmyteam;

import java.util.HashMap;

public class Restaurant {
    private String restaurantName;
    private String foodName;
    private HashMap<String, Float> foodPrices = new HashMap<>();

    public void createRestaurant(String restaurantName) {
        if (restaurantName != null && !restaurantName.trim().isEmpty()) {
            this.restaurantName = restaurantName;
        } else {
            System.out.println("Put a name or we will put it for you");
        }
    }

    public void addFood(String foodName) {
        if (foodName != null && !foodName.trim().isEmpty()) {
            this.foodName = foodName;
        } else {
            System.out.println("Nothing? Really?");
        }
    }

    public void addPrice(String foodName, float foodPrice) {
        if (foodName != null && foodPrice > 0) {
            foodPrices.put(foodName, foodPrice);
        } else {
            System.out.println("Are you giving it out for free?");
        }
    }
}
