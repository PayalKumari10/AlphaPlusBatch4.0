class Main {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    // Add a new node at the beginning of the list
    public void addFirst(int data) {
        // Step 1: Create a new node
        Node newNode = new Node(data);

        // Step 2: If the list is empty, make head and tail point to the new node
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // Step 3: Link the new node to the current head
        newNode.next = head;

        // Step 4: Update the head pointer to the new node
        head = newNode;
    }

    public static void main(String[] args) {
        Main ll = new Main();
        ll.addFirst(1);
        ll.addFirst(2);

        // Print the list
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
=== Code output ===

2 -> 1 -> null

=== Code Execution Successful ===
