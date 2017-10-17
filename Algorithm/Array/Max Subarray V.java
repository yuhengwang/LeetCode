public class Solution {
    /*
     * @param nums: an array of integers
     * @param k1: An integer
     * @param k2: An integer
     * @return: the largest sum
     */
    public int maxSubarray5(int[] nums, int k1, int k2) {
        // write your code here
        if (nums.length < k1) {
            return 0;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int[] sum = new int[nums.length + 1];
        int res = Integer.MIN_VALUE;
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            while (!queue.isEmpty() && queue.getFirst() < (i - k2)) {
                queue.removeFirst();
            }
            if (i >= k1) {
                while (!queue.isEmpty() && sum[queue.getLast()] > sum[i - k1]) {
                    queue.removeLast();
                }
                queue.offer(i -  k1);
            }
            //calculate
            if (!queue.isEmpty() && (sum[i] - sum[queue.getFirst()]) > res) {
                res = sum[i] - sum[queue.getFirst()];
            }
            
        }
        return res;
    }
}
