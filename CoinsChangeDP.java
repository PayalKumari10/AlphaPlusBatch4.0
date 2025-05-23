import java.util.*;

public class Main {
    public static int coinChange(int coins[], int sum) {
        int n = coins.length; // Define n
        int dp[][] = new int[n+1][sum+1];

        // Initialize when sum is 0
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < sum + 1; j++) {
            dp[0][j] = 0;
        }

        // O(N + Sum)
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else { // Invalid case
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String args[]) {
        int coins[] = {1, 2, 3};
        int sum = 4;
        
        // Call the function and print the result
        System.out.println(coinChange(coins, sum));  
    }
}

=== Code Output ===
4

=== Code Execution Successful ===
