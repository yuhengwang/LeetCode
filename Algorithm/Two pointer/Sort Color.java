// pure quick select cannot finish the requirement, but rainbow sort uses quick select
public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int zero = 0;
        int second = nums.length - 1;
        for (int i = 0; i <= second; i++) {
            while (nums[i] == 2 && i < second) 
                swap(i, second--, nums);
            while (nums[i] == 0 && i > zero)
                swap(i, zero++, nums);
        }
    }
    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
