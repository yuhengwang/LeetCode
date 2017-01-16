public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        if(nums.length == 1 && nums[0] == 1){
            return 1;
        }
        
        boolean flag = false;
        int record = 0;
        int num = 0;
        for(int i = 0; i < nums.length ; i++) {
            
          if(nums[i] == 1){
              if(flag == true){
                  num++;
              }
              if(flag == false){
                  num = 1;
              }
              flag = true;
          }else{
              if(num > record) {
                  record = num;
              }
              num = 0;
              flag = false;
          }
          
          
            }
            
            
        
        
        return num > record ? num:record;
        
    }
}
