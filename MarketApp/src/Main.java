import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<Client> clients = new ArrayList<>();
        OnlineStoreManagement onlineStoreManagement = new OnlineStoreManagement(products, clients, orders);


        while(true){
            System.out.println("Enter[1] to creating [2] to updating [3] to deleting Enter[4] to make delivery");
            int choice = scanner.nextInt();

            switch (choice){
                case 1: {
                    System.out.println("Select a category for create: [1]product [2]order [3]client");

                    int choice2 = scanner.nextInt();

                    switch (choice2){
                        case 1:{
                            onlineStoreManagement.createProduct();
                            break;
                        }

                        case 2:{
                            onlineStoreManagement.createOrder();
                            break;
                        }

                        case 3:{
                            onlineStoreManagement.createClient();
                            break;
                        }
                    }

                    break;
                }

                case 2:{
                    System.out.println("Select a category for update : [1]product [2]order [3]client");

                    int choice2 = scanner.nextInt();

                    switch (choice2){
                        case 1:{
                            onlineStoreManagement.updateProduct();
                            break;
                        }
                        case 2:{
                            onlineStoreManagement.updateOrder();
                            break;
                        }
                        case 3:{
                            onlineStoreManagement.updateClient();
                            break;
                        }
                    }

                    break;
                }

                case 3:{
                    System.out.println("Select a category for delete: [1]product [2]order [3]client");

                    int choice2 = scanner.nextInt();

                    switch (choice2){
                        case 1:{
                            onlineStoreManagement.deleteProduct();
                            break;
                        }
                        case 2:{
                            onlineStoreManagement.deleteOrder();
                            break;
                        }
                        case 3:{
                            onlineStoreManagement.deleteClient();
                            break;
                        }
                    }

                    break;
                }

                case 4:{
                    onlineStoreManagement.makeDelivery();
                    break;
                }
            }

        }

    }
}
