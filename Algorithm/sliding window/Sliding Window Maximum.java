we have a deque to store the global max and local max. 
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[]{};
        }
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
        //we remove those out of date element stored in deque
            while(!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
                //this is poll first
            }
            //if we found the one in deque is smaller than the incoming number, there is no reason to keep it, so we remove it
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.offer(i);
            if (i >= k - 1) {
                res[index++] = nums[q.peek()];
            }
        }
        return res;
    }
}
