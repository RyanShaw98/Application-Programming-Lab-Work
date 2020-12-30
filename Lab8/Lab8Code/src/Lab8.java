import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lab8 {
    public static void main(String[] args) throws SecurityException {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded\n");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/orderdb", "root", null);
        } catch (ClassNotFoundException e) {
            System.out.println("\nDriver not found");
            System.exit(-1);
        } catch (SQLException e) {
            System.out.println("\nFailed to connect to the database");
            System.exit(-1);
        } catch (ExceptionInInitializerError e) {
            System.out.println("Permission denied");
        }

        Statement statement = null;

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("\nFailed to access database");
            System.exit(-1);
        } catch (NullPointerException e) {
            System.out.println("\nFailed to access database");
            System.exit(-1);
        }


        queryDatabase(statement);

        try {
            statement.close();
            connection.close();
            System.out.println("\nConnection closed");
        } catch (SQLException e) {
            System.out.println("\nFailed to close connection");
            System.exit(-1);
        }
    }

    static void queryDatabase(Statement statement) {
        try {
//            Commented out to stop it repeatedly adding the following values
//            statement.executeUpdate("INSERT INTO orders VALUES (8, 3, 'desktop pc', 375.75);");
//            statement.executeUpdate("INSERT INTO orders VALUES (9, 5, 'football', 10.99);");
//            statement.executeUpdate("INSERT INTO orders VALUES (10, 4, 'keyboard', 50.20);");

            String query = "SELECT * FROM orders;";
            ResultSet rs = statement.executeQuery(query);
            double totalSpend = 0;
            double custCount = 0.0;
            Set<Integer> ordersOverTwenty = new HashSet<>();
            while (rs.next()) {
                totalSpend += (double) rs.getObject(4);
                custCount++;
                if ((double) rs.getObject(4) > 20) {
                    ordersOverTwenty.add((Integer) rs.getObject(2));
                }
            }
            System.out.println("The average customer spend is: £" + (double) ((int) ((totalSpend / custCount) * 100)) / 100 + "\n");


            query = "SELECT * FROM customers;";
            rs = statement.executeQuery(query);
            Map<Integer, String> customerInfo = new HashMap<>();
            while (rs.next()) {
                customerInfo.put((Integer) rs.getObject(1), (String) rs.getObject(2));
            }
            for (Map.Entry<Integer, String> entry : customerInfo.entrySet()) {
                System.out.println("ID: " + entry.getKey() + " -> Name: " + entry.getValue());
            }

            System.out.println("\nCustomers with orders over £20 (Using Sets):");
            for (int ID : ordersOverTwenty) {
                if (customerInfo.containsKey(ID)) {
                    System.out.println(customerInfo.get(ID));
                }
            }

            query = "SELECT customers.name FROM orders INNER JOIN customers ON ((customers.custid=orders.custid) && (orders.price > 20.00));";
            rs = statement.executeQuery(query);
            System.out.println("\nCustomers with orders over £20 (Using JOIN):");
            Set<String> uniqueRS = new HashSet<>();
            while (rs.next()) {
                uniqueRS.add((String) rs.getObject(1)); // Remove duplicates
            }
            for (String name : uniqueRS) {
                System.out.println(name);
            }

            query = "SELECT customers.name FROM orders INNER JOIN customers ON ((customers.custid=orders.custid) && (orders.price < 20.00));";
            rs = statement.executeQuery(query);
            System.out.println("\nCustomers with orders under £20 (Using JOIN):");
            uniqueRS = new HashSet<>();
            while (rs.next()) {
                uniqueRS.add((String) rs.getObject(1)); // Remove duplicates
            }
            for (String name : uniqueRS) {
                System.out.println(name);
            }

//            Commented out to stop it repeatedly adding the values from orders_2
//            InsertOrders ordersTable = new InsertOrders(statement);
//            ordersTable.addRow("orders_2.txt");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}