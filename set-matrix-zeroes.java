public class Solution {
    /*
     * Use first row and column as tmp records.
     */
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) return;
        
        boolean firstRowZeroes = false, firstColZeroes = false;
        int index;
        
        for (index = 0; index < matrix[0].length; index++) {
            if (matrix[0][index] == 0) {
                firstRowZeroes = true;
                break;
            }
        }
        
        for (index = 0; index < matrix.length; index++) {
            if (matrix[index][0] == 0) {
                firstColZeroes = true;
                break;
            }
        }
        
        for (index = 0; index < matrix.length; index++) {
            for (int i = 0; i < matrix[index].length; i++) {
                if (matrix[index][i] == 0) {
                    matrix[0][i] = 0;
                    matrix[index][0] = 0;
                }
            }
        }
        
        for (index = 1; index < matrix.length; index++) {
            for (int i = 1; i < matrix[index].length; i++) {
                if (matrix[0][i] == 0 || matrix[index][0] == 0) {
                    matrix[index][i] = 0;
                }
            }
        }
        
        if (firstRowZeroes) {
            for (index = 0; index < matrix[0].length; index++) matrix[0][index] = 0;
        }
        
        if (firstColZeroes) {
            for (index = 0; index < matrix.length; index++) matrix[index][0] = 0;
        }
    }
}
