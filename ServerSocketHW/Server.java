package end2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {

            ServerSocket serverSocket =new ServerSocket(9090);
            while (true){
                System.out.println("waiting client");
                Socket socket =  serverSocket.accept();
                System.out.println("client connected");
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
