import java.util.*;

class Solution {
    public String reverseParentheses(String s) {
        
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder current = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                // Save current string
                stack.push(current);
                current = new StringBuilder();
            } 
            else if (ch == ')') {
                // Reverse content inside brackets
                current.reverse();

                // Add it to the previous string
                StringBuilder previous = stack.pop();
                previous.append(current);

                current = previous;
            } 
            else {
                current.append(ch);
            }
        }

        return current.toString();
    }
}