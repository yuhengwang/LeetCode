 lo and hi are not regular index, but the pair index here. Basically you want to find
 the first even-index number not followed by the same number.
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)   return 0;
        int lo = 0;
        int hi = nums.length / 2;
        while (lo  + 1 < hi) {
            int middle = (hi + lo) / 2;
            if (nums[2 * middle] != nums[2 * middle + 1]) {
                hi = middle;
            } else {
                lo = middle;
            }
        }
        if (nums[2 * lo] != nums[2 * lo + 1]) return nums[2 * lo];
        else return nums[2 * hi];
    }
}
