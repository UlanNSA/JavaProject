package F;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//products==pr ULAN Delete
        ArrayList<Product> pr = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<Client> clients = new ArrayList<>();
        OnlineStoreManagement onlineStoreManagement = new OnlineStoreManagement(pr, clients, orders);
        boolean check = true;
        while (check) {
            System.out.println("Enter[1] CRUD" +
                    "\nEnter[2] to updating" +
                    "\nEnter[3] to deleting");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter[1] to create product, [2]to create order, [3] to create client");
                    int choice2 = scanner.nextInt();
                    if (choice2 == 1) {
                        onlineStoreManagement.createProduct();
                        break;
                    } else if (choice2 == 2) {
// onlineStoreManagement.createOrder(Client client);
// break;
                    } else if (choice2 == 3) {
                        onlineStoreManagement.createClient();
                        break;
                    } else {
                        System.out.println("error");
                    }
                }
                case 2: {
                    System.out.println("Enter[1] to update product [2]to update order [3] to update client");
                    int choice2 = scanner.nextInt();

                    if (choice2 == 1) {
                        onlineStoreManagement.updateProduct();
                        break;
                    }

                    if (choice2 == 2) {
                        onlineStoreManagement.updateOrder();
                        break;
                    }

                    if (choice2 == 3) {
                        onlineStoreManagement.updateClient();
                        break;
                    }
                    break;
                }

            }
        }
    }
}





