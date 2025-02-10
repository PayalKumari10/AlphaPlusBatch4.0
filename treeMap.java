import java.util.*;

public class Main {
    public static void main(String args[]) {
        TreeMap<String, Integer> tm = new TreeMap<>();
        
        tm.put("India", 100);
        tm.put("China", 150);
        tm.put("US", 50);
        tm.put("Indonesia", 6);

        
        HashMap<String, Integer> hm = new HashMap<>();
        
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        
        System.out.println(hm);
        System.out.println(tm);
    }
}

=== Code Output ===

{China=150, US=50, India=100}   //HashMap 
{China=150, India=100, Indonesia=6, US=50}   //TreeMap ->  sorted through keys

=== Code Execution Successful ===

