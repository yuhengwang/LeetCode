class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        int pl = 0;
        int ph = nums.length - 1;
        int i = 0;
        while (i <= ph) {
            if (nums[i] == 0) {
                swap(nums, i, pl);
                i++;
                pl++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i , ph);
                ph--;
            }
        }
        
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
