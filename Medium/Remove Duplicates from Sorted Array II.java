// two pointer
public class Solution {
    public int removeDuplicates(int[] nums) {
        
        if(nums.length < 2) {
            return nums.length;
        }
        
        int i = 1;
        int j = 0;
        int num = 1;
        
        while( i < nums.length) {
            
            if(nums[i] == nums[j]) {
                
                num++;
                if(num < 3){
                    j++;
                    nums[j] = nums[i];
                   
                }
                i++;
                
            }else{
                num = 1;
                j++;
                nums[j] = nums[i];
                i++;
            }
            
        }
        
        return j+1;
        
        
    }
}


//
public int removeDuplicates(int[] nums) {
    int i = 0;
    for (int n : nums)
        if (i < 2 || n > nums[i-2])
            nums[i++] = n;
    return i;
}
