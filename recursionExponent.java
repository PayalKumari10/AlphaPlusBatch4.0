import java.util.*;

public class Main {
    // Method to calculate power efficiently using recursion
    public static int power2(int a, int n) {
        if (n == 0) {
            return 1;
        }

        int halfPower = power2(a, n / 2);
        int halfPowerSq = halfPower * halfPower;

        if (n % 2 != 0) { // If n is odd
            return a * halfPowerSq;
        }

        return halfPowerSq;
    }

    public static void main(String[] args) {
        // Testing the power2 method
        int base = 2;
        int exponent = 5;
        System.out.println("Result: " + power2(base, exponent));
    }
}



=== Code Output ===

Result: 32

=== Code Execution Successful ===
