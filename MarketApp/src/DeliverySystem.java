public class DeliverySystem {
    private int orderId;
    private int clientId;
    private int invoiceNumber;

    public DeliverySystem(int orderId, int clientId, int invoiceNumber) {
        this.orderId = orderId;
        this.clientId = clientId;
        this.invoiceNumber = invoiceNumber;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
}
