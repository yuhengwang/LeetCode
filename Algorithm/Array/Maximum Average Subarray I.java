!!! Double.minvalue is positive, if we need negative double value, use minus double.max_value
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = nums[i] + sum[i];
        }
        double max = -Double.MAX_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            max = Math.max(sum[i + k] - sum[i], max);
        return max / k;
    }
}
