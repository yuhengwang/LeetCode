public class Solution {
    public int removeDuplicates(int[] nums) {
        
        int length = nums.length;
        if(length == 1) {
            return length;
        }
       
        int i = 1;
        int j = 0;
        
       while(i < nums.length){
           
            if(nums[i] == nums[j]){
                i++;
            }else{
               j++;
                nums[j] = nums[i];
               
                i++;
                
            }
        }
        
        return j+1;
        
    }
}
