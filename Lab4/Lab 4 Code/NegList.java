import java.util.ArrayList;
import java.util.List;

public class NegList {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();

        list1.add(-1);
        list1.add(-20);
        list1.add(15);
        list1.add(-100);
        list1.add(-845);
        list1.add(52);

        System.out.println("Before replaceNegList: " + list1.toString());
        replaceNegList(list1);
        System.out.println("After replaceNegList: " + list1.toString());
    }

    private static void replaceNegList(List<Integer> l) {
        int i = 0;
        for (int num : l) {
            if (num < 0) {
                l.set(i, (int) Math.sqrt((double) (num * num)));
            }
            i++;
        }
    }
}
