//hashtable
public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum6(int[] nums, int target) {
        // Write your code here
        HashMap<Integer, Integer> maps = new HashMap<>();
        HashSet<Integer> sets = new HashSet<>();
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!maps.containsKey(nums[i])) {
                maps.put(target - nums[i], i);
            } else {
                //hit
                maps.remove(target - nums[i]);
                maps.remove(nums[i]);
                if (!sets.contains(nums[i])&&!sets.contains(target - nums[i])) {
                    num++;
                    sets.add(nums[i]);
                    sets.add(target - nums[i]);
                } 
            }
        }
        return num;
    }
}
