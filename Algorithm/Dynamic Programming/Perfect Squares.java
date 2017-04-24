public class Solution {
    /**
     * @param n a positive integer
     * @return an integer
     */
    public int numSquares(int n) {
        // Write your code here
        //state: the least number of perfect square to sum to i
        int[] sum = new int[n + 1];
        Arrays.fill(sum, Integer.MAX_VALUE);
        //initialization, we set all perfect square num to 1
        for (int i = 0; i * i <= n; i++) {
            sum[i * i] = 1;
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                //compare with sum[i], or assume this time we can add j * j tp get the sum
                sum[i] = Math.min(sum[i], sum[i - j * j] + 1);
            }
        }
        return sum[n];
        
    }
}
