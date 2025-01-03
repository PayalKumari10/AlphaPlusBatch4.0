import java.util.*;

public class Main {
    public static void main(String args[]) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        
        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}


=== Code Output ===
1
2
3

=== Code Execution Successful ===
