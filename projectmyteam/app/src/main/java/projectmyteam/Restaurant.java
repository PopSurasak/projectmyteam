package projectmyteam;

import java.util.HashMap;

public class Restaurant {
    private String restaurantName;
    private String foodName;
    private String foodIngrediant;
    private HashMap<String, String> foodRecipes = new HashMap<>();
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

    public void addRecipe(String foodRecipe) {
        if (foodName != null && foodRecipe != null && !foodName.trim().isEmpty() && !foodRecipe.trim().isEmpty()) {
            foodRecipes.put(foodName, foodRecipe);
        } else {
            System.out.println("A proper meal?");
        }
    }

    public void addIngrediant(String foodIngrediant) {
        if (foodIngrediant != null && !foodIngrediant.trim().isEmpty()) {
            this.foodIngrediant = foodIngrediant;
        } else {
            System.out.println("What are you cooking?");
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
