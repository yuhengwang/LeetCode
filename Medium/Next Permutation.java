public class Solution {
    /**
     * @param nums: an array of integers
     * @return: An array of integers that's next permuation
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        // scan from right to left to find the first number who is smaller than its right num
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        if (nums.length < 2) {
            return nums;
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
            return nums;
        }
      //  System.out.println(index);
        int index2 = -1;
        //scan from right to left to find the first number that is larger than nums[index]
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                index2 = i;
                break;
            }
        }
      //  System.out.println(index2);
        swap(nums, index, index2);
        reverse(nums, index);
        return nums;
    }
    private void swap (int[] nums, int index, int index2) {
        int temp = nums[index];
        nums[index] = nums[index2];
        nums[index2] = temp;
    }
    private void reverse(int[] nums, int index) {
        int[] reverse = new int[nums.length - index - 1];
        for (int i = 0; i < reverse.length; i++) {
            reverse[i] = nums[index + i + 1];
        }
        int q = 1;
        for (int j = reverse.length - 1; j >= 0; j--) {
            nums[index + q++] = reverse[j];
        }
        
    }
    
}
