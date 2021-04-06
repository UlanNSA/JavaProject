package F;

import java.util.Date;

public class Payment {
    private int id;
    private int clientId;
    private int orderId;
    private Date date;
    private boolean status;//– (after receipt in txt file is created, status becomes true!)
    private double orderTotalPrice;

    public int calculatePayment() {
        return 0;
    }

}
