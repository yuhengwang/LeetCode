public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // start from any point, the maximum length until here 
        int[] t= new int[nums.length];
        //initilization
        for (int i = 0; i < nums.length; i++) {
            t[i] = 1;
        }
        //loop
        for (int i = 1; i < nums.length; i++) {
            int temp = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    temp = Math.max(temp, t[j] + 1);
                }
            }
            t[i] = temp;
           // System.out.println(temp);
        }
        int res = 0;
        //answer
        for (int i = 0 ; i < nums.length; i++) {
            res = Math.max(res, t[i]);
        }
        return res;
    }
}
