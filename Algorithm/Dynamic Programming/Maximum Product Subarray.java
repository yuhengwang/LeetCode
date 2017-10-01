so we need to record the min number and the max number until ith number, if the i + 1 th number is negative, we will times min to be the max,
if it is positive, we will just times max to max. 
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int min = nums[0];
        int max = nums[0];
        int r = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = min;
                min = max;
                max = temp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            r = Math.max(r, max);
        }
        return r;
    }
}
