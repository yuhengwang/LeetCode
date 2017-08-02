博弈DP，state定义某一个人的状态
Method I :
public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        //state: 当剩下i个金币的时候，当前取得人的输赢情况
        boolean[] f = new boolean[n + 1];
        if (n == 0) return false;
        if (n == 1) return true;
        if (n == 2) return true;
        f[0] = false;
        f[1] = true;
        f[2] = true;
        for (int i = 3; i <= n; i++) {
            f[i] = !f[i - 1] || !f[i - 2];  //我取了一个或者两个金币之后，另外一个输我就是赢
        }
        return f[n];
    }
}

