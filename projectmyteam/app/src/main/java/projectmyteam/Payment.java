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

    public String getChange() {
        float change = userPaid - totalPrice;
        if (change > 0) {
            return "Change: " + change;
        } else if (change < 0) {
            return "Pay more: " + (-change);
        } else {
            return "Thank you";
        }
    }
}
