public class Solution {
    public int numDistinct(String S, String T) {
        if (S.length() < T.length()) return 0;
        
        int[] result = new int[S.length()];
        int count = 0;
        
        for (int i = 0; i < S.length(); i++) {
            if (T.charAt(0) == S.charAt(i)) {
                count++;
            }
            result[i] = count;
        }
        
        for (int i = 1; i < T.length(); i++) {
            int previous = result[0];
            result[0] = 0;
            for (int j = 1; j < S.length(); j++) {
                int tmp = result[j];
                if (T.charAt(i) == S.charAt(j)) {
                    result[j] = previous + result[j - 1];
                } else {
                    result[j] = result[j - 1];
                }
                previous = tmp;
            }
        }
        
        return result[S.length() - 1];
    }
}
