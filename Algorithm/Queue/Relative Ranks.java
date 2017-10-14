class Solution {
    public String[] findRelativeRanks(int[] nums) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < nums.length; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        String[] s = new String[nums.length];
        int index = 0;
        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            String result = "";
            if (index == 0) {
                result = "Gold Medal";
            }
            if (index == 1) {
                result = "Silver Medal";
            }
            if (index == 2) {
                result = "Bronze Medal";
            }
            s[q[1]] = result.equals("") ? String.valueOf(index + 1) : result;
            index++;
            
        }
        return s;
    }
}
