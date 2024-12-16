import java.util.*;

public class Main {
    // Mapping of digits to letters as per a typical phone keypad
    final static char[][] L = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, 
                               {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, 
                               {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    // Function to generate letter combinations
    public static void letterCombinations(String D) {
        int len = D.length();
        if (len == 0) { // If input string is empty
            System.out.println("");
            return;
        }
        // Start the recursive process
        bfs(0, len, new StringBuilder(), D);
    }

    // Recursive function to generate combinations
    public static void bfs(int pos, int len, StringBuilder sb, String D) {
        if (pos == len) {
            // If all digits have been processed, print the current combination
            System.out.println(sb.toString());
            return;
        }

        // Get the letters corresponding to the current digit
        char[] letters = L[Character.getNumericValue(D.charAt(pos))];
        for (int i = 0; i < letters.length; i++) {
            // Recursively build the combinations
            bfs(pos + 1, len, new StringBuilder(sb).append(letters[i]), D);
        }
    }

    // Main function
    public static void main(String args[]) {
        // Test case
        letterCombinations("2");
    }
}

=== Code Output ===
a
b
c

=== Code Execution Successful ===
