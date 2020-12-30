import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class Lab7 {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/orderdb", "root", null);
            // past experience has shown that using the one-argument version of getConnection doesn't work for some students
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
            System.exit(1);
        } catch (SQLException e) {
            System.out.println("Failed to connect to database");
            System.exit(1);
        }

        Statement statement = null;

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Failed to access database");
            System.exit(1);
        }

        queryDatabase(statement);

        try {
            statement.close();
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            System.out.println("Problems closing connection");
            System.exit(1);
        }
    }

    static void queryDatabase(Statement statement) {
        try {
            String query = "SELECT * FROM customers;";
            ResultSet rs = statement.executeQuery(query);
            System.out.println("\nCustomers:\n");
            while (rs.next()) {
                System.out.println("ID: " + rs.getObject(1));
                System.out.println("Name: " + rs.getObject(2));
                System.out.println("Email: " + rs.getObject(3) + "\n");
            }

            query = "SELECT * FROM orders;";
            rs = statement.executeQuery(query);
            System.out.println("Orders in the range £10 - £40:\n");
            while (rs.next()) {
                if (((Double) rs.getObject(4) >= 10.0) && ((Double) rs.getObject(4) <= 40.0)) {
                    System.out.println("Order ID: " + rs.getObject(1));
                    System.out.println("Customer ID: " + rs.getObject(2));
                    System.out.println("Item: " + rs.getObject(3));
                    System.out.println("Price: £" + rs.getObject(4) + "\n");
                }
            }

            query = "SELECT name FROM customers INNER JOIN orders ON ((customers.custid=orders.custid) && (orders.price <= 40.0) && (orders.price >= 10.0));";
            rs = statement.executeQuery(query);
            Set<String> uniqueRS = new HashSet<>();
            System.out.println("Customer names with orders in the range £10 - £40:\n");
            while (rs.next()) {
                uniqueRS.add((String) rs.getObject(1));
            }
            for (String name : uniqueRS) {
                System.out.println(name);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
