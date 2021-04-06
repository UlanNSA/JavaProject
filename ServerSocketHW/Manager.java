package end2;

import java.sql.*;
import java.util.ArrayList;

public class Manager {
    private static Connection connection;
    private static String url = "jdbc:postgresql://localhost:5433/OOP";
    private static String user = "postgres";
    private static String pass = "Ulan2001";

    public void connect(){
        try {
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void add(Book book) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO library (id, title, author, price) VALUES (?, ?, ?, ?);");
        statement.setInt(1, (int) book.getId());
        statement.setString(2, book.getTitle());
        statement.setString(3, book.getAuthor());
        statement.setInt(4,  book.getPrice());
        statement.executeUpdate();
        statement.close();
    };

    public ArrayList<Book> list() throws SQLException{
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM library");
        ArrayList<Book> book2 = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            int id= resultSet.getInt("id");
            String title= resultSet.getString("title");
            String author= resultSet.getString("author");
            int price= resultSet.getInt("price");
            book2.add(new Book(id,title,author,price));
        }

        statement.close();
        return book2;

    }

}
