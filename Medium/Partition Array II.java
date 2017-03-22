public class Solution {
    /**
     * @param nums an integer array
     * @param low an integer
     * @param high an integer
     * @return nothing
     */
    public void partition2(int[] nums, int low, int high) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        int pl = 0;
        int ph = nums.length - 1;
        int i = 0; // contains low and low<x<high
        while (i <= ph) {
            if (i <= ph && nums[i] < low) {
                swap(nums, i, pl);
                i++;
                pl++;
            }else if (i <= ph && nums[i] > high) {
                swap(nums, ph, i);
                ph--;
            } else {
                i++;
            }
        }
    }
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
