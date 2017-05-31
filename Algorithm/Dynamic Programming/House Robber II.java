public class Solution {
    public int rob(int[] nums) {
         if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robCondition(nums, 0, nums.length - 2), robCondition(nums, 1, nums.length - 1));
    }
    
    public int robCondition(int[] nums, int low, int high) {
        //special condition
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        //state: the maximum money the robber can steal when he go to ith place
        int[] money = new int[nums.length];
        //initialization
        money[low] = nums[low];
        money[low + 1] = Math.max(money[low], nums[low + 1]);
        //loop
        for (int i = low + 2; i <= high; i++){
            money[i] = Math.max(money[i - 2] + nums[i], money[i - 1]);
        }
        return money[high];
    }
}
