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

    public boolean checkIngrediant(String orderedFood) {
        // Placeholder
        return true;
    }

    public void updateIngrediant(String foodIngrediant) {
        System.out.println("Ingredient updated: " + foodIngrediant);
    }
}
