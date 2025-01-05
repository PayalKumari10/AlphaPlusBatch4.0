import java.util.*;

public class Main {
    public static void main(String args[]) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);
        System.out.println(deque);
    }
}

=== Code Output ===
[2, 1, 3, 4]

=== Code Execution Successful ===
