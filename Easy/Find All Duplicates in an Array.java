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


// time O(N)
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
       
        List <Integer> res = new ArrayList <Integer> ();
        for(int i = 0;i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if(nums[index - 1] >0){
                nums[index - 1] = -nums[index - 1];
            }else{
                res.add(Math.abs(nums[i]));
            }
          
        }
        
        return res;
    }
}
