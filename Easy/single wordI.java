// XOR, A^A=0; 0^B=B
public class Solution {
    public int singleNumber(int[] nums) {
        
        int a=nums[0];
        for(int i=1;i<nums.length;i++){
            
            a= a^nums[i];
        }
        
        return a;
    }
}
