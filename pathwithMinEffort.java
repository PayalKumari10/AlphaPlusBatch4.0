import java.util.*;

class Main {
    static String decode(String str) {
        Stack<Integer> integerStack = new Stack<>();
        Stack<Character> stringStack = new Stack<>();
        String temp = "", result = "";

        for (int i = 0; i < str.length(); i++) {
            int count = 0;

            if (Character.isDigit(str.charAt(i))) {
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    count = count * 10 + (str.charAt(i) - '0'); 
                    i++;
                }
                i--;
                integerStack.push(count);
            } 
            else if (str.charAt(i) == ']') {
                temp = "";
                count = 1;

                if (!integerStack.isEmpty()) {
                    count = integerStack.pop();
                }

                while (!stringStack.isEmpty() && stringStack.peek() != '[') {
                    temp = stringStack.pop() + temp;
                }

                if (!stringStack.isEmpty() && stringStack.peek() == '[') {
                    stringStack.pop();
                }

                result = "";
                for (int j = 0; j < count; j++) {
                    result += temp;
                }

                for (int j = 0; j < result.length(); j++) {
                    stringStack.push(result.charAt(j));
                }
            } 
            else {
                stringStack.push(str.charAt(i));
            }
        }

        result = "";
        while (!stringStack.isEmpty()) {
            result = stringStack.pop() + result;
        }

        return result;
    }

    public static void main(String args[]) {
        String str = "3[b2[ca]]";
        System.out.println(decode(str)); 
    }
}


// Output: 
bcacabcacabcaca

=== Code Execution Successful ===
