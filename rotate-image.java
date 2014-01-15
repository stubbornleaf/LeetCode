public class Solution {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        
        for (int index = 0; index < length / 2; index++) {
            for (int count = 0; count < length - index * 2 - 1; count++) {
                int m = index, n = index + count, tmp = matrix[m][n];
                matrix[m][n] = matrix[length - n - 1][m];
                matrix[length - n - 1][m] = matrix[length - m - 1][length - n -1];
                matrix[length - m - 1][length - n -1] = matrix[n][length - m - 1];
                matrix[n][length - m - 1] = tmp;
            }
        }
    }
}
