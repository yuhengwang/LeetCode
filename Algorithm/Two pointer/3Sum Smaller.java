异向指针。time complexity O(N2)
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = -1;
            int k = -1;
            for (j = i + 1, k = nums.length - 1; j < nums.length - 1 && k > j; ) {
                if(nums[k] + nums[i] + nums[j] >= target) {
                    k--;
                    continue;
                }
            //k satisfy the requirement
                count += ( k - j);
                j++;
            }
        }
        return count;
    }
}
