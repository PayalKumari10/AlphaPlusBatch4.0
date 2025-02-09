import java.util.*;

public class Main {
    public static void main(String args[]) {
        //create
        HashMap<String, Integer> hm = new HashMap<>();
        
        //Insert
        hm.put("India", 100);
        hm.put("china", 150);
        hm.put("US", 50);
        
        System.out.println(hm);
        
        //size
        System.out.println(hm.size());
        
        //Is Empty
        hm.clear();
        System.out.println(hm.isEmpty());
    }
}


=== Code Output ===

{china=150, US=50, India=100}
3
true

=== Code Execution Successful ===
