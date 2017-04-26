public class Solution {
    /**
     * @param n an integer
     * @return an integer
     */
    public int climbStairs2(int n) {
        // Write your code here
        if (n <= 0) {
            return 1;
        }
        // state: how many ways to get on this step
        int[] f = new int[n + 1];
        // initialization
        f[0] = 1;
        f[1] = 1;
        // loop
        for (int i = 2; i <= n; i++) {
            int temp = 0;
            for (int j = Math.max(0, i - 3); j < i; j++) {
                temp += f[j];
            }
            f[i] = temp;
        }
        return f[n];
        
    }
}
