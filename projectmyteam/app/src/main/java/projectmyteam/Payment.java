package projectmyteam;

class Payment {
    private float totalPrice;
    private float userPaid;

    public void orderPrice(String orderUser, float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean userPaid(float paid) {
        this.userPaid = paid;
        return paid >= totalPrice;
    }
}