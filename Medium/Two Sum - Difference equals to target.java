public class Solution {
    /*
     * @param nums an array of Integer
     * @param target an integer
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new int[2];
        }
        int[] result = new int[2];
        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (maps.containsKey(nums[i])) {
                result[0] = maps.get(nums[i]) + 1;
                result[1] = i + 1;
                return result;
            }
            maps.put(target + nums[i], i);
          //  maps.put(target - nums[i], i);
            maps.put(nums[i] - target, i);
        }
        return result;
    }
}
