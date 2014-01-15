public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 0) return result;
        
        int m = matrix[0].length, n = matrix.length;
        
        for (int index = 0; index < (m < n ? (m + 1) / 2 : (n + 1) / 2); index++) {
            for (int j = index; j < m - index - 1; j++) {
                result.add(matrix[index][j]);
            }
            for (int i = index; i < n - index; i++) {
                result.add(matrix[i][m - index - 1]);
            }
            if (index != (n - index - 1) && index != (m - index - 1)) {
                for (int j = m - index - 2; j >= index; j--) {
                    result.add(matrix[n - index - 1][j]);
                }
                for (int i = n - index - 2; i >= index + 1; i--) {
                    result.add(matrix[i][index]);
                }
            }
        }
        
        return result;
    }
}
