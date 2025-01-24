import java.util.PriorityQueue;

public class Main {
    public static void main(String args[]) {
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        
        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(7);
        
        while(!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}

=== Code Output ===
1
3
4
7

=== Code Execution Successful ===
