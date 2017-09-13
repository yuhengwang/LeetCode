class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0)   return 0;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (peakSituation(nums, mid) == 0)  return mid;
            else if (peakSituation(nums, mid) == 1) start = mid;
            else if (peakSituation(nums, mid) == 2) end = mid;
        }
        if (peakSituation(nums, start) == 0)    return start;
        return end;
    }
    //202
    //123
    //321
    //020
    public int peakSituation(int[] nums, int index) {
        int left = index == 0 ? Integer.MIN_VALUE : nums[index - 1];
        int right = index == nums.length - 1 ? Integer.MIN_VALUE : nums[index + 1];
        int n = nums[index];
        if (n > left && n > right) {
            return 0;
        }
        if (n < right)  return 1;
        if (n < left)   return 2;
        return -1;
    }
}
