public class Solution {
    public int reverse(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        boolean isNegative = x < 0;
        int result = 0;
        
        if (isNegative) {
            x *= -1;
        }
        
        while (x > 0) {
            result *= 10;
            result += x % 10;
            x /= 10;
        }
        
        return isNegative ? (result * -1) : result;
    }
}
