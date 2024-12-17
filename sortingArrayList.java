import java.util.ArrayList;
import java.util.Collections; 

public class Main {
    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);

        System.out.println("Original List: " + list);

        // Sort in ascending order
        Collections.sort(list);
        System.out.println("Sorted List (Ascending): " + list);

        // Sort in descending order
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Sorted List (Descending): " + list);
    }
}


=== Code Output  ===

Original List: [2, 5, 9, 3, 6]
Sorted List (Ascending): [2, 3, 5, 6, 9]
Sorted List (Descending): [9, 6, 5, 3, 2]

=== Code Execution Successful ===
