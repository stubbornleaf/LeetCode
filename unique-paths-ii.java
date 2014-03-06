public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0][0] == 1) return 0;
        
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] result = new int[m];
        
        result[0] = 1;
        for (int index = 1; index < m; index++) {
            if (obstacleGrid[0][index] == 0) result[index] = result[index - 1];
            else result[index] = 0;
        }
        
        for (int indexN = 1; indexN < n; indexN++) {
            if (obstacleGrid[indexN][0] == 1) {
                result[0] = 0;
            }
            for (int indexM = 1; indexM < m; indexM++) {
                if (obstacleGrid[indexN][indexM] == 0) result[indexM] = result[indexM] + result[indexM - 1];
                else result[indexM] = 0;
            }
        }
        
        return result[m - 1];
    }
}
