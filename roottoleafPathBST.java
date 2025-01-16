import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Main {
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            // left subtree
            root.left = insert(root.left, val);
        } else {
            // right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static boolean search(Node root, int key) {
        if(root == null) {
            return false;
        }
        if(root.data == key) {
            return true;
        }
        if(root.data > key) {
           return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }
    public static Node findInorderSuccessor(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
    
  
    // public static void printPath(ArrayList<Integer> path) {
    //     for(int i = 0; i<path.size(); i++) {
    //         System.out.println(path.get(i)+"->");
    //     }
    //     System.out.println("N");
    // }
    
    
    public static void printPath(ArrayList<Integer> path) {
    for (int i = 0; i < path.size(); i++) {
        System.out.print(path.get(i));
        if (i < path.size() - 1) {
            System.out.print("->");
        }
    }
    System.out.println("Null"); // Move to the next line after printing the path
}

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if(root == null) {
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null) {
            printPath(path);
        }
        printRoot2Leaf(root.left,path);
        printRoot2Leaf(root.right,path);
        path.remove(path.size()-1);
        
    }
    public static void main(String args[]) {
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inorder(root);
        System.out.println();
        
      
       printRoot2Leaf(root, new ArrayList<>());
    }
}

=== Code Execution Successful ===

1 3 4 5 6 8 10 11 14 
8->5->3->1Null
8->5->3->4Null
8->5->6Null
8->10->11->14Null

=== Code Execution Successful ===
