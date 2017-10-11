class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        // we need two parameters to indicate the lower bound and the higher range of each range
        int low = nums[0];
        int next = low + 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == next) {
                next++;
                continue;
            }
            res.add(getRange(low, next - 1)); // both inclusive or same element
            low = nums[i];
            next = low + 1;
            
        }
        res.add(getRange(low, nums[nums.length - 1]));
        return res;
    }
    public String getRange(int low, int high) {
        return low == high ? String.valueOf(low) : String.valueOf(low) + "->" + String.valueOf(high);
    }
}
