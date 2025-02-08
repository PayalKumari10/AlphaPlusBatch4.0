import java.util.*;

public class Main {
    public static void main(String args[]) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Indonesia", 6);
        hm.put("Nepal", 5);
        
        // Iterate
        Set<String> keys = hm.keySet();
        System.out.println(keys);
        for (String k : keys) {
            System.out.println("key=" + k + ", value=" + hm.get(k));
        }
    }
}

=== Code Output ===
[China, US, Nepal, India, Indonesia]
key=China, value=150
key=US, value=50
key=Nepal, value=5
key=India, value=100
key=Indonesia, value=6

=== Code Execution Successful ===
