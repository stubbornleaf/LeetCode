public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        
        int length = matrix[0].length, width = matrix.length, m = 0, n = width - 1;
        
        while (m >= 0 && m < length && n >= 0 && n < width) {
            int val = matrix[n][m];
            if (val == target) return true;
            if (val > target) n--;
            else m++;
        }
        
        return false;
    }
}
