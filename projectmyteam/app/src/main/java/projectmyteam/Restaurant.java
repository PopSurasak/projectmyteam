package projectmyteam;

class Restaurant {
    private String restaurantName;
    private String foodName;
    private String foodRecipe;
    private String foodIngrediant;
    private String totalIngrediant;
    private float foodPrice;

    public void createRestaurant(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void addFood(String foodName) {
        this.foodName = foodName;
    }

    public void addRecipe(String foodRecipe) {
        this.foodRecipe = foodRecipe;
    }

    public void addIngrediant(String foodIngrediant) {
        this.foodIngrediant = foodIngrediant;
    }

    public void addPrice(float foodPrice) {
        this.foodPrice = foodPrice;
    }
}