public class Solution {
    private char[][] chars = new char[][]{ { ' ' }, { }, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' }, { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
    
    public ArrayList<String> letterCombinations(String digits) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<String> combinations = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        
        findCombination(digits, 0, sb, combinations);
        
        return combinations;
    }
    
    private void findCombination(String digits, int position, StringBuilder sb, ArrayList<String> combinations) {
        if (position == digits.length()) {
            combinations.add(sb.toString());
            return;
        }
        
        for (int i = 0; i < chars[digits.charAt(position) - '0'].length; i++) {
            sb.append(new Character(chars[digits.charAt(position) - '0'][i]).toString());
            findCombination(digits, position + 1, sb, combinations);
            sb.deleteCharAt(position);
        }
    }
}
