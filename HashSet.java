import java.util.*;

public class Main {
    public static void main(String args[]) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Bengaluru"); // Corrected spelling
        
        Iterator<String> it = cities.iterator(); // Fixed incorrect type
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

=== Code Output===
Delhi
Bengaluru
Noida
Mumbai

=== Code Execution Successful ===
