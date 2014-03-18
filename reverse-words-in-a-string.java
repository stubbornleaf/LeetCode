public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (end > start) {
                    sb.insert(0, " " + s.substring(start, end));
                }
                start = i + 1;
                end = i + 1;
            } else {
                end = i + 1;
            }
        }
        
        if (end > start) {
            sb.insert(0, " " + s.substring(start, end));
        }
        
        if (sb.length() > 0 && sb.charAt(0) == ' ') {
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}
