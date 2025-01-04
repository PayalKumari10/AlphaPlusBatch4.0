import java.util.*;

 class Main {
     static class Stack {
         Deque<Integer> deque = new LinkedList<>();
         
         public void push(int data) {
             deque.addLast(data);
         }
         
         public int pop() {
             return deque.removeLast();
         }
         public int peek() {
             return deque.getLast();
         }
     }
     public static void main(String args[]) {
         Stack s = new Stack();
         s.push(1);
         s.push(2);
         s.push(3);
         System.out.println("peek = " + s.peek());
         System.out.println(s.pop());
         System.out.println(s.pop());
         System.out.println(s.pop());
     }
}


=== Code Output ===
peek = 3
3
2
1
=== Code Execution Successful ===
