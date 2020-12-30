import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Lab6 {
    private static HashMap<String, Integer> marks = new HashMap<>();

    private static void printMap(HashMap<String, Integer> map) {
        Iterator mapIt = map.entrySet().iterator();
        while (mapIt.hasNext()) {
            Map.Entry buff = (Map.Entry) mapIt.next();
            System.out.println(buff.getKey() + ": " + buff.getValue());

        }
//         Alternatively you could iterate using this technique
//        for (Map.Entry i : map.entrySet()) {
//            System.out.println(i.getKey() + ": " + i.getValue());
//        }
    }

    private static void checkNegException(int i) {
        try {
            if (i < 0) {
                throw new InvalidNumberException("Negative marks are prohibited.");
            }
        } catch (InvalidNumberException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }

    private static double mapAvg(Map<String, Integer> map) {
        double total = 0;
        for (Map.Entry i : map.entrySet()) {
            checkNegException((Integer) i.getValue());
            total += (Integer) i.getValue();
        }
        double avg = (total / ((double) map.size())) * 100;
        return Math.round(avg) / (double) 100;
    }

    private static Map.Entry<String, Integer> highestMark(Map<String, Integer> map) {
        String name = "";
        int highMark = -1;
        for (Map.Entry i : map.entrySet()) {
            checkNegException((Integer) i.getValue());
            if ((Integer) i.getValue() > highMark) {
                name = (String) i.getKey();
                highMark = (Integer) i.getValue();
            }
        }
        return new AbstractMap.SimpleEntry<>(name, highMark);
    }

    public static void main(String[] args) {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        boolean more = true;
        while (more) {
            System.out.print("Name: ");
            String name = null;
            try {
                name = buf.readLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.print("Mark: ");
            int mark = -1;
            try {
                while (mark < 0) {
                    mark = Integer.parseInt(buf.readLine().trim());
                    if (mark < 0) {
                        System.out.print("Mark: ");
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid input - using 0");
            }
            marks.put(name, mark);
            System.out.print("More? ");
            try {
                if (buf.readLine().charAt(0) != 'y')
                    more = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
        printMap(marks);
        System.out.println("\nAverage mark: " + mapAvg(marks));
        System.out.println("Highest mark: " + highestMark(marks).getValue() + " (" + highestMark(marks).getKey() + ")");
        //printMap(highestMark(marks));
    }
}

class InvalidNumberException extends Exception {
    InvalidNumberException(String msg) {
        super(msg);
    }
}


