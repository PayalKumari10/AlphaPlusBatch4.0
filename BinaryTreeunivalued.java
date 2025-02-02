import java.util.*;

class Main {
    static class Node {
        int data;
        Node left;
        Node right;

        
        // Constructor to initialize Node with data
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static boolean isUnivalTree(Node root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && root.data != root.left.data) {
            return false;
        }

        if (root.right != null && root.data != root.right.data) {
            return false;
        }

        // Recursive calls for left and right subtrees
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    public static void main(String args[]) {
        // Construct the tree
        Node root = new Node(1);
        root.left = new Node(1);
        root.right = new Node(1);
        root.left.left = new Node(1);
        root.left.right = new Node(1);
        root.right.right = new Node(1);

        // Check if the tree is a unival tree
        if (isUnivalTree(root)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

=== Code Output===
YES

=== Code Execution Successful ===
