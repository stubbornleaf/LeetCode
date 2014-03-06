public class Solution {
    public int uniquePaths(int m, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (m == 0) return 0;
        
        int[] result = new int[m];
        int indexM, indexN;
        
        for (indexM = 0; indexM < m; indexM++) result[indexM] = 1;
        for (indexN = 1; indexN < n; indexN++) {
            for (indexM = 1; indexM < m; indexM++) {
                result[indexM] = result[indexM] + result[indexM - 1];
            }
        }
        
        return result[m - 1];
    }
}
