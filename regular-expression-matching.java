public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        
        if (p.length() > 1 && p.charAt(1) == '*') {
            int n = 0;
            while (n <= s.length() && (n == 0 || s.charAt(n - 1) == p.charAt(0) || p.charAt(0) == '.' )) {
                boolean tmp = isMatch(s.substring(n), p.substring(2));
                if (tmp) return true;
                else n++;
            }
            return false;
        } else {
            if (s.length() == 0) return false;
            
            char c = p.charAt(0);
            if (c == '.') {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                if (c != s.charAt(0)) return false;
                else return isMatch(s.substring(1), p.substring(1));
            }
        }
    }
}
