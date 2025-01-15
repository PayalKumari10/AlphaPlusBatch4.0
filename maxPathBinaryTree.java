class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class Res {
    public int val;
}

class Main {
    Node root;

    int findMaxUtil(Node node, Res res) {
        if (node == null)
            return 0;

        // Recursively calculate the maximum path sum for left and right subtrees
        int l = findMaxUtil(node.left, res);
        int r = findMaxUtil(node.right, res);

        // Maximum path sum including at most one child of the current node
        int max_single = Math.max(Math.max(l, r) + node.data, node.data);

        // Maximum path sum including both children of the current node
        int max_top = Math.max(max_single, l + r + node.data);

        // Update the result if max_top is greater
        res.val = Math.max(res.val, max_top);

        return max_single;
    }

    int findMaxSum() {
        return findMaxSum(root);
    }

    int findMaxSum(Node node) {
        Res res = new Res();
        res.val = Integer.MIN_VALUE;

        findMaxUtil(node, res);
        return res.val;
    }

    public static void main(String args[]) {
        Main tree = new Main();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(1);
        tree.root.right.right = new Node(-25);
        tree.root.right.right.left = new Node(3);
        tree.root.right.right.right = new Node(4);

        System.out.println("Maximum path sum is: " + tree.findMaxSum());
    }
}


=== Code Output ===


Maximum path sum is: 42

=== Code Execution Successful ===
