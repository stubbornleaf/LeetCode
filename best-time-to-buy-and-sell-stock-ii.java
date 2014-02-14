public class Solution {
    /*
     * To obtain max profit, just sell the stock if next price is lower than current price.
     */
    public int maxProfit(int[] prices) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int profit = 0, previous = Integer.MAX_VALUE;
        
        for (int index = 0; index < prices.length; index++) {
            if(prices[index] > previous) {
                profit += prices[index] - previous;
            }
            previous = prices[index];
        }
        
        return profit;
    }
}
