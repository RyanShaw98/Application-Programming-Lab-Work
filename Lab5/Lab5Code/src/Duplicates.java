import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Duplicates {

    private static List<Integer> sharedItems(List<Integer> list1, List<Integer> list2) {
        ArrayList<Integer> shared = new ArrayList<>();
        for (int item1 : list1) {
            for (int item2 : list2) {
                if (item2 == item1) {
                    shared.add(item2);
                }
            }
        }
        try {
            if (shared.isEmpty()) {
                throw new NoSharedItemsException("No shared items found.");
            }
        } catch (NoSharedItemsException e) {
            e.printStackTrace();
        }
        return shared;
    }

    private static List<Integer> sortAscending(ArrayList<Integer> list) {
        int count = 0;
        while (count < list.size()) {
            for (int itemIndex = 0; itemIndex < list.size() - 1; itemIndex++) {
                if (list.get(itemIndex) > list.get(itemIndex + 1)) {
                    int buff = list.get(itemIndex);
                    list.set(itemIndex, list.get(itemIndex + 1));
                    list.set(itemIndex + 1, buff);
                }
            }
            count++;
        }
        return list;


    }

    private static List<Integer> sortAscendingCollections(ArrayList<Integer> list) {
        Collections.sort(list);
        return list;
    }

    private static List<Integer> sortDescendingCollections(ArrayList<Integer> list) {
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> myList1 = new ArrayList<>();
        ArrayList<Integer> myList2 = new ArrayList<>();
        ArrayList<Integer> messyList = new ArrayList<>();

        myList1.add(7);
        myList1.add(1);
        myList1.add(9);
        myList1.add(4);
        myList1.add(5);

        myList2.add(7);
        myList2.add(1);
        myList2.add(9);
        myList2.add(3);
        myList2.add(2);

        messyList.add(9);
        messyList.add(2);
        messyList.add(0);
        messyList.add(1);
        messyList.add(8);


        System.out.println("Items in both 'myList1' and 'myList2':");
        System.out.println(sharedItems(myList1, myList2));

        System.out.println("\nOriginal 'messyList':");
        System.out.println(messyList);

        System.out.println("\n'messyList' sorted using Comparable:");
        System.out.println(sortAscending(messyList));

        System.out.println("\n'messyList' sorted using Collections:");
        System.out.println(sortAscendingCollections(messyList));

        System.out.println("\n'messyList' sorted using Collections descending:");
        System.out.println(sortDescendingCollections(messyList));

    }
}

class NoSharedItemsException extends Exception {
    NoSharedItemsException(String msg) {
        super(msg);
    }
}
