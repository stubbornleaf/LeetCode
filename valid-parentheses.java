public class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();
        
        for (int index = 0; index < s.length(); index++) {
            char c = s.charAt(index);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.size() == 0) return false;
                char tmp = stack.pop();
                if (c == ')') {
                    if (tmp != '(') return false;
                } else if (c == '}') {
                    if (tmp != '{') return false;
                } else {
                    if (tmp != '[') return false;
                }
            }
        }
        
        return stack.size() == 0;
    }
}
