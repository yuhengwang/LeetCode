//123. same as IV stock
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        if (prices.length < 5) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] - prices[i - 1] > 0) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        int[][] profit = new int[3][prices.length];
        //initialization
        for (int i = 0; i < prices.length; i++) {
            profit[0][i] = 0;
        }
        for (int i = 0; i < 3; i++) {
            profit[i][0] = 0;  
        }
        for (int i = 1; i < 3; i++) {
            int tempMax = -prices[0];
            for (int j = 1; j < prices.length; j++) {
                 profit[i][j] = Math.max(prices[j] + tempMax, profit[i][j - 1]); //sell or do nothing
                 tempMax = Math.max((profit[i - 1][j - 1] - prices[j]), tempMax); 
            }
        }
        return profit[2][prices.length - 1];
        
    }
}
