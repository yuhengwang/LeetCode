区间型dp。
最后Return的东西是为了要player 2也选择最大值。
time complexity o(2^n), space complexity o(1)
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        return match(nums, 0, nums.length - 1, 1) >= 0;
    }
    public int match(int[] nums, int start, int end, int turn) {
        if (start == end) {
            return turn * nums[start];
        }
        int a = turn * nums[start] + match(nums, start + 1, end, -turn);
        int b = turn * nums[end] + match(nums, start, end - 1, -turn);
        return turn * Math.max(turn * a, turn * b);
    }
    
}

memorization
time complexity o(n^2)
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int[][] mem = new int[nums.length][nums.length];
        return match(nums, 0, nums.length - 1, 1, mem) >= 0;
    }
    public int match(int[] nums, int start, int end, int turn, int[][] mem) {
        if (mem[start][end] != 0)   return mem[start][end];
        if (start == end) {
            return turn * nums[start];
        }
        int a = turn * nums[start] + match(nums, start + 1, end, -turn, mem);
        int b = turn * nums[end] + match(nums, start, end - 1, -turn, mem);
        mem[start][end] = turn * Math.max(turn * a, turn * b);
        return turn * Math.max(turn * a, turn * b);
    }
}

dp
倒序。。
time complexity n^2, space n^2
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int[][]dp = new int[nums.length + 1][nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = Math.max(nums[j] - dp[i][j - 1], nums[i] - dp[i + 1][j]);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }
}

长度来loop
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int[][]dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) dp[i][i] = nums[i];
        for (int len = 1; len < nums.length; len++) {
            for (int i = 0; i < nums.length - len; i++) {
                int j = i + len;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }
}
