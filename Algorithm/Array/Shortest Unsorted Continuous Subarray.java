//easy part leetcode 581
O(N) space O(N) time
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] copies = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while (i < nums.length && copies[i] == nums[i]) {
            i++;
        }
        while (j >= 0 && copies[j] == nums[j]) {
            j--;
        }
        
        return j - i + 1 > 0 ? j - i + 1 : 0;
    }
}
