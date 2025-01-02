import java.util.*;

class Main {
    static int arr[];
    static int size;
    static int rear;

    // Constructor matching class name
    public Main(int n) {  
        arr = new int[n];
        size = n;
        rear = -1;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return rear == -1;
    }

    // Add element to the queue
    public void add(int data) {
        if (rear == size - 1) {
            System.out.println("Queue is full");
            return;
        }
        rear = rear + 1;
        arr[rear] = data;
    }

    // Remove element from the queue
    public int remove() {
        if (isEmpty()) {
            System.out.println("Empty queue");
            return -1;
        }
        int front = arr[0];
        // Shift elements
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
        }
        rear = rear - 1;
        return front;
    }

    // Peek at the front of the queue
    public int peek() {
        if (isEmpty()) {
            System.out.println("Empty queue");
            return -1;
        }
        return arr[0];
    }

    // Main method
    public static void main(String[] args) {
        Main q = new Main(5); 
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
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
