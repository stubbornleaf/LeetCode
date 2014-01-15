public class Solution {
    public int maxProfit(int[] prices) {
        int base = Integer.MAX_VALUE, maxProfit = 0;
        
        for (int index = 0; index < prices.length; index++) {
            if (prices[index] < base) {
                base = prices[index];
            }
            
            if ((prices[index] - base) > maxProfit) {
                maxProfit = prices[index] - base;
            }
        }
        
        return maxProfit;
    }
}
