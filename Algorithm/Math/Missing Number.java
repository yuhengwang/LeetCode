//because all the number are from 0 to n inclusive
class Solution {
    public int missingNumber(int[] nums) {
        int a = 0 ^ nums[0];
        for (int i = 1; i < nums.length; i++) {
            a = a ^ i ^ nums[i];
        }
        return a ^ nums.length;
    }
}
