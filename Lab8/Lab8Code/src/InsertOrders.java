import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertOrders {

    private Statement statement;

    InsertOrders(Statement statement) {
        this.statement = statement;
    }

    void addRow(String fileName) {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            String line;
            String query;
            while (((line = fileReader.readLine())) != null) {
                query = line;
                statement.executeQuery(query);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Failed to open - file not found");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
}
