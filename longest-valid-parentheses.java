public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int index = 1;
        
        while (index <= s.length()) {
            if (s.charAt(index - 1) == '(') {
                stack.push(index);
            } else {
                if (stack.empty() || stack.peek() < 0) {
                    stack.push(-index);
                } else {
                    stack.pop();
                }
            }
            
            index++;
        }
        
        if (stack.empty()) return s.length();
        
        int max = 0, previous = s.length() + 1, tmp;
        while (!stack.empty()) {
            tmp = Math.abs(stack.pop());
            if ((previous - tmp - 1) > max) {
                max = previous - tmp - 1;
            }
            previous = tmp;
        }
        if (previous - 1 > max) max = previous - 1;
        
        return max;
    }
}
