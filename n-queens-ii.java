public class Solution {
    private int total = 0;
    
    public int totalNQueens(int n) {
        boolean[] columns = new boolean[n];
        boolean[] leftDiags = new boolean[n * 2 - 1];
        boolean[] rightDiags = new boolean[n * 2 - 1];
        
        findSolution(columns, leftDiags, rightDiags, 0, n);
        
        return total;
    }
    
    private void findSolution(boolean[] columns, boolean[] leftDiags, boolean[] rightDiags, int row, int n) {
        if (row == n) {
            total++;
        }
        
        for (int i = 0; i < columns.length; i++) {
            if (!columns[i] && !leftDiags[i - row + n - 1] && !rightDiags[i + row]) {
                columns[i] = true;
                leftDiags[i - row + n - 1] = true;
                rightDiags[i + row] = true;
                
                findSolution(columns, leftDiags, rightDiags, row + 1, n);
                
                columns[i] = false;
                leftDiags[i - row + n - 1] = false;
                rightDiags[i + row] = false;
            }
        }
    }
}
