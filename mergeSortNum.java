import java.util.*;

public class Main {
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " "); // Use print instead of println for better formatting
        }
        System.out.println();
    }

    public static void mergeSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        // Divide the array
        int mid = si + (ei - si) / 2; // Avoid potential overflow with (si+ei)/2
        mergeSort(arr, si, mid);     // Sort left part
        mergeSort(arr, mid + 1, ei); // Sort right part
        merge(arr, si, mid, ei);     // Merge the two parts
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1]; // Temporary array
        int i = si; // Left part pointer
        int j = mid + 1; // Right part pointer
        int k = 0; // Temp array pointer

        // Merge two sorted parts into the temp array
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from left part
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from right part
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // Copy temp array back to original array
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void main(String args[]) {
        int arr[] = {6, 3, 9, 8, 4, 5};
        mergeSort(arr, 0, arr.length - 1);
        printArr(arr); // Output sorted array
    }
}


=== Code Output ===

3 4 5 6 8 9 

=== Code Execution Successful ===
