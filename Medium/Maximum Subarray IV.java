public class Solution {
    /**
     * @param nums an array of integers
     * @param k an integer
     * @return the largest sum
     */
    public int maxSubarray4(int[] nums, int k) {
        // Write your code here
        if (nums.length < k) {
            return 0;
        }
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        int min = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length + 1; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            if ( i >= k && sum[i] - min > result) {
                result = sum[i] - min;
            }
            if (i >= k && min > sum[i - k + 1]) {
                min = sum[i - k + 1];    // i -k + 1 instead of i - k because the last element we consider is gonna move to next, the start point need to be reupdated.
            }
        }
        
        return result;
    }
}
