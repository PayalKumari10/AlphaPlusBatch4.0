import java.util.*;

public class Main {
    public static void main(String args[]) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        
        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("US", 50);
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        
        System.out.println(hm);
        System.out.println(lhm);
    }
}



=== Code Output ===

{China=150, US=50, India=100}   //Inorder way HashMap output
{India=100, China=150, US=50}   //Order way LinkedHashMap output

=== Code Execution Successful ===
