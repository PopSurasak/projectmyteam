package projectmyteam;

public class Promotion {
    private String description;
    private double discount;

    public Promotion(String description, double discount) {
        this.description = description;
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public double getDiscount() {
        return discount;
    }
}
