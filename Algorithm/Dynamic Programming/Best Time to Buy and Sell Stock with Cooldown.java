because there must be a cooldown day after selling a stock, so we use 5 variables to track
b0: the profit if we buy a stock today
b1: the profit if we bought a stock yesterday
s0: the profit if we sell a stock today
s1: the profit if we sell a stock yesterday
s2: the profit if we sell a stock the day before yesterday
The initial state happens at the first day, where i = 0. Hence, b0 (ie. the profit) should be the negative price of the stock on 0th day, b1
should be same as b0. For si, because there is no buy action before sell, there are all be 0.
For the loop part, the buy profit of current day should be considered by two conditions( buy or not buy), 
FIRST, we do nothing and simply copy the profit of yesterday, 
SECOND, there is a sell 2 days before so that we can buy it now.
the sell profit of current day should also be considered two conditions, one is to sell, another is not to sell. if it to sell it, it gonna be 
the profit of buy it yesterday and the price of stock today.
NOTE THAT b1 does not mean we have to buy it on yesterday, maybe it did nothing on yesterday.

Then we will return the profit of sell it on the current day, because we need to sell stock to get profit, it is reasonable that last action
is to sell stocks.

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int b0 = -prices[0];
        int b1 = b0;
        int s0 = 0;
        int s1 = 0;
        int s2 = 0;
        for (int i = 1; i < prices.length; i++) {
            b0 = Math.max(b1, s2 - prices[i]);
            s0 = Math.max(s1, prices[i] + b1);
            s2 = s1; s1 = s0;  b1 = b0;
        }
        return s0;
    }
}
