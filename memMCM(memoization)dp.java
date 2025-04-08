import java.util.*;

public class Classroom {
    public static int mcm(int arr[], int i, int j) { //O(n^2)
        if(i == j) {
            return 0;  //single matrix case
        }
        
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++) {
            int cost1 = mcm(arr, i, k); //Ai...Ak => arr[i-1]xarr[k]
            int cost2 = mcm(arr, k+1, j); //Ai+1...Aj => arr[k]xarr[j]
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }
        return ans; //mincost
    }
    
    public static int mcmMem(int arr[], int i, int j, int dp[][]) {
        if(i == j) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++) {
            int cost1 = mcmMem(arr, i, k, dp);
            int cost2 = mcmMem(arr, k+1, j, dp);
            int cost3 = arr[i-1] * arr[k] * arr[j];
            ans = Math.min(ans, cost1 + cost2 + cost3);
        }
        return dp[i][j] = ans;
    }
    public static void main(String args[]) {
        int arr [] = {1, 2, 3, 4, 3};  //n = 5
        int n = arr.length;
        
        int dp[][] = new int[n][n];
        for(int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
            System.out.println(mcmMem(arr, 1, n-1,dp ));
       
    }
}

=== Code Output ===
30

=== Code Execution Successful ===
