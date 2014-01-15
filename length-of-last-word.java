public class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        boolean hasLastWord = false;
        
        for (int index = s.length() - 1; index >= 0; index--) {
            char c = s.charAt(index);
            if (c == ' ') {
                if (hasLastWord) break;
                else continue;
            } else {
                hasLastWord = true;
                length++;
            }
        }
        
        return length;
    }
}
