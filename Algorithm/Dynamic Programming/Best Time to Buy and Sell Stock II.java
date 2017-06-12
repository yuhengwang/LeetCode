//leetcode 122 
the example about multiple transactions on buy and sell stock, when the number of transaactions
is larger than half of the prices length.
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
       int profit = 0;
       for (int i = 1; i < prices.length; i++) {
           if (prices[i] > prices[i - 1]) {
               profit += (prices[i] - prices[i - 1]);
           }
       }
       return profit;
    }
}
