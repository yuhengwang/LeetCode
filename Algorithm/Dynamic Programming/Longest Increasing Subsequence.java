// time complexity is O(N2)
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
// time complexity is O(NlogN), using binary search, it is also applied in Russian envelope
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
       int dp[] = new int[nums.length];
       int len = 0;
       for(int envelope : nums){
        int index = Arrays.binarySearch(dp, 0, len, envelope);
        if (index < 0) {
            index = -index - 1;
        }
        dp[index] = envelope;
        if (index == len) {
            len++;
        }
        }
        return len;
    }
}
