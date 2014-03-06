public class Solution {
    public int minPathSum(int[][] grid) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (grid.length == 0) return 0;
        
        int m = grid[0].length, n = grid.length, indexM, indexN;
        int[] result = new int[m];
        
        result[0] = grid[0][0];
        for (indexM = 1; indexM < m; indexM++) {
            result[indexM] = result[indexM - 1] + grid[0][indexM];
        }
        for (indexN = 1; indexN < n; indexN++) {
            result[0] = result[0] + grid[indexN][0];
            for (indexM = 1; indexM < m; indexM++) {
                if (result[indexM] > result[indexM - 1]) {
                    result[indexM] = result[indexM - 1] + grid[indexN][indexM];
                } else {
                    result[indexM] = result[indexM] + grid[indexN][indexM];
                }
            }
        }
        
        return result[m - 1];
    }
}
