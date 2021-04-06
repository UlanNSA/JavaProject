package end2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        Manager manager = new Manager();
        manager.connect();

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            PackageData packageData = null;
            while ((packageData=(PackageData)inputStream.readObject())!=null){
                if(packageData.getOperationType().equals("ADD_BOOK")){
                    Book book = packageData.getBook();
                    manager.add(book);
                }

                if(packageData.getOperationType().equals("LIST_BOOKS")){

                    ArrayList<Book> managerList = manager.list();
                    PackageData books = new PackageData(managerList);
                    outputStream.writeObject(books);

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
