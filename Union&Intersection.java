import java.util.*;

public class Main {
    public static void main(String args[]) {
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};

        HashSet<Integer> unionSet = new HashSet<>();
        HashSet<Integer> intersectionSet = new HashSet<>();
        
        // Union
        for (int num : arr1) {
            unionSet.add(num);
        }
        for (int num : arr2) {
            unionSet.add(num);
        }
        System.out.println("Union Size = " + unionSet.size());
        System.out.println("Union Elements = " + unionSet);

        // Intersection
        HashSet<Integer> tempSet = new HashSet<>();
        for (int num : arr1) {
            tempSet.add(num);
        }

        for (int num : arr2) {
            if (tempSet.contains(num)) {
                intersectionSet.add(num);
            }
        }
        System.out.println("Intersection Size = " + intersectionSet.size());
        System.out.println("Intersection Elements = " + intersectionSet);
    }
}

=== Code Output ===

Union Size = 6
Union Elements = [2, 3, 4, 6, 7, 9]
Intersection Size = 2
Intersection Elements = [3, 9]

=== Code Execution Successful ===
