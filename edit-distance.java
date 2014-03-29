public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return 0;
        } else if (word1 == null) {
            return word2.length();
        } else if (word2 == null) {
            return word1.length();
        }
        
        int m = word1.length(), n = word2.length(), previous;
        int[] result = new int[m + 1];
        
        for (int i = 0; i <= m; i++) {
            result[i] = i;
        }
        
        for (int i = 0; i < n; i++) {
            previous = result[0];
            result[0] = i + 1;
            for (int j = 0; j < m; j++) {
                if (word1.charAt(j) == word2.charAt(i)) {
                    int tmp = result[j + 1];
                    result[j + 1] = previous;
                    previous = tmp;
                } else {
                    int min = previous > result[j] ? result[j] : previous;
                    min = min > result[j + 1] ? result[j + 1] : min;
                    previous = result[j + 1];
                    result[j + 1] = min + 1;
                }
            }
        }
        
        return result[m];
    }
}
