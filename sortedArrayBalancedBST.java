import java.util.*;

public class Main {
    static class Node {
        int data;
        Node left;
        Node right;
        
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    public static void preorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.println(root.data+"");
        preorder(root.left);
        preorder(root.right);
    }
    
    public static Node createBST(int arr[], int st, int end) {
        if(st > end) {
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(arr[mid]);
        root.left =  createBST(arr, st, mid-1);
        root.right = createBST(arr, mid+1, end);
        return root;
    }
    
    public static void main(String args[]) {
        int arr[] = {3,5,6,8,10,11,12};
        
        Node root = createBST(arr, 0, arr.length-1);
        preorder(root);
    }
}


=== Code Output ===

8
5
3
6
11
10
12

=== Code Execution Successful ===
