package projectmyteam;

class Order {
    private String orderUser;
    private String orderFood;
    private int orderQuantity;
    private float orderPrice;

    public void orderUser(String orderUser) {
        this.orderUser = orderUser;
    }

    public void orderInfo(String orderFood, int orderQuantity) {
        this.orderFood = orderFood;
        this.orderQuantity = orderQuantity;
    }

    public void orderPrice(float orderPrice) {
        this.orderPrice = orderPrice;
    }
}