package projectmyteam;

public class Restaurant {
    private String restaurantName;
    private String foodName;
    private String foodPrice;

    public Restaurant(String restaurantName) {
        if (restaurantName != null && !restaurantName.trim().isEmpty()) {
            this.restaurantName = restaurantName;
        }
    }

    public String getRestaurantName() { 
        return restaurantName; 
    }

    public void addFood(String foodName) {
        if (foodName != null && !foodName.trim().isEmpty()) {
            this.foodName = foodName;
        }
    }

    public void addPrice(double price) {
        if (price > 0) {
            this.foodPrice = foodPrice;
        }
    }
}