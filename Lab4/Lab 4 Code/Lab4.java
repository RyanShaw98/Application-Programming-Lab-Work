import java.util.Iterator;
import java.util.List;
import java.util.Vector;

class Lab4 {
    private static <T extends Comparable<T>> int smallest(List<T> l) {
        if (l.size() == 0) return -1;
        else {
            Iterator<T> it = l.iterator();
            T smallestSoFar = it.next();
            T temp;
            int smallestPos = 0;
            int i = 1; //used to indicate position in list of next item
            while (it.hasNext()) {
                temp = it.next();
                if (smallestSoFar.compareTo(temp) > 0) { // compare next item with smallest so far
                    smallestSoFar = temp; // if it's smaller update smallestSoFar and smallestPos
                    smallestPos = i;
                }
                i++;
            }
            return smallestPos;
        }
    }

    private static <T extends Comparable<T>> int largest(List<T> l) {
        if (l.size() == 0) return -1;
        else {
            Iterator<T> it = l.iterator();
            T largestSoFar = it.next();
            T temp;
            int largestPos = 0;
            int i = 1; //used to indicate position in list of next item
            while (it.hasNext()) {
                temp = it.next();
                if (largestSoFar.compareTo(temp) < 0) { // compare next item with smallest so far
                    largestSoFar = temp; // if it's smaller update smallestSoFar and smallestPos
                    largestPos = i;
                }
                i++;
            }
            return largestPos;
        }
    }

    private static <T extends Comparable<T>> void deleteSmallest(List<T> l) { // for exercise 2
        if (l.size() != 0) {
            l.remove(smallest(l));
        }
    }

    public static void main(String[] args) {
        Vector<String> vec1 = new Vector<>();
        vec1.add("world");
        vec1.add("xxxx");
        vec1.add("Hello");
        vec1.add("aardvark");
        int smallPos = smallest(vec1);
        if (smallPos != -1) {
            System.out.println("Smallest entry is " + vec1.elementAt(smallPos) + " at position " + smallPos + ".");
        }

        System.out.println("Largest entry is " + vec1.elementAt(largest(vec1)) + " at position " + largest(vec1) + "\n");


        Vector<Integer> vec2 = new Vector<>();
        vec2.add(17);
        vec2.add(53);
        vec2.add(399);
        vec2.add(247);
        deleteSmallest(vec2);
        smallPos = smallest(vec2);
        if (smallPos != -1) {
            System.out.println("Smallest entry is " + vec2.elementAt(smallPos) + " at position " + smallPos + ".");
        }
        System.out.println("Largest entry is " + vec2.elementAt(largest(vec2)) + " at position " + largest(vec2) + "\n");

        Vector<Double> vec3 = new Vector<>();
        deleteSmallest(vec3);
        vec3.add(-517.0);
        vec3.add(474.0);
        vec3.add(3699.0);
        vec3.add(-3699.0);
        vec3.add(2455.0);
        vec3.add(-474.0);
        smallPos = smallest(vec3);
        if (smallPos != -1) {
            System.out.println("Smallest entry is " + vec3.elementAt(smallPos) + " at position " + smallPos + ".");
        }
        System.out.println("Largest entry is " + vec1.elementAt(largest(vec3)) + " at position " + largest(vec3));
    }
}