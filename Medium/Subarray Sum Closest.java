public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    class Pair {
        int sum;
        int index;
        public Pair (int index, int sum) {
            this.sum = sum;
            this.index = index;
        }
    }
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new int[2];
        }
        if (nums.length == 1) {
            return new int[] {0, 0};
        }
        int n = nums.length;
        Pair [] pairs = new Pair[n + 1];
        pairs[0] = new Pair(0, 0);
        for (int i = 1; i < n + 1; i++) {
           pairs[i] = new Pair(i, pairs[i - 1].sum + nums[i - 1]);
        }
        Arrays.sort(pairs, new Comparator<Pair>() {
           public int compare(Pair a, Pair b) {
               return a.sum - b.sum;
           } 
        });
        int difference = Integer.MAX_VALUE;
        int[] result = new int[2];
        for (int i = 1; i < n + 1; i++) {
            if (Math.abs(pairs[i].sum - pairs[i - 1].sum - 0)< difference) {
                difference = Math.abs(pairs[i].sum - pairs[i - 1].sum - 0);
                result[0] = Math.min(pairs[i].index, pairs[i - 1].index);
                result[1] = Math.max(pairs[i].index, pairs[i - 1].index) - 1;
            }
        }
        return result;
        
    }
}
