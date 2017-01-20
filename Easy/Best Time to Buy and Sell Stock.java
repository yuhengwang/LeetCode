public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int min = prices[0];
        int profit = prices[1] - prices[0];
        for( int i = 2; i < prices.length; i++) {
            min = Math.min(min, prices[i - 1]);
            profit = Math.max(profit, prices[i] - min);
        }
        if(profit < 0) {
            return 0;
        }
        return profit;
    }
}
