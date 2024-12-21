import java.util.ArrayList;

public class Main {
    public boolean isMonotonic(ArrayList<Integer> A) {
        boolean inc = true;
        boolean dec = true;

        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i) > A.get(i + 1)) {
                inc = false; // Not increasing
            }
            if (A.get(i) < A.get(i + 1)) {
                dec = false; // Not decreasing
            }
        }

        return inc || dec; // Monotonic if either increasing or decreasing
    }

    public static void main(String[] args) {
        Main obj = new Main();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);

        System.out.println("Is the list monotonic? " + obj.isMonotonic(list));
    }
}
