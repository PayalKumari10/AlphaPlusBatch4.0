import java.util.*;

public class Classroom {
    //TC : O(n2)  SC: O(1)
    static int max_profit(int a[], int b[], int n, int fee) {
        int diff_day = 1;
        int maxSum = 0;

        b[0] = 0; // max profit
        b[1] = diff_day; // corresponding diff_day

        while (diff_day < n) {
            int sum = 0;
            for (int i = 0; i + diff_day < n; i++) {
                int buy = a[i];
                int sell = a[i + diff_day];
                int profit = sell - buy - fee;
                if (profit > 0) {
                    sum += profit;
                }
            }

            if (b[0] < sum) {
                b[0] = sum;
                b[1] = diff_day;
            }

            diff_day++;
        }
        return b[0];
    }

    public static void main(String args[]) {
        int arr[] = {6, 1, 7, 2, 8, 4};
        int n = arr.length;
        int[] b = new int[2];
        int tranFee = 2;

        max_profit(arr, b, n, tranFee);
        System.out.println("Max Profit: " + b[0] + ", Best Diff Day: " + b[1]);
    }
}


=== Code Output ===

Max Profit: 8, Best Diff Day: 1

=== Code Execution Successful ===
