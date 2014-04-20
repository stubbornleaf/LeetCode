public class Solution {
    public String strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return haystack;
        }
        
        int[] next = new int[needle.length()];
        int tmp = 0, index = 0;
        
        next[0] = 0;
        for (int i = 1; i < needle.length(); i++) {
            while (tmp > 0 && needle.charAt(i) != needle.charAt(tmp)) {
                tmp = next[tmp - 1];
            }
            if (needle.charAt(i) == needle.charAt(tmp)) {
                tmp++;
            }
            next[i] = tmp;
        }
        
        for (int i = 0; i < haystack.length(); i++) {
            while (index > 0 && haystack.charAt(i) != needle.charAt(index)) {
                index = next[index - 1];
            }
            if (needle.charAt(index) == haystack.charAt(i)) {
                index++;
            }
            if (index == needle.length()) {
                return haystack.substring(i - needle.length() + 1);
            }
        }
        
        return null;
    }
}
