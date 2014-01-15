public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        if (obstacleGrid[0][0] == 1) return 0;
        
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] result = new int[n][m];
        
        result[0][0] = 1;
        for (int index = 1; index < m; index++) {
            if (obstacleGrid[0][index] == 0) result[0][index] = result[0][index - 1];
            else result[0][index] = 0;
        }
        for (int index = 1; index < n; index++) {
            if (obstacleGrid[index][0] == 0) result[index][0] = result[index - 1][0];
            else result[index][0] = 0;
        }
        
        for (int indexN = 1; indexN < n; indexN++) {
            for (int indexM = 1; indexM < m; indexM++) {
                if (obstacleGrid[indexN][indexM] == 0) result[indexN][indexM] = result[indexN - 1][indexM] + result[indexN][indexM - 1];
                else result[indexN][indexM] = 0;
            }
        }
        
        return result[n - 1][m - 1];
    }
}
