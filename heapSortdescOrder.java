import java.util.*;

public class Main {  
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();
        
        public void add(int data) {   // O(log n)
            // Add at last index
            arr.add(data);
            
            int x = arr.size() - 1;  // x is child index
            int par = (x - 1) / 2;  // Parent index
            
            while (x > 0 && arr.get(x) > arr.get(par)) {  // O(log n)
                // Swap 
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);  
               
                x = par;
                par = (x - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;
            
            if (left < arr.size() && arr.get(minIdx) < arr.get(left)) {
                minIdx = left;
            }
        
            if (right < arr.size() && arr.get(minIdx) < arr.get(right)) {
                minIdx = right;
            }   
            
            if (minIdx != i) {
                // Swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);
              
                heapify(minIdx);
            }
        }

        public int remove() {
            if (arr.size() == 0) {
                throw new NoSuchElementException("Heap is empty!");
            }

            int data = arr.get(0);
            
            // Step 1 - Swap first & last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);
            
            // Step 2 - Delete last
            arr.remove(arr.size() - 1);
            
            // Step 3 - Heapify
            if (!arr.isEmpty()) {
                heapify(0);
            }
            
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String args[]) {  
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);
        
        while (!h.isEmpty()) { // Heap sort O(log n)
            System.out.println(h.peek());
            h.remove();
        }
    }
}


=== Code Output ===

5
4
3
1

=== Code Execution Successful ===
