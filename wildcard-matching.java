public class Solution {
    public boolean isMatch(String s, String p) {
        String[] words = p.split("[*]+");
        if (p == null || p.length() == 0) {
            return s == null || s.length() == 0;
        }
        if (words.length == 0) {
            return p.length() != 0;
        }
        if (!p.contains("*")) {
            if (s.length() != p.length()) {
                return false;
            }
            boolean isMatch = true;
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) != '?' && s.charAt(i) != p.charAt(i)) {
                    isMatch = false;
                    break;
                }
            }
            return isMatch;
        }
        int end = -1;
        
        end = findFirst(s, 0, words[0]);
        if (end == -1 || p.charAt(0) != '*' && end != 0) {
            return false;
        }
        for (int i = 1; i < words.length; i++) {
            end = findFirst(s, end + words[i - 1].length(), words[i]);
            if (end == -1) {
                return false;
            }
        }
        if (p.charAt(p.length() - 1) == '*') {
            return true;
        }
        
        String last = words[words.length - 1];
        int i;
        for (i = last.length() - 1; i >= 0 && (s.length() - last.length() + i) >= 0; i--) {
            if (last.charAt(i) != '?' && last.charAt(i) != s.charAt(s.length() - last.length() + i)) {
                return false;
            }
        }
        return (s.length() - last.length() + i + 1) >= 0;
    }
    
    private int findFirst(String s, int start, String p) {
        for (int i = start; i <= s.length() - p.length(); i++) {
            boolean isMatch = true;
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) != '?' && p.charAt(j) != s.charAt(i + j)) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                return i;
            }
        }
        return -1;
    }
}
