public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int current = 1;
        
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = i; j <= n - i - 1 && current <= n * n; j++) {
                result[i][j] = current++;
            }
            for (int j = i + 1; j < n - i - 1 && current <= n * n; j++) {
                result[j][n - i - 1] = current++;
            }
            for (int j = i; j < n - i - 1 && current <= n * n; j++) {
                result[n - i - 1][n - j - 1] = current++;
            }
            for (int j = i; j < n - i - 1 && current <= n * n; j++) {
                result[n - j - 1][i] = current++;
            }
        }
        
        return result;
    }
}
