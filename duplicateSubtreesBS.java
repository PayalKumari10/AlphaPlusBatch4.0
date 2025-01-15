import java.util.HashMap;

public class Main {
    static HashMap<String, Integer> m;

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static String inorder(Node node) {
        if (node == null)
            return "";

        String str = "(";
        str += inorder(node.left);
        str += Integer.toString(node.data);
        str += inorder(node.right);
        str += ")";

        // Check for duplicate subtrees
        if (m.get(str) != null && m.get(str) == 1) {
            System.out.println("Duplicate subtree rooted at: " + node.data);
        }

        // Update the HashMap
        if (m.containsKey(str)) {
            m.put(str, m.get(str) + 1);
        } else {
            m.put(str, 1);
        }

        return str;
    }

    static void printAllDups(Node root) {
        m = new HashMap<>();
        inorder(root);
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

        // Print all duplicate subtrees
        printAllDups(root);
    }
}

=== Code Output ===
Duplicate subtree rooted at: 3

=== Code Execution Successful ===
