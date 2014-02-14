public class Solution {
    public int climbStairs(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int a = 1, b = 1, result = 1;
        
        for (int index = 2; index <= n; index++) {
            result = a + b;
            a = b;
            b = result;
        }
        
        return result;
    }
}
