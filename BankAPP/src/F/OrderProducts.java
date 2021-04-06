package F;

public class OrderProducts {
    private int productID;
    private double priceOfProduct;
    private int quantity;

    public OrderProducts(int productID, double priceOfProduct, int quantity) {
        this.productID = productID;
        this.priceOfProduct = priceOfProduct;
        this.quantity = quantity;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public double getPriceOfProduct() {
        return priceOfProduct;
    }

    public void setPriceOfProduct(double priceOfProduct) {
        this.priceOfProduct = priceOfProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
