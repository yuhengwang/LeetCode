public class Solution {
    /**
     * @param nums an integer array
     * @return nothing, do this in-place
     */
    public void moveZeroes(int[] nums) {
        // Write your code here
        int len = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                nums[len++] = nums[i++];
            } else {
                i++;
            }
        }
        while (len < nums.length) {
            nums[len++] = 0;
        }
    }
}
