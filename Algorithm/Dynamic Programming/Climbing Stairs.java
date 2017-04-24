public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if (n == 0) {
            return 1;
        }
        if (n < 3) {
            return n;
        }
         //state: how many distinct ways to climb to n
        int[] step = new int[n + 1];
        //initialization
        step[1] = 1;
        step[2] = 2;
        //loop
        for (int i = 3; i <= n; i++) {
            step[i] = step[i - 2] + step[i - 1];
        }
        //answer
        return step[n];
    }
}
