public class Solution {
    public int maxProfit(int[] prices) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int profit = 0, base = Integer.MAX_VALUE;
        
        for (int index = 0; index < prices.length; index++) {
            if(prices[index] > base) {
                profit += prices[index] - base;
            }
            base = prices[index];
        }
        
        return profit;
    }
}
