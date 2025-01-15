class Main {
    static class Node {
        int data;
        Node left, right;

        // Constructor to initialize Node with data
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static Node deleteLeaves(Node root, int x) {
        if (root == null)
            return null;

        root.left = deleteLeaves(root.left, x);
        root.right = deleteLeaves(root.right, x);

        // If the current node is a leaf node and matches the value x, delete it
        if (root.data == x && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }

    static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        // Construct the tree
        Node root = new Node(10);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(1);
        root.right.right = new Node(3);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(3);

        System.out.println("Inorder traversal before deletion:");
        inorder(root);

        // Delete leaf nodes with value 3
        root = deleteLeaves(root, 3);

        System.out.println("\nInorder traversal after deletion:");
        inorder(root);
    }
}

=== Code Output ===
Inorder traversal before deletion:
3 3 1 10 10 3 3 3 
Inorder traversal after deletion:
3 1 10 10 
=== Code Execution Successful ===
