package end2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {

            Socket socket = new Socket("127.0.0.1", 9090);
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);
            int check;
            boolean check2=true;
            while (check2){
                System.out.println("ENTER [1]ADD_BOOK OR [2]LIST_BOOKS AND [3]EXIT");
                check = sc.nextInt();
                sc.nextLine();
                switch (check){
                    case 1:
                        System.out.println("id:");
                        int id1 = sc.nextInt();
                        sc.nextLine();
                        System.out.println("title:");
                        String title = sc.nextLine();
                        System.out.println("author:");
                        String author = sc.nextLine();
                        System.out.println("price:");
                        int price = sc.nextInt();
                        Book book = new Book(id1,title,author,price);
                        PackageData packageData = new PackageData("ADD_BOOK",book);
                        objectOutputStream.writeObject(packageData);
                        break;
                    case 2:
                        PackageData packageData2 = new PackageData("LIST_BOOKS");
                        objectOutputStream.writeObject(packageData2);
                        PackageData packageData3 = (PackageData)objectInputStream.readObject();
                        ArrayList<Book> listBooks = packageData3.getBooks();
                        for (Book out: listBooks ) {
                            System.out.println(out);
                        }
                        break;
                    case 3:
                        System.out.println("see you soon wanderer");
                        check2=false;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
