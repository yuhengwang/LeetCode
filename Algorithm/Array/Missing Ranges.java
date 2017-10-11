parameter "next" is used to find the supposed next element in the array. 
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        int next = lower; 
        for (int i = 0; i < nums.length; i++) {
        //if the num element is smaller than lower....
            if (nums[i] < next) {
                continue;
            }
         // if nums[i] matches next
            if (nums[i] == next && nums[i] != Integer.MAX_VALUE) {
                next++;
                continue;
            }
            // there is a difference to be added to missing range.
            if (nums[i] - 1 >= next)
                res.add(getRange(next, nums[i] - 1));
            
            //because we already have nums[i], the next elements next to nums[i] in natural order is nums[i] + 1
            if (nums[i] != Integer.MAX_VALUE)
                next = nums[i] + 1;
            else
                next = nums[i];
        }
        if (next != Integer.MAX_VALUE && next <= upper) {
            res.add(getRange(next, upper));
        }
        return res;
    }
    public String getRange(int next, int upper) {
        return next == upper ? String.valueOf(next) : String.valueOf(next) + "->" + String.valueOf(upper);
    }
}
