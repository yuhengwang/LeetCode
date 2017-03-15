public class Solution {
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        // Write your code here O(nlogn)
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
           if (nums[len] != nums[i)
                nums[++len] = nums[i];
            
        }
        return len + 1;
        
        
    }
}
                                 //O(n) time & space
 public class Solution {
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        // Write your code here
       HashMap<Integer, Boolean> maps = new HashMap<>();
       for (int i = 0; i < nums.length; i++) {
           maps.put(nums[i], true);
       }
       int result = 0;
       for (Map.Entry<Integer, Boolean> entries: maps.entrySet()) {
           nums[result++] = entries.getKey();
       }
       return result;
        
        
    }
}
