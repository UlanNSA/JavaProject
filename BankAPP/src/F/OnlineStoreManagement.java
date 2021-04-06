package F;

import java.util.ArrayList;

public class OnlineStoreManagement {
    private ArrayList<Product> products;
    private ArrayList<Client> clients;
    private ArrayList<Order> orders;

    public OnlineStoreManagement(ArrayList<Product> products, ArrayList<Client> clients, ArrayList<Order> orders) {
        this.products = products;
        this.clients = clients;
        this.orders = orders;
    }

    //Create
    public void createClient() {
        System.out.println("Enter client's id");
        int id = Main.scanner.nextInt();
        System.out.println("Enter client's name");
        Main.scanner.next();
        String name = Main.scanner.nextLine();
        System.out.println("Enter client's surname");
        String surname = Main.scanner.nextLine();

        ArrayList<Order> orders = new ArrayList<>();
        Client client = new Client(id, name, surname, orders);

        clients.add(client);
        System.out.println("Created succesfully");
    }

    public void createOrder(Client client) {
        System.out.println("Enter order's id");
        int id = Main.scanner.nextInt();
        boolean temp = true;
        ArrayList<OrderProducts> orderProductsArrayList = new ArrayList<>();
        double totalPrice = 0;
        while (temp) {
            System.out.println("Enter[1] to add product to order" +
                    "\nEnter[2] to exit");
            int choice = Main.scanner.nextInt();
            switch (choice) {
                case 1:

                    for (Product i : products) {
                        System.out.println(i);
                    }

                    System.out.println("Enter product's id");
                    int productsId = Main.scanner.nextInt();
                    System.out.println("Enter amount of product");
                    int amountOfProduct = Main.scanner.nextInt();
                    if (products.get(productsId).getAmountInStock() < amountOfProduct) {
                        System.out.println("We don't have enough amount of this product");
                    } else {
                        OrderProducts orderProducts = new OrderProducts(productsId, products.get(productsId).getPrice(), amountOfProduct);
                        orderProductsArrayList.add(orderProducts);
                        products.get(productsId).setAmountInStock(products.get(productsId).getAmountInStock() - amountOfProduct);
                        totalPrice = products.get(productsId).getPrice() * amountOfProduct;
                    }
                    break;
                case 2:
                    temp = false;
                    break;
                default:
                    System.out.println("Incorrect input");
                    break;
            }
        }
        Order order = new Order(id, client.getId(), orderProductsArrayList, totalPrice);
        client.getOrderHistory().add(order);
        orders.add(order);
        System.out.println("Created succesfully");
    }

    public void createProduct() {
        System.out.println("Enter product's id");
        int id = Main.scanner.nextInt();
        Main.scanner.next();
        System.out.println("Enter product's name");
        String name = Main.scanner.nextLine();
        Main.scanner.next();
        System.out.println("Enter product's price");
        double price = Main.scanner.nextDouble();
        System.out.println("Enter product's amount in stock");
        int amount = Main.scanner.nextInt();

        Product product = new Product(id, name, price, amount);
        products.add(product);
        System.out.println("Created succesfully");
    }

    //Update
    public void updateClient() {

        for (Client i : clients) {
            System.out.println(i);
        }

        System.out.println("Enter client's id to update");
        int id = Main.scanner.nextInt();
        Main.scanner.next();

        for (Client i : clients) {
            if (i.getId() == id) {
                System.out.println("Enter new client's name ");
                String name = Main.scanner.nextLine();
                System.out.println("Enter new client's surname");
                String surname = Main.scanner.nextLine();

                Client newClient = new Client(i.getId(), name, surname, i.getOrderHistory());
                i = newClient;
            }
        }
    }

    public void updateOrder(Order order) {
        for (Order i : orders) {
            if (i.getId() == order.getId()) {
                i = order;
            }
        }
    }

    public void updateProduct(Product product) {
        for (Product i : products) {
            if (i.getId() == product.getId()) {
                i = product;
            }
        }
    }

    //Delete
    public void deleteClient(Client client) {
        clients.remove(client);
    }

    public void deleteOrder(Order order) {
        orders.remove(order);
    }

    public void deleteProduct(Product product) {
        products.remove(product);
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

}
