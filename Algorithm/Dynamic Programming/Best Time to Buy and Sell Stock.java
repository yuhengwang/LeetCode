track the so far min value of the stock, and buy it. Because we can only sell the stock after buying it, hence use variable : max to track the
biggest difference between buy and sell
public class Solution {
    public int maxProfit(int[] prices) {
        //special condition
        if (prices == null || prices.length < 2) {
            return 0;
        }
        
       int curMin = Integer.MAX_VALUE;
       curMin = prices[0];
       int max = Integer.MIN_VALUE;
       for (int i = 1; i < prices.length; i++) {
           if (curMin > prices[i]) {
               curMin = prices[i];
           }
           max = Math.max(max, (prices[i] - curMin));
       }
       return max;
    }
}
