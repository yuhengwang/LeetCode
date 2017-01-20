public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int difference = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = 0;;
            int k = nums.length - 1;
            while(j < k) {
            if(i == j) {
                j++;
                continue;
            }
            if(i == k) {
                k--;
                continue;
            }
            if(nums[i] + nums[j] + nums[k] == target) {
                return target;
            } else if (nums[i] + nums[j] + nums[k] > target) {
                if(difference > Math.abs(target - nums[i] - nums[j] - nums[k])) {
                    difference = Math.abs(target - nums[i] - nums[j] - nums[k]);
                    result = nums[i] + nums[j] + nums[k];
                }
                k--;
            } else {
                if(difference > Math.abs(target - nums[i] - nums[j] - nums[k])) {
                    difference = Math.abs(target - nums[i] - nums[j] - nums[k]);
                    result = nums[i] + nums[j] + nums[k];
                }
                j++;
            }
        }
        }
        return result;
        
    }
}
