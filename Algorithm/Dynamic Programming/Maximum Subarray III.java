local[i][k]表示前i个元素取k个子数组并且必须包含第i个元素的最大和。
global[i][k]表示前i个元素取k个子数组不一定包含第i个元素的最大和。
local[i][k]的状态函数：
max(global[i-1][k-1], local[i-1][k]) + nums[i-1]
有两种情况，第一种是第i个元素自己组成一个子数组，则要在前i－1个元素中找k－1个子数组，第二种情况是第i个元素属于前一个元素的子数组
，因此要在i－1个元素中找k个子数组（并且必须包含第i－1个元素，这样第i个元素才能合并到最后一个子数组中），取两种情况里面大的那个。
global[i][k]的状态函数：
max(global[i-1][k]，local[i][k])
有两种情况，第一种是不包含第i个元素，所以要在前i－1个元素中找k个子数组，第二种情况为包含第i个元素，在i个元素中找k个子数组且必须包含第i个元素，
取两种情况里面大的那个。


public class Solution {
    /*
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        // write your code here
        int[][] localMax = new int[k + 1][nums.length + 1];
        int[][] globalMax = new int[k + 1][nums.length + 1];
        for (int i = 1; i <= k; i++) {
            localMax[i][i - 1] = Integer.MIN_VALUE;
            for (int j = i; j <= nums.length; j++) {
                localMax[i][j] = Math.max(globalMax[i - 1][j - 1], localMax[i][j - 1]) + nums[j - 1];
                if (i == j) {
                    globalMax[i][j] = localMax[i][j];
                } else {
                    globalMax[i][j] = Math.max(globalMax[i][j - 1], localMax[i][j]);
                }
            }
        }
        return globalMax[k][nums.length];
    }
}
