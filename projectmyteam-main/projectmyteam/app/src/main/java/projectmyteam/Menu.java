package projectmyteam;

public class Menu
 {
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
}
