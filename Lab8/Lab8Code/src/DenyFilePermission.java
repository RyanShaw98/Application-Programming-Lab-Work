import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.Permission;

// VM Option: -Djava.security.manager -Djava.security.policy="src\fileReadPolicy"

public class DenyFilePermission extends JFrame {

    public static void main(String[] args) {
        try {
            Permission perm = new java.io.FilePermission("src/readTest.txt", "read");
            SecurityManager sm = System.getSecurityManager();
            if (sm != null) {
                sm.checkPermission(perm);
            }

            String filename = "src/readTest.txt";
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filename));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println(filename + " not found.");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (AccessControlException e) {
            System.out.println("Read access denied.");
        }
    }
}
