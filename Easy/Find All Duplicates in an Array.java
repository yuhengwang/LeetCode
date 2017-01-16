public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        Arrays.sort(nums);
        List <Integer> res = new ArrayList <Integer> ();
        for(int i = 0;i <  nums.length-1; i++) {
            if(nums[i] == nums[i+1]) {
                res.add(nums[i]);
            }
        }
        
        return res;
    }
}
