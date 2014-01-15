public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        
        int power = 1, tmp = x;
        while (tmp >= 10) {
            power *= 10;
            tmp /= 10;
        }
        
        tmp = x;
        while (tmp >= 10) {
            if (tmp / power != tmp % 10) {
                return false;
            } else {
                tmp = (tmp - (tmp / power) * power) - tmp % 10;
                tmp /= 10;
                power /= 100;
            }
        }
        return true;
    }
}
