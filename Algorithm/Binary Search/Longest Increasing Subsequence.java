 Arrays.binarySearch return the inserted index (-insert point - 1)when it cannot find the element in the array
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = 0;
        int[] dp = new int[length];
     
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num; //i should always < 0 if there is repeated elements, if the newly element is smaller than the last one, it will replace the last one element position
            // len will not increase
            if (i == len) {
                len++;
            }
        }
        return len;   
    }
}
