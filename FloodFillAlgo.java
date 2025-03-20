import java.util.*;

public class Main {
    public void helper(int[][] image, int sr, int sc, int color, boolean[][] vis, int orgCol) {
        // Base case: Out of bounds, already visited, or color mismatch
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || vis[sr][sc] || image[sr][sc] != orgCol) {
            return;
        }

        // Change color
        image[sr][sc] = color;

        // Mark as visited
        vis[sr][sc] = true;

        // Recursively fill adjacent pixels
        helper(image, sr, sc - 1, color, vis, orgCol); // Left
        helper(image, sr, sc + 1, color, vis, orgCol); // Right
        helper(image, sr - 1, sc, color, vis, orgCol); // Up
        helper(image, sr + 1, sc, color, vis, orgCol); // Down
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] vis = new boolean[image.length][image[0].length];
        int orgCol = image[sr][sc];
        if (orgCol != color) { // Prevent infinite loops
            helper(image, sr, sc, color, vis, orgCol);
        }
        return image;
    }

    public static void main(String args[]) {
        Main obj = new Main();
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1, sc = 1, color = 2;

        System.out.println("Before Flood Fill:");
        for (int[] row : image) {
            System.out.println(Arrays.toString(row));
        }

        int[][] result = obj.floodFill(image, sr, sc, color);

        System.out.println("After Flood Fill:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}

=== Code Output ===

Before Flood Fill:
[1, 1, 1]
[1, 1, 0]
[1, 0, 1]
After Flood Fill:
[2, 2, 2]
[2, 2, 0]
[2, 0, 1]

=== Code Execution Successful ===
