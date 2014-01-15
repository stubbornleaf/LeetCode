public class Solution {
    public int uniquePaths(int m, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int[][] result = new int[m + 1][n + 1];
        int indexM, indexN;
        
        if (m == 0 || n == 0) return 0;
        
        for (indexM = 1; indexM <= m; indexM++) result[indexM][1] = 1;
        for (indexN = 1; indexN <= n; indexN++) result[1][indexN] = 1;
        for (indexM = 2; indexM <= m; indexM++) {
            for (indexN = 2; indexN <= n; indexN++) {
                result[indexM][indexN] = result[indexM - 1][indexN] + result[indexM][indexN - 1];
            }
        }
        
        return result[m][n];
    }
}
