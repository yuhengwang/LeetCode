when we use binary search to get the answer in double range, the format is like below. we define error as diff between  the answer we can in previous 
iteration and this iteration, if the error is smaller than the threshold, we stop the program.
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double end = Integer.MIN_VALUE;
        double start = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            start = Math.min(start, nums[i]);
            end = Math.max(end, nums[i]);
        }
        double error = Integer.MAX_VALUE;
        double prev_mid = end;
        while (error > 0.00001) {
            double mid = (end - start) / 2 + start;
            if (helper(nums, k, mid)) {
                start = mid;
            } else {
                end = mid;
            }
            error = Math.abs(prev_mid - mid);
            prev_mid = mid;
        }
        return end;
        
    }
    min parameter is to record the minimum subarray( sum - mid), so that the sum can substract to maximum its value.
     public boolean helper(int[] nums, int k, double mid) {
        double sum = 0;
         double prev_sum = 0;
         double min = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i] - mid;
        }
        if (sum >= 0) {
            return true;
        }
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - mid;
            prev_sum += nums[i - k] - mid;
            min = Math.min(prev_sum, min);
            if (sum - min >= 0) {
                return true;
            }
        }
         return false;   
    }
}
