import java.util.*;

public class Main {
    static class Node { 
        Node[] children = new Node[26];
        boolean eow = false;
        int freq;

        public Node() {
            Arrays.fill(children, null);
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } else {
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static void findPrefix(Node node, String ans) {
        if (node == null) { 
            return;
        }

        if (node.freq == 1) { 
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < node.children.length; i++) { 
            if (node.children[i] != null) {
                findPrefix(node.children[i], ans + (char) (i + 'a'));
            }
        }
    }

    public static void main(String args[]) {
        String arr[] = {"zebra", "dog", "duck", "dove"};
        for (String word : arr) {
            insert(word);
        }
        root.freq = -1;
        findPrefix(root, "");
    }
}

=== Code Output ===

dog  // ascending order in A to Z
dov
du
z

=== Code Execution Successful ===
