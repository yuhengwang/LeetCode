//binary search function parameter is nums length, not nums.length - 1
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, 0, nums.length, target);
        return index < 0 ? -(index + 1) : index;
    }
}
