
public class Solution {
    /*
     * @param : a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length == 0) {
            return false;
        }
        int n = values.length;
        //后i个数的sum
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum[n - i] = sum[n - i - 1] + values[i];  
        }
        //state: 现在还剩i个金币，现在取得人最后最多可以去多少价值的金币
        int[] f = new int[n + 1];
        if (n == 0) {
            return false;
        }
        if (n == 1 || n == 2) {
            return true;
        }

        f[0] = 0;
        f[1] = values[n - 1];
        f[2] = values[n - 1] + values[n - 2];
        //我先取了1个金币，后面玩家能取到的最大值， 我先取了2个金币，后面玩家取到的最大值
        for (int i = 3; i <= n; i++) {
            f[i] = Math.max(sum[i] - f[i - 1], sum[i] - f[i - 2]);
        }
        return f[n] > sum[n] / 2;
    }
};
