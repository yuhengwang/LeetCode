it is divided into 2 situations for discussion, when k is larger than half of the price array, we can just simply trace the price, if there is
a price higher than previous price, and we will simply add the price difference to the profit.
if k is less than prices.length / 2, the state we use is int[][] profit = new int[k + 1][length], for all 0th operation, the profit would be 0,
and for profit on the first day, it would also be 0, meaning the profit earned after kth transaction until length th day. 
for each new caculation on prices day, the initial stage must buy the stock on first day if we will sell in the following day. 
The logic here is quite similar comparing to the cooldown question, but int[][] profit is similar to sell, and tempMax is similar to buy array. 

Note that, 1 transaction include buy and sell the stock.
public class Solution {
    public int maxProfit(int k, int[] prices) {
        //state:
        int length = prices.length;
        if (k > prices.length / 2) {
            int profit = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i + 1] > prices[i]) {
                    profit += prices[i + 1] - prices[i];
                }
            }
            return profit;
        }
        int[][] profit = new int[k + 1][length];//sell stock at kth operation
        //initialization
        for (int i = 0; i < length; i++) {
            profit[0][i] = 0;
        }
        for (int i = 0; i <= k; i++) {
            profit[i][0] = 0;
        }
        for (int i = 1; i <= k; i++) {
            int tempMax = -prices[0];
            for (int j = 1; j < length; j++) {
                profit[i][j] = Math.max(profit[i][j - 1], tempMax + prices[j]);  //sell; do nothing, 
                tempMax = Math.max(tempMax, profit[i - 1][j - 1] - prices[j]);//buy, do nothing, or buy after the selling
            }
        }
        return profit[k][length - 1];
        
    }
}
