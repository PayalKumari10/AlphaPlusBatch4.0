import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class Main {
    public static Node createMirror(Node root) {
        if (root == null) {
            return null;
        }
        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;
        return root;
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String args[]) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);

        System.out.println("Original Tree (Preorder):");
        preorder(root);

        root = createMirror(root);

        System.out.println("\nMirrored Tree (Preorder):");
        preorder(root);
    }
}

=== Code Output ===

Original Tree (Preorder):
8 5 3 6 10 11 
Mirrored Tree (Preorder):
8 10 11 5 6 3 
=== Code Execution Successful ===
