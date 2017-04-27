the state is the best worst case if we have i eggs and the building has j floors. To initialize the state, we can ensure that if the floor
only have 0 floor or 1 floor, the worst case must 0 or 1, no matter how many eggs we have. And if we only have one egg, the worst case for j floor building
must be j. After initializing the state, we need to process in loop. Starting from we have 2 eggs and the building has 2 floors, we have two
conditions to consider. We loop from 1 to j - 1, assume we first drop one egg at kth floor, if the egg break, the problem would be tranferred to
i - 1 eggs with k - 1 floors building. If the egg does not break, the problem would be transfered to i egges with j - k floors. We have to select the max number
so that we finish the worst case requirement. 
The LOOP ORDER once again, is first from up to down and from left to right, similar as Knight Shortest distance II. java!!!!!!!
public class Solution {
    /**
     * @param m the number of eggs
     * @param n the umber of floors
     * @return the number of drops in the worst case
     */
    public int dropEggs2(int m, int n) {
        // Write your code here
        //state: the best worst case if we have i eggs and the building has j floors
        int[][] dp = new int[m + 1][n + 1];
        //initialization
        for (int i = 1; i <= m ;i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        for (int j = 0; j <= n; j++) {
            dp[1][j] = j;
        }
        //loop
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[i - 1][k - 1], dp[i][j - k]));
                }
            }
        }
        return dp[m][n];
        
        
    }
}
