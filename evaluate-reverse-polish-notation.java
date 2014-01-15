public class Solution {
    public int evalRPN(String[] tokens) {
        List<String> delimiters = Arrays.asList(new String[]{ "+", "-", "*", "/" });
        Stack<String> nums = new Stack<String>();
        int result = Integer.parseInt(tokens[0]);
        
        for (int index = 0; index < tokens.length; index++) {
            String tmp = tokens[index];
            if (delimiters.contains(tmp)) {
                int b = Integer.parseInt(nums.pop()), a = Integer.parseInt(nums.pop());
                if (tmp.compareTo("+") == 0)
                    result = a + b;
                if (tmp.compareTo("-") == 0)
                    result = a - b;
                if (tmp.compareTo("*") == 0)
                    result = a * b;
                if (tmp.compareTo("/") == 0)
                    result = a / b;
                nums.push(new Integer(result).toString());
            } else {
                nums.push(tokens[index]);
            }
        }
        
        return result;
    }
}
