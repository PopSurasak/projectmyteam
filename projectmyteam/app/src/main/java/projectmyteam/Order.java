package projectmyteam;

public class Order {
    private String orderUser;
    private String orderFood;
    private int orderQuantity;
    private float orderPrice;

    public void setOrderUser(String orderUser) {
        this.orderUser = orderUser;
    }

    public void setOrderInfo(String orderFood, int orderQuantity) {
        this.orderFood = orderFood;
        this.orderQuantity = orderQuantity;
    }

    public void setOrderPrice(float unitPrice) {
        this.orderPrice = unitPrice * orderQuantity;
    }

    public void printOrderDetails() {
        System.out.println("Order User: " + orderUser);
        System.out.println("Food: " + orderFood);
        System.out.println("Quantity: " + orderQuantity);
        System.out.println("Total Price: " + orderPrice);
    }
}
