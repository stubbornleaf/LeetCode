public class Solution {
    public int minPathSum(int[][] grid) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int m, n;
        
        if (grid.length == 0) return 0;
        
        for (n = 1; n < grid[0].length; n++) grid[0][n] += grid[0][n - 1];
        for (m = 1; m < grid.length; m++) grid[m][0] += grid[m - 1][0];
        
        for (m = 1; m < grid.length; m++) {
            for (n = 1; n < grid[m].length; n++) {
                if (grid[m][n - 1] > grid[m - 1][n]) grid[m][n] += grid[m - 1][n];
                else grid[m][n] += grid[m][n - 1];
            }
        }
        
        return grid[m - 1][n - 1];
    }
}
