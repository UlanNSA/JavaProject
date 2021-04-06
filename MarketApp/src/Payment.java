import java.util.Date;

public class Payment {
    private int id;
    private int clientId;
    private int orderId;
    private Date date;
    private boolean status;
    private double orderTotalPrice;

    public Payment(int id, int clientId, int orderId, Date date, boolean status, double orderTotalPrice) {
        this.id = id;
        this.clientId = clientId;
        this.orderId = orderId;
        this.date = date;
        this.status = status;
        this.orderTotalPrice = orderTotalPrice;
    }

    public int calculatePayment(){
        return 0;
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

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(double orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }
}
