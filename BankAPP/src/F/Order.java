package F;

import java.util.ArrayList;

public class Order {
    private int id;
    private int clientId;
    private ArrayList<OrderProducts> productIds;
    private double totalPrice;

    public Order(int id, int clientId, ArrayList<OrderProducts> productIds, double totalPrice) {
        this.id = id;
        this.clientId = clientId;
        this.productIds = productIds;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public ArrayList<OrderProducts> getProductIds() {
        return productIds;
    }

    public void setProductIds(ArrayList<OrderProducts> productIds) {
        this.productIds = productIds;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", productIds=" + productIds +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
