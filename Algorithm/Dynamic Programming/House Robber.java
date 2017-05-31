leetcode 198 easy

public class Solution {
    public int rob(int[] nums) {
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
        money[0] = nums[0];
        money[1] = Math.max(money[0], nums[1]);
        //loop
        for (int i = 2; i < nums.length; i++){
            money[i] = Math.max(money[i - 2] + nums[i], money[i - 1]);
        }
        return money[nums.length - 1];
    }
}
