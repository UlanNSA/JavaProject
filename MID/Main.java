package MID;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Device> devices = new ArrayList<>();
        devices.add(new SmartPhone(100, "IphoneX", 10, "corei5", 8, 54, 10));
        devices.add(new SmartPhone(1111, "Iphone11", 20, "corei7", 16, 54, 11));
        devices.add(new Computer(12344, "Supercomputer", 2,  "corei9", 32, true, 1000000));
        devices.add(new Computer(13243, "Computer", 24, "corei5", 16, true, 110000));
        devices.add(new Laptop(758, "HP WEASLEY", 10, "corei7", 8, true, 1000, 1.6, true));
        devices.add(new Laptop(758, "HP PAVILION", 20, "corei9", 35, true, 100, 3.4, true));
        ArrayList<Device> sold = new ArrayList<>();
        String adminName = "Yerikov";
        String adminPassword = "Ulan";
        boolean check = true;
        while (check) {
            boolean check1 = true;
            System.out.println("Enter the username and password :");
            String username = sc.next();
            String password = sc.next();
            if(adminName.equals(username)&&adminPassword.equals(password)){
                System.out.println("ADMIN ACCESS");
                while (check1) {
                    System.out.println("THE OPERATION(1-4):1:Add product, 2: Supplement, 3: Delete," +
                            "4: Income, 5:logout");
                    int n = sc.nextInt();
                    switch (n) {

                        case 1: System.out.println("Enter the type(SmartPhone, Computer, Laptop): ");
                            String type1 = sc.next();
                            if (type1.equals("SmartPhone")) {
                                System.out.println("Enter the data: ");
                                int price = sc.nextInt();
                                String model = sc.next();
                                int count = sc.nextInt();
                                String cpu = sc.next();
                                int ram = sc.nextInt();
                                double mgpx = sc.nextDouble();
                                int generation = sc.nextInt();
                                devices.add(new SmartPhone(price, model, count, cpu, ram, mgpx, generation));
                            } else if (type1.equals("Computer")) {
                                System.out.println("Enter the data: ");
                                int price = sc.nextInt();
                                String model = sc.next();
                                int count = sc.nextInt();
                                String cpu = sc.next();
                                int ram = sc.nextInt();
                                boolean ssd = sc.nextBoolean();
                                int memory = sc.nextInt();
                                devices.add(new Computer(price, model, count, cpu, ram, ssd, memory));
                            } else if (type1.equals("Laptop")) {
                                System.out.println("Enter the data: ");
                                int price = sc.nextInt();
                                String model = sc.next();
                                int count = sc.nextInt();
                                String cpu = sc.next();
                                int ram = sc.nextInt();
                                boolean ssd = sc.nextBoolean();
                                int memory = sc.nextInt();
                                double weight = sc.nextDouble();
                                boolean touch = sc.nextBoolean();
                                devices.add(new Laptop(price, model, count, cpu, ram, ssd, memory,weight,touch));
                            } else {
                                System.out.println("Type is not defined");
                            }
                            System.out.println("Enter new operation");
                            break;
                        case 2:
                            System.out.println("Choose a product ");
                            int b = sc.nextInt()-1;
                            System.out.println("Enter new count : ");

                            int count = sc.nextInt();
                            if(count<=devices.get(b).getCount()){
                                System.out.println("you are not allowed");
                            }
                            else
                            devices.get(b).setCount(count);
                            break;
                        case 3:
                            System.out.println("Choose a product which would be delete");
                            int c = sc.nextInt()-1;
                            devices.remove(c);
                            break;
                        case 4:
                            showAllItems(sold);
                            System.out.println(sold.stream().mapToDouble(Device::getPerformance).sum());
                            break;
                        case 5:check1 = false;
                            break;
                    }
                }
            }
            else {
                System.out.println("USER ACCESS");
                ArrayList<Device> cart = new ArrayList<>();
                while (check1) {
                    System.out.println("THE OPERATION(1-3) => 1: views all items, 2: buy a product by index, 3: Filter, 4 sort ,5: to Exit");
                    int choose = sc.nextInt();
                    switch (choose){
                        case 1: showAllItems(devices); break;
                        case 2:
                            System.out.println("Buy a product: ");
                            int b = sc.nextInt()-1;
                            if(devices.get(b).getCount()>0){
                                cart.add(devices.get(b));
                                devices.get(b).buyProduct();
                                sold.add(devices.get(b));
                            }
                            else System.out.println("The product does not exist");
                            System.out.println("Enter new operation");
                            break;
                        case 3:

                            System.out.println("Enter the type(SmartPhone, Computer, Laptop): ");
                            String type = sc.next();
                            for (Device device : devices) {
                                if (device.getType().equals(type)) {
                                    device.showDetails();
                                }
                            }
                            System.out.println("Enter new operation");
                            break;
                        case 4:
                            sort(devices);
                            System.out.println("Enter new operation");
                            break;


                        case 5: check1 = false; break;
                    }


                }
                showAllItems(cart);
                System.out.println(cart.stream().mapToInt(Device::getPrice).sum());
            }
        }
    }

    public static void sort(ArrayList<Device> dev1){
        dev1.sort(Comparator.comparing(Device::getPerformance));
        for (Device devs:dev1
        ) {
            devs.showDetails();
        }
    }


    public static void showAllItems(ArrayList<Device> devices){
        devices.forEach(Good::showDetails);
    }


}
