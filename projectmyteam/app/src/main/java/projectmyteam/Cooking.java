package projectmyteam;

class Cooking {
    private String orderedFood;
    private String foodIngrediant;
    private String totalIngrediant;
    private int quantityIngrediant;

    public void startCooking(String orderedFood) {
        this.orderedFood = orderedFood;
        System.out.println("Cooking started for: " + orderedFood);
    }

    public void finishCooking(String orderedFood) {
        System.out.println("Cooking finished for: " + orderedFood);
    }

    public void sendOrder(String orderedFood) {
        System.out.println("Order sent for: " + orderedFood);
    }

    public void cancelOrder(String orderedFood) {
        System.out.println("Order canceled for: " + orderedFood);
    }

    public boolean checkIngrediant() {
        if (totalIngrediant != null && !totalIngrediant.isEmpty()) {
            System.out.println("Ingredients available for: " + orderedFood);
            return true;
        } else {
            System.out.println("Not enough ingredients for: " + orderedFood);
            return false;
        }
    }

    public void updateIngrediant(String newIngrediant, int quantity) {
        this.foodIngrediant = newIngrediant;
        this.quantityIngrediant = quantity;
        this.totalIngrediant = (this.totalIngrediant == null ? "" : this.totalIngrediant + ", ") + newIngrediant;
        System.out.println("Updated ingredients: " + this.totalIngrediant);
    }
}
