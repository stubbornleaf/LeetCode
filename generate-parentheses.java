public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        generateParenthesis("", n, n, result);
        return result;
    }
    
    private void generateParenthesis(String current, int left, int right, ArrayList<String> result) {
        if (left != 0) {
            if (left < right) {
                // Only put a ')' when there are more ')' than '('.
                generateParenthesis(current + ")", left, right - 1, result);
            }
            generateParenthesis(current + "(", left - 1, right, result);
        } else {
            StringBuilder sb = new StringBuilder(current);
            for (int index = 0; index < right; index++) {
                sb.append(")");
            }
            result.add(sb.toString());
        }
    }
}
