import java.util.*;

class Main {
    static int BalancedPartition(String str, int n) {
        int r = 0, l = 0; 
        int ans = 0;      
        
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'R') {
                r++;
            } else if (str.charAt(i) == 'L') {
                l++;
            }
            if (r == l) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "LLRRRLLRRL";
        int n = str.length();
        
        System.out.println("Balanced partitions: " + BalancedPartition(str, n));
    }
}


=== Code Output ===

Balanced partitions: 4

=== Code Execution Successful ===
