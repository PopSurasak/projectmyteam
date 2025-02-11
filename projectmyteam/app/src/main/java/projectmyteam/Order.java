package projectmyteam;

public class Order {
    private String orderUser;
    private String orderFood;
    private int orderQuantity;
    private float orderPrice;

    public void setOrderUser(String orderUser, String orderFood, int orderQuantity, float orderPrice) {
        this.orderUser = orderUser;
        this.orderFood = orderFood;
        this.orderQuantity = orderQuantity;
        this.orderPrice = orderPrice;
    }

    public void printOrderDetails() {
        System.out.println("Order User: " + orderUser);
        System.out.println("Food: " + orderFood);
        System.out.println("Quantity: " + orderQuantity);
        System.out.println("Total Price: " + orderPrice);
    }
}
