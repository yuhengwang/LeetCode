public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        int end = nums.length - 1;
        int start = 0;
        int min = nums[end];
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] <= min) {
                end = mid;
            } else if (nums[mid] > min) {
                start = mid;
            }
        }
        return nums[start] - nums[end] > 0 ? nums[end] : nums[start];
    }
}
