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
// time complexity O(nlogn), space complexity o(n)
public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum6(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int num = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                num++;
                left++;
                right--;
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
            
        }
        return num;
    }
}
