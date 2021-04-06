package F;

import java.util.ArrayList;

public class LoyalClient extends Client{
    private int discount;
    private double Double;

    public LoyalClient(int id, String name, String surname, ArrayList<Order> orderHistory, int discount, double aDouble) {
        super(id, name, surname, orderHistory);
        this.discount = discount;
        Double = aDouble;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getDouble() {
        return Double;
    }

    public void setDouble(double aDouble) {
        Double = aDouble;
    }

    @Override
    public String toString() {
        return "LoyalClient{" +
                "discount=" + discount +
                ", Double=" + Double +
                '}';
    }
}

