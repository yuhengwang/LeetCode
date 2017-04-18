public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        //int[] left to store the possible max sum from left to right
        //int[] right to store the possible max sum from right to left
        int size = nums.size();
        int[] left = new int[size];
        int[] right = new int[size];
        int min = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += nums.get(i);
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
            left[i] = max;
        }
        sum = 0;
        max = Integer.MIN_VALUE;
        min = 0;
        for (int i = size - 1; i >= 0; i--) {
            sum += nums.get(i);
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
            right[i] = max;
            
        }
        max = Integer.MIN_VALUE;
        // iterate for the split line
        for (int i = 0; i < size - 1; i++) {
            max = Math.max(left[i] + right[i + 1], max);
        }
        return max;
}
}

