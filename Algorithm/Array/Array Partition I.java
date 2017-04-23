//leetcode 561
The maximum sum of the min num of each pair is to get the sorted array, from 0 to nums.length, add by 2.
public class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
        
    }
}
