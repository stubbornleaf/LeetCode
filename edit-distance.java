public class Solution {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length(), length2 = word2.length();
        int[][] result = new int[length2 + 1][length1 + 1];
        
        for (int index = 0; index <= length1; index++) result[0][index] = index;
        for (int index = 0; index <= length2; index++) result[index][0] = index;
        
        for (int i = 0; i < length2; i++) {
            for (int j = 0; j < length1; j++) {
                if (word1.charAt(j) == word2.charAt(i)) {
                    result[i + 1][j + 1] = result[i][j];
                } else {
                    int min = result[i][j] > result[i + 1][j] ? result[i + 1][j] : result[i][j];
                    min = result[i][j + 1] > min ? min : result[i][j + 1];
                    result[i + 1][j + 1] = min + 1;
                }
            }
        }
        
        return result[length2][length1];
    }
}
