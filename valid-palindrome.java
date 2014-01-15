public class Solution {
    public boolean isPalindrome(String s) {
        int length = s.length(), l = 0, r = length - 1;
        
        while (l < length) {
            Character c = s.charAt(l);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') break;
            else l++;
        }
        while (r >= 0) {
            Character c = s.charAt(r);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') break;
            else r--;
        }
        
        while (l < r) {
            if (new Character(s.charAt(l)).toString().equalsIgnoreCase(new Character(s.charAt(r)).toString())) {
                l++;
                while (l < length) {
                    Character c = s.charAt(l);
                    if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') break;
                    else l++;
                }
                r--;
                while (r >= 0) {
                    Character c = s.charAt(r);
                    if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') break;
                    else r--;
                }
            } else {
                return false;
            }
        }
        
        return true;
    }
}
