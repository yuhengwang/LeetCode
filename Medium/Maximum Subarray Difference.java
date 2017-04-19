public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        int[] leftMin = new int[nums.length];
        int[] rightMin = new int[nums.length];
        int[] leftMax = new int[nums.length];
        int[] rightMax = new int[nums.length];
        int max = Integer.MIN_VALUE;
        int min = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - min);
            min = Math.min(sum, min);
            leftMax[i] = max; 
        }
        max = Integer.MIN_VALUE;
        min = 0;
        sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
            rightMax[i] = max;
        }
        max = 0;
        min = Integer.MAX_VALUE;
        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min, sum - max);
            max = Math.max(sum, max);
            leftMin[i] = min; 
          //  System.out.print(min+ " ");
        }
        //System.out.println();
        max = 0;
        min = Integer.MAX_VALUE;
        sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            min = Math.min(min, sum - max);
            max = Math.max(sum, max);
            rightMin[i] = min; 
          //  System.out.print(min+ " ");
        }
       // System.out.println();
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            res = Math.max(res, Math.abs(leftMin[i] - rightMax[i + 1]));
            res = Math.max(res, Math.abs(leftMax[i] - rightMin[i + 1]));
        }
        return res;
        
        
    }
}

