public class Solution {
    public int climbStairs(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int[] results = new int[n + 1];
        results[0] = 1;
        results[1] = 1;
        
        for (int index = 2; index <= n; index++) {
            results[index] = results[index - 1] + results[index - 2];
        }
        
        return results[n];
    }
}
