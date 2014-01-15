public class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length <= 1) return 0;
        
        int base, roof, max;
        int[] firstMax = new int[length], secondMax = new int[length];
        
        firstMax[0] = 0;
        base = prices[0];
        max = 0;
        for (int index = 1; index < length; index++) {
            if (prices[index] > base) {
                int tmp = prices[index] - base;
                if (tmp > max) {
                    max = tmp;
                }
            } else {
                base = prices[index];
            }
            firstMax[index] = max;
        }
        
        secondMax[length - 1] = 0;
        roof = prices[length - 1];
        max = 0;
        for (int index = length - 2; index >= 0; index--) {
            if (prices[index] < roof) {
                int tmp = roof - prices[index];
                if (tmp > max) {
                    max = tmp;
                }
            } else {
                roof = prices[index];
            }
            secondMax[index] = max;
        }
        
        max = firstMax[length - 1] > secondMax[0] ? firstMax[length - 1] : secondMax[0];
        for (int index = 0; index < length - 2; index++) {
            if ((firstMax[index] + secondMax[index + 1]) > max) {
                max = firstMax[index] + secondMax[index + 1];
            }
        }
        
        return max;
    }
}
