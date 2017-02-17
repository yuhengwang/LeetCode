public class Solution {
    /**
     * @param nums a list of integers.
     * @return the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            res[0] = res[0] + nums[i];
        }
        for (int j = 1; j < nums.length - k + 1; j++) {
            res[j] = res[j - 1] - nums[j - 1] + nums[j + k - 1];
        }
        return res;
        
    }
}

