import java.util.*;
public class Main {
    public static void findPermutation(String str, String ans) {
        //base case
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }
        //recursion - O(n*n!)
        for(int i=0; i<str.length(); i++) {
            char curr = str.charAt(i);
            //"abcd" => "ab"  + "de" = "abde"
            String NewStr = str.substring(0,i) + str.substring(i + 1);
            findPermutation(NewStr, ans+curr);
        }
    }
    public static void main(String args[]) {
        String str = "abc";
        findPermutation(str, "");
    }
}



=== Code Output ===
abc
acb
bac
bca
cab
cba

=== Code Execution Successful ===
