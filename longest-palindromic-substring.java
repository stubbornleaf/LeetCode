public class Solution {
    public String longestPalindrome(String s) {
        int length = s.length(), max = 1, start = 0, end = 0;
        boolean[][] isPalindrome = new boolean[length][length];
        
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (i == 0) {
                    isPalindrome[i][j] = true;
                } else if (i == 1) {
                    isPalindrome[i][j] = s.charAt(j) == s.charAt(j + i);
                    if (isPalindrome[i][j] && (i + 1) > max) {
                        max = i + 1;
                        start = j;
                        end = start + i;
                    }
                } else {
                    isPalindrome[i][j] = (s.charAt(j) == s.charAt(j + i) && isPalindrome[i - 2][j + 1]);
                    if (isPalindrome[i][j] && (i + 1) > max) {
                        max = i + 1;
                        start = j;
                        end = start + i;
                    }
                }
            }
        }
        
        return s.substring(start, end + 1);
    }
}
