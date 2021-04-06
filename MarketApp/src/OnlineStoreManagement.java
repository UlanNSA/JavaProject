import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OnlineStoreManagement {
    private ArrayList<Product> products;
    private ArrayList<Client> clients;
    private ArrayList<Order> orders;
    private ArrayList<Tastamat> tastamats;

    public OnlineStoreManagement(ArrayList<Product> products, ArrayList<Client> clients, ArrayList<Order> orders) {
        this.products = products;
        this.clients = clients;
        this.orders = orders;
    }

    //Tastamat
    public ArrayList<Tastamat> tastamatsFile(){
        String line;
        ArrayList<Tastamat> address = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Tastamat.txt"));
            while((line = reader.readLine()) != null){
                String[] str = line.split(";");
                address.add(new Tastamat(Integer.parseInt(str[0]), str[1], str[2]));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return address;
    }

    //Payment
    public void draft(Client client, Order order){
        Payment payment;
        System.out.println("Enter id of payment");
        int id = Main.scanner.nextInt();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        boolean status = true;
        payment = new Payment(id, client.getId(), order.getId(), date, status, order.getTotalPrice());
        try {
            FileWriter writer = new FileWriter("receipt.txt", true);
            writer.write(payment.toString());
            writer.append("\n");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Delivery
    public void makeDelivery(){
        for(Client i: clients){
            System.out.println(i);
        }

        System.out.println("Enter client's id");
        int id = Main.scanner.nextInt();

        for(Client i: clients){
            if(i.getId() == id){
                System.out.println("Enter[1] to direct delivery" +
                        "\nEnter[2] to tastamat delivery");

                int choice = Main.scanner.nextInt();
                switch (choice){
                    case 1:{
                        System.out.println("Enter city");
                        Main.scanner.nextLine();
                        String city = Main.scanner.nextLine();
                        System.out.println("Enter street");
                        String street = Main.scanner.nextLine();
                        System.out.println("Enter house number");
                        int number = Main.scanner.nextInt();
                        System.out.println("Enter flat nubmer");
                        int flatNumber = Main.scanner.nextInt();

                        DirectDelivery directDelivery = new DirectDelivery(city,street,number,flatNumber);
                        System.out.println("Succesfully deliveried");
                        break;
                    }
                    case 2:{
                        tastamats = tastamatsFile();

                        for(Tastamat tastamat: tastamats){
                            System.out.println(tastamat);
                        }
                        System.out.println("Enter number of tastamat");
                        int number = Main.scanner.nextInt();
                        System.out.println("Succesfully deliveried");
                        break;
                    }
                }
            }
        }


    }

    //Prime and Loyal Client
    public void changeClient(){

        for(Client i: clients){
            if(i.getOrderHistory().size() >= 1 && i.getOrderHistory().size() < 10 && !(i instanceof PrimeClient) && !(i instanceof LoyalClient) ){
                PrimeClient primeClient = new PrimeClient(i.getId(), i.getName(), i.getSurname(), i.getOrderHistory(), 5);
                i = primeClient;
            }
            else if(i.getOrderHistory().size() >= 10 && !(i instanceof LoyalClient)){
                LoyalClient loyalClient = new LoyalClient(i.getId(), i.getName(), i.getSurname(), i.getOrderHistory(), 5,0);
                i = loyalClient;
            }
        }

    }

    //Create
    public void createClient(){
        System.out.println("Enter client's id");
        int id = Main.scanner.nextInt();
        System.out.println("Enter client's name");
        Main.scanner.nextLine();
        String name = Main.scanner.nextLine();
        System.out.println("Enter client's surname");
        String surname = Main.scanner.nextLine();

        ArrayList<Order> orders = new ArrayList<>();
        Client client = new OrdinaryClient(id,name,surname, orders);

        clients.add(client);
        System.out.println("Created succesfully");
    }

    public void createOrder(){
        for(Client i: clients){
            System.out.println(i);
        }
        System.out.println("Enter client's id");
        int clientId = Main.scanner.nextInt();

        for(Client client: clients) {

            if (client.getId() == clientId) {
                System.out.println("Enter order's id");
                int id = Main.scanner.nextInt();
                boolean temp = true;
                ArrayList<OrderProducts> orderProductsArrayList = new ArrayList<>();
                double totalPrice = 0;
                double price = 0;
                while (temp) {
                    System.out.println("Enter[1] to add product to order" +
                            "\nEnter[2] to exit");
                    int choice = Main.scanner.nextInt();
                    switch (choice) {
                        case 1:{

                            for (Product i : products) {
                                System.out.println(i);
                            }

                            System.out.println("Enter product's id");
                            int productsId = Main.scanner.nextInt();
                            System.out.println("Enter amount of product");
                            int amountOfProduct = Main.scanner.nextInt();

                            for (Product i : products) {
                                if (i.getId() == productsId) {
                                    if (i.getAmountInStock() < amountOfProduct) {
                                        System.out.println("We don't have enough amount of this product");
                                    } else {
                                        OrderProducts orderProducts = new OrderProducts(productsId, i.getPrice(), amountOfProduct);
                                        orderProductsArrayList.add(orderProducts);
                                        i.setAmountInStock(i.getAmountInStock() - amountOfProduct);

                                        totalPrice = i.getPrice() * amountOfProduct;
                                        if (client instanceof PrimeClient) {
                                            totalPrice = totalPrice - (totalPrice * ((PrimeClient) client).getDiscount());
                                        } else if (client instanceof LoyalClient) {
                                            ((LoyalClient) client).setCashback(((LoyalClient) client).getCashback() + totalPrice * 0.1);
                                            totalPrice = totalPrice - (totalPrice * ((LoyalClient) client).getDiscount());
                                        }

                                        price += totalPrice;
                                    }
                                }
                            }
                            changeClient();
                            break;
                        }
                        case 2: {
                            temp = false;
                            break;
                        }
                        default:
                            System.out.println("Incorrect input");
                            break;
                    }
                }
                Order order = new Order(id, client.getId(), orderProductsArrayList, price);
                client.getOrderHistory().add(order);
                draft(client, order);
                orders.add(order);
                System.out.println("Created completed");
            }
        }
    }

    public void createProduct(){
        System.out.println("Enter product's id");
        int id = Main.scanner.nextInt();
        System.out.println("Enter product's name");
        Main.scanner.nextLine();
        String name = Main.scanner.nextLine();
        System.out.println("Enter product's price");
        double price = Main.scanner.nextDouble();
        System.out.println("Enter product's amount in stock");
        int amount = Main.scanner.nextInt();

        Product product = new Product(id,name,price,amount);
        products.add(product);
        System.out.println("Created completed");
    }

    //Update
    public void updateClient(){

        for(Client i: clients){
            System.out.println(i);
        }

        System.out.println("Enter client's id to update");
        int id = Main.scanner.nextInt();

        for(Client i: clients){
            if(i.getId() == id){
                System.out.println("Enter new client's name ");
                Main.scanner.nextLine();
                String name = Main.scanner.nextLine();
                System.out.println("Enter new client's surname");
                String surname = Main.scanner.nextLine();

                Client newClient = new Client(i.getId(), name, surname, i.getOrderHistory());
                i = newClient;
                System.out.println("Updated completed");
            }
        }
    }

    public void updateOrder(){
        for(Client i: clients){
            System.out.println(i);
        }

        System.out.println("Enter client's id");
        int id = Main.scanner.nextInt();

        for(Client i: clients){
            if(i.getId() == id){
                for(Order order:i.getOrderHistory()){
                    System.out.println(order);
                }

                System.out.println("Enter order's id");
                int orderId = Main.scanner.nextInt();
                for(Order order:i.getOrderHistory()){
                    if(order.getId() == orderId){
                        for(OrderProducts orderProducts: order.getProductIds()){
                            System.out.println(orderProducts);
                        }

                        System.out.println("Enter order products id");
                        int orderProductId = Main.scanner.nextInt();

                        for(OrderProducts orderProducts: order.getProductIds()){
                            if(orderProducts.getProductId() == orderProductId){
                                System.out.println(orderProducts.getQuantity());
                                System.out.println("Enter new amount of product");
                                int amount = Main.scanner.nextInt();
                                orderProducts.setQuantity(amount);

                                for(Product p: products) {
                                    if(p.getId() == orderProducts.getProductId()) {
                                        if(p.getAmountInStock() > amount) {
                                            order.setTotalPrice(orderProducts.getPriceOfProduct() * amount);
                                            System.out.println("Updated succesfully");
                                        }
                                        else
                                            System.out.println("We don't have enough amount of this product");
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }

    }

    public void updateProduct(){
        for(Product i: products){
            System.out.println(i);
        }
        System.out.println("Enter id of product");
        int id = Main.scanner.nextInt();

        for(Product i: products){
            if(i.getId() == id){
                System.out.println("Enter product's name");
                String name = Main.scanner.nextLine();
                System.out.println("Enter product's price");
                double price = Main.scanner.nextDouble();
                System.out.println("Enter product's amount");
                int amount = Main.scanner.nextInt();

                i.setName(name);
                i.setPrice(price);
                i.setAmountInStock(amount);
                System.out.println("Updated completed");
            }
        }

    }

    //Delete
    public void deleteClient(){
        for(Client i: clients){
            System.out.println(i);
        }
        System.out.println("Enter id of client");
        int id = Main.scanner.nextInt();

        for(Client i: clients){
            if(i.getId() == id){
                clients.remove(i);
                System.out.println("Deleted completed");
            }
        }

    }

    public void deleteOrder(){
        for(Client i: clients){
            System.out.println(i);
        }
        System.out.println("Enter id of client");
        int id = Main.scanner.nextInt();

        for(Client i: clients){
            if(i.getId() == id){
                for(Order order: i.getOrderHistory()){
                    System.out.println(order);
                }
                System.out.println("Enter id of order");
                int orderId = Main.scanner.nextInt();

                for(Order order: i.getOrderHistory()){
                    if(order.getId() == orderId){
                        orders.remove(order);
                        i.setOrderHistory(new ArrayList<Order>());
                        System.out.println("Deleted completed");
                    }
                }

            }
        }

    }

    public void deleteProduct(){
        for(Product i: products){
            System.out.println(i);
        }
        System.out.println("Enter id of product");
        int id = Main.scanner.nextInt();

        for(Product i: products){
            if(i.getId() == id){
                products.remove(i);
                System.out.println("Deleted completed");
            }
        }
    }

    //Getter & Setter
    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
