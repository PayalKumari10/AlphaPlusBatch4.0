import java.util.*;

public class Main {
    public static void main(String args[]) {
        HashSet<String>cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Bengaluru");
        System.out.println(cities);
        
        LinkedHashSet<String>lhs = new LinkedHashSet<>();
        
        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Noida");
        lhs.add("Bengaluru");
        System.out.println(lhs);
        
        TreeSet<String> ts = new TreeSet<>();
        ts.add("Delhi");
        ts.add("Mumbai");
        ts.add("Noida");
        ts.add("Bengalurur");
        System.out.println(ts);
        
     }
}


=== Code Output ===

[Delhi, Bengaluru, Noida, Mumbai]  //(HashSet)-unorder 
[Delhi, Mumbai, Noida, Bengaluru]  //(LinkedHashSet)-same input getting output same order
[Bengalurur, Delhi, Mumbai, Noida] //(TreeSet)-order (A-Z)

=== Code Execution Successful ===
