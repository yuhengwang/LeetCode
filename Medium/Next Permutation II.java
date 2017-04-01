public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public void nextPermutation(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        if (nums.length < 2) {
            return;
        }
        int index = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            Arrays.sort(nums);
            return;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, i , index);
                reverse(nums, index + 1);
                break;
            }
        }

    }
      
    public void swap(int[] nums, int i ,int index) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
    public void reverse(int[] nums, int index) {
        for (int i = index, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
