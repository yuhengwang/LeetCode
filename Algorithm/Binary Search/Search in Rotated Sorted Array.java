class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low + 1 <  high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] < nums[mid]) { //left is sorted
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid;
                } else {
                    low = mid;
                }
            } else {
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid;
                } else{
                    high = mid;
                }
            }
        }
        if (nums[low] == target)    return low;
        if (nums[high] == target)   return high;
        return -1;
    }  
}
