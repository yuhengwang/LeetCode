
public class Solution {
    /*
     * @param : a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        int n = values.length;
        // from ith coin to jth coin, the sum of all coin value
        if (n <= 2) {
            return true;
        }
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + values[i - 1];
        }
        //if ith coin to jth coin is left, the maximum value that the current player will get
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            f[i][i] = values[i];
        }
        for loop循环的顺序很重要！！， f[i][j]是依靠在DOWN和LEFT，所以从row开始遍历是不可以的，只能斜着遍历
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n; i++) {
                int j = i + len - 1;
                System.out.println(i + " " + j); 输出的值以3x1的array为例，
                输出的是 0 1
                        1 2
                         2 3
                         0 2
                         1 3
                         2 4
                if (j >= n) continue;
                int s = sum[j + 1] - sum[i];//ith 到 jth coin之间的总值
                f[i][j] = Math.max(s - f[i + 1][j], s - f[i][j - 1]);
            }
        }
        不对的循环！！
        /*for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int s = sum[j + 1] - sum[i]; 
                f[i][j] = Math.max(s - f[i + 1][j], 
                s - f[i][j - 1]);
            }
        }*/
        return f[0][n - 1] > sum[n] / 2;
    }
};
