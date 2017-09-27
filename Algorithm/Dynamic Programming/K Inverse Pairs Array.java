when we try to add a new digit, the position we move it from right will create the same amount of new inverse pairs, for example, if we
put it on the right, no new inverse pairs will generate, if we put it one position from right, one new inverse pair will generate. 
From the last approach, we've observed that we need to traverse back to some limit in the previous row of the dpdp array to fill in the current dpdp entry. Instead of doing this traversal to find the sum of the required elements, we can ease the process if we fill the cumulative sum upto the current element in a row in any dpdp entry, instead of the actual value.

Thus, now, dp[i][j]=count(i,j)+\sum_{k=0}^{j-1} dp[i][k]dp[i][j]=count(i,j)+∑
​k=0
​j−1
​​ dp[i][k]. Here, count(i,j) refers to the number of arrangements with i elements and exactly j inverse pairs. Thus, each entry 
contains the sum of all the previous elements in the same row along with its own result.

Now, we need to determine the value of count(i,j)count(i,j) to be added to the sum of previous elements in a row, in order to update 
the dp[i][j] entry. But, we need not traverse back in the previous row , since it contains entries representing the cumulative
sums now. Thus, to obtain the sum of elements from dp[i-1][j-i+1] (when we put the new digit at the head of the number, we can 
generate i new inverse pairs to get j inverse pairs) to dp[i-1][j](including both), we can 
directly use dp[i-1][j] - dp[i-1][j-i].

Now, to reflect the condition min(j,i−1) used in the previous approaches, we can note that, 
we need to take the sum of only i elements in the previous row, if ii elements exist till we reach the end of the 
array while traversing backwards. Otherwise, we simply take the sum of all the elements.

Only ii elements are considered because for generating j new inverse pairs, by adding i as the new number at the jth position, j could
reach only upto i-1, as discussed in the last approaches as well. Thus, we need to consider the sum of elements from dp[i-1][j-(i-1)]
to dp[i-1][j](including both) using dp[i-1][j] - dp[i-1][j-i] if j−i≥0

Otherwise, we add all the elements of the previous row upto the current column jj being considered. In other words, 
we can use dp[i-1][j] directly as the required sum.

At the end, while returning the result, we need to return dp[n][k]-dp[n][k-1] to obtain the required result from the cumulative sums.
class Solution {
    public int kInversePairs(int n, int k) {
        //how many answers for the k inverse pairs in n length string
        int M = 1000000007;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    // upper layer range dp[i - 1][j] - dp[i - 1][j - i] if j - i < 0 return 0
                    int val = (dp[i - 1][j] + M - (j < i ?  0 : dp[i - 1][j - i])) % M;
                    dp[i][j] = (val + dp[i][j - 1]) % M;
                }
            }
        }
        // 4, 2
        // 3, 2// 3, 1//3, 0
        return (dp[n][k] + M - (k > 0 ? dp[n][k - 1] : 0)) % M;
    }
}
