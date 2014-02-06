public class Solution {
    public int minCut(String s) {
        int length = s.length();
        boolean[][] isPalindrome = new boolean[length][length];
        int[] cuts = new int[length];
        
        for (int i = 0; i < length; i++) {
            cuts[i] = length - 1;
            for (int j = 0; j < length - i; j++) {
                if (i == 0) {
                    isPalindrome[j][j + i] = true;
                } else if (i == 1) {
                    isPalindrome[j][j + i] = s.charAt(j) == s.charAt(j + i);
                } else {
                    isPalindrome[j][j + i] = s.charAt(j) == s.charAt(j + i) && isPalindrome[j + 1][j + i - 1];
                }
            }
        }
        
        cuts[length - 1] = 0;
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (isPalindrome[i][length - 1]) {
                    cuts[i] = 0;
                } else if (isPalindrome[i][j - 1] && cuts[i] > cuts[j] + 1) {
                    cuts[i] = cuts[j] + 1;
                }
            }
        }
        
        return cuts[0];
    }
}
