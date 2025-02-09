import java.util.*;

public class Main { // This is the main class required by the online compiler
    public static void main(String args[]) {
        MyHashMap<String, Integer> hm = new MyHashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Nepal", 5);

        for (String key : hm.keySet()) {
            System.out.println(key + " -> " + hm.get(key));
        }

        System.out.println("Get India: " + hm.get("India"));
        System.out.println("Remove India: " + hm.remove("India"));
        System.out.println("Get India After Removal: " + hm.get("India"));
        System.out.println("Is Empty: " + hm.isEmpty());
    }
}

// Custom HashMap class (renamed to avoid conflict)
class MyHashMap<K, V> {
    private class Node {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int n;
    private int N;
    private LinkedList<Node>[] buckets;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        this.N = 4;
        this.buckets = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }

    private int hashFunction(K key) {
        int hc = key.hashCode();
        return Math.abs(hc) % N;
    }

    private int searchInLL(K key, int bi) {
        LinkedList<Node> ll = buckets[bi];
        for (int i = 0; i < ll.size(); i++) {
            Node node = ll.get(i);
            if (node.key.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    private void rehash() {
        LinkedList<Node>[] oldBuckets = buckets;
        buckets = new LinkedList[N * 2];
        N = 2 * N;
        for (int i = 0; i < N; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (int i = 0; i < oldBuckets.length; i++) {
            LinkedList<Node> ll = oldBuckets[i];
            for (Node node : ll) {
                put(node.key, node.value);
            }
        }
    }

    public void put(K key, V value) {
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);

        if (di != -1) {
            Node node = buckets[bi].get(di);
            node.value = value;
        } else {
            buckets[bi].add(new Node(key, value));
            n++;
        }

        double lambda = (double) n / N;
        if (lambda > 2.0) {
            rehash();
        }
    }

    public boolean containsKey(K key) {
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);
        return di != -1;
    }

    public V remove(K key) {
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);

        if (di != -1) {
            Node node = buckets[bi].remove(di);
            n--;
            return node.value;
        }
        return null;
    }

    public V get(K key) {
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);

        if (di != -1) {
            Node node = buckets[bi].get(di);
            return node.value;
        }
        return null;
    }

    public ArrayList<K> keySet() {
        ArrayList<K> keys = new ArrayList<>();

        for (int i = 0; i < buckets.length; i++) {
            LinkedList<Node> ll = buckets[i];
            for (Node node : ll) {
                keys.add(node.key);
            }
        }
        return keys;
    }

    public boolean isEmpty() {
        return n == 0;
    }
}

=== Code Output ===

Nepal -> 5
US -> 50
India -> 100
China -> 150
Get India: 100
Remove India: 100
Get India After Removal: null
Is Empty: false

=== Code Execution Successful ===
