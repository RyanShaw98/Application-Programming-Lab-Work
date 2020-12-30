import java.util.ArrayList;
import java.util.Iterator;

public class Statistics {

    private static int maximumIterator(ArrayList<Integer> list) {
        Iterator it = list.iterator();
        int max = list.get(0);
        int buffer;
        while (it.hasNext()) {
            buffer = (int) it.next();
            if (buffer > max) {
                max = buffer;
            }
        }
        return max;
    }

    private static int maximumFor(ArrayList<Integer> list) {
        int max = list.get(0);
        for (int i : list) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    private static int minimumIterator(ArrayList<Integer> list) {
        Iterator it = list.iterator();
        int min = list.get(0);
        int buffer;
        while (it.hasNext()) {
            buffer = (int) it.next();
            if (buffer < min) {
                min = buffer;
            }
        }

        return min;
    }

    private static int minimumFor(ArrayList<Integer> list) {
        int min = list.get(0);
        for (int i : list) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    private static double averageIterator(ArrayList<Integer> list) {
        Iterator it = list.iterator();
        double total = 0;
        while (it.hasNext()) {
            total += (int) it.next();
        }
        return total / (double) list.size();
    }

    private static double averageFor(ArrayList<Integer> list) {
        double total = 0;
        for (int i : list) {
            total += i;
        }
        return total / (double) list.size();
    }

    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(5);
        myList.add(1);
        myList.add(10);
        myList.add(8);
        myList.add(3);

        System.out.println("Iterator methods:");
        System.out.println("Max: " + maximumIterator(myList));
        System.out.println("Min: " + minimumIterator(myList));
        System.out.println("Avg: " + averageIterator(myList));

        System.out.println("\nFor loop methods:");
        System.out.println("Max: " + maximumFor(myList));
        System.out.println("Min: " + minimumFor(myList));
        System.out.println("Avg: " + averageFor(myList));
    }
}
